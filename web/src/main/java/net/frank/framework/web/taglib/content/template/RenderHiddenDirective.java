package net.frank.framework.web.taglib.content.template;

import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.jsp.PageContext;

import net.frank.framework.spring.SpringContextUtil;
import net.frank.framework.web.taglib.content.type.TypeRender;
import net.frank.framework.writer.JspResponseWriter;
import net.frank.framework.bo.BusinessObject;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.velocity.context.InternalContextAdapter;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.directive.Directive;
import org.apache.velocity.runtime.parser.node.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RenderHiddenDirective extends Directive {

	private transient Logger log = LoggerFactory.getLogger(getClass());
	public static final String CALL_FUNCTION_NAME = "renderHidden";

	@Override
	public String getName() {
		return CALL_FUNCTION_NAME;
	}

	@Override
	public int getType() {
		return LINE;
	}

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
		JspResponseWriter jspWrite = new JspResponseWriter();
		PageContext pageContext = (PageContext) vContext
				.get(RenderDirective.JSP_PAGE_CONTEXT);
		TypeRender typeRender = (TypeRender) SpringContextUtil
				.getBean("hiddenRender");
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
