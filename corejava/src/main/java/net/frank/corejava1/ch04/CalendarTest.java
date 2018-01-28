package net.frank.corejava1.ch04;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarTest {
	
	/**
	 * 类之间的关系
	 * 依赖(dependence)  (use-a)
	 * 聚合(aggregation)	(has-a)
	 * 继承(inheritance)	(is-a)
	 * 
	 * 
	 * 表达类关系的UML符号
	 * 关系						UML连接符
	 * ------------------------------------------------
	 * 继承						实线三角箭头
	 * 接口实现					虚线三角箭头
	 * 依赖						虚线大于号箭头
	 * 聚合						空平行四边形实线
	 * 关联						实线
	 * 直接关联					实线大于号箭头
	 * 
	**/
	
	public static void main(String[] args) {
		GregorianCalendar d = new GregorianCalendar();
		int today = d.get(Calendar.DAY_OF_MONTH);
		int month = d.get(Calendar.MONTH);
		
		d.set(Calendar.DAY_OF_MONTH, 1);
		int weekday = d.get(Calendar.DAY_OF_WEEK);
		int firstDayOfWeek = d.getFirstDayOfWeek();
		int indent = 0;
		while(weekday != firstDayOfWeek) {
			indent ++;
			d.add(Calendar.DAY_OF_MONTH, -1);
			weekday = d.get(Calendar.DAY_OF_WEEK);
		}
		String[] weekdayNames = new DateFormatSymbols().getShortWeekdays();
		do {
			System.out.printf("%4s", weekdayNames[weekday]);
			d.add(Calendar.DAY_OF_MONTH, 1);
			weekday = d.get(Calendar.DAY_OF_WEEK);
		}while(weekday != firstDayOfWeek);
		System.out.println();
		
		for(int i=1;i<=indent;i++) {
			System.out.print("    ");
		}
		
		d.set(Calendar.DAY_OF_MONTH,1);
		do {
			int day = d.get(Calendar.DAY_OF_MONTH);
			System.out.printf("%3d", day);
			if(day == today) {
				System.out.print("*");
			}else {
				System.out.print(" ");
			}
			d.add(Calendar.DAY_OF_MONTH, 1);
			weekday = d.get(Calendar.DAY_OF_WEEK);
			if(weekday == firstDayOfWeek) {
				System.out.println();
			}
		}while(d.get(Calendar.MONTH) == month);
		if(weekday!=firstDayOfWeek ) {
			System.out.println();
		}
	}
	/***
	 * java.util.GregorianCalendar 格里高利历
	 * GregorianCalendar()
	 * 构造一个日历对象，用来表示默认地区，默认时区的当前时间
	 * 
	 * GregorianCalendar(int year, int month, int day)
	 * GregorianCalendar(int year, int month, int day, int hour, int minute, int secord)
	 * 用给定日期和时间构造一个日历对象
	 * 参数	year				该日期所在年份
	 * 		month			该日期所在月份		以0为基准, 0表示1月
	 * 		day				该月份中的日期
	 * 		hour				小时（0-23）
	 * 		minute			分钟（0-59）
	 * 		secord			秒（0-59）
	 * 
	 * int get(int field)
	 * 返回给定域的值			可以是下述选项之一：	Calendar.ERA、Calendar.YEAR、Calendar.MONTH、
	 * 											Calendar.WEEK_OF_YEAR、Calendar_WEEK_OF_MONTH、
	 * 											Calendar.DAY_OF_MONTH、Calendar.DAY_OF_YEAR、
	 * 											Calendar.DAY_OF_WEEK、Calendar.DAY_OF_WEEK_IN_MONTH、
	 * 											Calendar.AM_PM、Calendar.HOUR、Calendar.HOUR_OF_DAY、
	 * 											Calendar.MINUTE、Calendar.SECOND、
	 * 											Calendar.MILLISECOND、Calendar.ZONE_OFFSET、Calendar.DST_OFFSET
	 *
	 * void set(int field, int value)
	 * 设置给定域的值
	 * 
	 * void set(int year, int month, int day)
	 * void set(int year, int month, int day, int hour, int minute, int secord)
	 * 将日期域和时间域设置为新值
	 * 
	 * void add(int field, int amount)
	 * 可以对日期信息进行算术运算，amount可以是负值
	 * 
	 * int getFirstDayOfWeek()
	 * 获取当前用户所在地区，一个星期中的第一天。
	 * 
	 * void setTime(Date time)
	 * 将日历设置成指定时间点
	 * 
	 * Date getTime()
	 * 获取这个日历当前值所表达的时间点
	 * 
	 * java.text.DateFormatSymbols
	 * String[] getShortWeekdays()
	 * String[] getShortMontsh()
	 * String[] getWeekdays()
	 * String[] getMonths()
	 * 获取当前地区的星期几或月份的名称
	 * 
	 */
}