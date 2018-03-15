package net.frank.corejava1.ch05;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CopyOfTest {

	public static void main(String[] args) {
		int[] a = {1,2,3};
		a = (int[]) goodCopyOf(a,10);
		System.out.println(Arrays.toString(a));
		String[] b = {"Tom","Dick","Harry"};
		b = (String[]) goodCopyOf(b,10);
		System.out.println(Arrays.toString(b));
		
		System.out.println("The following call will generate an exception.");
		b = (String[]) badCopyOf(b,10);
		
	}
	
	private static Object[] badCopyOf(Object[] a, int newLength) {
		Object [] newArray = new Object[newLength];
		System.arraycopy(a, 0 ,newArray,0, Math.min(a.length, newLength));
		return newArray;
	}
	
	private static Object goodCopyOf(Object a, int newLength) {
		Class<?> cl = a.getClass();
		if(!cl.isArray()) {
			return null;
		}
		Class<?> componentType = cl.getComponentType();
		int length = Array.getLength(a);
		Object newArray = Array.newInstance(componentType, newLength);
		System.arraycopy(a,0, newArray , 0, Math.min(length,newLength));
		return newArray;
	}
	/***
	 * java.lang.reflect.Array
	 * static Object get(Object array, int index)
	 * static T getT(Object array,int index)
	 * 从指定数组获取值
	 * 
	 * static void set(Object array, int index, Object newValue)
	 * static void setT(Object array, int index, T newValue)
	 * 从指定数组设置值
	 * 
	 * static int getLength(Object array)
	 * 返回数据的长度
	 * 
	 * static Object newInstance(Class componentType, int length)
	 * static Object newInstance(Class componentType, int[] lengths);
	 * 返回一个具有给定类型，给定维数的数组对象
	 * 
	 * 
	 * 
	 */

}
