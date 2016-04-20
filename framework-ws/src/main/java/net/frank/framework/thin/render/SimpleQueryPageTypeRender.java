package net.frank.framework.thin.render;

import java.util.ArrayList;
import java.util.Iterator;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import net.frank.framework.bo.BaseEntity;
import net.frank.framework.thin.Condition;
import net.frank.framework.thin.OrderBy;
import net.frank.framework.thin.SimpleQueryPage;
import net.frank.framework.ws.WsXmlConstants.Property;
import net.frank.framework.ws.render.DefaultWsRender;

public final class SimpleQueryPageTypeRender extends DefaultWsRender {
	private static final String BEGIN_TAG="<simpleQueryPage>";
	private static final String END_TAG="</simpleQueryPage>";
	
	private static final String BEGIN_TAG2="<BaseEntity class=\"${className}\">";
	private static final String END_TAG2="</BaseEntity>";
	
	private static final String FIELD_CONTITION_LIST = "contitionList";
	private static final String FIELD_ORDER_BY_LIST = "orderByList";
	private static final String FIELD_CURRENT_PAGE = "currentPage";
	private static final String FIELD_SIZE = "size";
	private static final String FIELD_COUNT = "count";
	private static final String FIELD_MAIN_QUERY_SQL = "mainQuerySql";
	private static final String FIELD_MAPPER_NAME = "rowMapperName";
	private static final String FIELD_RESULT = "result";
	
	private static final String ATTRIBLE_CLASS = "class";

	private static final String DEFAULT_CHILDREN_CLASS_NAME = "java.util.List";
	private static final String CONTITION_CLASS_NAME = "net.frank.framework.thin.Condition";
	private static final String ORDER_BY_CLASS_NAME = "net.frank.framework.thin.OrderBy";
	
	@Override
	public void outputXml(BaseEntity targetObject, String property,
			StringBuffer input) {
		input.append(BEGIN_TAG);
		getWsRenderPool().getWsRender(CLASS_NAME.CLASS_NAME_INTEGER).outputXml(targetObject,
				FIELD_CURRENT_PAGE, input);
		getWsRenderPool().getWsRender(CLASS_NAME.CLASS_NAME_INTEGER).outputXml(targetObject,
				FIELD_SIZE, input);
		getWsRenderPool().getWsRender(CLASS_NAME.CLASS_NAME_INTEGER).outputXml(targetObject,
				FIELD_COUNT, input);
		getWsRenderPool().getWsRender(CLASS_NAME.CLASS_NAME_CLOB).outputXml(targetObject,
				FIELD_MAIN_QUERY_SQL, input);
		getWsRenderPool().getWsRender(CLASS_NAME.CLASS_NAME_STRING).outputXml(targetObject,
				FIELD_MAPPER_NAME, input);
		SimpleQueryPage sqp = (SimpleQueryPage) targetObject;
		if(sqp.getConditionList()!=null && 
				!sqp.getConditionList().isEmpty()){
			input.append(Property.BEGIN)
				.append(FIELD_CONTITION_LIST)
				.append(Property.BEGIN_2)
				.append(DEFAULT_CHILDREN_CLASS_NAME)
				.append(Property.BEGIN_3);
			for (Iterator<Condition> it = sqp
					.getConditionList().iterator(); it.hasNext();) {
				Condition currChild = it.next();
				getWsRenderPool().getWsRender(CONTITION_CLASS_NAME).outputXml(currChild, "", input);
			}
			input.append(Property.END);
		}else {
			input.append(Property.BEGIN).append(FIELD_CONTITION_LIST).append(Property.BEGIN_2)
				.append(DEFAULT_CHILDREN_CLASS_NAME)
				.append(Property.END_PROPERTY_EMPTY_END);
		}
		if(sqp.getOrderByList()!=null && 
				!sqp.getOrderByList().isEmpty()){
			input.append(Property.BEGIN)
				.append(FIELD_ORDER_BY_LIST)
				.append(Property.BEGIN_2)
				.append(DEFAULT_CHILDREN_CLASS_NAME)
				.append(Property.BEGIN_3);
			for (Iterator<OrderBy> it = sqp
					.getOrderByList().iterator(); it.hasNext();) {
				OrderBy currChild = it.next();
				getWsRenderPool().getWsRender(ORDER_BY_CLASS_NAME).outputXml(currChild, "", input);
			}
			input.append(Property.END);
		}else {
			input.append(Property.BEGIN).append(FIELD_ORDER_BY_LIST).append(Property.BEGIN_2)
				.append(DEFAULT_CHILDREN_CLASS_NAME)
				.append(Property.END_PROPERTY_EMPTY_END);
		}
		if(sqp.getResult()!=null && 
				!sqp.getResult().isEmpty()){
			input.append(Property.BEGIN)
				.append(FIELD_RESULT)
				.append(Property.BEGIN_2)
				.append(DEFAULT_CHILDREN_CLASS_NAME)
				.append(Property.BEGIN_3);
			for (Iterator<BaseEntity> it = sqp
					.getResult().iterator(); it.hasNext();) {
				BaseEntity currChild = it.next();
				input.append(BEGIN_TAG2.replace("${className}", currChild.getClass().getName()));
				getWsRenderPool().getWsRender(currChild.getClass().getName()).outputXml(currChild, "", input);
				input.append(END_TAG2);
			}
			input.append(Property.END);
		}else {
			input.append(Property.BEGIN).append(FIELD_RESULT).append(Property.BEGIN_2)
				.append(DEFAULT_CHILDREN_CLASS_NAME)
				.append(Property.END_PROPERTY_EMPTY_END);
		}
		input.append(END_TAG);
	}
	
	@Override
	public void setProperty(BaseEntity targetObject, Node w3cNode) {
		SimpleQueryPage sqp = (SimpleQueryPage) targetObject;
		NodeList propertiesElement = w3cNode.getChildNodes();
		if(propertiesElement!=null && propertiesElement.getLength()>0){
			for(int i=0;i<propertiesElement.getLength();i++){
				Node currentElement = propertiesElement.item(i);
				if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_CURRENT_PAGE)){
					getWsRenderPool().getWsRender(CLASS_NAME.CLASS_NAME_INTEGER).setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_SIZE)){
					getWsRenderPool().getWsRender(CLASS_NAME.CLASS_NAME_INTEGER).setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_COUNT)){
					getWsRenderPool().getWsRender(CLASS_NAME.CLASS_NAME_INTEGER).setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_MAIN_QUERY_SQL)){
					getWsRenderPool().getWsRender(CLASS_NAME.CLASS_NAME_CLOB).setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_MAPPER_NAME)){
					getWsRenderPool().getWsRender(CLASS_NAME.CLASS_NAME_STRING).setProperty(
							targetObject,currentElement);
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_CONTITION_LIST)){
					NodeList sonElement = currentElement.getChildNodes();
					if(sonElement!=null && sonElement.getLength()>0){
						sqp.setConditionList(new ArrayList<Condition>());
						for (int j=0;j<sonElement.getLength(); j++) {
							Node _son = sonElement.item(j);
							Condition condition = new Condition();
							getWsRenderPool().getWsRender(CONTITION_CLASS_NAME).setProperty(condition, _son);
							sqp.getConditionList().add(condition);
						}
					}
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_ORDER_BY_LIST)){
					NodeList sonElement = currentElement.getChildNodes();
					if(sonElement!=null && sonElement.getLength()>0){
						sqp.setOrderByList(new ArrayList<OrderBy>());
						for (int j=0;j<sonElement.getLength(); j++) {
							Node _son = sonElement.item(j);
							OrderBy orderBy = new OrderBy();
							getWsRenderPool().getWsRender(ORDER_BY_CLASS_NAME).setProperty(orderBy, _son);
							sqp.getOrderByList().add(orderBy);
						}
					}
				}else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_RESULT)){
					NodeList sonElement = currentElement.getChildNodes();
					if(sonElement!=null && sonElement.getLength()>0){
						sqp.setResult(new ArrayList<BaseEntity>());
						for (int j=0;j<sonElement.getLength(); j++) {
							Node _son = sonElement.item(j);
							String clazzName = _son.getAttributes().getNamedItem(ATTRIBLE_CLASS).getNodeValue();
							Object o = null;
							try{
								o = Class.forName(clazzName).newInstance();
							}catch(ClassNotFoundException e){
								o = null;
							} catch (InstantiationException e) {
								o = null;
							} catch (IllegalAccessException e) {
								o = null;
							}
							if(o!=null && o instanceof BaseEntity){
								BaseEntity be = (BaseEntity) o;
								getWsRenderPool().getWsRender(clazzName).setProperty(be, _son);
								sqp.getResult().add(be);
							}
						}
					}
				}
			}
		}
	}
	
}
