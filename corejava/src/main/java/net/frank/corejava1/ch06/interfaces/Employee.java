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
