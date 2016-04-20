package net.frank.dede.render;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import net.frank.framework.bo.BaseEntity;
import net.frank.framework.thin.render.BaseEntityTypeRender;

public final class DedeArcattRender extends BaseEntityTypeRender {

	private static final String FIELD_SORTID = "sortid";
	private static final String FIELD_ATT = "att";
	private static final String FIELD_ATTNAME = "attname";

	@Override
	public void outputBodyXml(BaseEntity targetObject, String property,
			StringBuffer input) {
		getWsRenderPool().getWsRender("java.lang.Integer").outputXml(targetObject,
			FIELD_SORTID, input);
		getWsRenderPool().getWsRender("java.lang.String").outputXml(targetObject,
			FIELD_ATT, input);
		getWsRenderPool().getWsRender("java.lang.String").outputXml(targetObject,
			FIELD_ATTNAME, input);
	}

	@Override
	public void setBodyProperty(BaseEntity targetObject, Node w3cNode) {
		NodeList propertiesElement = w3cNode.getChildNodes();
		if(propertiesElement!=null && propertiesElement.getLength()>0){
			for(int i=0;i<propertiesElement.getLength();i++){
				Node currentElement = propertiesElement.item(i);
				if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_SORTID)){
					getWsRenderPool().getWsRender("java.lang.Integer").setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_ATT)){
					getWsRenderPool().getWsRender("java.lang.String").setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_ATTNAME)){
					getWsRenderPool().getWsRender("java.lang.String").setProperty(
							targetObject,currentElement);
				}
			}
		}
	}
}
