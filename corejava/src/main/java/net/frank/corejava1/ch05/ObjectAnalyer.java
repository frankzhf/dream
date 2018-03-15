package net.frank.corejava1.ch05;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class ObjectAnalyer {
	
	private 	ArrayList<Object> visited = new ArrayList<>();
	
	public String toString(Object obj) {
		if(obj== null) {
			return "null";
		}
		if(visited.contains(obj)) {
			return "...";
		}
		visited.add(obj);
		Class<?> cl = obj.getClass();
		if(cl == String.class) {
			return (String)obj;
		}
		if(cl.isArray()) {
			String r = cl.getComponentType() + "[]{";
			for(int i=0;i<Array.getLength(obj);i++) {
				if(i>0) {
					r+=",";
				}
				Object val = Array.get(obj, i);
				if(cl.isPrimitive()) {
					r += val;
				}else {
					r += toString(val);
				}
			}
			return r+"}";
		}
		String r = cl.getName();
		do {
			r+= "[";
			Field[] fields = cl.getDeclaredFields();
			AccessibleObject.setAccessible(fields, true);
			for(Field f:fields) {
				if(!Modifier.isStatic(f.getModifiers())) {
					if(!r.endsWith("[")) {
						r += ",";
					}
					r+= f.getName() +"=";
					try {
						Class<?> t = f.getType();
						Object val = f.get(obj);
						if(t.isPrimitive()) {
							r += val;
						}else {
							toString(val);
						}
					}catch(Exception e) {
						
					}
				}
			}
			r+= "]";
			cl=cl.getSuperclass();
		}while(cl!=null);
		return r;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> squares = new ArrayList<>();
		for(int i=1;i<=5;i++) {
			squares.add(i*i);
		}
		System.out.println(new ObjectAnalyer().toString(squares));
	}

	/***
	 * java.lang.reflect.AccessibleObject
	 * void setAccessible(boolean flag)
	 * 为反射对象设置可访问标志
	 * 
	 * boolean isAccessible()
	 * 返回反射对象可访问标志的值
	 * 
	 * static void setAccessible(AccessibleObject[] array, boolean flag)
	 * 是一种设置对象数组可访问标志的快捷方法
	 * 
	 * java.lang.Class
	 * Field getField(String name)
	 * Field[] getFields()
	 * 返回指定对象的公有域，或包含所有公有域的数组
	 * 
	 * Field getDeclaredField(String name)
	 * Field[] getDeclaredFields()
	 * 返回指定对象的给定域，或包含所有给定域的数组
	 * 
	 * java.lang.reflect.Field
	 * Object get(Object obj)
	 * 返回obj的给定域的值
	 * 
	 * void set(Object obj, Object newValue)
	 * 设置obj的给定域的值
	 * 
	 */
}
