package net.frank.demos.concurrent.ch01.semaphore.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.frank.demos.concurrent.ch01.semaphore.extthread.ThreadE;
import net.frank.demos.concurrent.ch01.semaphore.extthread.ThreadF;
import net.frank.demos.concurrent.ch01.semaphore.service.Service;

public class RunD {
	
	private static transient Logger log = LoggerFactory.getLogger(RunC.class);
	
	public static void main(String[] args) throws InterruptedException{
		Service service = new Service();
		ThreadE a = new ThreadE(service);
		a.setName("A");
		a.start();
		
		ThreadF b = new ThreadF(service);
		b.setName("B");
		b.start();
		
		Thread.sleep(10000);
		b.interrupt();
		log.debug("main中断了b");
		
	}

}
