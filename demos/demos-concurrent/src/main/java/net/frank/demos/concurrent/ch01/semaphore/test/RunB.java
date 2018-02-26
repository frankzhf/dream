package net.frank.demos.concurrent.ch01.semaphore.test;

import net.frank.demos.concurrent.ch01.semaphore.extthread.ThreadD;
import net.frank.demos.concurrent.ch01.semaphore.service.Service;

public class RunB {

	public static void main(String[] args) {
		Service service = new Service(10);
		ThreadD [] a = new ThreadD[10];
		for(int i=0;i<10;i++) {
			a[i] = new ThreadD(service);
			a[i].start();
		}
		
	}

}
