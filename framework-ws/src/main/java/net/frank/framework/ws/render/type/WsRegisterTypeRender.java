package net.frank.framework.ws.render.type;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import net.frank.framework.bo.BaseEntity;
import net.frank.framework.ws.define.WsRegister;
import net.frank.framework.ws.render.DefaultWsRender;

public final class WsRegisterTypeRender extends DefaultWsRender {
	private static final String BEGIN_TAG="<wsRegister>";
	private static final String END_TAG="</wsRegister>";
	private static final String DEFAULT_WS_RENDER_ID = "default";
	
	private static final String FIELD_LOGIN_NAME = "loginId";
	private static final String FIELD_PASSWORD = "password";
	private static final String FIELD_STATUS = "status";
	
	@Override
	public void outputXml(BaseEntity targetObject, String property,
			StringBuffer input) {
		input.append(BEGIN_TAG);
		getWsRenderPool().getWsRender(DEFAULT_WS_RENDER_ID).outputXml(targetObject,
				FIELD_LOGIN_NAME, input);
		getWsRenderPool().getWsRender(DEFAULT_WS_RENDER_ID).outputXml(targetObject,
				FIELD_PASSWORD, input);
		getWsRenderPool().getWsRender(CLASS_NAME.CLASS_NAME_INTEGER).outputXml(targetObject,
				FIELD_STATUS, input);
		input.append(END_TAG);
	}
	
	@Override
	public void setProperty(BaseEntity targetObject, Node w3cNode) {
		WsRegister wsRegister = (WsRegister)targetObject;
		NodeList propertiesElement = w3cNode.getChildNodes();
		if(propertiesElement!=null && propertiesElement.getLength()>0){
			for(int i=0;i<propertiesElement.getLength();i++){
				Node currentElement = propertiesElement.item(i);
				if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_LOGIN_NAME)){
					getWsRenderPool().getWsRender(DEFAULT_WS_RENDER_ID).setProperty(
							wsRegister,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_PASSWORD)){
					getWsRenderPool().getWsRender(DEFAULT_WS_RENDER_ID).setProperty(
							wsRegister,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_STATUS)){
					getWsRenderPool().getWsRender(CLASS_NAME.CLASS_NAME_INTEGER).setProperty(
							wsRegister,currentElement);
				}
			}
		}
		
	}
}
