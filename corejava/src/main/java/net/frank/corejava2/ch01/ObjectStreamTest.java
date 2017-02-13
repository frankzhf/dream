package net.frank.corejava2.ch01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamTest {
	
	
	
	public static void main(String[] args){
		Employee harry = new Employee("Harry Hacker",50000,1989,10,1);
		Manager carl = new Manager("Carl Cracker",80000,1987,12,15);
		carl.setSecretary(harry);
		Manager tony = new Manager("Tony Tester",40000,1990,3,15);
		tony.setSecretary(harry);
		
		Employee[] staff = new Employee[3];
		staff[0] = harry;
		staff[1] = carl;
		staff[2] = tony;
		
		try{
			ObjectOutputStream out = 
					new ObjectOutputStream(new FileOutputStream("employee_2.dat"));
			out.writeObject(staff);
			out.close();
			
			ObjectInputStream in =
					new ObjectInputStream(new FileInputStream("employee_2.dat"));
			Employee[] newStaff = (Employee[]) in.readObject();
			in.close();
			
			//newStaff[1].raiseSalary(10);
			for(Employee e:newStaff){
				System.out.println(e);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
/**
 * Class java.io.ObjectOutputStream
 * ObjectOutputStrem(OutputStream out)
 * 构造
 * 
 * void writeObject(Object obj)
 * 指定的对象写入
 * 
 * Class java.io.ObjectInputStream
 * ObjectInputStream(InputStream in)
 * 构造
 * 
 * Object readObject()
 * 读入一个对像
 * 
 * 
 * 注意Externalizable 和 transient
 * 
 */