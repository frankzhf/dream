package net.frank.demos.concurrent.ch01.semaphore.service;

import java.util.concurrent.Semaphore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TryAcquireService {
	
	private transient Logger log = LoggerFactory.getLogger(TryAcquireService.class);
	
	private Semaphore semaphore = new Semaphore(1);
	
	public void testMethod(){
		if(semaphore.tryAcquire()) {	
			log.debug("成功进入方法");
			try {
				Thread.sleep(10000);
			}catch(InterruptedException e) {
				
			}
			semaphore.release();
		}else{
			log.debug("未成功进入方法");
		}
	}
	
	/***
	 * tryAcquire(int permits)
	 * tryAcquire(long timeout, TimeUnit unit)
	 * tryAcquire(int permits, long timeout, TimeUnit unit)
	 * 
	 * 
	 * 
	 * 
	 */
	
}
