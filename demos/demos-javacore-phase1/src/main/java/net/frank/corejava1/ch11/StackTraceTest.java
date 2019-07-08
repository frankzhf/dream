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

/**
 * java.lang.Throwable
 * Throwable(Throwable cause)
 * Throwable(String message, Throwable cause)
 * 用给定的原因构造一个Throwable对象
 * 
 * Throwable initCause(Throwable cause)
 * 将这个对象设置为原因。如果这个对象已经被设置为原因，则抛出一个异常，返回this引用
 * 
 * Throwable getCause()
 * 获得设置为这个对象的原因的异常对象，如果没有设置原因，则返回null
 * 
 * StackTraceElement[] getStatkTrace()
 * 获得构造这个对象时调用堆栈的跟踪
 * 
 * void addSuppressed(Throwable t)
 * 为这个异常增加一个抑制异常。这出现在带资源的try语句中，其中t是close方法抛出的一个异常
 * 
 * Throwable[] getSuppressed()
 * 得到家个异常的所有抑制异常。一般来说，这些带资源的try语句中close方法抛出的异常
 * 
 * java.lang.Exception
 * Exception(Throwable cause)
 * Exception(String message, Throwable cause)
 * 用给定的原因构造一个异常对象
 * 
 * java.lang.RuntimeException
 * RuntimeException(Throwable cause)
 * RuntimeException(String message, Throwable cause)
 * 用给定的原因构造一个RuntimeException对象
 * 
 * java.lang.StackTraceElement
 * String getFileName()
 * 返回这个元素运行时对应的源文件名。如果这个信息不存在，则返回null
 * 
 * int getLineNumber()
 * 返回这个元素运行时的源文件行数。如果这个信息不存在，则返回-1
 * 
 * String getClassName()
 * 返回这个元素运行时对应的类的全名
 * 
 * String getMethodName()
 * 返回这个元素运行时对应的方法名。构造器名是<int>;静态初始化器名是<clinit>。这里无法区分同名的重载方法
 * 
 * boolean isNativeMehtod()
 * 如果这个元素运行时在一个本地方法中，则返回true
 * 
 * String toString()
 * 如果存在的话，返回一个包含类名、方法名、文件名和行数的格式化字符串
 * 
 */
	
/***
 * java.lang.ClassLoader
 * void setDefaultAssertionStatus(boolean b)
 * 对于通过类加载器加载的所有类来说，如果没有显式地说明类或包的断言状态，就启用或禁用断言
 * 
 * void setClassAssertionStatus(String className, boolean b)
 * 对于给定的类和它的内部类，启用或禁用断言
 * 
 * void setPackageAssertionStatus(String packageName, boolean b)
 * 对于给定包和其子包中的所有类，启用或禁用断言
 * 
 * void clearAssertionStatus()
 * 移去所有类和包的显式断言状态设置，并禁用所有通过这个类加载器加载的类的断言
 * 
 * 
 * 
 */
}
