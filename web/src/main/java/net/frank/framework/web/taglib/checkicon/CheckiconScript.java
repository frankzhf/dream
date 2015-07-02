package net.frank.framework.web.taglib.checkicon;


import java.io.Serializable;
public class CheckiconScript implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String checkicon(String iconname){	
		StringBuffer buf = new StringBuffer();
		
		buf.append("<span>");
		buf.append("<img name='p"+ iconname + "' src='/global/images/pass.gif' width='16' height='16' onclick=");
		buf.append("e"+ iconname + ".style.display='block';this.style.display='none';");
		buf.append(iconname+".value=parseInt("+iconname+".value)+1;>");
		buf.append("<img name='e"+ iconname + "' src='/global/images/error.gif' width='16' height='16' style='display:none' onclick=");
		buf.append("p"+ iconname + ".style.display='block';this.style.display='none';");
		buf.append(iconname+".value=parseInt("+iconname+".value)-1;>");
		buf.append("</span>");
		
		buf.append("<input type='hidden' name='"+iconname+"' value='0'>");
		
		buf.append("<script>");
		buf.append("if ("+iconname+".value=='0'){");
		buf.append("p"+ iconname + ".style.display='block';");
		buf.append("e"+ iconname + ".style.display='none';"); 
		buf.append("}else{");
		buf.append("p"+ iconname + ".style.display='none';");
		buf.append("e"+ iconname + ".style.display='block';}");
		buf.append("</script>");              
				
		return buf.toString();
	}
}
