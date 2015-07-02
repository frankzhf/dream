package net.frank.commons;

public class Test {
	public static void main(String[] args){
		
		Byte i= 6;
		String string = Integer.toBinaryString(i);
		
		//short ii = (i >> 1);
		System.out.println(string );
		System.out.println(i>>1 );
		System.out.println(i>>2 );
		
		//System.out.println(ii);
		
	}
}
