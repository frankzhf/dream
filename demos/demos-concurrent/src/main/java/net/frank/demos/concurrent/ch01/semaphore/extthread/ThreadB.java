package net.frank.demos.concurrent.ch01.semaphore.extthread;

import net.frank.demos.concurrent.ch01.semaphore.service.Service;

public class ThreadB extends Thread {
	
	private Service service;
	
	public ThreadB(Service service) {
		super();
		this.service = service;
	}
	
	@Override
	public void run() {
		service.testMethod();
	}
	
}
