package net.frank.demos.concurrent.ch01.semaphore.extthread;

import net.frank.demos.concurrent.ch01.semaphore.service.TryAcquireService;

public class TryAcquireThread extends Thread {
	
	private TryAcquireService service;
	
	public TryAcquireThread(TryAcquireService service) {
		super();
		this.service = service;
	}
	
	@Override
	public void run() {
		service.testMethod();
	}
	
}
