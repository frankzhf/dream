package net.frank.dede.render;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import net.frank.framework.bo.BaseEntity;
import net.frank.framework.thin.render.BaseEntityTypeRender;

public final class DedePlusRender extends BaseEntityTypeRender {

	private static final String FIELD_AID = "aid";
	private static final String FIELD_PLUSNAME = "plusname";
	private static final String FIELD_MENUSTRING = "menustring";
	private static final String FIELD_MAINURL = "mainurl";
	private static final String FIELD_WRITER = "writer";
	private static final String FIELD_ISSHOW = "isshow";
	private static final String FIELD_FILELIST = "filelist";

	@Override
	public void outputBodyXml(BaseEntity targetObject, String property,
			StringBuffer input) {
		getWsRenderPool().getWsRender("java.lang.Integer").outputXml(targetObject,
			FIELD_AID, input);
		getWsRenderPool().getWsRender("java.lang.String").outputXml(targetObject,
			FIELD_PLUSNAME, input);
		getWsRenderPool().getWsRender("java.lang.String").outputXml(targetObject,
			FIELD_MENUSTRING, input);
		getWsRenderPool().getWsRender("java.lang.String").outputXml(targetObject,
			FIELD_MAINURL, input);
		getWsRenderPool().getWsRender("java.lang.String").outputXml(targetObject,
			FIELD_WRITER, input);
		getWsRenderPool().getWsRender("java.lang.Integer").outputXml(targetObject,
			FIELD_ISSHOW, input);
		getWsRenderPool().getWsRender("[C").outputXml(targetObject,
			FIELD_FILELIST, input);
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
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_PLUSNAME)){
					getWsRenderPool().getWsRender("java.lang.String").setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_MENUSTRING)){
					getWsRenderPool().getWsRender("java.lang.String").setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_MAINURL)){
					getWsRenderPool().getWsRender("java.lang.String").setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_WRITER)){
					getWsRenderPool().getWsRender("java.lang.String").setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_ISSHOW)){
					getWsRenderPool().getWsRender("java.lang.Integer").setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_FILELIST)){
					getWsRenderPool().getWsRender("[C").setProperty(
							targetObject,currentElement);
				}
			}
		}
	}
}
