package net.frank.framework.ws.render.type;

import org.w3c.dom.Node;

import net.frank.commons.CommonConstants;
import net.frank.framework.bo.BaseEntity;
import net.frank.framework.ws.render.DefaultWsRender;

public class ResourceRefRender extends DefaultWsRender {

	private static final String DEFAULT_CLASS_NAME = "net.frank.framework.bo.Resource";
	
	private static final String DEFAULT_ATTRIBUTE_REFID = "refId";
	

	@Override
	public void outputXml(BaseEntity targetObject, String property,
			StringBuffer input) {
		if (targetObject != null
				&& targetObject instanceof net.frank.framework.bo.Resource
				&& ((net.frank.framework.bo.Resource) targetObject).getId() != null) {
			net.frank.framework.bo.Resource _self = (net.frank.framework.bo.Resource) targetObject;
			input.append(Property.BEGIN).append(property)
					.append(Property.BEGIN_2).append(DEFAULT_CLASS_NAME)
					.append(Property.BEGIN_RESOURCE_REF)
					.append(_self.getId() + CommonConstants.EMPTY_STRING)
					.append(Property.END_PROPERTY_EMPTY_END);
		} else {
			outputEmptyXml(property, input);
		}
	}
	
	@Override
	public void setProperty(BaseEntity targetObject, Node w3cNode) {
		String propertyName = w3cNode.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue();
		
		Node refIdAttribute = w3cNode.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_REFID);
		if(refIdAttribute!=null 
				&& refIdAttribute.getNodeValue()!=null 
				&& !CommonConstants.EMPTY_STRING.equals(refIdAttribute.getNodeValue())){
			String strRefId =refIdAttribute.getNodeValue();
			Long refId = Long.decode(strRefId);
			net.frank.framework.bo.Resource _refResource = new net.frank.framework.bo.Resource();
			if(_refResource!=null){
				_refResource.setId(refId);
			}
			targetObject._setValue(propertyName, _refResource);
		}else{
			targetObject._setValue(propertyName, null);
		}
	}
	
	@Override
	public String getClassName(String property) {
		return DEFAULT_CLASS_NAME;
	}
}