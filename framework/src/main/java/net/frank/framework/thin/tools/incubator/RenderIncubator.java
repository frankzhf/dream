package net.frank.framework.thin.tools.incubator;

import java.io.File;
import java.util.Iterator;

import net.frank.commons.CommonConstants;
import net.frank.framework.thin.tools.model.Column;
import net.frank.framework.thin.tools.model.TableData;

public class RenderIncubator extends AbstractIncubator {
	private static final String BAK = CommonConstants.SPACE;
	private static final String ENT = CommonConstants.STRING_ENTER;
	private static final String TAB = CommonConstants.STRING_TAB;
	
	private static final String SUFFIX_FILE_NAME = "Render";
	
	public RenderIncubator(File folder, String packageName, TableData tableData) {
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
		writeConstantsField(fileContent, tableData);
		writeOutputBodyXmlFunction(fileContent, tableData);
		writeSetBodyPropertyFunction(fileContent, tableData);
		writeClassEnd(fileContent);
		return fileContent.toString();
	}
	
	private void writePackageInfo(StringBuffer fileContent, String packageName) {
		fileContent.append("package").append(BAK).append(packageName)
				.append(";").append(ENT);
	}
	
	private void writeImportInfo(StringBuffer fileContent, TableData tableData) {
		fileContent.append(ENT).append("import").append(BAK).append("org.w3c.dom.Node;").append(ENT).
			append("import").append(BAK).append("org.w3c.dom.NodeList;").append(ENT);
		fileContent.append(ENT).append("import").append(BAK).append("net.frank.framework.bo.BaseEntity;").append(ENT).
			append("import").append(BAK).append("net.frank.framework.thin.render.BaseEntityTypeRender;").append(ENT);
	}
	
	private void writeClassHead(StringBuffer fileContent, TableData tableData) {
		fileContent.append(ENT);
		fileContent.append("public final class ").append(tableData.getJavaClassName()).
			append("Render extends BaseEntityTypeRender {").append(ENT);
	}
	
	private void writeConstantsField(StringBuffer fileContent,
			TableData tableData) {
		fileContent.append(ENT);
		for(Iterator<Column> it=tableData.getColumnList().iterator();it.hasNext();){
			Column currColumn = it.next();
			fileContent.append(TAB).append("private static final String FIELD_").
				append(currColumn.getColumnName().toUpperCase()).append(" = \"").
				append(currColumn.getColumnName()).append("\";").append(ENT);
		}
		
	}
	
	private void writeOutputBodyXmlFunction(StringBuffer fileContent,
			TableData tableData) {
		fileContent.append(ENT);
		fileContent.append(TAB).append("@Override").append(ENT);
		fileContent.append(TAB).append("public void outputBodyXml(BaseEntity targetObject, String property,").append(ENT).
			append(TAB).append(TAB).append(TAB).append("StringBuffer input) {").append(ENT);
		for(Iterator<Column> it=tableData.getColumnList().iterator();it.hasNext();){
			Column currColumn = it.next();
			fileContent.append(TAB).append(TAB).append("getWsRenderPool().getWsRender(\"").append(processJavaClassMapKey(currColumn.getColumnType())).
				append("\").outputXml(targetObject,").append(ENT).append(TAB).append(TAB).append(TAB).
				append("FIELD_").append(currColumn.getColumnName().toUpperCase()).append(", input);").append(ENT);
		}
		fileContent.append(TAB).append("}").append(ENT);
	}
	
	private void writeSetBodyPropertyFunction(StringBuffer fileContent,
			TableData tableData) {
		fileContent.append(ENT);
		fileContent.append(TAB).append("@Override").append(ENT);
		fileContent.append(TAB).append("public void setBodyProperty(BaseEntity targetObject, Node w3cNode) {").append(ENT);
		fileContent.append(TAB).append(TAB).append("NodeList propertiesElement = w3cNode.getChildNodes();").append(ENT);
		fileContent.append(TAB).append(TAB).append("if(propertiesElement!=null && propertiesElement.getLength()>0){").append(ENT);
		fileContent.append(TAB).append(TAB).append(TAB).append("for(int i=0;i<propertiesElement.getLength();i++){").append(ENT);
		fileContent.append(TAB).append(TAB).append(TAB).append(TAB).append("Node currentElement = propertiesElement.item(i);").append(ENT);
		boolean isFirst = true;
		for(Iterator<Column> it=tableData.getColumnList().iterator();it.hasNext();){
			Column currColumn = it.next();
			if(isFirst){
				fileContent.append(TAB).append(TAB).append(TAB).append(TAB).
					append("if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_").
					append(currColumn.getColumnName().toUpperCase()).append(")){").append(ENT);
				fileContent.append(TAB).append(TAB).append(TAB).append(TAB).append(TAB).
					append("getWsRenderPool().getWsRender(\"").append(processJavaClassMapKey(currColumn.getColumnType())).
					append("\").setProperty(").append(ENT);
				fileContent.append(TAB).append(TAB).append(TAB).append(TAB).append(TAB).append(TAB).append(TAB).
					append("targetObject,currentElement);").append(ENT);
				fileContent.append(TAB).append(TAB).append(TAB).append(TAB).
					append("}");
				isFirst = false;
			}else{
				fileContent.append("else if(currentElement.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue().equals(FIELD_").
					append(currColumn.getColumnName().toUpperCase()).append(")){").append(ENT);
				fileContent.append(TAB).append(TAB).append(TAB).append(TAB).append(TAB).
					append("getWsRenderPool().getWsRender(\"").append(processJavaClassMapKey(currColumn.getColumnType())).
					append("\").setProperty(").append(ENT);
				fileContent.append(TAB).append(TAB).append(TAB).append(TAB).append(TAB).append(TAB).append(TAB).
					append("targetObject,currentElement);").append(ENT);
				fileContent.append(TAB).append(TAB).append(TAB).append(TAB).
					append("}");
			}
		}
		fileContent.append(ENT);
		fileContent.append(TAB).append(TAB).append(TAB).append("}").append(ENT);
		fileContent.append(TAB).append(TAB).append("}").append(ENT);
		fileContent.append(TAB).append("}").append(ENT);
	}
	
	private String processJavaClassMapKey(String javaClass){
		if("char[]".equals(javaClass)){
			return "[C";
		}
		if("byte[]".equals(javaClass)){
			return "[B";
		}
		return javaClass;
		
	}
	
	
	private void writeClassEnd(StringBuffer fileContent) {
		fileContent.append("}").append(ENT);
	}
}
