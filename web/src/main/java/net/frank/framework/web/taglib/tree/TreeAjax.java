package net.frank.framework.web.taglib.tree;

import org.directwebremoting.WebContextFactory;

import net.frank.framework.web.ajax.BaseAjax;

public class TreeAjax extends BaseAjax{
	
	
	public String showCallbackPage(String callback,String id) throws Exception{
		int index = id.indexOf("_");
		if (index>0){
			id = id.substring(index+1);
		}
		return WebContextFactory.get().forwardToString(callback+id); 
		
	}
}
