package net.frank.demos.concurrent.ch02.cdl.test;

import net.frank.demos.concurrent.ch02.cdl.extthread.MyThread;
import net.frank.demos.concurrent.ch02.cdl.service.MyService;

public class RunI {

	public static void main(String[] args) throws InterruptedException {
		MyService service = new MyService();
		MyThread t = new MyThread(service);
		t.start();
		Thread.sleep(2000);
		service.downMehtod();
	}

}
