package net.frank.framework.web.taglib.pucker;

import java.io.Serializable;

/**
 * @author Squall.zhou
 *
 */

public class PuckerScript implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	public String pucker(String center, String title, boolean open ,String iconbrown,String name){
		String puckerScript = "";
		
		StringBuffer buf = new StringBuffer();
			
		buf.append("<table><tr><td width='5px'>");
			
		buf.append("<span id='iconadd" +name+ "'");
		buf.append(" style='display:none' onclick=");
		buf.append("centext" +name+ ".style.display='block';iconadd" +name+ ".style.display='none';iconjian" +name+ ".style.display='block';");
		buf.append(">");
		buf.append("<img src='" + iconbrown + "add.gif'>");		
		buf.append("</span>");	
		
		buf.append("<span id='iconjian" +name+ "'");
		buf.append(" style='display:block' onclick=");
		buf.append("centext" +name+ ".style.display='none';iconadd" +name+ ".style.display='block';iconjian" +name+ ".style.display='none';");
		buf.append(">");
		buf.append("<img src='" + iconbrown + "jian.gif'>");		
		buf.append("</span>");	
				
		buf.append("</td><td><b>" + title + "</b></td></tr><tr><td colspan='2'>");
		
		buf.append("<span id='centext" +name+ "' style='display:block'>");
		buf.append(center);
		buf.append("</span></td></tr></table>");
		
		puckerScript = buf.toString();
		
		if(open){
			return puckerScript;
		}else{
			puckerScript = puckerScript.replaceAll("style='display:block'","temp");
			puckerScript = puckerScript.replaceAll("style='display:none'","style='display:block'");
			puckerScript = puckerScript.replaceAll("temp","style='display:none'");
			return puckerScript;
		}		
	}
	
//	public static void main(String[] args){
//		System.out.println(new PuckerScript().pucker("SSSSS","hean",false,""));	
//		System.out.println(new PuckerScript().pucker("tttt","hean",true,""));	
//	}

}
