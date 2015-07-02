package net.frank.framework.web.taglib.lookup;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import net.frank.commons.CommonConstants;
import net.frank.framework.bo.Resource;
import net.frank.framework.security.Session;
import net.frank.framework.service.CmsService;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.spring.SpringContextHolder;
import net.frank.framework.web.security.AuthenticatorHolder;

public class ResourceTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6109574114787070603L;
	
	private static final String DEFAULT_VAR_NAME = "resource"; 
	
	private String var = DEFAULT_VAR_NAME;

	private Long resourceId;

	private Resource parentResource;

	private String path;

	private String alias;
	
	private Session cs;
	
	public ResourceTag(){
		super();
	}
	
	
	public String getVar() {
		return this.var;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}
	
	public void setParentResource(Resource parentResource) {
		this.parentResource = parentResource;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	public Session getCs() {
		return cs;
	}

	public void setCs(Session cs) {
		this.cs = cs;
	}
	
	public void reset(){
		var = DEFAULT_VAR_NAME;
		resourceId = null;
		parentResource = null;
		path = null;
		alias = null;
		cs = null;
	}
	
	@Override
	public int doEndTag() throws JspException {
		CmsService cmsService = (CmsService) SpringContextHolder
			.getApplicationContext().getBean(ServiceNames.CMS_SERVICE);
		QueryService queryService = (QueryService) SpringContextHolder
			.getApplicationContext().getBean(ServiceNames.QUERY_SERVICE);
		if(cs == null){
			cs = AuthenticatorHolder.getClientSession();
		}
		Resource resource = new Resource();
		if(resourceId!=null){
			resource.setId(resourceId);
			resource = cmsService.getResource(resource, cs);
		}else if(path != null && path.length()>0 ){
			resource = cmsService.getResource(path, cs);
		}else if(parentResource != null && alias != null && alias.length()>0 ){
			resource = queryService.getResource(parentResource.getId(), alias);
			resource = cmsService.getResource(resource, cs);
		}else{
			resource.setCode(CommonConstants.CMS_CODE.MESSAGE_UNKNOW);
		}
		pageContext.setAttribute(var, resource);
		reset();
		return EVAL_PAGE;
	}
	
	@Override
	public void release(){
		super.release();
		reset();
	}
	
}
