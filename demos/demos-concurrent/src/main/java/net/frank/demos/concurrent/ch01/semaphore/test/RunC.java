package net.frank.demos.concurrent.ch01.semaphore.test;

import java.util.concurrent.Semaphore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RunC {
	
	private static transient Logger log = LoggerFactory.getLogger(RunC.class);
	
	public static void main(String[] args) {
		try {
			Semaphore semaphore = new Semaphore(5);
			semaphore.acquire();
			semaphore.acquire();
			semaphore.acquire();
			semaphore.acquire();
			semaphore.acquire();
			log.debug(semaphore.availablePermits() + "");
			semaphore.release();
			semaphore.release();
			semaphore.release();
			semaphore.release();
			semaphore.release();
			semaphore.release();
			log.debug(semaphore.availablePermits() + "");
			semaphore.release(4);
			log.debug(semaphore.availablePermits() + "");
			
			/***
			 * 相比较而言,
			 * Semaphore 还提供了drainPermits方法，这个方法返回和availablePermits一样，但permit清零
			 * 
			 * 
			 */
			log.debug("第一次调用drainPermits");
			log.debug(semaphore.drainPermits() + "");
			
			log.debug("再调一次availablePermits");
			log.debug(semaphore.availablePermits() + "");
			
			
		}catch(InterruptedException e) {
			
		}
	}

}
