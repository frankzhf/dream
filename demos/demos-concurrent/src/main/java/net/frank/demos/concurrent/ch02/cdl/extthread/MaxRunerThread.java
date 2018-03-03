package net.frank.demos.concurrent.ch02.cdl.extthread;

import java.util.concurrent.CountDownLatch;
/**
 * 
 *裁判在等全部的运动员的到来
 */

public class MaxRunerThread extends Thread {
	private CountDownLatch maxRuner;
	public MaxRunerThread(CountDownLatch maxRuner) {
		super();
		this.maxRuner = maxRuner;
	}
	
	
	@Override
	public void run() {
		try {
			Thread.sleep(2000);
			maxRuner.countDown();
		}catch(InterruptedException e) {
			
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch maxRunner = new CountDownLatch(10);
		MaxRunerThread[] threadArray = new MaxRunerThread[Integer.parseInt(maxRunner.getCount()+"")];
		for(int i=0;i<threadArray.length;i++) {
			threadArray[i] = new MaxRunerThread(maxRunner);
			threadArray[i].setName("线程"+(i+1));
			threadArray[i].start();
		}
		maxRunner.await();
		System.out.println("All back...");
	}
}
