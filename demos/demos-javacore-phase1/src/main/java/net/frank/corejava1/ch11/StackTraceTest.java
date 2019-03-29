package net.frank.corejava1.ch11;

import java.util.Scanner;

/**
 * java.lang.Throwable
 * Throwable()
 * 构造一个新的Throwable对象，这个对象没有详细的描述信息
 * 
 * Throwable(String message)
 * 构造一个新的Throwable对象，这个对象带有特定的详细描述信息
 * 
 * String getMessage()
 * 获取Throwable对象的详细描述信息
 */



public class StackTraceTest {
	
	public static int factorial(int n) {
		System.out.println("factorial("+n+"):");
		Throwable t = new Throwable();
		StackTraceElement[] frames = t.getStackTrace();
		for(StackTraceElement f : frames) {
			System.out.println(f);
		}
		int r;
		if(n<=1) {
			r = 1;
		}else {
			r= n* factorial(n-1);
		}
		System.out.println("return " + r);
		return r;
	}
	
	public static void main(String[] args) {
		try(Scanner in = new Scanner(System.in)){
			System.out.println("Enter n: " );
			int n= in.nextInt();
			factorial(n);
		}
	}

}
