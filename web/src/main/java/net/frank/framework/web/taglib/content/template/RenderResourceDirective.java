package net.frank.framework.web.taglib.content.template;

import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

//import javax.servlet.jsp.PageContext;

import net.frank.commons.CommonConstants;
import net.frank.commons.util.DateUtil;
import net.frank.framework.writer.JspResponseWriter;
import net.frank.framework.xml.Xhtml;
import net.frank.framework.bo.BusinessObject;
import net.frank.framework.bo.Resource;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.context.InternalContextAdapter;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.directive.Directive;
import org.apache.velocity.runtime.parser.node.Node;

public class RenderResourceDirective extends Directive {
	private static final String HIDDEN_ELEMENT_TYPE = "hidden";
	private transient Log log = LogFactory.getLog(getClass());
	public static final String CALL_FUNCTION_NAME = "renderResource";

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
		BusinessObject bo = (BusinessObject) node.jjtGetChild(0)
				.value(vContext);
		Resource res = bo.getResource();
		JspResponseWriter jspWrite = new JspResponseWriter();
		// jspWrite.setWebRoot((String)vContext.get(RenderDirective.WEB_CONTEXT_ROOT));
		// PageContext pageContext = (PageContext) vContext
		// .get(RenderDirective.JSP_PAGE_CONTEXT);

		processLongField(jspWrite, "id", res);
		processLongField(jspWrite, "parentId", res);
		processField(jspWrite, "alias", res);
		processLongField(jspWrite, "typeId", res);
		processBooleanField(jspWrite, "active", res);
		processBooleanField(jspWrite, "systemNode", res);
		processLongField(jspWrite, "ownResourceId", res);
		processLongField(jspWrite, "ownGroupResourceId", res);
		processTimeField(jspWrite, "createdDt", res);
		processLongField(jspWrite, "lastAccountResourceId", res);
		processTimeField(jspWrite, "lastUpdatedDt", res);
		processByteField(jspWrite, "currentAccountPermission", res);
		processByteField(jspWrite, "currentGroupPermission", res);
		processByteField(jspWrite, "othersPermission", res);
		writer.write(jspWrite.getBuffer().toString());
		return true;
	}

	private void processLongField(JspResponseWriter jspWrite, String fieldName,
			Resource resource) {
		Long value = (Long) getProperty(resource, fieldName);
		String elementName = "resource.longString(" + fieldName + ")";
		jspWrite.startElement(Xhtml.Tag.INPUT);
		jspWrite.attribute(Xhtml.Attr.ID, elementName);
		jspWrite.attribute(Xhtml.Attr.NAME, elementName);
		jspWrite.attribute(Xhtml.Attr.VALUE,
				value == null ? CommonConstants.EMPTY_STRING : value.toString());
		jspWrite.attribute(Xhtml.Attr.TYPE, HIDDEN_ELEMENT_TYPE);
		jspWrite.endElement(Xhtml.Tag.INPUT);
	}

	private void processField(JspResponseWriter jspWrite, String fieldName,
			Resource resource) {
		String value = (String) getProperty(resource, fieldName);
		String elementName = "resource." + fieldName;
		jspWrite.startElement(Xhtml.Tag.INPUT);
		jspWrite.attribute(Xhtml.Attr.ID, elementName);
		jspWrite.attribute(Xhtml.Attr.NAME, elementName);
		jspWrite.attribute(Xhtml.Attr.VALUE,
				value == null ? CommonConstants.EMPTY_STRING : value.toString());
		jspWrite.attribute(Xhtml.Attr.TYPE, HIDDEN_ELEMENT_TYPE);
		jspWrite.endElement(Xhtml.Tag.INPUT);

	}

	private void processBooleanField(JspResponseWriter jspWrite,
			String fieldName, Resource resource) {
		Boolean value = (Boolean) getProperty(resource, fieldName);
		String elementName = "resource.booleanString(" + fieldName + ")";
		jspWrite.startElement(Xhtml.Tag.INPUT);
		jspWrite.attribute(Xhtml.Attr.ID, elementName);
		jspWrite.attribute(Xhtml.Attr.NAME, elementName);
		jspWrite.attribute(Xhtml.Attr.VALUE,
				value == null ? CommonConstants.EMPTY_STRING : value.toString());
		jspWrite.attribute(Xhtml.Attr.TYPE, HIDDEN_ELEMENT_TYPE);
		jspWrite.endElement(Xhtml.Tag.INPUT);
	}

	private void processTimeField(JspResponseWriter jspWrite, String fieldName,
			Resource resource) {
		Date value = (Date) getProperty(resource, fieldName);
		String elementName = "resource.timestampString(" + fieldName + ")";
		jspWrite.startElement(Xhtml.Tag.INPUT);
		jspWrite.attribute(Xhtml.Attr.ID, elementName);
		jspWrite.attribute(Xhtml.Attr.NAME, elementName);
		jspWrite.attribute(
				Xhtml.Attr.VALUE,
				value == null ? CommonConstants.EMPTY_STRING : DateUtil
						.toString(value, CommonConstants.DEFAULT_TIME_FORMAT));
		jspWrite.attribute(Xhtml.Attr.TYPE, HIDDEN_ELEMENT_TYPE);
		jspWrite.endElement(Xhtml.Tag.INPUT);
	}

	private void processByteField(JspResponseWriter jspWrite, String fieldName,
			Resource resource) {
		Byte value = (Byte) getProperty(resource, fieldName);
		String elementName = "resource.byteString(" + fieldName + ")";
		jspWrite.startElement(Xhtml.Tag.INPUT);
		jspWrite.attribute(Xhtml.Attr.ID, elementName);
		jspWrite.attribute(Xhtml.Attr.NAME, elementName);
		jspWrite.attribute(Xhtml.Attr.VALUE,
				value == null ? CommonConstants.EMPTY_STRING : value.toString());
		jspWrite.attribute(Xhtml.Attr.TYPE, HIDDEN_ELEMENT_TYPE);
		jspWrite.endElement(Xhtml.Tag.INPUT);
	}

	private void processIntegerField(JspResponseWriter jspWrite,
			String fieldName, Resource resource) {
		Integer value = (Integer) getProperty(resource, fieldName);
		String elementName = "resource.integerString(" + fieldName + ")";
		jspWrite.startElement(Xhtml.Tag.INPUT);
		jspWrite.attribute(Xhtml.Attr.ID, elementName);
		jspWrite.attribute(Xhtml.Attr.NAME, elementName);
		jspWrite.attribute(Xhtml.Attr.VALUE,
				value == null ? CommonConstants.EMPTY_STRING : value.toString());
		jspWrite.attribute(Xhtml.Attr.TYPE, HIDDEN_ELEMENT_TYPE);
		jspWrite.endElement(Xhtml.Tag.INPUT);
	}

	private Object getProperty(Resource resource, String fieldName) {
		Object value = null;
		try {
			value = PropertyUtils.getProperty(resource, fieldName);
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
		return value;
	}
}
