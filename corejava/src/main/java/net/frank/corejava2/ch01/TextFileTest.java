package net.frank.corejava2.ch01;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextFileTest {
	
	public static void main(String[] args){
		Employee[] staff = new Employee[3];
		staff[0] = new Employee("Carl Cracker",75000,1987,12,15);
		staff[1] = new Employee("Harry Hacker",50000,1989,10,1);
		staff[2] = new Employee("Tony Tester",40000,1990,3,15);
		try{
			PrintWriter out = new PrintWriter("employee.dat");
			writeData(staff,out);
			out.close();
			
			Scanner in = new Scanner(new FileReader("employee.dat"));
			Employee[] newStaff = readData(in);
			in.close();
			
			for(Employee e:newStaff)
				System.out.println(e);
			
		}catch(IOException e){
			
		}
		
	}
	
	
	private static void writeData(Employee[] employees,PrintWriter out) throws IOException{
		out.println(employees.length);
		for(Employee e:employees)
			e.writeData(out);
	}
	
	private static Employee[] readData(Scanner in){
		int n = in.nextInt();
		in.nextLine();
		
		Employee[] employees = new Employee[n];
		for(int i=0;i<n;i++){
			employees[i] = new Employee();
			employees[i].readData(in);
		}
		return employees;
	}
	
	
}
