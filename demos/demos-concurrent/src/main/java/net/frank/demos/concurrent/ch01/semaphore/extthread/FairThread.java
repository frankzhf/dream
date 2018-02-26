package net.frank.demos.concurrent.ch01.semaphore.extthread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.frank.demos.concurrent.ch01.semaphore.service.FairService;


public class FairThread extends Thread {
	
	private transient Logger log = LoggerFactory.getLogger(FairThread.class);
	
	private FairService service;
	
	public FairThread(FairService service) {
		super();
		this.service = service;
	}
	
	@Override
	public void run() {
		log.debug("startup...");
		service.testMethod();
	}
}
