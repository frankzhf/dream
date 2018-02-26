package net.frank.demos.concurrent.ch01.semaphore.service;

import java.util.concurrent.Semaphore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FairService {
	
	private transient Logger log = LoggerFactory.getLogger(FairService.class);
	
	private Semaphore semaphore;
	
	public FairService(boolean isFair) {
		semaphore = new Semaphore(1,isFair);
	}
	
	public void testMethod() {
		try {
			semaphore.acquire();
			log.debug("doing");
		}catch(InterruptedException e) {
			log.error(e.getMessage(),e);
		}finally {
			semaphore.release();
		}
	}
}
