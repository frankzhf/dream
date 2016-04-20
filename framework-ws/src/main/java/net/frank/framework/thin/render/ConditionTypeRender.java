package net.frank.framework.thin.render;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import net.frank.framework.bo.BaseEntity;
import net.frank.framework.thin.Condition;
import net.frank.framework.ws.render.DefaultWsRender;

public final class ConditionTypeRender extends DefaultWsRender {
	private static final String BEGIN_TAG="<Condition>";
	private static final String END_TAG="</Condition>";
	
	private static final String FIELD_RELATE = "relate";
	private static final String FIELD_COLUMN_NAME = "columnName";
	private static final String FIELD_COLUMN_TYPE = "columnType";
	private static final String FIELD_OPERATE = "operate";
	private static final String FIELD_VALUE = "value";
	
	@Override
	public void outputXml(BaseEntity targetObject, String property,
			StringBuffer input) {
		input.append(BEGIN_TAG);
		getWsRenderPool().getWsRender(CLASS_NAME.CLASS_NAME_INTEGER).outputXml(targetObject,
				FIELD_RELATE, input);
		getWsRenderPool().getWsRender(CLASS_NAME.CLASS_NAME_STRING).outputXml(targetObject,
				FIELD_COLUMN_NAME, input);
		getWsRenderPool().getWsRender(CLASS_NAME.CLASS_NAME_INTEGER).outputXml(targetObject,
				FIELD_COLUMN_TYPE, input);
		getWsRenderPool().getWsRender(CLASS_NAME.CLASS_NAME_INTEGER).outputXml(targetObject,
				FIELD_OPERATE, input);
		getWsRenderPool().getWsRender(CLASS_NAME.CLASS_NAME_STRING).outputXml(targetObject,
				FIELD_VALUE, input);
		input.append(END_TAG);
	}
	
	@Override
	public void setProperty(BaseEntity targetObject, Node w3cNode) {
		Condition contition = (Condition)targetObject;
		NodeList propertiesElement = w3cNode.getChildNodes();
		if(propertiesElement!=null && propertiesElement.getLength()>0){
			for(int i=0;i<propertiesElement.getLength();i++){
				Node currentElement = propertiesElement.item(i);
				if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_RELATE)){
					getWsRenderPool().getWsRender(CLASS_NAME.CLASS_NAME_INTEGER).setProperty(
							contition,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_COLUMN_NAME)){
					getWsRenderPool().getWsRender(CLASS_NAME.CLASS_NAME_STRING).setProperty(
							contition,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_COLUMN_TYPE)){
					getWsRenderPool().getWsRender(CLASS_NAME.CLASS_NAME_INTEGER).setProperty(
							contition,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_OPERATE)){
					getWsRenderPool().getWsRender(CLASS_NAME.CLASS_NAME_INTEGER).setProperty(
							contition,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_VALUE)){
					getWsRenderPool().getWsRender(CLASS_NAME.CLASS_NAME_STRING).setProperty(
							contition,currentElement);
				}
			}
		}
	}
}
