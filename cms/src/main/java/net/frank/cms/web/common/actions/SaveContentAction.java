package net.frank.cms.web.common.actions;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.frank.cms.common.CmsCommonConstants;
import net.frank.commons.CommonConstants;
import net.frank.framework.bo.BusinessObject;
import net.frank.framework.bo.Resource;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ResourceService;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.struts.action.BaseAction;
import net.frank.framework.struts.form.CmsForm;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;



public class SaveContentAction extends BaseAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CmsForm _form = (CmsForm) form;
		ResourceService resourceService = (ResourceService)getBean(ServiceNames.RESOURCE_SERVICE);
		QueryService queryService = (QueryService) getBean(ServiceNames.QUERY_SERVICE); 
		Resource resource = _form.getResource();
		Long typeId = _form.getResource().getTypeId();
		log.debug("Current typeId:"+typeId);
		Object bo = _form.getContent(CommonConstants.EMPTY_STRING+typeId);
		if(bo instanceof BusinessObject){
			BusinessObject _bo = (BusinessObject)bo;
			if (!_form.getUpdateFilesMap().isEmpty()) {
				BusinessObject existsObject = null;
				if (resource.getId() != null) {
					existsObject = queryService
							.getBo(resource.getId());
				}
				for (Iterator<String> it = _form.getUpdateFilesMap().keySet()
						.iterator(); it.hasNext();) {
					String key = it.next();
					_bo.setBlobString(key, existsObject);
				}
			}
			try {
				Class<?> type = _bo.getClass();
				BeanInfo beanInfo = Introspector.getBeanInfo(type);
				PropertyDescriptor[] propertyDescriptors = beanInfo
						.getPropertyDescriptors();
				for (int i = 0; i < propertyDescriptors.length; i++) {
					PropertyDescriptor descriptor = propertyDescriptors[i];
					String propertyName = descriptor.getName();
					if (!(propertyName.equals("class") || propertyName
							.equals("resource"))) {
						Method readMethod = descriptor.getReadMethod();
						Object result = readMethod.invoke(_bo,
								new Object[0]);
						if (!readMethod.getReturnType().isInterface() && (readMethod
								.getReturnType().getSuperclass().getName().equals(BusinessObject.class.getName()) ||
								readMethod.getReturnType().getName().equals(Resource.class.getName())) ) {
							Resource r = (Resource) result;
							Method writeMethod = descriptor.getWriteMethod();
							log.debug("resourceId ->" + r.getId());
							if (r.getId() != null) {
								r = queryService.getResource(r.getId());
								writeMethod.invoke(_bo,
										new Object[] { r });
							} else {
								writeMethod.invoke(_bo,
										new Object[] { null });
							}
						}
					}
				}
			} catch (IntrospectionException e) {
				throw new Exception(e);
			} catch (IllegalAccessException e) {
				throw new Exception(e);
			} catch (InvocationTargetException e) {
				throw new Exception(e);
			}
			((BusinessObject) bo).setResource(resource);
			resourceService.saveOrUpdateBo((BusinessObject)_bo, getClientSession());
			_form.setResource(_bo.getResource());
			request.setAttribute("resource", _bo.getResource());
			request.setAttribute("content", _bo);
			String name = _bo.getClass().getName().substring(_bo.getClass().getName().lastIndexOf(CommonConstants.POINT)+1);
			request.setAttribute("templateName", name+".html");
			request.setAttribute("resourceName", name);
		}
		return mapping.findForward(CmsCommonConstants.FORWARD.SUCCESS);
	}
}
