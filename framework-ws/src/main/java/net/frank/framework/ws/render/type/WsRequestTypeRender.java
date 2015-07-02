package net.frank.framework.ws.render.type;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import net.frank.framework.bo.BaseEntity;
import net.frank.framework.ws.define.WsRequest;
import net.frank.framework.ws.render.DefaultWsRender;

public final class WsRequestTypeRender extends DefaultWsRender {
	private static final String BEGIN_TAG="<wsRequest>";
	private static final String END_TAG="</wsRequest>";
	private static final String DEFAULT_CLASS_NAME = "net.frank.framework.bo.Resource";
	
	private static final String FIELD_ACTION = "action";
	private static final String FIELD_CREATE_DATE = "createDate";
	private static final String FIELD_RESOURCE = "resource";
	
	
	@Override
	public void outputXml(BaseEntity targetObject, String property,
			StringBuffer input) {
		input.append(BEGIN_TAG);
		getWsRenderPool().getWsRender(CLASS_NAME.CLASS_NAME_INTEGER).outputXml(targetObject,
				FIELD_ACTION, input);
		getWsRenderPool().getWsRender(CLASS_NAME.CLASS_NAME_DATE).outputXml(targetObject,
				FIELD_CREATE_DATE, input);
		getWsRenderPool().getWsRender(DEFAULT_CLASS_NAME).outputXml(targetObject,
				FIELD_RESOURCE, input);
		input.append(END_TAG);
	}
	
	@Override
	public void setProperty(BaseEntity targetObject, Node w3cNode) {
		WsRequest wsRequest = (WsRequest)targetObject;
		NodeList propertiesElement = w3cNode.getChildNodes();
		if(propertiesElement!=null && propertiesElement.getLength()>0){
			for(int i=0;i<propertiesElement.getLength();i++){
				Node currentElement = propertiesElement.item(i);
				if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_ACTION)){
					getWsRenderPool().getWsRender(CLASS_NAME.CLASS_NAME_INTEGER).setProperty(
							wsRequest,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_CREATE_DATE)){
					getWsRenderPool().getWsRender(CLASS_NAME.CLASS_NAME_DATE).setProperty(
							wsRequest,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_RESOURCE)){
					getWsRenderPool().getWsRender(DEFAULT_CLASS_NAME).setProperty(
							wsRequest,currentElement);
				}
			}
		}
	}
}
