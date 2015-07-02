package net.frank.framework.struts.fileupload;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileItemHeaders;
import org.apache.commons.fileupload.FileItemHeadersSupport;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.RequestContext;
import org.apache.commons.fileupload.FileUploadBase.FileUploadIOException;
import org.apache.commons.fileupload.FileUploadBase.IOFileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

public class StrutsServletFileUpload extends ServletFileUpload {
	public List<FileItem> parseRequest(RequestContext ctx)
            throws FileUploadException {
        List<FileItem> items = new ArrayList<FileItem>();
        boolean successful = false;
        try {
            FileItemIterator iter = getItemIterator(ctx);
            FileItemFactory fac = getFileItemFactory();
            if (fac == null) {
                throw new NullPointerException(
                    "No FileItemFactory has been set.");
            }
            while (iter.hasNext()) {
                final FileItemStream item = iter.next();
                final String fileName =  item.getFieldName();
                FileItem fileItem = fac.createItem(item.getFieldName(),
                        item.getContentType(), item.isFormField(),
                        fileName);
                items.add(fileItem);
                try {
                    Streams.copy(item.openStream(), fileItem.getOutputStream(),
                            true);
                } catch (FileUploadIOException e) {
                    throw (FileUploadException) e.getCause();
                } catch (IOException e) {
                    throw new IOFileUploadException(
                            "Processing of " + MULTIPART_FORM_DATA
                            + " request failed. " + e.getMessage(), e);
                }
                if (fileItem instanceof FileItemHeadersSupport) {
                    final FileItemHeaders fih = item.getHeaders();
                    ((FileItemHeadersSupport) fileItem).setHeaders(fih);
                }
            }
            successful = true;
            return items;
        } catch (FileUploadIOException e) {
            throw (FileUploadException) e.getCause();
        } catch (IOException e) {
            throw new FileUploadException(e.getMessage(), e);
        } finally {
            if (!successful) {
                for (Iterator iterator = items.iterator(); iterator.hasNext();) {
                    FileItem fileItem = (FileItem) iterator.next();
                    try {
                        fileItem.delete();
                    } catch (Throwable e) {
                        // ignore it
                    }
                }
            }
        }
    }
}
