package net.frank.corejava0.jakarta.ch01;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.FastDateFormat;

public class FastDateFormatSample {

	public static void main(String[] args) {
		Date now = new Date();
		String isoDT = DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(now);
		System.out.println(isoDT);
		
		FastDateFormat formatter = FastDateFormat.getInstance("yyyy-MM", //ISO 8601
				TimeZone.getDefault(),									//增加ZZ用于表示时区 如果中国是 +8:00
				Locale.getDefault());									//转换方法是线程安全
		String output = formatter.format(new Date());
		System.out.println(output);
		
		
		
		/***
		 * 
		 * DateFormatUtils.ISO_DATE_FORMAT				yyyy-MM-dd
		 * 
		 * DateFormatUtils.ISO_DATE_TIME_ZONE_FORMAT		yyyy-MM-ddZZ
		 * 
		 * DateFormatUtils.ISO_DATETIME_FORMAT			yyyy-MM-dd'T'HH:mm:ss
		 * 
		 * DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT			yyyy-MM-dd'T'HH:mm:ssZZ
		 * 
		 * DateFormatUtils.ISO_TIME_FORMAT				'T'HH:mm:ss
		 * 
		 * DateFormatUtils.ISO_TIME_NO_T_FORMAT			HH:mm:ss
		 * 
		 * DateFormatUtils.ISO_TIME_NO_T_TIME_ZONE_FORMAT			HH:mm:ssZZ
		 * 
		 * DateFormatUtils.ISO_TIME_TIME_ZONE_FORMAT		'T'HH:mm:ssZZ
		 * 
		 * SMTP_DATETIME_FORMAT							EEE, dd MMM yyyy HH:mm:ss Z
		 * 
		 */
		
		FastDateFormat dtFormat = DateFormatUtils.ISO_DATETIME_FORMAT;
		
		//Date now = new Date();
		Date nearestHour = DateUtils.round(now, Calendar.HOUR);
		Date nearestDay = DateUtils.round(now, Calendar.DAY_OF_MONTH);
		Date nearestYear = DateUtils.round(now, Calendar.YEAR);
		
		System.out.println(dtFormat.format(now));
		System.out.println(dtFormat.format(nearestHour));
		System.out.println(dtFormat.format(nearestDay));
		System.out.println(dtFormat.format(nearestYear));
		
		
		Date truncatedMonth = DateUtils.truncate(now, Calendar.MONTH);
		Date truncatedHour = DateUtils.truncate(now, Calendar.HOUR);
		

		System.out.println(dtFormat.format(now));
		System.out.println(dtFormat.format(truncatedMonth));
		System.out.println(dtFormat.format(truncatedHour));
		
		
	}

}
