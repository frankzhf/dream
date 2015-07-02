package net.frank.framework.ws.render.type;

import java.util.ArrayList;
import java.util.Iterator;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import net.frank.commons.CommonConstants;
import net.frank.framework.bo.BaseEntity;
import net.frank.framework.service.CacheService;
import net.frank.framework.ws.render.DefaultWsRender;

public class ResourceTypeRender extends DefaultWsRender {

	private static final String DEFAULT_CLASS_NAME = "net.frank.framework.bo.Resource";

	private static final String DEFAULT_WS_RENDER_ID = "default";

	private static final String DEFAULT_BO_WS_RENDER_ID = "net.frank.framework.bo.BusinessObject";

	private static final String TIMESTAMP_WS_RENDER_ID = "java.util.Date";

	private static final String DEFAULT_CHILDREN_FIELD_NAME = "children";

	private static final String DEFAULT_CHILDREN_CLASS_NAME = "java.util.List";

	//private static final String DEFAULT_REF_ELEMENT_NAME = "resourceRef";

	private CacheService cacheService;

	public void setCacheService(CacheService cacheService) {
		this.cacheService = cacheService;
	}

	@Override
	public void outputXml(BaseEntity targetObject, String property,
			StringBuffer input) {
		input.append(Property.BEGIN).append(property).append(Property.BEGIN_2)
				.append(DEFAULT_CLASS_NAME).append(Property.BEGIN_3);
		net.frank.framework.bo.Resource _resource = null;
		if(property == null || "".equals(property)){
			_resource = (net.frank.framework.bo.Resource)targetObject;
		}else{
			Object field = targetObject._getValue(property);
			if (field != null) {
				_resource = (net.frank.framework.bo.Resource) field;
			} else {
				_resource = new net.frank.framework.bo.Resource();
			}
		}
		getWsRenderPool().getWsRender(CLASS_NAME.CLASS_NAME_LONG).outputXml(
				_resource, Resource.PROPERTY.ID, input);
		getWsRenderPool().getWsRender(CLASS_NAME.CLASS_NAME_LONG).outputXml(
				_resource, Resource.PROPERTY.PARENT_ID, input);
		getWsRenderPool().getWsRender(CLASS_NAME.CLASS_NAME_BOOLEAN).outputXml(
				_resource, Resource.PROPERTY.ACTIVE, input);
		getWsRenderPool().getWsRender(CLASS_NAME.CLASS_NAME_BOOLEAN).outputXml(
				_resource, Resource.PROPERTY.SYSTEM_NODE, input);
		getWsRenderPool().getWsRender(DEFAULT_WS_RENDER_ID).outputXml(
				_resource, Resource.PROPERTY.ALIAS, input);
		getWsRenderPool().getWsRender(TIMESTAMP_WS_RENDER_ID).outputXml(
				_resource, Resource.PROPERTY.CREATED_DT, input);
		getWsRenderPool().getWsRender(TIMESTAMP_WS_RENDER_ID).outputXml(
				_resource, Resource.PROPERTY.LAST_UPDATED_DT, input);
		getWsRenderPool().getWsRender(CLASS_NAME.CLASS_NAME_BYTE).outputXml(
				_resource, Resource.PROPERTY.CURRENT_ACCOUNT_PERMISSION, input);
		getWsRenderPool().getWsRender(CLASS_NAME.CLASS_NAME_BYTE).outputXml(
				_resource, Resource.PROPERTY.CURRENT_GROUP_PERMISSION, input);
		getWsRenderPool().getWsRender(CLASS_NAME.CLASS_NAME_BYTE).outputXml(
				_resource, Resource.PROPERTY.OTHERS_PERMISSION, input);
		getWsRenderPool().getWsRender(CLASS_NAME.CLASS_NAME_LONG).outputXml(
				_resource, Resource.PROPERTY.TYPE_ID, input);
		getWsRenderPool().getWsRender(CLASS_NAME.CLASS_NAME_LONG).outputXml(
				_resource, Resource.PROPERTY.OWN_RESOURCE_ID, input);
		getWsRenderPool().getWsRender(CLASS_NAME.CLASS_NAME_LONG).outputXml(
				_resource, Resource.PROPERTY.OWN_GROUP_RESOURCE_ID, input);
		getWsRenderPool().getWsRender(CLASS_NAME.CLASS_NAME_LONG).outputXml(
				_resource, Resource.PROPERTY.LAST_ACCOUNT_RESOURCE_ID, input);
		String type = _resource.getLongString("typeId");
		if (type != null && !CommonConstants.EMPTY_STRING.equals(type)) {
			Long _type = Long.decode(type);
			if ((TYPE.RESOURCE).equals(_type)) {
				if (_resource.getChildren() != null
						&& !_resource.getChildren().isEmpty()) {
					input.append(Property.BEGIN)
							.append(DEFAULT_CHILDREN_FIELD_NAME)
							.append(Property.BEGIN_2)
							.append(DEFAULT_CHILDREN_CLASS_NAME)
							.append(Property.BEGIN_3);
					for (Iterator<net.frank.framework.bo.Resource> it = _resource
							.getChildren().iterator(); it.hasNext();) {
						net.frank.framework.bo.Resource currChild = it.next();
						input.append(Resource.REF_BEGIN)
								.append(currChild.getId())
								.append(Resource.REF_END);
					}
					input.append(Property.END);
				} else {
					outputEmptyXml(DEFAULT_CHILDREN_FIELD_NAME, input);
				}
			} else {
				input.append(Property.BEGIN).append(Resource.PROPERTY.OBJECT)
						.append(Property.BEGIN_2);
				input.append(cacheService.getTypeContent().get(_type)
						.getEntityClassName());
				input.append(Property.BEGIN_3);
				getWsRenderPool().getWsRender(DEFAULT_BO_WS_RENDER_ID)
						.outputXml(_resource, "object", input);
				input.append(Property.END);
			}
		}
		input.append(Property.END);
	}

	@Override
	public void setProperty(BaseEntity targetObject, Node w3cNode) {
		String propertyName = w3cNode.getAttributes()
				.getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue();
		NodeList propertiesElement = w3cNode.getChildNodes();
		if (propertiesElement!=null && propertiesElement.getLength()>0) {
			net.frank.framework.bo.Resource _resource = new net.frank.framework.bo.Resource();
			for (int i=0;i<propertiesElement.getLength();i++) {
				Node currentElement = propertiesElement.item(i);
				if (currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue()
						.equals(Resource.PROPERTY.OBJECT)) {
					if (currentElement.getChildNodes()!=null && currentElement.getChildNodes().getLength()>0 ) {
						getWsRenderPool().getWsRender(DEFAULT_BO_WS_RENDER_ID)
								.setProperty(_resource, currentElement);
					}
				} else if (currentElement
						.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(
								Resource.PROPERTY.ID)) {
					getWsRenderPool().getWsRender(CLASS_NAME.CLASS_NAME_LONG)
							.setProperty(_resource, currentElement);
				} else if (currentElement
						.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(
								Resource.PROPERTY.PARENT_ID)) {
					getWsRenderPool().getWsRender(CLASS_NAME.CLASS_NAME_LONG)
							.setProperty(_resource, currentElement);
				} else if (currentElement
						.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(
								Resource.PROPERTY.ACTIVE)) {
					getWsRenderPool()
							.getWsRender(CLASS_NAME.CLASS_NAME_BOOLEAN)
							.setProperty(_resource, currentElement);
				} else if (currentElement
						.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(
								Resource.PROPERTY.SYSTEM_NODE)) {
					getWsRenderPool()
							.getWsRender(CLASS_NAME.CLASS_NAME_BOOLEAN)
							.setProperty(_resource, currentElement);
				} else if (currentElement
						.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(
								Resource.PROPERTY.ALIAS)) {
					getWsRenderPool().getWsRender(DEFAULT_WS_RENDER_ID)
							.setProperty(_resource, currentElement);
				} else if (currentElement
						.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(
								Resource.PROPERTY.CREATED_DT)) {
					getWsRenderPool().getWsRender(TIMESTAMP_WS_RENDER_ID)
							.setProperty(_resource, currentElement);
				} else if (currentElement
						.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(
								Resource.PROPERTY.LAST_UPDATED_DT)) {
					getWsRenderPool().getWsRender(TIMESTAMP_WS_RENDER_ID)
							.setProperty(_resource, currentElement);
				} else if (currentElement
						.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(
								Resource.PROPERTY.CURRENT_ACCOUNT_PERMISSION)) {
					getWsRenderPool()
							.getWsRender(CLASS_NAME.CLASS_NAME_INTEGER)
							.setProperty(_resource, currentElement);
				} else if (currentElement
						.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(
								Resource.PROPERTY.CURRENT_GROUP_PERMISSION)) {
					getWsRenderPool()
							.getWsRender(CLASS_NAME.CLASS_NAME_INTEGER)
							.setProperty(_resource, currentElement);
				} else if (currentElement
						.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(
								Resource.PROPERTY.OTHERS_PERMISSION)) {
					getWsRenderPool()
							.getWsRender(CLASS_NAME.CLASS_NAME_INTEGER)
							.setProperty(_resource, currentElement);
				} else if (currentElement
						.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(
								Resource.PROPERTY.TYPE_ID)) {
					getWsRenderPool().getWsRender(CLASS_NAME.CLASS_NAME_LONG)
							.setProperty(_resource, currentElement);
				} else if (currentElement
						.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(
								Resource.PROPERTY.OWN_RESOURCE_ID)) {
					getWsRenderPool().getWsRender(CLASS_NAME.CLASS_NAME_LONG)
							.setProperty(_resource, currentElement);
				} else if (currentElement
						.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(
								Resource.PROPERTY.OWN_GROUP_RESOURCE_ID)) {
					getWsRenderPool().getWsRender(CLASS_NAME.CLASS_NAME_LONG)
							.setProperty(_resource, currentElement);
				} else if (currentElement
						.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(
								Resource.PROPERTY.LAST_ACCOUNT_RESOURCE_ID)) {
					getWsRenderPool().getWsRender(CLASS_NAME.CLASS_NAME_LONG)
							.setProperty(_resource, currentElement);
				} else if (currentElement
						.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(
								Resource.PROPERTY.CHILDREN)) {
					_resource
							.setChildren(new ArrayList<net.frank.framework.bo.Resource>());
					NodeList sonElement = currentElement.getChildNodes();
					if(sonElement!=null && sonElement.getLength()>0){
						for (int j=0;j<sonElement.getLength(); j++) {
							Node _son = sonElement.item(j);
							net.frank.framework.bo.Resource _sonResource = new net.frank.framework.bo.Resource();
							_resource.getChildren().add(_sonResource);
							_sonResource.setId(Long.decode(_son.getAttributes().getNamedItem(
									Resource.PROPERTY.ID).getNodeValue()));
						}
					}
				}
			}
			targetObject._setValue(propertyName, _resource);
		} else {
			targetObject._setValue(propertyName, null);
		}
	}

	@Override
	public String getClassName(String property) {
		return DEFAULT_CLASS_NAME;
	}
}
