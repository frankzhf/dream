package net.frank.framework.web.taglib.vml;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class VMLStyleTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7687911766401725577L;

	public int doEndTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try{
			out.write("<style>\n\tv\\:* { Behavior: url(#default#VML) }\n</style>");
		}catch(IOException e){
		}
	
		return EVAL_PAGE;
	}

}
