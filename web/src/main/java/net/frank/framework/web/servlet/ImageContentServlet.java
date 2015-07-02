package net.frank.framework.web.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import net.frank.commons.CommonConstants;
import net.frank.framework.bo.BusinessObject;
import net.frank.framework.bo.Image;

public class ImageContentServlet extends BlobContentServlet {
	
	private static final long serialVersionUID = -6767770479315325325L;
	
	public static String WEB_CONTEXT = CommonConstants.EMPTY_STRING;
	
	private static final String DEFAULT_IMAGE_PATH = "/global/images/default.jpg";
	
	@Override
	public void init() throws ServletException {
		super.init();
		WEB_CONTEXT = getServletContext().getContextPath();
	}
	
	
	@Override
	protected void processResponseHeader(HttpServletResponse response,
			BusinessObject bo) {
		response.reset();
		processContentType(response, bo);
	}
	@Override
	protected void processContentType(HttpServletResponse response,
			BusinessObject bo) {
		if(bo instanceof Image){
			response.setContentType("image/"+((Image)bo).getImageFormat());
		}else{
			response.setContentType("image/octet-stream");
		}
	}
	
	
	protected void processNullContent(HttpServletResponse response) {
		ServletContext sc = getServletContext();
		String filePath = 
				sc.getRealPath(DEFAULT_IMAGE_PATH);
		FileInputStream fis = null;
		try{
			fis = new FileInputStream(filePath);
			if(fis.available()>0){
				OutputStream os = response.getOutputStream();
				byte[] buff = new byte[CommonConstants.DEFAULT_BYTE_BUFFER_LENGTH];
				int length = 0;
				int readLength = 0;
				while ((readLength = fis.read(buff)) != -1) {
					os.write(buff, 0, readLength);
					length += readLength;
				}
				response.setContentLength(length);
				os.flush();
			}
		}catch(IOException e){
			
		}finally{
			try{
				if(fis!=null){
					fis.close();
				}
			}catch(IOException e){}
		}
	}
	
}
