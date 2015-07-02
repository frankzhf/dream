package net.frank.framework.thin.tools.incubator;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import net.frank.commons.CommonConstants;
import net.frank.commons.util.StringUtil;
import net.frank.framework.thin.tools.model.Column;
import net.frank.framework.thin.tools.model.TableData;

public class BeanIncubator extends AbstractIncubator {

	private static final String BAK = CommonConstants.SPACE;
	private static final String ENT = CommonConstants.STRING_ENTER;
	private static final String TAB = CommonConstants.STRING_TAB;
	private static final String SUPER_CLASS_NAME = "net.frank.framework.bo.BaseEntity";

	public BeanIncubator(File folder, String packageName, TableData tableData) {
		super(folder, packageName, tableData);
	}

	@Override
	public String getFileName(TableData tableData) {
		return tableData.getJavaClassName()+ FILE_EXT;
	}

	@Override
	public String getFileContent(String packageName, TableData tableData) {
		StringBuffer fileContent = new StringBuffer(
				CommonConstants.DEFAULT_BYTE_BUFFER_LENGTH);
		writePackageInfo(fileContent, packageName);
		writeImportInfo(fileContent, tableData);
		writeClassHead(fileContent, tableData);
		writeFields(fileContent, tableData);
		writePropertyFunction(fileContent, tableData);
		writeToString(fileContent, tableData);
		writeClassEnd(fileContent);
		return fileContent.toString();
	}

	

	private void writePackageInfo(StringBuffer fileContent, String packageName) {
		fileContent.append("package").append(BAK).append(packageName)
				.append(";").append(ENT);
	}

	private void writeImportInfo(StringBuffer fileContent, TableData tableData) {
		Map<String, String> importMap = new HashMap<String, String>();
		for (Iterator<Column> it = tableData.getColumnList().iterator(); it
				.hasNext();) {
			Column currColumn = it.next();
			String columnType = currColumn.getColumnType();
			if (!columnType.equals("byte[]")  &&
					!columnType.equals("char[]") && 
					!columnType.startsWith("java.lang")
					&& importMap.get(columnType) == null) {
				fileContent.append(ENT).append("import").append(BAK)
						.append(currColumn.getColumnType()).append(";");
				importMap.put(currColumn.getColumnType(),
						currColumn.getColumnType());
			}
		}
		fileContent.append(ENT);
	}

	private void writeClassHead(StringBuffer fileContent, TableData tableData) {
		fileContent.append(ENT).append("public").
			append(BAK).append("class").append(BAK).
			append(tableData.getJavaClassName()).
			append(BAK).append("extends").append(BAK).append(SUPER_CLASS_NAME).
			append("{").append(ENT);
	}
	
	private void writeFields(StringBuffer fileContent, TableData tableData) {
		fileContent.append(ENT).append(ENT);
		for (Iterator<Column> it = tableData.getColumnList().iterator(); it
				.hasNext();) {
			Column currColumn = it.next();
			Class<?> clazz = null;
			try{
				clazz = Class.forName(SUPER_CLASS_NAME);
			}catch(ClassNotFoundException e){
				
			}
			String columnName = currColumn.getColumnName();
			String fieldName = StringUtil.column2property(columnName);
			try{
				clazz.getDeclaredField(fieldName);
			}catch(NoSuchFieldException e){
				fileContent.append(TAB).append("private").append(BAK).
					append(getClassNameForFullName(currColumn.getColumnType())).
					append(BAK).append(fieldName).append(";").append(ENT).append(ENT);
			}
		}
		fileContent.append(ENT).append(ENT);
	}
	private String getClassNameForFullName(String fullName){
		return fullName.substring(fullName.lastIndexOf(CommonConstants.POINT) +1);
	}
	
	private void writePropertyFunction(StringBuffer fileContent,
			TableData tableData) {
		fileContent.append(ENT).append(ENT);
		for (Iterator<Column> it = tableData.getColumnList().iterator(); it
				.hasNext();) {
			Column currColumn = it.next();
			Class<?> clazz = null;
			try{
				clazz = Class.forName(SUPER_CLASS_NAME);
			}catch(ClassNotFoundException e){
			}
			String columnName = currColumn.getColumnName();
			String fieldName = StringUtil.column2property(columnName);
			try{
				clazz.getDeclaredField(fieldName);
			}catch(NoSuchFieldException e){
				fileContent.append(TAB).append("public").append(BAK).
					append(getClassNameForFullName(currColumn.getColumnType())).
					append(BAK).append("get").append(upperFirstChar(fieldName)).
					append("(){").append(ENT).append(TAB).append(TAB).append("return").
					append(BAK).append("this.").append(fieldName).append(";").append(ENT).
					append(TAB).append("}").append(ENT).append(ENT);
				
				fileContent.append(TAB).append("public").append(BAK).
					append("void").append(BAK).append("set").append(upperFirstChar(fieldName)).
					append("(").append(getClassNameForFullName(currColumn.getColumnType())).append(BAK).
					append(fieldName).append("){").append(ENT).append(TAB).append(TAB).append("this.").
					append(fieldName).append("=").append(fieldName).append(";").append(ENT).
					append(TAB).append("}").append(ENT).append(ENT);
			}
		}
		fileContent.append(ENT).append(ENT);
	}
	
	private String upperFirstChar(String value){
		char fisrtChar = value.charAt(0);
		if(fisrtChar>=97 && fisrtChar<=122){
			fisrtChar = (char)(((int)fisrtChar)-32);
		}
		return new StringBuffer(CommonConstants.SHORT_STRING_BUFFER_LENGTH).
				append(fisrtChar).append(value.substring(1)).toString();
	}
	
	private void writeToString(StringBuffer fileContent, TableData tableData) {
		fileContent.append(ENT).append(ENT);
		fileContent.append(TAB).append("public").append(BAK).
			append("String").append(BAK).append("toString(){").append(ENT);
		
		fileContent.append(TAB).append(TAB).append("return").append(BAK).
			append("\"\"").append(ENT);
		for (Iterator<Column> it = tableData.getColumnList().iterator(); it
				.hasNext();) {
			Column currColumn = it.next();
			String columnName = currColumn.getColumnName();
			String fieldName = StringUtil.column2property(columnName);
			if("char[]".equals(currColumn.getColumnType())){
				fileContent.append(TAB).append(TAB).append("+").
					append("new String(this.get").append(upperFirstChar(fieldName)).append("())").
					append("+").append("\"\\t\"").append(ENT);
			}else{
				fileContent.append(TAB).append(TAB).append("+").
					append("this.get").append(upperFirstChar(fieldName)).append("()").
					append("+").append("\"\\t\"").append(ENT);
			}
		}
		fileContent.append(TAB).append(TAB).append(";").append(ENT);
		fileContent.append(TAB).append("}").append(ENT);
		fileContent.append(ENT).append(ENT);
	}
	
	private void writeClassEnd(StringBuffer fileContent) {
		fileContent.append("}").append(ENT);
	}

}
