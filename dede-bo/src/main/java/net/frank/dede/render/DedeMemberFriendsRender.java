package net.frank.dede.render;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import net.frank.framework.bo.BaseEntity;
import net.frank.framework.thin.render.BaseEntityTypeRender;

public final class DedeMemberFriendsRender extends BaseEntityTypeRender {

	private static final String FIELD_ID = "id";
	private static final String FIELD_FID = "fid";
	private static final String FIELD_FLOGINID = "floginid";
	private static final String FIELD_FUNAME = "funame";
	private static final String FIELD_MID = "mid";
	private static final String FIELD_ADDTIME = "addtime";
	private static final String FIELD_FTYPE = "ftype";
	private static final String FIELD_GROUPID = "groupid";
	private static final String FIELD_DESCRIPTION = "description";

	@Override
	public void outputBodyXml(BaseEntity targetObject, String property,
			StringBuffer input) {
		getWsRenderPool().getWsRender("java.lang.Integer").outputXml(targetObject,
			FIELD_ID, input);
		getWsRenderPool().getWsRender("java.lang.Integer").outputXml(targetObject,
			FIELD_FID, input);
		getWsRenderPool().getWsRender("java.lang.String").outputXml(targetObject,
			FIELD_FLOGINID, input);
		getWsRenderPool().getWsRender("java.lang.String").outputXml(targetObject,
			FIELD_FUNAME, input);
		getWsRenderPool().getWsRender("java.lang.Integer").outputXml(targetObject,
			FIELD_MID, input);
		getWsRenderPool().getWsRender("java.lang.Integer").outputXml(targetObject,
			FIELD_ADDTIME, input);
		getWsRenderPool().getWsRender("java.lang.Byte").outputXml(targetObject,
			FIELD_FTYPE, input);
		getWsRenderPool().getWsRender("java.lang.Integer").outputXml(targetObject,
			FIELD_GROUPID, input);
		getWsRenderPool().getWsRender("java.lang.String").outputXml(targetObject,
			FIELD_DESCRIPTION, input);
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
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_FID)){
					getWsRenderPool().getWsRender("java.lang.Integer").setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_FLOGINID)){
					getWsRenderPool().getWsRender("java.lang.String").setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_FUNAME)){
					getWsRenderPool().getWsRender("java.lang.String").setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_MID)){
					getWsRenderPool().getWsRender("java.lang.Integer").setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_ADDTIME)){
					getWsRenderPool().getWsRender("java.lang.Integer").setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_FTYPE)){
					getWsRenderPool().getWsRender("java.lang.Byte").setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_GROUPID)){
					getWsRenderPool().getWsRender("java.lang.Integer").setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_DESCRIPTION)){
					getWsRenderPool().getWsRender("java.lang.String").setProperty(
							targetObject,currentElement);
				}
			}
		}
	}
}
