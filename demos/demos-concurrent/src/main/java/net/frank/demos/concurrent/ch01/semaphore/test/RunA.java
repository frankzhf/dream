package net.frank.demos.concurrent.ch01.semaphore.test;

import net.frank.demos.concurrent.ch01.semaphore.extthread.ThreadA;
import net.frank.demos.concurrent.ch01.semaphore.extthread.ThreadB;
import net.frank.demos.concurrent.ch01.semaphore.extthread.ThreadC;
import net.frank.demos.concurrent.ch01.semaphore.service.Service;

public class RunA {

	public static void main(String[] args) {
		Service service = new Service();
		ThreadA a = new ThreadA(service);
		a.setName("A");
		ThreadB b = new ThreadB(service);
		b.setName("B");
		ThreadC c = new ThreadC(service);
		c.setName("C");
		
		a.start();
		b.start();
		c.start();
		
		
	}

}
