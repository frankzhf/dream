package net.frank.corejava1.ch06.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

public class ProxyText {

	public static void main(String[] args) {
		Object[] elements = new Object[1000];
		for(int i=0;i<elements.length;i++) {
			Integer value = i + 1;
			InvocationHandler handler = new TraceHandler(value);
			Object proxy = Proxy.newProxyInstance(null, new Class[] { Comparable.class}, handler);
			elements[i] = proxy;
		}
		
		Integer key = new Random().nextInt(elements.length) + 1;
		int result = Arrays.binarySearch(elements, key);
		if(result >=0) {
			System.out.println(elements[result]);
		}	
	}
}


class TraceHandler implements InvocationHandler{
	
	private Object target;
	
	public TraceHandler(Object t) {
		target = t;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.print(target);
		System.out.print("." + method.getName() + "(");
		
		if(args!=null) {
			for(int i=0;i<args.length;i++) {
				System.out.print(args[i]);
				if(i<args.length -1) {
					System.out.print(", ");
				}
			}
		}
		System.out.println(")");
		return method.invoke(target, args);
	}
}

/***
 * java.lang.reflect.InvocationHandler
 * Object invoke(Object proxy, Method method, Object[] args)
 * 定义了代理对象调用方法时希望执行的动作
 * 
 * java.lang.reflect.Proxy
 * static Class getProxyClass(ClassLoader loader, Class[] interfaces)
 * 返回实现指定指口的代理类
 * 
 * static Object newProxyInstance(ClassLoader loader, Class[] interfaces, InvocationHandler hander)
 * 构造一个实现指定接口的代理类的实例。所有方法都将调用给定处理器对象的invoke方法
 * 
 * static boolean isProxyClass(Class c)
 * 判断类是否是一个代理类
**/ 
