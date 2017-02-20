package net.frank.corejava2.ch01;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomFileTest {
	static final int RECORD_SIZE=2*Employee.NAME_SIZE +8+4+4+4;
	public static void main(String[] args){
		Employee[] staff = new Employee[3];
		staff[0] = new Employee("Carl Cracker",75000,1987,12,15);
		staff[1] = new Employee("Harry Hacker",50000,1989,10,1);
		staff[2] = new Employee("Tony Tester",40000,1990,3,15);
		try{
			DataOutputStream out = new DataOutputStream(new FileOutputStream("employee_1.dat"));
			for(Employee e :staff){
				e.writeData(out);
			}
			out.close();
			RandomAccessFile in = new RandomAccessFile("employee_1.dat","r");
			int n= (int) (in.length() /RECORD_SIZE);
			Employee[] newStaff = new Employee[n];
			for(int i=n-1;i>=0;i--){
				newStaff[i] = new Employee();
				in.seek(i*RECORD_SIZE);
				newStaff[i].readData(in);
			}
			in.close();
			for(Employee e:newStaff){
				System.out.println(e);
			}		
		}catch(IOException e){
			
		}		
	}	
}
/****
 *  Class java.io.RandomAccessFile
 *  RandomAccessFile(String file, String mode)
 *  RandomAccessFile(File file, String mode)
 *  参数	file	要打开的文件
 *  	mode	"r"表示只读；"rw"表示读写模式；"rws"表示每次更新时，都对数据和元数据的写磁盘操作进行同步的读、写的模式；"rwd"表示每次更新时，只对数据的写磁盘操作进行同步的读、写的模式
 * 
 *  long getFilePointer()
 *  返回文件指针的当前位置
 *  
 *  void seek(long pos)
 *  将文件指针的开始设置到pom个字节处
 *  
 *  long length()
 *  返回文件按照字节来度量的长度
 *  
 */