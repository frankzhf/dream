package net.frank.demos.concurrent.ch01.semaphore.test;

import net.frank.demos.concurrent.ch01.semaphore.extthread.MyThread;
import net.frank.demos.concurrent.ch01.semaphore.service.MyService;

public class RunE {
	
	public static void main(String[] args) throws InterruptedException{
		MyService service = new MyService();
		MyThread firstThread = new MyThread(service);
		firstThread.start();
		
		MyThread[] threadArray = new MyThread[4];
		for(int i=0;i<threadArray.length;i++) {
			threadArray[i] = new MyThread(service);
			threadArray[i].start();
		}
	}

}
