package net.frank.demos.concurrent.ch01.semaphore.test;

import net.frank.demos.concurrent.ch01.semaphore.extthread.M3Thread;
import net.frank.demos.concurrent.ch01.semaphore.service.M3Service;

public class M3Run {

	public static void main(String[] args) {
		M3Service service = new M3Service();
		
		M3Thread[] threadArray = new M3Thread[12];
		for(int i=0;i<threadArray.length;i++) {
			threadArray[i] = new M3Thread(service);
			threadArray[i].start();
		}
		
	}

}
