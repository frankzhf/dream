package net.frank.dede.render;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import net.frank.framework.bo.BaseEntity;
import net.frank.framework.thin.render.BaseEntityTypeRender;

public final class DedeFlinkRender extends BaseEntityTypeRender {

	private static final String FIELD_ID = "id";
	private static final String FIELD_SORTRANK = "sortrank";
	private static final String FIELD_URL = "url";
	private static final String FIELD_WEBNAME = "webname";
	private static final String FIELD_MSG = "msg";
	private static final String FIELD_EMAIL = "email";
	private static final String FIELD_LOGO = "logo";
	private static final String FIELD_DTIME = "dtime";
	private static final String FIELD_TYPEID = "typeid";
	private static final String FIELD_ISCHECK = "ischeck";

	@Override
	public void outputBodyXml(BaseEntity targetObject, String property,
			StringBuffer input) {
		getWsRenderPool().getWsRender("java.lang.Integer").outputXml(targetObject,
			FIELD_ID, input);
		getWsRenderPool().getWsRender("java.lang.Integer").outputXml(targetObject,
			FIELD_SORTRANK, input);
		getWsRenderPool().getWsRender("java.lang.String").outputXml(targetObject,
			FIELD_URL, input);
		getWsRenderPool().getWsRender("java.lang.String").outputXml(targetObject,
			FIELD_WEBNAME, input);
		getWsRenderPool().getWsRender("java.lang.String").outputXml(targetObject,
			FIELD_MSG, input);
		getWsRenderPool().getWsRender("java.lang.String").outputXml(targetObject,
			FIELD_EMAIL, input);
		getWsRenderPool().getWsRender("java.lang.String").outputXml(targetObject,
			FIELD_LOGO, input);
		getWsRenderPool().getWsRender("java.lang.Integer").outputXml(targetObject,
			FIELD_DTIME, input);
		getWsRenderPool().getWsRender("java.lang.Integer").outputXml(targetObject,
			FIELD_TYPEID, input);
		getWsRenderPool().getWsRender("java.lang.Integer").outputXml(targetObject,
			FIELD_ISCHECK, input);
	}

	@Override
	public void setBodyProperty(BaseEntity targetObject, Node w3cNode) {
		NodeList propertiesElement = w3cNode.getChildNodes();
		if(propertiesElement!=null && propertiesElement.getLength()>0){
			for(int i=0;i<propertiesElement.getLength();i++){
				Node currentElement = propertiesElement.item(i);
				if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_ID)){
					getWsRenderPool().getWsRender("java.lang.Integer").setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_SORTRANK)){
					getWsRenderPool().getWsRender("java.lang.Integer").setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_URL)){
					getWsRenderPool().getWsRender("java.lang.String").setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_WEBNAME)){
					getWsRenderPool().getWsRender("java.lang.String").setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_MSG)){
					getWsRenderPool().getWsRender("java.lang.String").setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_EMAIL)){
					getWsRenderPool().getWsRender("java.lang.String").setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_LOGO)){
					getWsRenderPool().getWsRender("java.lang.String").setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_DTIME)){
					getWsRenderPool().getWsRender("java.lang.Integer").setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_TYPEID)){
					getWsRenderPool().getWsRender("java.lang.Integer").setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_ISCHECK)){
					getWsRenderPool().getWsRender("java.lang.Integer").setProperty(
							targetObject,currentElement);
				}
			}
		}
	}
}
