package net.frank.commons.log4j;

import java.io.IOException;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Logger;

import org.apache.log4j.PatternLayout;

public class ThreadLoggerFactory {
	
	private static Logger log = Logger.getLogger(ThreadLoggerFactory.class);
	
	ThreadLoggerFactory() {
	};

	public static Logger getLogger() {
		Logger logger = null;
		// 创建一个Logger实例, 就以线程名命名
		logger = Logger.getLogger(Thread.currentThread().getName());
		PatternLayout layout = (PatternLayout) log.getParent().getAppender("myThreadfile").getLayout();
		DailyRollingFileAppender fileAppender = (DailyRollingFileAppender) log.getParent().getAppender("myThreadfile");
		// 控制台输出
		// ConsoleAppender concoleAppender = new ConsoleAppender(layout,
		// "System.out");

		// 文件输出
		//threadDailyRollingAppender.setFile(fileAppender.getFile());
		ThreadDailyRollingAppender threadDailyRollingAppender = null;
		try {
			threadDailyRollingAppender = new ThreadDailyRollingAppender(
					layout,fileAppender.getFile().replace("#thread_desc",Thread.currentThread().getId()+"_"+Thread.currentThread().getName()),
					fileAppender.getDatePattern());
		} catch (IOException e) {
			e.printStackTrace();
		}
		threadDailyRollingAppender.setAppend(fileAppender.getAppend());
		
		threadDailyRollingAppender.setImmediateFlush(fileAppender.getImmediateFlush());
		threadDailyRollingAppender.setThreshold(fileAppender.getThreshold());
		// 绑定到Logger
		logger.setLevel(log.getParent().getLevel());
		// logger.addAppender(concoleAppender);
		logger.addAppender(threadDailyRollingAppender);
		return logger;
	}
}