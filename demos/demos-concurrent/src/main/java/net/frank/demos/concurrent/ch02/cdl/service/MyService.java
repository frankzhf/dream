package net.frank.demos.concurrent.ch02.cdl.service;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyService {
	
	private transient Logger log = LoggerFactory.getLogger(MyService.class);
	
	private CountDownLatch down = new CountDownLatch(1);
	
	public void testMethod() {
		try {
			log.debug("A");
			down.await();
			log.debug("B");
		}catch(InterruptedException e) {
			
		}
	}
	
	public void downMehtod() {
		log.debug("X");
		down.countDown();
	}
	
}
