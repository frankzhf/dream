package net.frank.cms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StringTest {
	
	public static void main(String[] args) throws Exception{
		List<String> data = new ArrayList<String>();
		List<String> error = new ArrayList<String>();
		
		data.add("0");
		data.add("1");
		data.add("2");
		data.add("3");
		data.add("4");
		
		for(Iterator<String> it = data.iterator();it.hasNext();){
			String value = it.next();
			Integer _value = Integer.parseInt(value);
			if(_value%2==0){
				error.add(value);
				it.remove();
			}
		}
		
		System.out.print("data [ ");
		for(Iterator<String> it = data.iterator();it.hasNext();){
			String value = it.next();
			System.out.print(value + " " );
		}
		System.out.println(" ]");
		
		System.out.print("error [ ");
		for(Iterator<String> it = error.iterator();it.hasNext();){
			String value = it.next();
			System.out.print(value + " " );
		}
		System.out.println(" ]");
	}
}
