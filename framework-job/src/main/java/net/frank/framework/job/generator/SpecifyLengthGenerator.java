package net.frank.framework.job.generator;

import java.io.BufferedWriter;
import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.frank.commons.util.StringUtil;
import net.frank.framework.job.JobConstant;
import net.frank.framework.job.JobException;
import net.frank.framework.job.model.DataRow;

public class SpecifyLengthGenerator implements IPlaintextGenerator {
	
	protected transient Logger log = LoggerFactory.getLogger(getClass());

	/**
	 * define as columnName1[|columnName2|.......]
	 */
	private String columnNames;
	
	/**
	 * define as length1[|length2|.......]
	 */
	private String columnLengths;
	
	public SpecifyLengthGenerator(String columnNames, String columnLengths){
		this.columnNames = columnNames;
		this.columnLengths = columnLengths;
	}
	
	@Override
	public void processLine(DataRow dataRow, BufferedWriter bw)
			throws JobException {
		try{
			String[] columns = columnNames.split(JobConstant.DEFAULT_LINE_SPLIT);
			String[] lengths = columnLengths.split(JobConstant.DEFAULT_LINE_SPLIT);
			if(columns!=null && columns.length>0){
				StringBuffer sb = new StringBuffer(JobConstant.DEFAULT_STRING_BUFFER_LENGTH);
				for(int i=0;i<columns.length;i++){
					String columnName = columns[i];
					String strLenght = lengths[i];
					int length = Integer.parseInt(strLenght);
					String columnValue = dataRow.getColumn(columnName).getColumnValue();
					if(StringUtil.isNumber(columnValue)){
						sb.append(StringUtils.leftPad(columnValue, length, ' '));
					}else{
						sb.append(StringUtils.rightPad(columnValue, length, ' '));
					}
				}
				bw.newLine();
			}
		}catch(IOException e){
			log.error(e.getMessage(),e);
			throw new JobException(e);
		}
	}
}
