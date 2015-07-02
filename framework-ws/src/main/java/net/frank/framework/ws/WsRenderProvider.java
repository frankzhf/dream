package net.frank.framework.ws;

import java.io.Serializable;
import java.util.Map;

import net.frank.framework.ws.define.WsRender;

public class WsRenderProvider implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3653235788333855244L;

	private Map<String,WsRender> wsRenderMap;
	
	public void setWsRenderMap(Map<String,WsRender> wsRenderMap){
		this.wsRenderMap = wsRenderMap;
	}
	
	public WsRender getWsRender(String className) {
		if(wsRenderMap.get(className)!= null){
			return wsRenderMap.get(className);
		}else{
			return null;
		}
	}
}
