package net.frank.framework.web.taglib.security;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import net.frank.framework.bo.Resource;
import net.frank.framework.service.PermissionService;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.spring.SpringContextHolder;
import net.frank.framework.web.security.AuthenticatorHolder;
import net.frank.framework.web.security.ClientSession;

public class HasPermissionTag extends TagSupport {

	private static final long serialVersionUID = -3747462446080220238L;
	private Long resourceId;
	private String resourcePath;
	private String permission;
	
	private static final String PERMISSION_RUN = "run";
	private static final String PERMISSION_READ = "read";
	private static final String PERMISSION_WRITE = "write";

	public Long getResourceId() {
		return resourceId;
	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}

	public String getResourcePath() {
		return resourcePath;
	}

	public void setResourcePath(String resourcePath) {
		this.resourcePath = resourcePath;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}
	
	@Override
	public int doStartTag() throws JspException {
		if (hasPermission())
			return (EVAL_BODY_INCLUDE);
		else
			return (SKIP_BODY);

	}

	private boolean hasPermission() {
		if (resourceId == null && resourcePath == null) {
			return false;
		}
		QueryService queryService = (QueryService) SpringContextHolder
				.getApplicationContext().getBean(ServiceNames.QUERY_SERVICE);
		PermissionService permissionService = (PermissionService) SpringContextHolder
				.getApplicationContext().getBean(
						ServiceNames.PERMISSION_SERVICE);
		Resource checkResource = null;
		if (resourceId != null) {
			checkResource = queryService.getResource(resourceId);
		} else {
			checkResource = queryService.getResourceAsPath(resourcePath);
		}
		if (checkResource == null) {
			return false;
		}
		ClientSession cs = AuthenticatorHolder.getClientSession();
		if(PERMISSION_RUN.equals(permission)){
			return permissionService.checkRunPermission(checkResource, cs);
		}else if(PERMISSION_WRITE.equals(permission)){
			return permissionService.checkWritePermission(checkResource, cs);
		}else if(PERMISSION_READ.equals(permission)){
			return permissionService.checkReadPermission(checkResource, cs);
		}else{
			return false;
		}
	}
	
	@Override
	public void release(){
		resourceId = null;
		resourcePath = null;
		permission = null;
		super.release();
	}
}
