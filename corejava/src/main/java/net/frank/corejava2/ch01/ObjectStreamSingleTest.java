package net.frank.corejava2.ch01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

public class ObjectStreamSingleTest {
	
	public static void main(String[] args){
		try{
			ObjectOutputStream out = 
					new ObjectOutputStream(new FileOutputStream("employee_3.dat"));
			out.writeObject(Orientation.HORIZONTAL);
			out.close();
			ObjectInputStream in =
					new ObjectInputStream(new FileInputStream("employee_3.dat"));
			Orientation newObj = (Orientation) in.readObject();
			in.close();
			System.out.println(newObj.getValue());
		}catch(Exception e){
			e.printStackTrace();
			throw new Error(e);
		}
	}
}


class Orientation implements Serializable {
	/**
	 * 
	 */
	public static final Orientation HORIZONTAL = new Orientation(1);
	public static final Orientation VERTICAL = new Orientation(2);
	private int value;
	private Orientation(int v){
		value = v;
	}
	public int getValue(){
		return value;
	}
	
	protected Object readResolve() throws ObjectStreamException{
		if(value == 1)
			return Orientation.HORIZONTAL;
		if(value == 2)
			return Orientation.VERTICAL;
		return null;
	}
}
/***
 * 在oracle jdk 1.7上测试正常，似乎无需实现readResolve
 * 
 */
