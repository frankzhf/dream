package net.frank.framework.web.taglib.pucker;

import java.io.IOException;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;


public class PuckerTag extends BodyTagSupport {

	private static final long serialVersionUID = 1L;

	private String titletext;
	private String iconbrown = "/global/images/";
	private String name = "";
	
	private boolean opened = true;
	
	public String getIconbrown() {
		return iconbrown;
	}

	public void setIconbrown(String iconbrown) {
		this.iconbrown = iconbrown;
	}

	public boolean isOpened() {
		return opened;
	}

	public void setOpened(boolean opened) {
		this.opened = opened;
	}

	public String getTitletext() {
		return titletext;
	}

	public void setTitletext(String titletext) {
		this.titletext = titletext;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int doEndTag() throws JspTagException{
		String puckerScript="";
		
		try{
			BodyContent puckerContent = getBodyContent();
			
			if(puckerContent!=null){
				String puckerContentString = puckerContent.getString();
				PuckerScript pucker = new PuckerScript();
				
				puckerScript = pucker.pucker(puckerContentString,this.getTitletext(),this.isOpened(),this.getIconbrown(),this.getName());			
			}
			
			pageContext.getOut().write(puckerScript);
		}catch(IOException e){
			throw new JspTagException("Error" + e.toString());			
		}
		return EVAL_PAGE;		
	}
}
