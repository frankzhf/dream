package net.frank.demos.concurrent.ch01.semaphore.extthread;

import net.frank.demos.concurrent.ch01.semaphore.service.MomService;

public class MomThread extends Thread {
	private MomService service;
	
	public MomThread(MomService service) {
		super();
		this.service = service;
	}
	
	@Override
	public void run() {
		service.sayHello();
	}
	
}
