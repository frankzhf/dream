package net.frank.demos.concurrent.ch01.semaphore.extthread;

import net.frank.demos.concurrent.ch01.semaphore.service.M3Service;

public class M3Thread extends Thread {
	private M3Service service;
	
	public M3Thread(M3Service service) {
		super();
		this.service = service;
	}
	
	@Override
	public void run() {
		service.sayHello();
	}
	
}
