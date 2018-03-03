package net.frank.demos.concurrent.ch02.cdl.service;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PreparedService {
	private transient Logger log = LoggerFactory.getLogger(PreparedService.class);
	
	private CountDownLatch down = new CountDownLatch(1);
	
	public void testMethod() {
		try {
			log.debug("准备");
			down.await();
			log.debug("结束");
		}catch(InterruptedException e) {
			
		}
	}
	
	public void downMethod() {
		log.debug("开始");
		down.countDown();
	}
}
