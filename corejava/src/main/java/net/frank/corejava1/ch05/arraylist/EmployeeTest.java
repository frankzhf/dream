package net.frank.corejava1.ch05.arraylist;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;


public class EmployeeTest {
	public static void main(String[] args) {
		ArrayList<Employee> staff = new ArrayList<>();
		staff.add(new Employee("Carl Cracker", 75000, 1987, 12, 15));
		staff.add(new Employee("Harry Hacker", 50000, 1989, 10, 1));
		staff.add(new Employee("Tony Tester", 40000, 1990, 3, 15));
		for (Employee e : staff) {
			e.raiseSalary(5);
		}
		for (Employee e : staff) {
			System.out.println("name=" + e.getName() + ",salary=" + e.getSalary() + ",hireDay=" + e.getHireDay());
		}
	}
	
	/***
	 * 
	 * java.util.ArrayList<T>
	 * ArrayList<T>()
	 * 构造一个空数组列表
	 * 
	 * ArrayList<T>(int initialCapacity)
	 * 用指定容量构造一个空数组列表
	 * 
	 * boolean add(T obj)
	 * 在数组列表的尾端添加一个元素，永远返回true
	 * 
	 * int size()
	 * 返回存储在数组列表中的当前元素数量
	 * 
	 * void ensureCapacity(int capacity)
	 * 确保数组列表在不重新分配存储空间的情况下能够保存给定数量的元素
	 * 
	 * void trimToSize()
	 * 将数给列表的存储容量削减到当前尺寸
	 * 
	 * void set(int index, T obj)
	 * 设置数组列表指定位置的元素值，这个操作会覆盖这个位置的原有内容
	 * 
	 * T get(int index)
	 * 获得指定位置的元素值
	 * 
	 * void add(int index, T obj)
	 * 向后移动元素，以便插入元素
	 * 
	 * T remove(int index)
	 * 删除一个元素，并将后面的元素向前移动，被删除的元素由返回值返回
	 * 
	 */
}

class Employee {
	private String name;
	private double salary;
	private Date hireDay;

	public Employee(String n, double s, int year, int month, int day) {
		name = n;
		salary = s;
		GregorianCalendar calendar = new GregorianCalendar(year, month-1, day);
		hireDay = calendar.getTime();
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public Date getHireDay() {
		return hireDay;
	}

	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}

}
