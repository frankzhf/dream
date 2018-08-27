package net.frank.corejava1.ch06.interfaces;

public class Employee implements Comparable<Employee> {

	private String name;
	private double salary;
	
	public Employee(String n, double s) {
		name = n;
		salary = s;
	}
	
	public String getName() {
		return name;
	}
	public double getSalary() {
		return salary;
	}
	
	public void raiseSalary(double byPrecent) {
		double raise = salary * byPrecent/100;
		salary += raise;
	}
	
	@Override
	public int compareTo(Employee other) {
		return Double.compare(salary, other.getSalary());
	}
}
/***
 * 
 * java.lang.Comparable<T>
 * int compareTo(T other)
 * 用这个对象与other进行比较。如果这个对象小于other则返回负值；如果相等则返回0；否则返回正值
 * 
 * java.util.Arrays
 * static void sort(Object[] a)
 * 使用比较排序算法对数组a中的元素进行排序。要求数组中的元素必须属于实现了Comparable接口的类，并且元素之间必须是可比较的
 * 
 * java.lang.Integer
 * static int compare(int x, int y)
 * 如果x<y返回一个负整数；如果x和y相等，则返回0；否则返回一个负整数
 * 
***/