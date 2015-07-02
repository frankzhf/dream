package net.frank.framework.job.generator;

import java.io.BufferedWriter;
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.frank.framework.job.JobConstant;
import net.frank.framework.job.JobException;
import net.frank.framework.job.model.DataRow;

public class DefaultSplitGenerator implements IPlaintextGenerator {

	protected transient Log log = LogFactory.getLog(getClass());

	/**
	 * define as columnName1[|columnName2|.......]
	 */
	private String columnNames;

	private String columnSplit;

	public DefaultSplitGenerator(String columnNames, String columnSplit) {
		this.columnNames = columnNames;
		this.columnSplit = columnSplit;
	}

	public DefaultSplitGenerator(String columnNames) {
		this(columnNames, JobConstant.DEFAULT_SPLIT);
	}

	@Override
	public void processLine(DataRow dataRow, BufferedWriter bw)
			throws JobException {
		try{
			String [] columns = columnNames.split(JobConstant.DEFAULT_LINE_SPLIT);
			if(columns!=null && columns.length>0){
				StringBuffer sb = new StringBuffer(JobConstant.DEFAULT_STRING_BUFFER_LENGTH);
				for(int i=0;i<columns.length;i++){
					String columnName = columns[i];
					if(i!=0){
						sb.append(columnSplit);
					}
					sb.append(dataRow.getColumn(columnName).getColumnValue());
				}
				bw.write(sb.toString());
				bw.newLine();
			}
		}catch(IOException e){
			log.error(e.getMessage(),e);
			throw new JobException(e);
		}
	}

}
