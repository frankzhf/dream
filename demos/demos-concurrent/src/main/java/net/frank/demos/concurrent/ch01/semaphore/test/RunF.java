package net.frank.demos.concurrent.ch01.semaphore.test;

import net.frank.demos.concurrent.ch01.semaphore.extthread.FairThread;
import net.frank.demos.concurrent.ch01.semaphore.service.FairService;

public class RunF {

	public static void main(String[] args) throws Exception {
		FairService falseService = new FairService(false);//线程启动和方法执行是乱序
		
		FairThread firstThread = new FairThread(falseService);
		firstThread.start();
		
		FairThread[] threadArray = new FairThread[4];
		
		for(int i=0;i<threadArray.length;i++) {
			threadArray[i] = new FairThread(falseService);
			threadArray[i].start();
		}
		
		Thread.sleep(10000);
		
		
		FairService trueService = new FairService(false);	//线程启动和方法执行是顺序
		firstThread = new FairThread(trueService);
		firstThread.start();
		
		 threadArray = new FairThread[4];
		
		for(int i=0;i<threadArray.length;i++) {
			threadArray[i] = new FairThread(trueService);
			threadArray[i].start();
		}
		
		
	}

}
