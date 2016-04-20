package net.frank.dede.render;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import net.frank.framework.bo.BaseEntity;
import net.frank.framework.thin.render.BaseEntityTypeRender;

public final class DedeAdmintypeRender extends BaseEntityTypeRender {

	private static final String FIELD_RANK = "rank";
	private static final String FIELD_TYPENAME = "typename";
	private static final String FIELD_SYSTEM = "system";
	private static final String FIELD_PURVIEWS = "purviews";

	@Override
	public void outputBodyXml(BaseEntity targetObject, String property,
			StringBuffer input) {
		getWsRenderPool().getWsRender("java.lang.Float").outputXml(targetObject,
			FIELD_RANK, input);
		getWsRenderPool().getWsRender("java.lang.String").outputXml(targetObject,
			FIELD_TYPENAME, input);
		getWsRenderPool().getWsRender("java.lang.Integer").outputXml(targetObject,
			FIELD_SYSTEM, input);
		getWsRenderPool().getWsRender("[C").outputXml(targetObject,
			FIELD_PURVIEWS, input);
	}

	@Override
	public void setBodyProperty(BaseEntity targetObject, Node w3cNode) {
		NodeList propertiesElement = w3cNode.getChildNodes();
		if(propertiesElement!=null && propertiesElement.getLength()>0){
			for(int i=0;i<propertiesElement.getLength();i++){
				Node currentElement = propertiesElement.item(i);
				if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_RANK)){
					getWsRenderPool().getWsRender("java.lang.Float").setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_TYPENAME)){
					getWsRenderPool().getWsRender("java.lang.String").setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_SYSTEM)){
					getWsRenderPool().getWsRender("java.lang.Integer").setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_PURVIEWS)){
					getWsRenderPool().getWsRender("[C").setProperty(
							targetObject,currentElement);
				}
			}
		}
	}
}
