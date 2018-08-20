package net.frank.framework.job.parser;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.frank.framework.job.JobConstant;
import net.frank.framework.job.JobException;
import net.frank.framework.job.model.DataColumn;
import net.frank.framework.job.model.DataRow;

public class DefaultSplitParser implements IPlaintextParser {
	
	protected transient Logger log = LoggerFactory.getLogger(getClass());
	
	private String columnNames;
	
	private String columnSplit;
	
	public DefaultSplitParser(String columnNames,String columnSplit){
		this.columnNames = columnNames;
		this.columnSplit = columnSplit;
	}
	
	public DefaultSplitParser(String columnNames){
		this(columnNames,JobConstant.DEFAULT_LINE_SPLIT);
	}
	
	@Override
	public void processLine(String line, DataRow dataRow) throws JobException {
		String[] values = line.split(columnSplit,-1);
		String[] columns = columnNames.split(JobConstant.DEFAULT_LINE_SPLIT);
		if(values!=null && values.length >0){
			for(int i=0;i<values.length;i++){
				String value = values[i];
				String columnName = columns[i];
				DataColumn dataColumn = new DataColumn();
				dataColumn.setColumnName(columnName);
				dataColumn.setColumnValue(value);
				dataRow.putColumn(dataColumn);
			}
		}
	}

}
