package net.frank.corejava0.logback.jobs;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class MyRunnable implements Runnable {

	private static final DateFormat df = new SimpleDateFormat("_yyyyMMdd-HHmmss.SSS");
	private Logger log = LoggerFactory.getLogger(MyRunnable.class);
	private static final String JOB_FILE_NAME = "logFileName";

	private String jobName;

	public MyRunnable(String jobName) {
		this.jobName = jobName;
	}

	@Override
	public void run() {
		try {
			MDC.put(JOB_FILE_NAME, jobName + df.format(new Date()));
			log.debug("Start job {}",jobName);
			Thread.sleep(10000);
			log.debug("End job {}",jobName);
		} catch (Exception e) {
			
		} finally {
			if (MDC.get(JOB_FILE_NAME)!=null) {
				MDC.remove("logFileName");
			}
		}
	}
}
