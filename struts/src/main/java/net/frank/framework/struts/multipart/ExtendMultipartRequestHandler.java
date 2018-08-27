package net.frank.framework.struts.multipart;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts.Globals;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.config.ModuleConfig;
import org.apache.struts.upload.FormFile;
import org.apache.struts.upload.MultipartRequestHandler;
import org.apache.struts.upload.MultipartRequestWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExtendMultipartRequestHandler implements MultipartRequestHandler {

	protected static transient Logger log = LoggerFactory
			.getLogger(ExtendMultipartRequestHandler.class);

	public static final long DEFAULT_SIZE_MAX = 250 * 1024 * 1024;

	public static final int DEFAULT_SIZE_THRESHOLD = 256 * 1024;

	private Hashtable<String, Object> elementsAll;
	private Hashtable<String, Object> elementsFile;
	private Hashtable<String, Object> elementsText;

	private ActionMapping mapping;

	private ActionServlet servlet;

	@Override
	@SuppressWarnings("unchecked")
	public void handleRequest(HttpServletRequest request)
			throws ServletException {
		ModuleConfig ac = (ModuleConfig) request
				.getAttribute(Globals.MODULE_KEY);
		ServletFileUpload upload = new ServletFileUpload();
		upload.setHeaderEncoding(request.getCharacterEncoding());
		upload.setSizeMax(getSizeMax(ac));
		elementsText = new Hashtable<String, Object>();
		elementsFile = new Hashtable<String, Object>();
		elementsAll = new Hashtable<String, Object>();
		List<FileItem> items = null;
		try {
			items = upload.parseRequest(request);
		} catch (ServletFileUpload.SizeLimitExceededException e) {
			request.setAttribute(
					MultipartRequestHandler.ATTRIBUTE_MAX_LENGTH_EXCEEDED,
					Boolean.TRUE);
		} catch (FileUploadException e) {
			log.error("Failed to parse multipart request", e);
			throw new ServletException(e);
		}
		Iterator<FileItem> iter = items.iterator();
		while (iter.hasNext()) {
			FileItem item = (FileItem) iter.next();
			if (item.isFormField()) {
				addTextParameter(request, item);
			} else {
				addFileParameter(item);
			}
		}

	}

	protected void addTextParameter(HttpServletRequest request, FileItem item) {
		String name = item.getFieldName();
		String value = null;
		boolean haveValue = false;
		String encoding = null;

		if (item instanceof DiskFileItem) {
			encoding = ((DiskFileItem) item).getCharSet();
			if (log.isDebugEnabled()) {
				log.debug("DiskFileItem.getCharSet=[" + encoding + "]");
			}
		}

		if (encoding == null) {
			encoding = request.getCharacterEncoding();
			if (log.isDebugEnabled()) {
				log.debug("request.getCharacterEncoding=[" + encoding + "]");
			}
		}

		if (encoding != null) {
			try {
				value = item.getString(encoding);
				haveValue = true;
			} catch (Exception e) {
				// Handled below, since haveValue is false.
			}
		}

		if (!haveValue) {
			try {
				value = item.getString("ISO-8859-1");
			} catch (java.io.UnsupportedEncodingException uee) {
				value = item.getString();
			}

			haveValue = true;
		}

		if (request instanceof MultipartRequestWrapper) {
			MultipartRequestWrapper wrapper = (MultipartRequestWrapper) request;

			wrapper.setParameter(name, value);
		}

		String[] oldArray = (String[]) elementsText.get(name);
		String[] newArray;

		if (oldArray != null) {
			newArray = new String[oldArray.length + 1];
			System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);
			newArray[oldArray.length] = value;
		} else {
			newArray = new String[] { value };
		}

		elementsText.put(name, newArray);
		elementsAll.put(name, newArray);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void addFileParameter(FileItem item) {
		FormFile formFile = new CommonsFormFile(item);
		String name = item.getFieldName();
		if (elementsFile.containsKey(name)) {
			Object o = elementsFile.get(name);
			if (o instanceof List) {
				((List) o).add(formFile);
			} else {
				List<FormFile> list = new ArrayList<FormFile>();
				list.add((FormFile) o);
				list.add(formFile);
				elementsFile.put(name, list);
				elementsAll.put(name, list);
			}
		} else {
			elementsFile.put(name, formFile);
			elementsAll.put(name, formFile);
		}
	}

	static class CommonsFormFile implements FormFile, Serializable {

		private static final long serialVersionUID = -1814545984510352367L;
		FileItem fileItem;
		public CommonsFormFile(FileItem fileItem) {
			this.fileItem = fileItem;
		}
		
		public String getContentType() {
			return fileItem.getContentType();
		}
		
		public void setContentType(String contentType) {
			throw new UnsupportedOperationException(
					"The setContentType() method is not supported.");
		}
		
		public int getFileSize() {
			return (int) fileItem.getSize();
		}
		
		public void setFileSize(int filesize) {
			throw new UnsupportedOperationException(
					"The setFileSize() method is not supported.");
		}
		
		public String getFileName() {
			return getBaseFileName(fileItem.getName());
		}
		
		public void setFileName(String fileName) {
			throw new UnsupportedOperationException(
					"The setFileName() method is not supported.");
		}
		
		public byte[] getFileData() throws FileNotFoundException, IOException {
			return fileItem.get();
		}
		
		public InputStream getInputStream() throws FileNotFoundException,
				IOException {
			return fileItem.getInputStream();
		}
		
		public void destroy() {
			fileItem.delete();
		}
		
		protected String getBaseFileName(String filePath) {
			// First, ask the JDK for the base file name.
			String fileName = new File(filePath).getName();
			// Now check for a Windows file name parsed incorrectly.
			int colonIndex = fileName.indexOf(":");
			if (colonIndex == -1) {
				colonIndex = fileName.indexOf("\\\\");
			}
			int backslashIndex = fileName.lastIndexOf("\\");
			if ((colonIndex > -1) && (backslashIndex > -1)) {
				fileName = fileName.substring(backslashIndex + 1);
			}
			return fileName;
		}
		
		public String toString() {
			return getFileName();
		}
	}

	@Override
	public void setServlet(ActionServlet servlet) {
		this.servlet = servlet;
	}

	@Override
	public void setMapping(ActionMapping mapping) {
		this.mapping = mapping;
	}

	@Override
	public ActionServlet getServlet() {
		return this.servlet;
	}

	@Override
	public ActionMapping getMapping() {
		return this.mapping;
	}

	@Override
	public Hashtable<String, Object> getTextElements() {
		return this.elementsText;
	}

	@Override
	public Hashtable<String, Object> getFileElements() {
		return this.elementsFile;
	}

	@Override
	public Hashtable<String, Object> getAllElements() {
		return this.elementsAll;
	}

	@Override
	public void rollback() {
		Iterator<Object> iter = elementsFile.values().iterator();
		Object o;
		while (iter.hasNext()) {
			o = iter.next();
			if (o instanceof List) {
				for (@SuppressWarnings("unchecked")
				Iterator<FormFile> i = ((List<FormFile>) o).iterator(); i
						.hasNext();) {
					i.next().destroy();
				}
			} else {
				((FormFile) o).destroy();
			}
		}
	}

	@Override
	public void finish() {
		rollback();
	}

	protected long getSizeMax(ModuleConfig mc) {
		return convertSizeToBytes(mc.getControllerConfig().getMaxFileSize(),
				DEFAULT_SIZE_MAX);
	}

	protected long getSizeThreshold(ModuleConfig mc) {
		return convertSizeToBytes(mc.getControllerConfig().getMemFileSize(),
				DEFAULT_SIZE_THRESHOLD);
	}

	protected long convertSizeToBytes(String sizeString, long defaultSize) {
		int multiplier = 1;
		if (sizeString.endsWith("K")) {
			multiplier = 1024;
		} else if (sizeString.endsWith("M")) {
			multiplier = 1024 * 1024;
		} else if (sizeString.endsWith("G")) {
			multiplier = 1024 * 1024 * 1024;
		}
		if (multiplier != 1) {
			sizeString = sizeString.substring(0, sizeString.length() - 1);
		}
		long size = 0;
		try {
			size = Long.parseLong(sizeString);
		} catch (NumberFormatException nfe) {
			log.warn("Invalid format for file size ('" + sizeString
					+ "'). Using default.");
			size = defaultSize;
			multiplier = 1;
		}
		return (size * multiplier);
	}

}
