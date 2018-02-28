package net.frank.demos.concurrent.ch01.semaphore.service;

import java.util.concurrent.Semaphore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 多进路多处理多出路
 * 
 * M3 
 * More Input
 * More Process
 * More Outpu
 *
 */

public class M3Service {
	private transient Logger log = LoggerFactory.getLogger(M3Service.class);
	
	private Semaphore semaphore = new Semaphore(3);
	
	public void sayHello() {
		try {
			semaphore.acquire();
			log.debug("Ready");
			log.debug("begin hello");
			for(int i=0;i<5;i++) {
				log.debug("print " + (i +1));
			}
			log.debug("end hello");
			semaphore.release();
			log.debug("end");
		}catch(InterruptedException e) {
			log.error(e.getMessage(),e);
		}
	}
	
}
