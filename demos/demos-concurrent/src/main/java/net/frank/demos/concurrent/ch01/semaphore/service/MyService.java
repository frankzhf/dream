package net.frank.demos.concurrent.ch01.semaphore.service;

import java.util.concurrent.Semaphore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyService {
	
	private transient Logger log = LoggerFactory.getLogger(MyService.class);
	
	
	private Semaphore semaphore = new Semaphore(1);
	public void testMethod() {
		try {
			semaphore.acquire();			//消耗许可数 可以加一个int型的参数
			log.debug("begin");
			Thread.sleep(10000);
			log.debug("有否有线毛在等待:"+semaphore.hasQueuedThreads());
			log.debug("还有"+semaphore.getQueueLength()+ "个线程在等待");
			log.debug("end");
			semaphore.release();			//释放许可数 可以加一个int型的参数
		}catch(InterruptedException e){
			log.error(e.getMessage(),e);
		} 
	}
	
}
