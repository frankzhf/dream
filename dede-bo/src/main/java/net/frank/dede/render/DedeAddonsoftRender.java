package net.frank.dede.render;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import net.frank.framework.bo.BaseEntity;
import net.frank.framework.thin.render.BaseEntityTypeRender;

public final class DedeAddonsoftRender extends BaseEntityTypeRender {

	private static final String FIELD_AID = "aid";
	private static final String FIELD_TYPEID = "typeid";
	private static final String FIELD_FILETYPE = "filetype";
	private static final String FIELD_LANGUAGE = "language";
	private static final String FIELD_SOFTTYPE = "softtype";
	private static final String FIELD_ACCREDIT = "accredit";
	private static final String FIELD_OS = "os";
	private static final String FIELD_SOFTRANK = "softrank";
	private static final String FIELD_OFFICIALURL = "officialUrl";
	private static final String FIELD_OFFICIALDEMO = "officialDemo";
	private static final String FIELD_SOFTSIZE = "softsize";
	private static final String FIELD_SOFTLINKS = "softlinks";
	private static final String FIELD_INTRODUCE = "introduce";
	private static final String FIELD_DACCESS = "daccess";
	private static final String FIELD_NEEDMONEY = "needmoney";
	private static final String FIELD_TEMPLET = "templet";
	private static final String FIELD_USERIP = "userip";
	private static final String FIELD_REDIRECTURL = "redirecturl";

	@Override
	public void outputBodyXml(BaseEntity targetObject, String property,
			StringBuffer input) {
		getWsRenderPool().getWsRender("java.lang.Integer").outputXml(targetObject,
			FIELD_AID, input);
		getWsRenderPool().getWsRender("java.lang.Integer").outputXml(targetObject,
			FIELD_TYPEID, input);
		getWsRenderPool().getWsRender("java.lang.String").outputXml(targetObject,
			FIELD_FILETYPE, input);
		getWsRenderPool().getWsRender("java.lang.String").outputXml(targetObject,
			FIELD_LANGUAGE, input);
		getWsRenderPool().getWsRender("java.lang.String").outputXml(targetObject,
			FIELD_SOFTTYPE, input);
		getWsRenderPool().getWsRender("java.lang.String").outputXml(targetObject,
			FIELD_ACCREDIT, input);
		getWsRenderPool().getWsRender("java.lang.String").outputXml(targetObject,
			FIELD_OS, input);
		getWsRenderPool().getWsRender("java.lang.Integer").outputXml(targetObject,
			FIELD_SOFTRANK, input);
		getWsRenderPool().getWsRender("java.lang.String").outputXml(targetObject,
			FIELD_OFFICIALURL, input);
		getWsRenderPool().getWsRender("java.lang.String").outputXml(targetObject,
			FIELD_OFFICIALDEMO, input);
		getWsRenderPool().getWsRender("java.lang.String").outputXml(targetObject,
			FIELD_SOFTSIZE, input);
		getWsRenderPool().getWsRender("[C").outputXml(targetObject,
			FIELD_SOFTLINKS, input);
		getWsRenderPool().getWsRender("[C").outputXml(targetObject,
			FIELD_INTRODUCE, input);
		getWsRenderPool().getWsRender("java.lang.Integer").outputXml(targetObject,
			FIELD_DACCESS, input);
		getWsRenderPool().getWsRender("java.lang.Integer").outputXml(targetObject,
			FIELD_NEEDMONEY, input);
		getWsRenderPool().getWsRender("java.lang.String").outputXml(targetObject,
			FIELD_TEMPLET, input);
		getWsRenderPool().getWsRender("java.lang.String").outputXml(targetObject,
			FIELD_USERIP, input);
		getWsRenderPool().getWsRender("java.lang.String").outputXml(targetObject,
			FIELD_REDIRECTURL, input);
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
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_TYPEID)){
					getWsRenderPool().getWsRender("java.lang.Integer").setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_FILETYPE)){
					getWsRenderPool().getWsRender("java.lang.String").setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_LANGUAGE)){
					getWsRenderPool().getWsRender("java.lang.String").setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_SOFTTYPE)){
					getWsRenderPool().getWsRender("java.lang.String").setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_ACCREDIT)){
					getWsRenderPool().getWsRender("java.lang.String").setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_OS)){
					getWsRenderPool().getWsRender("java.lang.String").setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_SOFTRANK)){
					getWsRenderPool().getWsRender("java.lang.Integer").setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_OFFICIALURL)){
					getWsRenderPool().getWsRender("java.lang.String").setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_OFFICIALDEMO)){
					getWsRenderPool().getWsRender("java.lang.String").setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_SOFTSIZE)){
					getWsRenderPool().getWsRender("java.lang.String").setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_SOFTLINKS)){
					getWsRenderPool().getWsRender("[C").setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_INTRODUCE)){
					getWsRenderPool().getWsRender("[C").setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_DACCESS)){
					getWsRenderPool().getWsRender("java.lang.Integer").setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_NEEDMONEY)){
					getWsRenderPool().getWsRender("java.lang.Integer").setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_TEMPLET)){
					getWsRenderPool().getWsRender("java.lang.String").setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_USERIP)){
					getWsRenderPool().getWsRender("java.lang.String").setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_REDIRECTURL)){
					getWsRenderPool().getWsRender("java.lang.String").setProperty(
							targetObject,currentElement);
				}
			}
		}
	}
}
