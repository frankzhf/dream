package net.frank.cms.web.core.actions;

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
import net.frank.framework.bo.BusinessObject;
import net.frank.framework.bo.Resource;
import net.frank.framework.service.CmsService;
import net.frank.framework.service.PermissionService;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.struts.action.BaseAction;
import net.frank.framework.struts.form.CmsForm;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

public class SaveInformDetailsAction extends BaseAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CmsForm _form = (CmsForm) form;
		Resource resource = _form.getResource();
		CmsService cmsService = (CmsService) getBean(ServiceNames.CMS_SERVICE);
		QueryService queryService = (QueryService) getService(request,
				ServiceNames.QUERY_SERVICE);
		if (resource.getId() == null
				&& queryService.getResource(resource.getParentId(),
						resource.getAlias()) != null) {
			ActionMessage actionMessage = new ActionMessage("errors.detail",
					"Resource's alias can't same");
			ActionMessages actionMessages = new ActionMessages();
			actionMessages.add(CmsCommonConstants.EMPTY_STRING, actionMessage);
			addErrors(request, actionMessages);
			request.setAttribute("resource", resource);
			return mapping.findForward(CmsCommonConstants.FORWARD.FAILURE);
		}

		PermissionService permissionService = (PermissionService) getBean(ServiceNames.PERMISSION_SERVICE);
		permissionService.fillResource(_form, resource);
		if (CmsCommonConstants.TYPE.RESOURCE.equals(resource.getTypeId())) {
			if(resource.getId()!=null){
				cmsService.updateResource(resource, getClientSession());
			}else{
				cmsService.createResource(resource, getClientSession());
			}
			log.debug("Content is Resource ->" + resource.getId());
		} else {
			BusinessObject businessObject = (BusinessObject) _form
					.getContentMap().get(resource.getTypeId());
			if (!_form.getUpdateFilesMap().isEmpty()) {
				BusinessObject existsObject = null;
				if (resource.getId() != null) {
					existsObject = queryService.getBo(resource.getId());
				}
				for (Iterator<String> it = _form.getUpdateFilesMap().keySet()
						.iterator(); it.hasNext();) {
					String key = it.next();
					businessObject.setBlobString(key, existsObject);
				}
			}
			log.debug("Input Object class ->"
					+ businessObject.getClass().getName());
			if (!businessObject.getErrorFieldsValue().isEmpty()) {
				ActionMessages actionMessages = new ActionMessages();
				for (Iterator<String> it = businessObject.getErrorFieldsValue()
						.keySet().iterator(); it.hasNext();) {
					String key = it.next();
					String error = businessObject.getErrorFieldsValue()
							.get(key);
					ActionMessage actionMessage = new ActionMessage(
							"errors.detail", error);
					actionMessages.add(CmsCommonConstants.EMPTY_STRING,
							actionMessage);
				}
				addErrors(request, actionMessages);
				request.setAttribute("resource", resource);
				return mapping.findForward(CmsCommonConstants.FORWARD.FAILURE);
			}
			try {
				Class<?> type = businessObject.getClass();
				BeanInfo beanInfo = Introspector.getBeanInfo(type);
				PropertyDescriptor[] propertyDescriptors = beanInfo
						.getPropertyDescriptors();
				for (int i = 0; i < propertyDescriptors.length; i++) {
					PropertyDescriptor descriptor = propertyDescriptors[i];
					String propertyName = descriptor.getName();
					if (!(propertyName.equals("class") || propertyName
							.equals("resource"))) {
						Method readMethod = descriptor.getReadMethod();
						Object result = readMethod.invoke(businessObject,
								new Object[0]);
						if ( !readMethod.getReturnType().isInterface() && (readMethod
								.getReturnType().getSuperclass().getName().equals(BusinessObject.class.getName()) ||
								readMethod.getReturnType().getName().equals(Resource.class.getName())) ) {
							Resource r = (Resource) result;
							Method writeMethod = descriptor.getWriteMethod();
							log.debug("resourceId ->" + r.getId());
							if (r.getId() != null) {
								r = queryService.getResource(r.getId());
								writeMethod.invoke(businessObject,
										new Object[] { r });
							} else {
								writeMethod.invoke(businessObject,
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
			//businessObject.setResource(resource);
			resource.setObject(businessObject);
			if(resource.getId()!=null){
				cmsService.updateResource(resource, getClientSession());
			}else{
				cmsService.createResource(resource, getClientSession());
			}
			//resourceService.saveOrUpdateBo(businessObject,
			//		getClientSession());
			_form.setResource(resource);
			_form.setListResource(null);
			log.debug(_form.getResource());
		}
		request.setAttribute("resource", resource);
		return mapping.findForward(CmsCommonConstants.FORWARD.SUCCESS);
	}
}
