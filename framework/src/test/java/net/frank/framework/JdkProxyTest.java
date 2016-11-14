package net.frank.framework;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object o = Proxy.newProxyInstance(IHello.class.getClassLoader(),
				new Class[]{IHello.class}, new HelloImpl());
		if(o instanceof IHello){
			((IHello) o).say("ha ha");
		}
		
		
	}

}

interface IHello{
	public void say(String hello);
}

class HelloImpl implements InvocationHandler{
	public void say(Method method, Object[] args){
		System.out.println("Input Param->"+args[0]);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		if(method.getName().equals("say")){
			 say(method,args);
		}
		return null;
	}
}