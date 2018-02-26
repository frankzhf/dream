package net.frank.demos.concurrent.ch01.semaphore.test;

import net.frank.demos.concurrent.ch01.semaphore.extthread.TryAcquireThread;
import net.frank.demos.concurrent.ch01.semaphore.service.TryAcquireService;

public class RunG {

	public static void main(String[] args) {
		TryAcquireService service = new TryAcquireService();
		TryAcquireThread a = new TryAcquireThread(service);
		a.setName("A");
		a.start();
		
		TryAcquireThread b = new TryAcquireThread(service);
		b.setName("B");
		b.start();
		
	}

}
