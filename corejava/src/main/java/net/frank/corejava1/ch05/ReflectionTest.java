package net.frank.corejava1.ch05;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class ReflectionTest {

	public static void main(String[] args) {
		String name = null;
		if (args.length > 0) {
			name = args[0];
		} else {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter class name(e.g. java.util.Date):");
			name = scanner.next();
			scanner.close();
		}
		try{
			Class<?> cl = Class.forName(name);
			Class<?> superCl = cl.getSuperclass();
			String modifiers = Modifier.toString(cl.getModifiers());
			if(modifiers!=null && modifiers.length() >0){
				System.out.print(modifiers + " ");
			}
			System.out.print("class " + name);
			if(superCl != null &&
					superCl != Object.class){
				System.out.print(" extends " + superCl.getName());
			}
			if(cl.getInterfaces()!=null && cl.getInterfaces().length > 0){
				System.out.print("\n\t\t implements ");
				for(int i=0;i<cl.getInterfaces().length;i++){
					Class<?> _interface = cl.getInterfaces()[i];
					if(i == 0){
						System.out.print(_interface.getName());
					}else{
						System.out.print(","+_interface.getName());
					}
				}
			}
			
			
			System.out.print("{\n");
			
			printConstructors(cl);
			System.out.println();
			printMethods(cl);
			System.out.println();
			printFields(cl);
			
			System.out.print("}\n");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		System.exit(0);
	}
	
	
	private static void printConstructors(Class<?> cl){
		Constructor<?>[] constructors = cl.getDeclaredConstructors();
		for(Constructor<?> c : constructors){
			String name = c.getName();
			System.out.print("\n\t");
			String modifiers = Modifier.toString(c.getModifiers());
			if(modifiers!=null && modifiers.length()>0){
				System.out.print(modifiers + " ");
			}
			System.out.print(name+"(");
			Class<?>[] parameters = c.getParameterTypes();
			if(parameters!=null && 
					parameters.length>0){
				for(int i=0;i<parameters.length;i++){
					Class<?> param = parameters[i];
					if(i>0){
						System.out.print(",");
					}
					System.out.print(param.getName());
				}
			}
				
			System.out.print(");\n");
		}
	}
	private static void printMethods(Class<?> cl){
		Method [] methods = cl.getDeclaredMethods();
		for(Method m : methods){
			String name = m.getName();
			System.out.print("\n\t");
			String modifiers = Modifier.toString(m.getModifiers());
			if(modifiers!=null && modifiers.length()>0){
				System.out.print(modifiers + " ");
			}
			System.out.print(name+"(");
			Class<?>[] parameters = m.getParameterTypes();
			if(parameters!=null && 
					parameters.length>0){
				for(int i=0;i<parameters.length;i++){
					Class<?> param = parameters[i];
					if(i>0){
						System.out.print(",");
					}
					System.out.print(param.getName());
				}
			}
				
			System.out.print(");\n");
		}
	}
	private static void printFields(Class<?> cl){
		Field[] fields = cl.getDeclaredFields();
		for(Field f : fields){
			String name = f.getName();
			System.out.print("\n\t");
			String modifiers = Modifier.toString(f.getModifiers());
			if(modifiers!=null && modifiers.length()>0){
				System.out.print(modifiers + " ");
			}
			System.out.print(name+";\n");
		}
	}
	
	/***
	 * java.lang.Class
	 * Field[] getFields()
	 * Field[] getDeclaredFields()
	 * 返回类的所有字段，Declared方法包括私有的
	 * 
	 * Method[] getMehtods()
	 * Method[] getDeclareMethods()
	 * 返回类的所有方法，Declared方法包括私有的
	 * 
	 * Constructor[] getConstructors()
	 * Constructor[] getDeclaredConstructors()
	 * 返回类的所有构造方法，Declared方法包括私有的
	 * 
	 * java.lang.reflect.Field
	 * java.lang.reflect.Mehtod
	 * java.lang.reflect.Constructor
	 * Class getDeclaringClass()
	 * 返回一个用于描述类中定义的构造器
	 * 
	 * Class[] getExceptionTypes()（在Constructor和Method中）
	 * 返回构造或方法定义的异常类型
	 * 
	 * int getModifiers();
	 * 返回一个用于描述构造器
	 * 
	 * String getName()
	 * 返回一个用于描述构造器的字符串
	 * 
	 * Class[] getParameterTypes()（在Constructor和Method中）
	 * 返回构造或方法定义的参数类型
	 * 
	 * Class getReturnType()（在Method中）
	 * 返回法定义的返回值类型
	 * 
	 * java.lang.reflect.Modifier
	 * static String toString(int modifiers)
	 * 返回对应modifiers中位置的修饰符的字符串
	 * 
	 * static boolean isAbstract(int modifiers)
	 * static boolean isFinal(int modifiers)
	 * static boolean isInterface(int modifiers)
	 * static boolean isNative(int modifiers)
	 * static boolean isPrivate(int modifiers)
	 * static boolean isProtected(int modifiers)
	 * static boolean isPublic(int modifiers)
	 * static boolean isStatic(int modifiers)
	 * static boolean isStrict(int modifiers)
	 * static boolean isSynchronized(int modifiers)
	 * static boolean isVolatile(int modifiers)
	 * 判断修饰符是否包含特定描述
	 * 
	 */
	
}
