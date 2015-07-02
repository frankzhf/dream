package net.frank.framework.bo;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.frank.commons.CommonConstants;
import net.frank.commons.util.DateUtil;

public abstract class BaseEntity implements IBase, Serializable {

	/**
	 * 
	 */

	public static final String SETTER_PREFIX = "set";
	public static final String GETTER_PREFIX = "get";

	public static final String[] skipMethodName = { "wait", "equals",
			"toString", "hashCode", "getClass", "notify", "notifyAll",
			"setForm", "getForm", "getNodeIcon", "getNodeOpenIcon",
			"setErrorFieldsValue", "getErrorFieldsValue", "clone","_setValue","_getValue","byteString"};

	private static final Object[] METHOD_DEFAULT_PARAM = new Object[] {};

	private static final Object[] METHOD_DEFAULT_NULL_PARAM = new Object[] { null };

	private static Map<String,Map<String,Method>> methodMap = null;

	private static final long serialVersionUID = -725835001549125508L;
	protected transient Log log = LogFactory.getLog(this.getClass());
	private static Integer BIGDECIMAL_SCALE = 2;
	protected Map<String, String> errorFieldsValue = new HashMap<String, String>();

	private Boolean selected = Boolean.FALSE;

	private Long id;

	private IForm form;

	public Map<String, String> getErrorFieldsValue() {
		return errorFieldsValue;
	}

	public void setErrorFieldsValue(Map<String, String> errorFieldsValue) {
		this.errorFieldsValue = errorFieldsValue;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

	// ================================================================
	// Non-String Value parse method
	// ================================================================

	/**
	 * Get string value of the specified date field, the format pattern is
	 * "dd/MM/yyyy"
	 * 
	 * @param dateFieldName
	 *            the name of the date field
	 * @return the formatted string value of specified date field, return null
	 *         if the date is null
	 */
	public String getDateString(String dateFieldName) {
		StringBuffer methodName = new StringBuffer(64);
		methodName.append(GETTER_PREFIX);
		methodName.append(upperFirstChar(dateFieldName));
		Method getMethod = getMethod(methodName.toString());
		Date date = null;
		try {
			date = (Date) getMethod.invoke(this, METHOD_DEFAULT_PARAM);
			if (date != null)
				return DateUtil.toString(date,
						CommonConstants.DEFAULT_DATE_FORMAT);
			else if (errorFieldsValue.get(dateFieldName) != null) {
				return errorFieldsValue.get(dateFieldName);
			} else {
				return CommonConstants.EMPTY_STRING;
			}
		} catch (IllegalAccessException e) {
			log.debug("IllegalAccessException");
			throw new RuntimeException();
		} catch (InvocationTargetException e) {
			log.debug("InvocationTargetException");
			throw new RuntimeException();
		}
	}

	/**
	 * Set the date when this record was created as a String
	 * 
	 * @param dateFieldName
	 *            the name of the date field
	 * @param dateString
	 *            a string value of date
	 */
	public void setDateString(String dateFieldName, String dateString) {
		StringBuffer methodName = new StringBuffer(64);
		methodName.append(SETTER_PREFIX);
		methodName.append(upperFirstChar(dateFieldName));
		Method setMethod = getMethod(methodName.toString());
		try {
			try {
				Date date = null;
				if (dateString != null && dateString.length() != 0) {
					date = DateUtil.toDate(dateString,
							CommonConstants.DEFAULT_DATE_FORMAT);
				}
				setMethod.invoke(this, date);
			} catch (IllegalAccessException e) {
				log.debug("IllegalAccessException");
				throw new RuntimeException();
			} catch (InvocationTargetException e) {
				log.debug("InvocationTargetException");
				throw new RuntimeException();
			}
		} catch (RuntimeException e) {
			errorFieldsValue.put(dateFieldName, dateString);
			try {
				setMethod.invoke(this, METHOD_DEFAULT_NULL_PARAM);
			} catch (Exception ee) {

			}
		}
	}

	/**
	 * Get string value of the specified date field, the format pattern is
	 * "dd/MM/yyyy h:mm:ss a"
	 * 
	 * @param dateFieldName
	 *            the name of the date field
	 * @return the formatted string value of specified date field, return null
	 *         if the date is null
	 */
	public String getTimestampString(String dateFieldName) {
		StringBuffer methodName = new StringBuffer(64);
		methodName.append(GETTER_PREFIX);
		methodName.append(upperFirstChar(dateFieldName));
		Method getMethod = getMethod(methodName.toString());
		try {
			Date timestamp = (Date) getMethod
					.invoke(this, METHOD_DEFAULT_PARAM);
			if (timestamp != null)
				return DateUtil.toString(timestamp,
						CommonConstants.DEFAULT_TIME_FORMAT);
			else if (errorFieldsValue.get(dateFieldName) != null) {
				return errorFieldsValue.get(dateFieldName);
			} else {
				return CommonConstants.EMPTY_STRING;
			}
		} catch (IllegalAccessException e) {
			log.debug("IllegalAccessException");
			throw new RuntimeException();
		} catch (InvocationTargetException e) {
			log.debug("InvocationTargetException");
			throw new RuntimeException();
		}
	}

	/**
	 * Set the date/time when this record was created as a String
	 * 
	 * @param dateFieldName
	 *            the name of the date field
	 * @param dateString
	 *            a string value of date
	 */
	public void setTimestampString(String dateFieldName, String dateString) {
		StringBuffer methodName = new StringBuffer(64);
		methodName.append(SETTER_PREFIX);
		methodName.append(upperFirstChar(dateFieldName));
		Method setMethod = getMethod(methodName.toString());
		try {
			try {
				Date timestamp = null;
				if (dateString != null && dateString.length() != 0) {
					timestamp = DateUtil.toDate(dateString,
							CommonConstants.DEFAULT_TIME_FORMAT);
				}
				setMethod.invoke(this, timestamp);
			} catch (IllegalAccessException e) {
				log.debug("IllegalAccessException");
				throw new RuntimeException();
			} catch (InvocationTargetException e) {
				log.debug("InvocationTargetException");
				throw new RuntimeException();
			}
		} catch (RuntimeException e) {
			errorFieldsValue.put(dateFieldName, dateString);
			try {
				setMethod.invoke(this, METHOD_DEFAULT_NULL_PARAM);
			} catch (Exception ee) {

			}
		}

	}

	/**
	 * Get the string value of specified field which type is BigDescimal
	 * 
	 * @param fieldName
	 * @return
	 * @throws IllegalAccessException
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws NumberFormatException
	 */
	public String getBigDecimalString(String fieldName) {
		StringBuffer methodName = new StringBuffer(64);
		methodName.append(GETTER_PREFIX);
		methodName.append(upperFirstChar(fieldName));
		Method getMethod = getMethod(methodName.toString());
		try {
			BigDecimal bdField = (BigDecimal) getMethod.invoke(this,
					METHOD_DEFAULT_PARAM);
			if (bdField != null) {
				bdField.setScale(BIGDECIMAL_SCALE, BigDecimal.ROUND_HALF_UP);
				return bdField.toString();
			} else {
				if (errorFieldsValue.get(fieldName) != null) {
					return errorFieldsValue.get(fieldName);
				} else {
					return CommonConstants.EMPTY_STRING;
				}
			}
		} catch (IllegalAccessException e) {
			log.debug("IllegalAccessException");
			throw new RuntimeException();
		} catch (InvocationTargetException e) {
			log.debug("InvocationTargetException");
			throw new RuntimeException();
		} catch (NumberFormatException e) {
			log.debug("NumberFormatException");
			throw new RuntimeException();
		}
	}

	/**
	 * Set the BigDecimal when this record was created as a String
	 * 
	 * @param bdFieldName
	 * @param bdString
	 * @throws ParseException
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NumberFormatException
	 */
	public void setBigDecimalString(String bdFieldName, String bdString) {
		StringBuffer methodName = new StringBuffer(64);
		methodName.append(SETTER_PREFIX);
		methodName.append(upperFirstChar(bdFieldName));
		Method setMethod = getMethod(methodName.toString());
		try {
			try {
				BigDecimal bd = null;
				if (bdString != null && bdString.length() != 0) {
					bd = new BigDecimal(bdString);
				}
				setMethod.invoke(this, bd);
			} catch (Exception NumberFormatException) {
				throw new RuntimeException();
				// PropertyUtils.setProperty(this, bdFieldName, null);
			}
		} catch (RuntimeException e) {
			errorFieldsValue.put(bdFieldName, bdString);
			try {
				setMethod.invoke(this, METHOD_DEFAULT_NULL_PARAM);
			} catch (Exception ee) {

			}
		}
	}

	/**
	 * Get the string value of specified field which type is Integer
	 * 
	 * @param fieldName
	 * @return
	 */
	public String getIntegerString(String fieldName) {
		StringBuffer methodName = new StringBuffer(64);
		methodName.append(GETTER_PREFIX);
		methodName.append(upperFirstChar(fieldName));
		Method getMethod = getMethod(methodName.toString());
		try {
			Integer intField = (Integer) getMethod.invoke(this,
					METHOD_DEFAULT_PARAM);
			if (intField != null) {
				return intField.toString();
			} else {
				if (errorFieldsValue.get(fieldName) != null) {
					return errorFieldsValue.get(fieldName);
				} else {
					return CommonConstants.EMPTY_STRING;
				}
			}
		} catch (IllegalAccessException e) {
			log.debug("IllegalAccessException");
			throw new RuntimeException();
		} catch (InvocationTargetException e) {
			log.debug("InvocationTargetException");
			throw new RuntimeException();
		}
	}

	/**
	 * Set the Integer when this record was created as a String
	 * 
	 * @param intFieldName
	 * @param intString
	 */
	public void setIntegerString(String fieldName, String intString) {
		StringBuffer methodName = new StringBuffer(64);
		methodName.append(SETTER_PREFIX);
		methodName.append(upperFirstChar(fieldName));
		Method setMethod = getMethod(methodName.toString());
		try {
			try {
				Integer intValue = null;
				if (intString != null && intString.length() != 0) {
					intValue = Integer.parseInt(intString);
				}
				setMethod.invoke(this, intValue);
			} catch (IllegalAccessException e) {
				log.debug("IllegalAccessException");
				throw new RuntimeException();
			} catch (InvocationTargetException e) {
				log.debug("InvocationTargetException");
				throw new RuntimeException();
			}
		} catch (RuntimeException e) {
			errorFieldsValue.put(fieldName, intString);
			try {
				setMethod.invoke(this, METHOD_DEFAULT_NULL_PARAM);
			} catch (Exception ee) {

			}
		}
	}
	
	/***
	 * 
	 * @param fieldName
	 * @return
	 */
	public String getByteString(String fieldName){
		StringBuffer methodName = new StringBuffer(64);
		methodName.append(GETTER_PREFIX);
		methodName.append(upperFirstChar(fieldName));
		Method getMethod = getMethod(methodName.toString());
		try {
			Byte byteField = (Byte) getMethod.invoke(this,
					METHOD_DEFAULT_PARAM);
			if (byteField != null) {
				return byteField.toString();
			} else {
				if (errorFieldsValue.get(fieldName) != null) {
					return errorFieldsValue.get(fieldName);
				} else {
					return CommonConstants.EMPTY_STRING;
				}
			}
		} catch (IllegalAccessException e) {
			log.debug("IllegalAccessException");
			throw new RuntimeException();
		} catch (InvocationTargetException e) {
			log.debug("InvocationTargetException");
			throw new RuntimeException();
		}
	}
	
	/***
	 * 
	 * @param fieldName
	 * @param byteString
	 */
	public void setByteString(String fieldName, String byteString) {
		StringBuffer methodName = new StringBuffer(64);
		methodName.append(SETTER_PREFIX);
		methodName.append(upperFirstChar(fieldName));
		Method setMethod = getMethod(methodName.toString());
		try {
			try {
				Byte byteValue = null;
				if (byteString != null && byteString.length() != 0) {
					byteValue = Byte.parseByte(byteString);
				}
				setMethod.invoke(this, byteValue);
			} catch (IllegalAccessException e) {
				log.debug("IllegalAccessException");
				throw new RuntimeException();
			} catch (InvocationTargetException e) {
				log.debug("InvocationTargetException");
				throw new RuntimeException();
			}
		} catch (RuntimeException e) {
			errorFieldsValue.put(fieldName, byteString);
			try {
				setMethod.invoke(this, METHOD_DEFAULT_NULL_PARAM);
			} catch (Exception ee) {

			}
		}
	}
	
	/**
	 * Get the string value of specified field which type is Long
	 * 
	 * @param fieldName
	 * @return
	 */
	public String getLongString(String fieldName) {
		StringBuffer methodName = new StringBuffer(64);
		methodName.append(GETTER_PREFIX);
		methodName.append(upperFirstChar(fieldName));
		Method getMethod = getMethod(methodName.toString());
		try {
			Object longField = getMethod.invoke(this, METHOD_DEFAULT_PARAM);
			if (longField != null) {
				return longField.toString();
			} else {
				return CommonConstants.EMPTY_STRING;
			}
		} catch (IllegalAccessException e) {
			log.debug("IllegalAccessException");
			throw new RuntimeException();
		} catch (InvocationTargetException e) {
			log.debug("InvocationTargetException");
			throw new RuntimeException();
		}
	}

	/**
	 * Set the Long when this record was created as a String
	 * 
	 * @param longFieldName
	 * @param longString
	 */
	public void setLongString(String longFieldName, String longString) {
		StringBuffer methodName = new StringBuffer(64);
		methodName.append(SETTER_PREFIX);
		methodName.append(upperFirstChar(longFieldName));
		Method setMethod = getMethod(methodName.toString());
		try {
			try {
				Long longValue = null;
				if (longString != null && longString.length() != 0) {
					longValue = Long.parseLong(longString);
				}
				setMethod.invoke(this, longValue);
			} catch (IllegalAccessException e) {
				log.debug("IllegalAccessException");
				throw new RuntimeException();
			} catch (InvocationTargetException e) {
				log.debug("InvocationTargetException");
				throw new RuntimeException();
			}
		} catch (RuntimeException e) {
			errorFieldsValue.put(longFieldName, longString);
			try {
				setMethod.invoke(this, METHOD_DEFAULT_NULL_PARAM);
			} catch (Exception ee) {

			}
		}
	}

	/**
	 * Set the Clob when this record was created as a fileFullName
	 * 
	 * @param clobFieldName
	 * @param fileFullName
	 */

	public void setClobString(String clobFieldName, String docBody) {
		StringBuffer methodName = new StringBuffer(64);
		methodName.append(SETTER_PREFIX);
		methodName.append(upperFirstChar(clobFieldName));
		Method setMethod = getMethod(methodName.toString());
		try {
			try {
				if (docBody != null) {
					char[] chars = docBody.toCharArray();
					setMethod.invoke(this, chars);
				} else {
					setMethod.invoke(this, METHOD_DEFAULT_NULL_PARAM);
				}
			} catch (IllegalAccessException e) {
				log.debug("IllegalAccessException");
				throw new RuntimeException();
			} catch (InvocationTargetException e) {
				log.debug("InvocationTargetException");
				throw new RuntimeException();
			}
		} catch (RuntimeException e) {
			errorFieldsValue.put(clobFieldName, docBody);
			try {
				setMethod.invoke(this, METHOD_DEFAULT_NULL_PARAM);
			} catch (Exception ee) {

			}
		}
	}

	public String getClobString(String clobFieldName) {
		StringBuffer methodName = new StringBuffer(64);
		methodName.append(GETTER_PREFIX);
		methodName.append(upperFirstChar(clobFieldName));
		Method getMethod = getMethod(methodName.toString());
		try {
			char[] chars = (char[]) getMethod
					.invoke(this, METHOD_DEFAULT_PARAM);
			if (chars != null) {
				String value = new String(chars);
				return value;
			} else {
				if (errorFieldsValue.get(clobFieldName) != null) {
					return errorFieldsValue.get(clobFieldName);
				} else {
					return CommonConstants.EMPTY_STRING;
				}
			}
		} catch (IllegalAccessException e) {
			log.debug("IllegalAccessException");
			throw new RuntimeException();
		} catch (InvocationTargetException e) {
			log.debug("InvocationTargetException");
			throw new RuntimeException();
		}
	}

	/**
	 * Set the boolean when this record was created as a fileFullName
	 * 
	 * @param booleanFieldName
	 * @param fileFullName
	 */

	public void setBooleanString(String booleanFieldName, String value) {
		StringBuffer methodName = new StringBuffer(64);
		methodName.append(SETTER_PREFIX);
		methodName.append(upperFirstChar(booleanFieldName));
		Method setMethod = getMethod(methodName.toString());
		try {
			try {
				if (value != null
						&& !value.equals(CommonConstants.EMPTY_STRING)) {
					if (CommonConstants.BOOLEAN_TRUE_STRING.equals(value)
							|| CommonConstants.BOOLEAN_TRUE_STRING2
									.equals(value))
						setMethod.invoke(this, Boolean.TRUE);
					else
						setMethod.invoke(this, Boolean.FALSE);
				} else {
					setMethod.invoke(this, METHOD_DEFAULT_NULL_PARAM);
				}
			} catch (IllegalAccessException e) {
				log.debug("IllegalAccessException");
				throw new RuntimeException();
			} catch (InvocationTargetException e) {
				log.debug("InvocationTargetException");
				throw new RuntimeException();
			}
		} catch (RuntimeException e) {
			errorFieldsValue.put(booleanFieldName, value);
			try {
				setMethod.invoke(this, METHOD_DEFAULT_NULL_PARAM);
			} catch (Exception ee) {

			}
		}
	}

	public String getBooleanString(String booleanFieldName) {
		StringBuffer methodName = new StringBuffer(64);
		methodName.append(GETTER_PREFIX);
		methodName.append(upperFirstChar(booleanFieldName));
		Method getMethod = getMethod(methodName.toString());
		try {
			Boolean booleanField = (Boolean) getMethod.invoke(this,
					METHOD_DEFAULT_PARAM);
			if (booleanField != null) {
				return booleanField.toString();
			} else {
				if (errorFieldsValue.get(booleanFieldName) != null) {
					return errorFieldsValue.get(booleanFieldName);
				} else {
					return CommonConstants.EMPTY_STRING;
				}
			}
		} catch (IllegalAccessException e) {
			log.debug("IllegalAccessException");
			throw new RuntimeException();
		} catch (InvocationTargetException e) {
			log.debug("InvocationTargetException");
			throw new RuntimeException();
		}
	}

	public String getBlobString(String blobFieldName) {
		return CommonConstants.EMPTY_STRING;
	}

	/**
	 * Set the Blob when this record was created as a fileFullName
	 * 
	 * @param blobFieldName
	 * @param fileFullName
	 * @throws SQLException
	 */
	public void setBlobString(String blobFieldName, BusinessObject existObject)
			throws SQLException {
		StringBuffer methodName = new StringBuffer(64);
		methodName.append(SETTER_PREFIX);
		methodName.append(upperFirstChar(blobFieldName));
		Method setMethod = getMethod(methodName.toString());

		methodName = new StringBuffer(64);
		methodName.append(GETTER_PREFIX);
		methodName.append(upperFirstChar(blobFieldName));
		Method getMethod = getMethod(methodName.toString());
		try {
			try {
				if (getForm() != null) {
					InputStream is = getForm()
							.convertInputStream(blobFieldName);
					if (is != null) {
						byte[] bytes = new byte[is.available()];
						is.read(bytes);
						if (bytes.length > CommonConstants.DEFAULT_BLOB_LENGTH_LIMIT) {
							throw new RuntimeException("Blob field too long.");
						}
						if (bytes.length == 0) {
							if (existObject != null) {
								bytes = (byte[]) getMethod.invoke(existObject,
										METHOD_DEFAULT_PARAM);
							}
						}
						setMethod.invoke(this, bytes);
					} else {
						setMethod.invoke(this, METHOD_DEFAULT_NULL_PARAM);
					}
				} else {
					setMethod.invoke(this, METHOD_DEFAULT_NULL_PARAM);
				}
			} catch (IllegalAccessException e) {
				log.debug("IllegalAccessException");
				throw new RuntimeException(e.getMessage());
			} catch (InvocationTargetException e) {
				log.debug("InvocationTargetException");
				throw new RuntimeException(e.getMessage());
			} catch (IOException e) {
				log.debug("IOException");
				throw new RuntimeException(e.getMessage());
			}
		} catch (RuntimeException e) {
			errorFieldsValue.put(blobFieldName, e.getMessage());
			try {
				setMethod.invoke(this, METHOD_DEFAULT_NULL_PARAM);
			} catch (Exception ee) {

			}
		}
	}

	public Object _getValue(String fieldName) {
		StringBuffer methodName = new StringBuffer(64);
		methodName.append(GETTER_PREFIX);
		methodName.append(upperFirstChar(fieldName));
		Method getMethod = getMethod(methodName.toString());
		try {
			return getMethod.invoke(this, METHOD_DEFAULT_PARAM);
		} catch (IllegalAccessException e) {
			log.debug("IllegalAccessException");
			throw new RuntimeException();
		} catch (InvocationTargetException e) {
			log.debug("InvocationTargetException");
			throw new RuntimeException();
		}
	}
	
	public void _setValue(String fieldName,Object value){
		StringBuffer methodName = new StringBuffer(64);
		methodName.append(SETTER_PREFIX);
		methodName.append(upperFirstChar(fieldName));
		Method setMethod = getMethod(methodName.toString());
		try {
			try {
				if (value != null
						&& !value.equals(CommonConstants.EMPTY_STRING)) {
					setMethod.invoke(this, value);
				} else {
					setMethod.invoke(this, METHOD_DEFAULT_NULL_PARAM);
				}
			} catch (IllegalAccessException e) {
				log.debug("IllegalAccessException");
				throw new RuntimeException();
			} catch (InvocationTargetException e) {
				log.debug("InvocationTargetException");
				throw new RuntimeException();
			}
		} catch (RuntimeException e) {
			errorFieldsValue.put(fieldName, value.toString());
			try {
				setMethod.invoke(this, METHOD_DEFAULT_NULL_PARAM);
			} catch (Exception ee) {

			}
		}
	}

	public String getNodeIcon() {
		if (this instanceof Resource) {
			return CommonConstants.TREE_CONFIG.DEFAULT_RESOUCE_ICON;
		} else {
			return CommonConstants.TREE_CONFIG.DEFAULT_NOT_RESOUCE_ICON;
		}
	}

	public String getNodeOpenIcon() {
		if (this instanceof Resource) {
			return CommonConstants.TREE_CONFIG.DEFAULT_RESOUCE_OPEN_ICON;
		} else {
			return CommonConstants.TREE_CONFIG.DEFAULT_NOT_RESOUCE_ICON;
		}
	}

	public IForm getForm() {
		return form;
	}

	public void setForm(IForm form) {
		this.form = form;
	}

	private String upperFirstChar(String value) {
		char[] chars = value.toCharArray();
		if (chars[0] >= 97 && chars[0] <= 122) {
			chars[0] -= 32;
			value = null;
			value = new String(chars); 
		}
		return value;
	}

	private Method getMethod(String methodName) {
		Map<String,Method> currMethodMap = null;
		if (methodMap == null) {
			methodMap = new HashMap<String,Map<String,Method>>();
		}	
		if(methodMap.get(this.getClass().getName())==null){
			currMethodMap = new HashMap<String,Method>();
			methodMap.put(this.getClass().getName(), currMethodMap);
			Method[] methods = this.getClass().getMethods();
			for (int i = 0; i < methods.length; i++) {
				if (existsSkipIndex(methods[i].getName()) == -1) {
					currMethodMap.put(methods[i].getName(), methods[i]);
				}
			}
		}else{
			currMethodMap = methodMap.get(this.getClass().getName());
		}
		return currMethodMap.get(methodName);
	}

	private int existsSkipIndex(String methodName) {
		for (int i = 0; i < skipMethodName.length; i++) {
			if (skipMethodName[i].equals(methodName)) {
				return i;
			}
		}
		return -1;
	}
}
