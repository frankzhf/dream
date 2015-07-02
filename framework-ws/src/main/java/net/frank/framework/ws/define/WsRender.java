package net.frank.framework.ws.define;

import org.w3c.dom.Node;

import net.frank.framework.bo.BaseEntity;
import net.frank.framework.ws.WsRenderProvider;

public interface WsRender {
	public void outputXml(BaseEntity targetObject,String property,StringBuffer input);
	
	public void setProperty(BaseEntity targetObject,Node w3cNode);
	
	public WsRenderProvider getWsRenderPool();
	
	public Object getObject(String text);
	
	public String getClassName(String property);
}
