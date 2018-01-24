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
	
}