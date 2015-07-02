package net.frank.framework.web.taglib.vml;

import java.io.IOException;

//import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class VMLHtmlTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3621174977578662583L;

	public int doStartTag() throws JspException {
		try{
			JspWriter out = pageContext.getOut();
			out.write("<html xmlns:v=\"urn:schemas-microsoft-com:vml\">");
		}catch(IOException e){
		}
		return EVAL_BODY_INCLUDE;
	}

	public int doEndTag() throws JspException {
		try{
			JspWriter out = pageContext.getOut();
			out.write("</html>\n");
		}catch(IOException e){}
		return EVAL_PAGE;
	}
}
