package net.frank.demos.concurrent.ch01.semaphore.extthread;

import net.frank.demos.concurrent.ch01.semaphore.service.Service;

public class ThreadE extends Thread {
	
	private Service service;
	
	public ThreadE(Service service) {
		super();
		this.service = service;
	}
	
	@Override
	public void run() {
		service.testBigMethod();
	}
	
}
