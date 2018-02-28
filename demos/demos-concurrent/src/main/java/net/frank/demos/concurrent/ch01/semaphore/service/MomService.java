package net.frank.demos.concurrent.ch01.semaphore.service;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 多进路单处理多出路
 * 
 * Mom
 * More Input
 * one Process
 * More Outpu
 *
 */

public class MomService {
	private transient Logger log = LoggerFactory.getLogger(MomService.class);
	
	private Semaphore semaphore = new Semaphore(3);
	private ReentrantLock lock = new ReentrantLock();
	
	public void sayHello() {
		try {
			semaphore.acquire();
			log.debug("Ready");
			lock.lock();
			log.debug("begin hello");
			for(int i=0;i<5;i++) {
				log.debug("print " + (i +1));
			}
			log.debug("end hello");
			lock.unlock();
			semaphore.release();
			log.debug("end");
		}catch(InterruptedException e) {
			log.error(e.getMessage(),e);
		}
	}
	
}
