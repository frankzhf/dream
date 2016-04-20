package net.frank.dede.render;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import net.frank.framework.bo.BaseEntity;
import net.frank.framework.thin.render.BaseEntityTypeRender;

public final class DedeSysconfigRender extends BaseEntityTypeRender {

	private static final String FIELD_AID = "aid";
	private static final String FIELD_VARNAME = "varname";
	private static final String FIELD_INFO = "info";
	private static final String FIELD_GROUPID = "groupid";
	private static final String FIELD_TYPE = "type";
	private static final String FIELD_VALUE = "value";

	@Override
	public void outputBodyXml(BaseEntity targetObject, String property,
			StringBuffer input) {
		getWsRenderPool().getWsRender("java.lang.Integer").outputXml(targetObject,
			FIELD_AID, input);
		getWsRenderPool().getWsRender("java.lang.String").outputXml(targetObject,
			FIELD_VARNAME, input);
		getWsRenderPool().getWsRender("java.lang.String").outputXml(targetObject,
			FIELD_INFO, input);
		getWsRenderPool().getWsRender("java.lang.Integer").outputXml(targetObject,
			FIELD_GROUPID, input);
		getWsRenderPool().getWsRender("java.lang.String").outputXml(targetObject,
			FIELD_TYPE, input);
		getWsRenderPool().getWsRender("[C").outputXml(targetObject,
			FIELD_VALUE, input);
	}

	@Override
	public void setBodyProperty(BaseEntity targetObject, Node w3cNode) {
		NodeList propertiesElement = w3cNode.getChildNodes();
		if(propertiesElement!=null && propertiesElement.getLength()>0){
			for(int i=0;i<propertiesElement.getLength();i++){
				Node currentElement = propertiesElement.item(i);
				if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_AID)){
					getWsRenderPool().getWsRender("java.lang.Integer").setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_VARNAME)){
					getWsRenderPool().getWsRender("java.lang.String").setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_INFO)){
					getWsRenderPool().getWsRender("java.lang.String").setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_GROUPID)){
					getWsRenderPool().getWsRender("java.lang.Integer").setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_TYPE)){
					getWsRenderPool().getWsRender("java.lang.String").setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_VALUE)){
					getWsRenderPool().getWsRender("[C").setProperty(
							targetObject,currentElement);
				}
			}
		}
	}
}
