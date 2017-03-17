package net.frank.commons.log4j;

import java.io.IOException;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Layout;

public class ThreadDailyRollingAppender extends DailyRollingFileAppender implements Cloneable {

	public ThreadDailyRollingAppender() {
		super();
	}

	public ThreadDailyRollingAppender(Layout layout,String fileName , String datePattern) throws IOException {
		super(layout,fileName,datePattern);  
	}

}
