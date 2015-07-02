package net.frank.framework.ws.render.type;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import net.frank.framework.bo.BaseEntity;
import net.frank.framework.ws.define.WsAaInfo;
import net.frank.framework.ws.render.DefaultWsRender;

public final class WsAaInfoTypeRender extends DefaultWsRender {
	
	private static final String BEGIN_TAG="<wsAaInfo>";
	private static final String END_TAG="</wsAaInfo>";
	private static final String DEFAULT_WS_RENDER_ID = "default";
	
	private static final String FIELD_LOGIN_NAME = "loginName";
	private static final String FIELD_PASSWORD = "password";
	private static final String FIELD_PLATFORM = "platform";
	private static final String FIELD_APPLICATION = "application";
	private static final String FIELD_STATUS = "loginStatus";	
	
	@Override
	public void outputXml(BaseEntity targetObject, String property,
			StringBuffer input) {
		input.append(BEGIN_TAG);
		getWsRenderPool().getWsRender(DEFAULT_WS_RENDER_ID).outputXml(targetObject,
				FIELD_LOGIN_NAME, input);
		getWsRenderPool().getWsRender(DEFAULT_WS_RENDER_ID).outputXml(targetObject,
				FIELD_PASSWORD, input);
		getWsRenderPool().getWsRender(DEFAULT_WS_RENDER_ID).outputXml(targetObject,
				FIELD_PLATFORM, input);
		getWsRenderPool().getWsRender(DEFAULT_WS_RENDER_ID).outputXml(targetObject,
				FIELD_APPLICATION, input);
		getWsRenderPool().getWsRender(CLASS_NAME.CLASS_NAME_INTEGER).outputXml(targetObject,
				FIELD_STATUS, input);
		input.append(END_TAG);
	}
	
	@Override
	public void setProperty(BaseEntity targetObject, Node w3cNode) {
		WsAaInfo wsAaInfo = (WsAaInfo)targetObject;
		NodeList propertiesElement = w3cNode.getChildNodes();
		if(propertiesElement!=null && propertiesElement.getLength()>0){
			for(int i=0;i<propertiesElement.getLength();i++){
				Node currentElement = propertiesElement.item(i);
				if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_LOGIN_NAME)){
					getWsRenderPool().getWsRender(DEFAULT_WS_RENDER_ID).setProperty(
							wsAaInfo,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_PASSWORD)){
					getWsRenderPool().getWsRender(DEFAULT_WS_RENDER_ID).setProperty(
							wsAaInfo,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_STATUS)){
					getWsRenderPool().getWsRender(CLASS_NAME.CLASS_NAME_INTEGER).setProperty(
							wsAaInfo,currentElement);
				}
			}
		}
		
	}
	
}
