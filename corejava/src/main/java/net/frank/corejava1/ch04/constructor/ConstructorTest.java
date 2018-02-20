package net.frank.corejava1.ch04.constructor;

import java.util.Random;

/***
 * 
 * Class java.util.Random
 * Random()
 * 构造一个新的随机数生成器
 * 
 * int nextInt(int n)
 * 返回一个0~n之前的随机数
 * 
 */

public class ConstructorTest {

	public static void main(String[] args) {
		Employee [] staff = new Employee[3];
		staff[0] = new Employee("Harry",40000);
		staff[1] = new Employee(60000);
		staff[2] = new Employee();
		
		for(Employee e :staff) {
			System.out.println("name=" + e.getName() + ",id=" +e.getId() +",salary=" + e.getSalary());
		}
	}

}


class Employee{
	private static int nextId;
	
	private int id;
	private String name="";
	private double salary;
	
	static {
		Random generator = new Random();
		nextId = generator.nextInt(100000);
	}
	
	//object initialization block
	{
		id = nextId;
		nextId ++;
	}
	
	public Employee(String n, double s) {
		name = n;
		salary = s;
	}
	
	public Employee(double s) {
		this("Employee #"+nextId,s );
	}
	
	public Employee() {
		// name initialized to "" -- see below
		// salary not explicitly set -- initialized to 0
		// id initialized in initialization block
	}
	
	public String getName() {
		return name;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public int getId() {
		return id;
	}
	
}
