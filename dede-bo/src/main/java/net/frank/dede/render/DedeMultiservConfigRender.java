package net.frank.dede.render;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import net.frank.framework.bo.BaseEntity;
import net.frank.framework.thin.render.BaseEntityTypeRender;

public final class DedeMultiservConfigRender extends BaseEntityTypeRender {

	private static final String FIELD_REMOTEUPLOADS = "remoteuploads";
	private static final String FIELD_REMOTEUPURL = "remoteupUrl";
	private static final String FIELD_RMINFO = "rminfo";
	private static final String FIELD_SERVINFO = "servinfo";

	@Override
	public void outputBodyXml(BaseEntity targetObject, String property,
			StringBuffer input) {
		getWsRenderPool().getWsRender("java.lang.Integer").outputXml(targetObject,
			FIELD_REMOTEUPLOADS, input);
		getWsRenderPool().getWsRender("[C").outputXml(targetObject,
			FIELD_REMOTEUPURL, input);
		getWsRenderPool().getWsRender("[C").outputXml(targetObject,
			FIELD_RMINFO, input);
		getWsRenderPool().getWsRender("[C").outputXml(targetObject,
			FIELD_SERVINFO, input);
	}

	@Override
	public void setBodyProperty(BaseEntity targetObject, Node w3cNode) {
		NodeList propertiesElement = w3cNode.getChildNodes();
		if(propertiesElement!=null && propertiesElement.getLength()>0){
			for(int i=0;i<propertiesElement.getLength();i++){
				Node currentElement = propertiesElement.item(i);
				if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_REMOTEUPLOADS)){
					getWsRenderPool().getWsRender("java.lang.Integer").setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_REMOTEUPURL)){
					getWsRenderPool().getWsRender("[C").setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_RMINFO)){
					getWsRenderPool().getWsRender("[C").setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_SERVINFO)){
					getWsRenderPool().getWsRender("[C").setProperty(
							targetObject,currentElement);
				}
			}
		}
	}
}
