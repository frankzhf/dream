package net.frank.framework.web.taglib.content;

import java.io.Serializable;
import java.util.Map;

import net.frank.framework.web.taglib.content.type.TypeRender;

public class ContentRenderProvider implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 252529860076398146L;

	private Map<String,TypeRender> typeRenderMap;

	private static final String DEFAULT_TYPE_RENDER = "default";

	public void setTypeRenderMap(Map<String,TypeRender> typeRenderMap) {
		this.typeRenderMap = typeRenderMap;
	}
	
	public TypeRender getTypeRender(String className) {
		if(typeRenderMap.get(className)!= null){
			return typeRenderMap.get(className);
		}else{
			return typeRenderMap.get(DEFAULT_TYPE_RENDER);
		}
	}
}
