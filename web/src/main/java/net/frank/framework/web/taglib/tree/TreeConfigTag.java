package net.frank.framework.web.taglib.tree;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class TreeConfigTag extends TagSupport {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 5929774139591760705L;

	public int doEndTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try{
				renderer(out);
		}catch(IOException e){
			throw new JspException(e);
		}
		return EVAL_PAGE;
	}
	
	private void renderer(JspWriter jspWriter) throws IOException{
		StringBuffer buf = new StringBuffer();
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
		String baseUrl = request.getContextPath();
		buf.append("<script src='").append(baseUrl).append("/dwr/interface/").append("TreeAjax.js'></script>\n");
		buf.append("<script src='").append(baseUrl).append("/dwr/engine.js'></script>\n");
		buf.append("<script src='").append(baseUrl).append("/dwr/util.js'></script>\n");

		buf.append("<script src='").append(baseUrl).append("/global/scripts/xloadtree2b/xtree2.js'></script>\n");
		buf.append("<script src='").append(baseUrl).append("/global/scripts/xloadtree2b/xmlextras.js'></script>\n");
		buf.append("<script src='").append(baseUrl).append("/global/scripts/xloadtree2b/xloadtree2.js'></script>\n");
		
		buf.append("<link type=\"text/css\" rel=\"stylesheet\" href='").append(baseUrl).append("/global/css/xloadtree2b/xtree2.css'/>\n");
		
		
		jspWriter.write(buf.toString());
	}


}
