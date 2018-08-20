package net.frank.framework.job;

import java.sql.Connection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractJob implements IAbstractJob {
	
	protected transient Logger log = LoggerFactory.getLogger(getClass());
	
	protected abstract void runJob()throws JobException;
	
	protected abstract Connection getConnection();
	
	private int processedNum = 0;
	
	public int getProcessedNum(){
		return processedNum;
	}
	
	public void processedNumPlus (){
		processedNum ++ ;
	}
	
	@Override
	public void execute(){
		try{
			runJob();
		}catch(JobException e){
			log.error(e.getMessage(),e);
			procssException(e);
		}
	}
	
	protected abstract void procssException(JobException e);
}
