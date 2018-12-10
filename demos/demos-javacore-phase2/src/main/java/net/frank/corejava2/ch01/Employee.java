package net.frank.corejava2.ch01;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Employee implements Cloneable,Serializable {
	
	
	
	/**
	 *  implements Serializable 序列化方式
	 */
	private static final long serialVersionUID = -1909227258258861936L;
	private String name;
	private double salary;
	private Date hireDay;
	
	public Employee(){
		
	}
	
	public Employee(String n,double s,int year,int month,int day){
		name = n;
		salary = s;
		GregorianCalendar calendar = 
				new GregorianCalendar(year,month-1,day);
		hireDay = calendar.getTime();
	}
	
	public String getName(){
		return name;
	}
	
	public double getSalary(){
		return salary;
	}
	
	public Date getHireDay(){
		return hireDay;
	}
	
	public void raiseSalary(double byPercent){
		double raise = salary * byPercent / 100;
		salary += raise;
	}
	
	public String toString(){
		return getClass().getName() + "[name="+name +",salary=" + salary + ",hireDay=" + hireDay +"]"; 
	}
	
	// use by TextFileTest
	public void writeData(PrintWriter out){
		GregorianCalendar calendar = 
				new GregorianCalendar();
		calendar.setTime(hireDay);
		out.println(name + "|" + salary+ "|" + calendar.get(Calendar.YEAR) +"|"
				+ (calendar.get(Calendar.MONTH) +1 ) +"|"
				+ calendar.get(Calendar.DAY_OF_MONTH));
	}
	
	// use by TextFileTest
	public void readData(Scanner in){
		String line = in.nextLine();
		String[] tokens = line.split("\\|");
		name = tokens[0];
		salary = Double.parseDouble(tokens[1]);
		int y= Integer.parseInt(tokens[2]);
		int m= Integer.parseInt(tokens[3]);
		int d= Integer.parseInt(tokens[4]);
		GregorianCalendar calendar = 
				new GregorianCalendar(y,m-1,d);
		hireDay = calendar.getTime();
	}
	
	// use by RandomFileTest
	public void writeData(DataOutput out)throws IOException{
		DataIO.writeFixedString(name, NAME_SIZE, out);
		out.writeDouble(salary);
		GregorianCalendar calendar = 
				new GregorianCalendar();
		calendar.setTime(hireDay);
		
		out.writeInt(calendar.get(Calendar.YEAR));
		out.writeInt(calendar.get(Calendar.MONTH)+1);
		out.writeInt(calendar.get(Calendar.DAY_OF_MONTH));
	}
	
	// use by RandomFileTest
	public void readData(DataInput in) throws IOException{
		name = DataIO.readFixedString(NAME_SIZE, in);
		salary = in.readDouble();
		int year = in.readInt();
		int month = in.readInt();
		int day = in.readInt();
		
		GregorianCalendar calendar = 
				new GregorianCalendar(year,month-1,day);
		hireDay = calendar.getTime();
	}
	
	// use by SerialCloneTest
	public Object clone(){
		try{
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(bout);
			out.writeObject(this);
			out.close();
			ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
			ObjectInputStream in = new ObjectInputStream(bin);
			Object ret = in.readObject();
			in.close();
			return ret;
		}catch(Exception e){
			return null;
		}
		
	}
	
	
	static final int NAME_SIZE=40;
	
}
