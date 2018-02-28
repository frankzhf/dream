package net.frank.demos.concurrent.ch01.semaphore.test;

import net.frank.demos.concurrent.ch01.semaphore.extthread.MomThread;
import net.frank.demos.concurrent.ch01.semaphore.service.MomService;

public class MomRun {

	public static void main(String[] args) {
		MomService service = new MomService();
		
		MomThread[] threadArray = new MomThread[12];
		for(int i=0;i<threadArray.length;i++) {
			threadArray[i] = new MomThread(service);
			threadArray[i].start();
		}
		
	}

}
