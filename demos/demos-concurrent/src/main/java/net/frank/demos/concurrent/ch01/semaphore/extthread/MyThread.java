package net.frank.demos.concurrent.ch01.semaphore.extthread;

import net.frank.demos.concurrent.ch01.semaphore.service.MyService;

public class MyThread extends Thread {
	
	
	private MyService myService;
	
	public MyThread(MyService myService) {
		super();
		this.myService = myService;
	}
	
	@Override
	public void run() {
		myService.testMethod();
	}
	
	
}
