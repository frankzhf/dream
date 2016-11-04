package net.frank.framework.thin.render;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import net.frank.framework.bo.BaseEntity;
import net.frank.framework.thin.OrderBy;
import net.frank.framework.ws.render.DefaultWsRender;

public final class OrderByTypeRender extends DefaultWsRender {
	private static final String BEGIN_TAG="<orderBy>";
	private static final String END_TAG="</orderBy>";
	
	private static final String FIELD_COLUMN_NAME = "columnName";
	private static final String FIELD_ORDER_STATUS = "orderStatus";
	
	@Override
	public void outputXml(BaseEntity targetObject, String property,
			StringBuffer input) {
		input.append(BEGIN_TAG);
		getWsRenderPool().getWsRender(CLASS_NAME.CLASS_NAME_STRING).outputXml(targetObject,
				FIELD_COLUMN_NAME, input);
		getWsRenderPool().getWsRender(CLASS_NAME.CLASS_NAME_INTEGER).outputXml(targetObject,
				FIELD_ORDER_STATUS, input);
		input.append(END_TAG);
	}
	
	@Override
	public void setProperty(BaseEntity targetObject, Node w3cNode) {
		OrderBy orderBy = (OrderBy)targetObject;
		NodeList propertiesElement = w3cNode.getChildNodes();
		if(propertiesElement!=null && propertiesElement.getLength()>0){
			for(int i=0;i<propertiesElement.getLength();i++){
				Node currentElement = propertiesElement.item(i);
				if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_COLUMN_NAME)){
					getWsRenderPool().getWsRender(CLASS_NAME.CLASS_NAME_STRING).setProperty(
							orderBy,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_ORDER_STATUS)){
					getWsRenderPool().getWsRender(CLASS_NAME.CLASS_NAME_INTEGER).setProperty(
							orderBy,currentElement);
				}
			}
		}
	}
}
