package net.frank.framework.web.taglib.content;

import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import net.frank.commons.CommonConstants;
import net.frank.framework.spring.SpringContextUtil;
import net.frank.framework.web.taglib.content.property.PropertiesResourceCacheProvider;
import net.frank.framework.web.taglib.content.template.RenderDirective;
import net.frank.framework.web.taglib.content.template.RenderPropertiesDirective;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.springframework.web.servlet.support.JspAwareRequestContext;
import org.springframework.web.servlet.support.RequestContext;

public final class VelocityContentImpl extends SimpleTagSupport {

	private transient Logger log = LoggerFactory.getLogger(getClass());

	private Object var;

	private String mode = CommonConstants.PAGE_MODE.VIEW;

	private String templateName;

	private String resourceName;

	private VelocityEngine velocityEngine = (VelocityEngine) SpringContextUtil
			.getBean("velocityEngine");
	private PropertiesResourceCacheProvider propertiesResourceCacheProvider = (PropertiesResourceCacheProvider) SpringContextUtil
			.getBean("propertiesResourceCacheProvider");

	public void setVar(Object var) {
		this.var = var;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public void doTag() throws JspException, IOException {
		if (var == null) {
			throw new JspException("Content Tag can't process Null Object");
		}
		log.debug("var is:" + var);
		if (templateName == null
				|| CommonConstants.EMPTY_STRING.equals(templateName)) {
			throw new JspException("Content Tag can't process Null Template");
		}
		log.debug("templateName is:" + templateName);
		if (resourceName == null
				|| CommonConstants.EMPTY_STRING.equals(resourceName)) {
			throw new JspException("Content Tag can't process Null Resource");
		}
		log.debug("resourceName is:" + resourceName);
		Map<String, String> fieldMap = new HashMap<String, String>();
		PageContext pageContext = (PageContext) getJspContext();
		RequestContext requestContext = new JspAwareRequestContext(pageContext);

		Locale currentLocale = requestContext.getLocale();
		Properties p = propertiesResourceCacheProvider.getPropertiesResource(
				resourceName,
				currentLocale.getLanguage() + "_" + currentLocale.getCountry());
		Map<String, Object> paramMap = new HashMap<String, Object>();
		PropertyDescriptor[] pds = PropertyUtils.getPropertyDescriptors(var
				.getClass());
		for (int i = 0; i < pds.length; i++) {
			PropertyDescriptor pd = pds[i];
			if (!isIgnoreFile(pd.getName())) {
				fieldMap.put(pd.getName(), pd.getName());
			}
		}
		paramMap.put(RenderDirective.JSP_PAGE_CONTEXT, pageContext);
		paramMap.put("var", var);
		paramMap.put("fieldMap", fieldMap);
		paramMap.put(RenderPropertiesDirective.PROPERTIES_KEY, p);
		paramMap.put("isEdit",
				CommonConstants.PAGE_MODE.EDIT.equals(mode) ? Boolean.TRUE
						: Boolean.FALSE);
		String value = VelocityEngineUtils.mergeTemplateIntoString(
				velocityEngine, templateName, "UTF-8", paramMap);
		log.debug("======================Generate Content BEG=======================");
		log.debug(value);
		log.debug("======================Generate Content END=======================");
		getJspContext().getOut().write(value);
	}

	private boolean isIgnoreFile(String field) {
		boolean isResult = false;
		for (int i = 0; i < ContentConstants.IGRONE_PROPERTY_LIST.length; i++) {
			String compareField = ContentConstants.IGRONE_PROPERTY_LIST[i];
			if (compareField.equals(field)) {
				isResult = true;
				break;
			}
		}
		return isResult;
	}
}