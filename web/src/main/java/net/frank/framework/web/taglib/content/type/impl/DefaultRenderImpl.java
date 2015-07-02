package net.frank.framework.web.taglib.content.type.impl;

import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.jsp.PageContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.frank.commons.CommonConstants;
import net.frank.framework.web.taglib.content.type.TypeRender;
import net.frank.framework.writer.JspResponseWriter;
import net.frank.framework.xml.Xhtml;
import net.frank.framework.bo.BusinessObject;
import net.frank.framework.bo.Resource;
import net.frank.commons.util.DateUtil;

public class DefaultRenderImpl implements TypeRender {

	protected transient Log log = LogFactory.getLog(getClass());

	private static final String CONTENT_NAME = "content";

	private static final String DEFAULT_MAX_LENGTH = "255";

	@Override
	public void readRender(JspResponseWriter out, String fieldName,
			Object value, String className, BusinessObject bo,
			PageContext pageContext) {
		if (value != null)
			out.text(prepareValue(fieldName, value, className, bo));
		else
			out.text(CommonConstants.EMPTY_STRING);
	}

	@Override
	public void editRender(JspResponseWriter out, String fieldName,
			Object value, String className, BusinessObject bo,
			PageContext pageContext) {
		out.startElement(Xhtml.Tag.INPUT);
		String elementName = getElementName(fieldName, value, className, bo);
		out.attribute(Xhtml.Attr.NAME, elementName);
		out.attribute(Xhtml.Attr.ID, getElementId(elementName));
		out.attribute(Xhtml.Attr.MAXLENGTH, DEFAULT_MAX_LENGTH);
		out.attribute(Xhtml.Attr.VALUE,
				prepareValue(fieldName, value, className, bo));
		out.attribute(Xhtml.Attr.TYPE, DEFAULT_ELEMENT_INPUT_TYPE);
		out.endElement(Xhtml.Tag.INPUT);
	}

	protected String getElementName(String fieldName, Object obj,
			String className, BusinessObject bo) {
		StringBuffer sb = new StringBuffer(
				CommonConstants.SHORT_STRING_BUFFER_LENGTH);
		sb.append(CONTENT_NAME);
		sb.append(CommonConstants.LEFT_BRACKET);
		sb.append(bo.getResource().getTypeId());
		sb.append(CommonConstants.RIGHT_BRACKET);
		sb.append(CommonConstants.POINT);
		if (CommonConstants.CLASS_NAME.CLASS_NAME_STRING.equals(className)) {
			sb.append(fieldName);
		} else if (CommonConstants.CLASS_NAME.CLASS_NAME_INTEGER
				.equals(className)) {
			sb.append("integerString").append(CommonConstants.LEFT_BRACKET)
					.append(fieldName).append(CommonConstants.RIGHT_BRACKET);
		} else if (CommonConstants.CLASS_NAME.CLASS_NAME_LONG.equals(className)) {
			sb.append("longString").append(CommonConstants.LEFT_BRACKET)
					.append(fieldName).append(CommonConstants.RIGHT_BRACKET);
		} else if (CommonConstants.CLASS_NAME.CLASS_NAME_BIGDECIMAL
				.equals(className)) {
			sb.append("bigDecimalString").append(CommonConstants.LEFT_BRACKET)
					.append(fieldName).append(CommonConstants.RIGHT_BRACKET);
		} else if (CommonConstants.CLASS_NAME.CLASS_NAME_DATE.equals(className)) {
			sb.append("dateString").append(CommonConstants.LEFT_BRACKET)
					.append(fieldName).append(CommonConstants.RIGHT_BRACKET);
		} else if (CommonConstants.CLASS_NAME.CLASS_NAME_BLOB.equals(className)) {
			sb.append("blobString").append(CommonConstants.LEFT_BRACKET)
					.append(fieldName).append(CommonConstants.RIGHT_BRACKET);
		} else if (CommonConstants.CLASS_NAME.CLASS_NAME_CLOB.equals(className)) {
			sb.append("clobString").append(CommonConstants.LEFT_BRACKET)
					.append(fieldName).append(CommonConstants.RIGHT_BRACKET);
		} else if (CommonConstants.CLASS_NAME.CLASS_NAME_BOOLEAN
				.equals(className)) {
			sb.append("booleanString").append(CommonConstants.LEFT_BRACKET)
					.append(fieldName).append(CommonConstants.RIGHT_BRACKET);
		} else if (Resource.class.getName().equals(className)) {
			sb.append(fieldName).append(".longString(id)");
		} else {
			sb.append(fieldName);
		}
		return sb.toString();
	}

	protected String getElementId(String elementName) {
		log.debug("getElementId($elementName) =>" + elementName);
		StringBuffer sb = new StringBuffer(
				CommonConstants.SHORT_STRING_BUFFER_LENGTH);
		int begin = 0;
		int end = elementName.length();
		String temp0;
		int[] _end = new int[4];
		_end[0] = elementName.indexOf(CommonConstants.POINT);
		_end[1] = elementName.indexOf(CommonConstants.LEFT_BRACKET);
		_end[2] = elementName.indexOf(CommonConstants.RIGHT_BRACKET);
		_end[3] = elementName
				.indexOf(CommonConstants.DATA_FIELD_REFER_SYMBOL_BEG);
		for (int i = 0; i < _end.length; i++) {
			if (_end[i] > -1 && end > _end[i]) {
				end = _end[i];
			}
		}
		while (end > -1) {
			temp0 = elementName.substring(begin, end);
			elementName = elementName.substring(end + 1);
			sb.append(temp0).append(CommonConstants.UNDER_LINE);
			end = elementName.length();
			_end[0] = elementName.indexOf(CommonConstants.POINT);
			_end[1] = elementName.indexOf(CommonConstants.LEFT_BRACKET);
			_end[2] = elementName.indexOf(CommonConstants.RIGHT_BRACKET);
			_end[3] = elementName
					.indexOf(CommonConstants.DATA_FIELD_REFER_SYMBOL_BEG);
			if (_end[0] == -1 && _end[1] == -1 && _end[2] == -1
					&& _end[3] == -1) {
				end = -1;
			} else {
				for (int i = 0; i < _end.length; i++) {
					if (_end[i] > -1 && end > _end[i]) {
						end = _end[i];
					}
				}
			}
		}
		sb.append(elementName);
		return sb.toString();
	}

	protected String prepareValue(String fieldName, Object obj,
			String className, BusinessObject bo) {
		if (obj == null) {
			return CommonConstants.EMPTY_STRING;
		}
		if (CommonConstants.CLASS_NAME.CLASS_NAME_STRING.equals(className)) {
			return obj.toString();
		} else if (CommonConstants.CLASS_NAME.CLASS_NAME_INTEGER
				.equals(className)) {
			return obj.toString();
		} else if (CommonConstants.CLASS_NAME.CLASS_NAME_LONG.equals(className)) {
			return obj.toString();
		} else if (CommonConstants.CLASS_NAME.CLASS_NAME_BIGDECIMAL
				.equals(className)) {
			BigDecimal o = (BigDecimal) obj;
			o.setScale(CommonConstants.BIGDECIMAL_SCALE,
					BigDecimal.ROUND_HALF_UP);
			return o.toString();
		} else if (CommonConstants.CLASS_NAME.CLASS_NAME_DATE.equals(className)) {
			Date date = (Date) obj;
			return DateUtil.toString(date, CommonConstants.DEFAULT_DATE_FORMAT);
		} else if (obj instanceof Resource) {
			Resource rbo = (Resource) obj;
			return rbo.getId() == null ? CommonConstants.EMPTY_STRING : rbo
					.getId() + CommonConstants.EMPTY_STRING;
		} else if (CommonConstants.CLASS_NAME.CLASS_NAME_CLOB.equals(className)) {
			char[] c = (char[]) obj;
			String value = new String(c);
			return value;
		} else if (CommonConstants.CLASS_NAME.CLASS_NAME_BOOLEAN
				.equals(className)) {
			Boolean boo = (Boolean) obj;
			if (boo) {
				return "true";
			} else {
				return "false";
			}
		} else {
			return obj.toString();
		}
	}

	protected String prepareReadValue(String fieldName, Object obj,
			String className, BusinessObject bo) {
		if (obj == null) {
			return CommonConstants.EMPTY_STRING;
		}
		if (CommonConstants.CLASS_NAME.CLASS_NAME_STRING.equals(className)) {
			return obj.toString();
		} else if (CommonConstants.CLASS_NAME.CLASS_NAME_INTEGER
				.equals(className)) {
			return obj.toString();
		} else if (CommonConstants.CLASS_NAME.CLASS_NAME_LONG.equals(className)) {
			return obj.toString();
		} else if (CommonConstants.CLASS_NAME.CLASS_NAME_BIGDECIMAL
				.equals(className)) {
			BigDecimal o = (BigDecimal) obj;
			o.setScale(CommonConstants.BIGDECIMAL_SCALE,
					BigDecimal.ROUND_HALF_UP);
			return o.toString();
		} else if (CommonConstants.CLASS_NAME.CLASS_NAME_DATE.equals(className)) {
			Date date = (Date) obj;
			return DateUtil.toString(date, CommonConstants.DEFAULT_DATE_FORMAT);
		} else if (obj instanceof Resource) {
			Resource rbo = (Resource) obj;
			return rbo.getId() == null ? CommonConstants.EMPTY_STRING : rbo
					.getId() + CommonConstants.EMPTY_STRING;
		} else if (CommonConstants.CLASS_NAME.CLASS_NAME_CLOB.equals(className)) {
			char[] c = (char[]) obj;
			String value = new String(c);
			return value;
		} else if (CommonConstants.CLASS_NAME.CLASS_NAME_BOOLEAN
				.equals(className)) {
			Boolean boo = (Boolean) obj;
			if (boo) {
				return "true";
			} else {
				return "false";
			}
		} else {
			return obj.toString();
		}
	}

}
