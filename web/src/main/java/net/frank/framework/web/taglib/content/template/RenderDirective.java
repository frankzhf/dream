package net.frank.framework.web.taglib.content.template;

import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.jsp.PageContext;

import net.frank.commons.CommonConstants;
import net.frank.framework.service.CacheService;
import net.frank.framework.spring.SpringContextUtil;
import net.frank.framework.web.taglib.content.ContentRenderProvider;
import net.frank.framework.web.taglib.content.type.TypeRender;
import net.frank.framework.writer.JspResponseWriter;
import net.frank.framework.bo.BusinessObject;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.context.InternalContextAdapter;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.directive.Directive;
import org.apache.velocity.runtime.parser.node.Node;

public class RenderDirective extends Directive {
	
	private static final String DEFAULT_RENDER_CLASS = "net.frank.framework.web.taglib.content.type.impl.DefaultRenderImpl";
	
	private static final String DEFAULT_BO_RENDER_CLASS_KEY = "net.frank.framework.bo.Resource";
	
	public static final String JSP_PAGE_CONTEXT = "pageContext";

	private transient Log log = LogFactory.getLog(getClass());

	public static final String CALL_FUNCTION_NAME = "render";

	@Override
	public String getName() {
		return CALL_FUNCTION_NAME;
	}

	@Override
	public int getType() {
		return LINE;
	}

	/***
	 * Format #elementRender($fieldName,$var,$isEdit)
	 */
	@Override
	public boolean render(InternalContextAdapter vContext, Writer writer,
			Node node) throws IOException, ResourceNotFoundException,
			ParseErrorException, MethodInvocationException {

		String fieldName = (String) node.jjtGetChild(0).value(vContext);
		log.debug("input fieldName is:" + fieldName);

		BusinessObject bo = (BusinessObject) node.jjtGetChild(1)
				.value(vContext);
		log.debug("input BO is:" + bo);

		Boolean isEdit = (Boolean) node.jjtGetChild(2).value(vContext);
		log.debug("input isEdit is:" + isEdit);

		Object value = null;
		PropertyDescriptor propertyDescriptor = null;
		try {
			value = PropertyUtils.getProperty(bo, fieldName);
			propertyDescriptor = PropertyUtils.getPropertyDescriptor(bo,
					fieldName);
		} catch (IllegalAccessException e) {
			log.debug("IllegalAccessException");
			throw new RuntimeException();
		} catch (InvocationTargetException e) {
			log.debug("InvocationTargetException");
			throw new RuntimeException();
		} catch (NoSuchMethodException e) {
			log.debug("NoSuchMethodException");
			throw new RuntimeException();
		}
		String className = propertyDescriptor.getPropertyType().getName();
		if (fieldName.indexOf(CommonConstants.DATA_FIELD_REFER_SYMBOL_BEG) > -1) {
			int begIndex = fieldName
					.indexOf(CommonConstants.DATA_FIELD_REFER_SYMBOL_BEG) + 1;
			Long typeId = Long.decode(fieldName.substring(begIndex));
			CacheService cacheService = (CacheService) SpringContextUtil
					.getBean("cacheService");
			className = cacheService.getTypeContent().get(typeId)
					.getEntityClassName();
		}
		ContentRenderProvider contentRenderProvider = (ContentRenderProvider) SpringContextUtil
				.getBean("contentRenderProvider");
		JspResponseWriter jspWrite = new JspResponseWriter();
		PageContext pageContext = (PageContext) vContext.get(JSP_PAGE_CONTEXT);
		TypeRender typeRender = contentRenderProvider.getTypeRender(className);
		Class<?> fieldClass = null;
		Object fieldInstance = null;
		if(typeRender!=null && typeRender.getClass().getName().equals(DEFAULT_RENDER_CLASS)){
			try{
				fieldClass = Class.forName(className);
				fieldInstance = fieldClass.newInstance();
			}catch(ClassNotFoundException e){
				log.error(fieldClass + " Not found",e);
				fieldClass = null;
			}catch( IllegalAccessException e){
				log.error("fieldInstance newInstance error",e);
				fieldInstance = null;
			}catch(InstantiationException e){
				log.error("fieldInstance newInstance error",e);
				fieldInstance = null;
			}
			if(fieldClass!=null && fieldInstance instanceof BusinessObject){
				typeRender = contentRenderProvider.getTypeRender(DEFAULT_BO_RENDER_CLASS_KEY);
				className = DEFAULT_BO_RENDER_CLASS_KEY;
			}
		}
		if (isEdit) {
			typeRender.editRender(jspWrite, fieldName, value, className, bo,
					pageContext);
		} else {
			typeRender.readRender(jspWrite, fieldName, value, className, bo,
					pageContext);
		}

		writer.write(jspWrite.getBuffer().toString());
		return true;
	}

}
