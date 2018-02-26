package net.frank.demos.concurrent.ch01.semaphore.extthread;

import net.frank.demos.concurrent.ch01.semaphore.service.Service;

public class ThreadC extends Thread {
	
	private Service service;
	
	public ThreadC(Service service) {
		super();
		this.service = service;
	}
	
	@Override
	public void run() {
		service.testMethod();
	}
	
}
