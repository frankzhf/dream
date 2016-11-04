package net.frank.framework.job.model;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class DataRow implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6758783700059680234L;
	private Map<String,DataColumn> columnMap = new HashMap<String,DataColumn>();
	
	public DataColumn getColumn(String columnName){
		return columnMap.get(columnName);
	}
	
	public void putColumn(DataColumn dataColumn){
		columnMap.put(dataColumn.getColumnName(), dataColumn);
	}
	
	@Override
	public String toString(){
		StringBuffer sb = new StringBuffer(512);
		sb.append(getClass().getName()).append("[\n");
		Field[] fieldArray = getClass().getDeclaredFields();
		Method[] methods = getClass().getMethods();
		Map<String,Method> methodMap = new HashMap<String,Method>();
		for(int i=0;i<methods.length;i++){
			Method currM = methods[i];
			methodMap.put(currM.getName(), currM);
		}
		for(int i=0;i<fieldArray.length;i++){
			Field curr = fieldArray[i];
			String fieldName = curr.getName();
			if("columnMap".equals(fieldName)){
				String getMethod = "get";
				String field0 = ("" +fieldName.charAt(0)).toUpperCase();
				getMethod += (field0 + fieldName.substring(1));
				Method m = methodMap.get(getMethod);
				if(m!=null){
					Object value = "";
					try{
						value = m.invoke(this, new Object[]{});
					}catch(IllegalAccessException e){
					}catch(InvocationTargetException e){
					}
					sb.append(fieldName + " : " +value +"\n");
				}
			}
		}
		sb.append(columnMap);
		sb.append("]\n");
		return sb.toString();
	}
}
