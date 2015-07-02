package net.frank.framework.thin.render;

import org.w3c.dom.Node;

import net.frank.framework.bo.BaseEntity;
import net.frank.framework.ws.render.DefaultWsRender;

public abstract class BaseEntityTypeRender extends DefaultWsRender {
	
	@Override
	public void outputXml(BaseEntity targetObject, String property,
			StringBuffer input) {
		//input.append(BEGIN_TAG.replace("${className}", getClassName(targetObject)));
		outputBodyXml(targetObject,property,input);
		//input.append(END_TAG);
	}

	@Override
	public void setProperty(BaseEntity targetObject, Node w3cNode) {
		if(targetObject!=null){
			setBodyProperty(targetObject, w3cNode);
		}
	}
	
	public abstract void outputBodyXml(BaseEntity targetObject, String property,
			StringBuffer input);
	
	public abstract void setBodyProperty(BaseEntity targetObject, Node w3cNode);
	
	
	private String getClassName(BaseEntity targetObject){
		return targetObject.getClass().getName();
	}
}
