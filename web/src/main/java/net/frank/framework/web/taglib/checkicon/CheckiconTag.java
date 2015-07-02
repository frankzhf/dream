package net.frank.framework.web.taglib.checkicon;

import java.io.IOException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class CheckiconTag extends BodyTagSupport {
	
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	public int doStartTag() throws JspTagException{
		String checkiconScript="";					
		CheckiconScript checkicon = new CheckiconScript();				
		checkiconScript = checkicon.checkicon(this.getName());			
	
		try {
			System.out.println(checkiconScript);
			pageContext.getOut().write(checkiconScript);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return SKIP_BODY;		
	}



}
