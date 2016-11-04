package net.frank.framework.thin.tools.incubator;

import java.io.File;
import java.util.Iterator;

import net.frank.commons.CommonConstants;
import net.frank.commons.util.StringUtil;
import net.frank.framework.thin.tools.model.Column;
import net.frank.framework.thin.tools.model.TableData;

public class RowmapperIncubator extends AbstractIncubator {
	
	private static final String BAK = CommonConstants.SPACE;
	private static final String ENT = CommonConstants.STRING_ENTER;
	private static final String TAB = CommonConstants.STRING_TAB;
	
	private static final String SUFFIX_FILE_NAME = "RowMapper";
	
	public RowmapperIncubator(File folder, String packageName,
			TableData tableData) {
		super(folder, packageName, tableData);
	}

	@Override
	public String getFileName(TableData tableData) {
		return tableData.getJavaClassName()+SUFFIX_FILE_NAME+FILE_EXT;
	}

	@Override
	public String getFileContent(String packageName, TableData tableData) {
		StringBuffer fileContent = new StringBuffer(
				CommonConstants.DEFAULT_BYTE_BUFFER_LENGTH);
		writePackageInfo(fileContent, packageName);
		writeImportInfo(fileContent, tableData);
		writeClassHead(fileContent, tableData);
		writeMapRowFunction(fileContent, tableData);
		writeClassEnd(fileContent);
		return fileContent.toString();
	}

	private void writePackageInfo(StringBuffer fileContent, String packageName) {
		fileContent.append("package").append(BAK).append(packageName)
				.append(";").append(ENT);
	}
	
	private void writeImportInfo(StringBuffer fileContent, TableData tableData) {
		fileContent.append(ENT).append("import").append(BAK).append("java.sql.ResultSet;").append(ENT).
			append("import").append(BAK).append("java.sql.SQLException;").append(ENT).append(ENT);
		fileContent.append("import").append(BAK).append("net.frank.dede.bean.").
			append(tableData.getJavaClassName()).append(";").append(ENT).append(ENT);
		fileContent.append("import").append(BAK).append("org.springframework.jdbc.core.RowMapper;").
			append(ENT);
	}
	
	private void writeClassHead(StringBuffer fileContent, TableData tableData) {
		fileContent.append(ENT);
		fileContent.append("public final class ").append(tableData.getJavaClassName()).
			append("RowMapper implements RowMapper<").append(tableData.getJavaClassName()).
			append("> {").append(ENT);
	}
	
	private void writeMapRowFunction(StringBuffer fileContent,
			TableData tableData) {
		fileContent.append(ENT);
		fileContent.append(TAB).append("@Override").append(ENT);
		fileContent.append(TAB).append("public").append(BAK).
			append(tableData.getJavaClassName()).append(BAK).append("mapRow(ResultSet rs, int index)").append(ENT);
		fileContent.append(TAB).append(TAB).append(TAB).append("throws SQLException {").append(ENT);
		fileContent.append(TAB).append(TAB).append(tableData.getJavaClassName()).append(BAK).append("to = new ").
			append(tableData.getJavaClassName()).append("();").append(ENT);
		for(Iterator<Column> it=tableData.getColumnList().iterator();it.hasNext();){
			Column currColumn = it.next();
			String columnName = currColumn.getColumnName();
			String fieldName = StringUtil.column2property(columnName);
			if("id".equals(fieldName)){
				fileContent.append(TAB).append(TAB).append("to.setId(rs.getLong(\"").append(columnName)
					.append("\"));").append(ENT);
			}else{
				fileContent.append(TAB).append(TAB).append("to.set").append(upperFirstChar(fieldName)).
					append("(").append("rs.get").append(getJavaClass(currColumn.getColumnType())).
					append("(\"").append(columnName).append("\")");
				if("char[]".equals(currColumn.getColumnType())){
					fileContent.append(".toCharArray()");
				}
				fileContent.append(");").append(ENT);
			}
		}
		fileContent.append(TAB).append(TAB).append("return to;").append(ENT);
		fileContent.append(TAB).append("}").append(ENT);
	}
	
	private String upperFirstChar(String value){
		char fisrtChar = value.charAt(0);
		if(fisrtChar>=97 && fisrtChar<=122){
			fisrtChar = (char)(((int)fisrtChar)-32);
		}
		return new StringBuffer(CommonConstants.SHORT_STRING_BUFFER_LENGTH).
				append(fisrtChar).append(value.substring(1)).toString();
	}
	
	private String getJavaClass(String columnType){
		if("java.lang.Integer".equals(columnType)){
			return "Int";
		}
		if("byte[]".equals(columnType)){
			return "Bytes";
		}
		if("char[]".equals(columnType)){
			return "String";
		}
		return getClassNameForFullName(columnType);
	}
	
	private String getClassNameForFullName(String fullName){
		return fullName.substring(fullName.lastIndexOf(CommonConstants.POINT) +1);
	}
	
	private void writeClassEnd(StringBuffer fileContent) {
		fileContent.append("}").append(ENT);
	}
	
	/**
		return to;


	 */
}
