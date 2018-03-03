package net.frank.demos.concurrent.ch02.cdl.extthread;

import net.frank.demos.concurrent.ch02.cdl.service.MyService;

public class MyThread extends Thread {
	private MyService myService;
	public MyThread(MyService service) {
		super();
		this.myService = service;
	}
	
	@Override
	public void run() {
		myService.testMethod();
	}
	
}
