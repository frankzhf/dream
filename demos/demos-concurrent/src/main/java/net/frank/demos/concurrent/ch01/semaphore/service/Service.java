package net.frank.demos.concurrent.ch01.semaphore.service;

import java.util.concurrent.Semaphore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Service {
	
	private transient Logger log = LoggerFactory.getLogger(Service.class);
	
	public Service() {
		semaphore = new Semaphore(1);
	}
	
	public Service(int permits) {
		semaphore = new Semaphore(permits);
	}
	
	
	private Semaphore semaphore;//参数permits的作用是定义一个许可数
	
	public void testMethod() {
		int cast = 1;
		testMethod(cast); 
	}
	
	public void testMethod(int cast) {
		try {
			semaphore.acquire(cast);			//消耗许可数 可以加一个int型的参数
			log.debug("begin timer = " + System.currentTimeMillis());
			int sleepValue = (int)(Math.random() *10000);
			log.debug("停止了" + (sleepValue / 1000) +"秒");
			Thread.sleep(sleepValue);
			log.debug("end timer = " + System.currentTimeMillis());
			semaphore.release(cast);			//释放许可数 可以加一个int型的参数
		}catch(InterruptedException e){
			log.error(e.getMessage(),e);
		}
	}
	
	public void testBigMethod() {
		try {
			semaphore.acquireUninterruptibly();			//使用acquire方法，如果线程被调interrupt，方法将抛异常，使用acquireUninterruptibly,线程将继续执行结束
			log.debug("begin timer = " + System.currentTimeMillis());
			Thread.sleep(Integer.MAX_VALUE/10000);
			log.debug("end timer = " + System.currentTimeMillis());
			semaphore.release();	
		}catch(InterruptedException e){
			log.error(e.getMessage(),e);
		}
	}
	
}
