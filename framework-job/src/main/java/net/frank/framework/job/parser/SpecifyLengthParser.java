package net.frank.framework.job.parser;

import net.frank.framework.job.JobConstant;
import net.frank.framework.job.JobException;
import net.frank.framework.job.model.DataColumn;
import net.frank.framework.job.model.DataRow;

public class SpecifyLengthParser implements IPlaintextParser {
	
	
	/**
	 * define as columnName1[|columnName2|.......]
	 */
	private String columnNames;
	
	/**
	 * define as length1[|length2|.......]
	 */
	private String columnLengths;
	
	public SpecifyLengthParser(String columnNames,String columnLengths){
		this.columnNames = columnNames;
		this.columnLengths = columnLengths;
	}
	
	@Override
	public void processLine(String line, DataRow dataRow) throws JobException {
		String[] columns = columnNames.split(JobConstant.DEFAULT_LINE_SPLIT);
		String[] lengths = columnLengths.split(JobConstant.DEFAULT_LINE_SPLIT);
		int start = 0;
		int end = 0;
		if(columns!=null && columns.length >0){
			for(int i=0;i<columns.length;i++){
				String column = columns[i];
				String strLength = lengths[i];
				int length = Integer.parseInt(strLength);
				end += length;
				String columnValue = line.substring(start,end);
				DataColumn dataColumn = new DataColumn();
				dataColumn.setColumnName(column);
				dataColumn.setColumnValue(columnValue);
				dataRow.putColumn(dataColumn);
				start = end;
			}
		}
	}

}
