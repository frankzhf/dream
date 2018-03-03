package net.frank.demos.concurrent.ch02.cb;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BoudleThread extends Thread {
	
	private transient Logger log = LoggerFactory.getLogger(BoudleThread.class);
	
	private CyclicBarrier cbRef;
	
	public BoudleThread(CyclicBarrier cbRef) {
		super();
		this.cbRef = cbRef;
	}
	
	@Override
	public void run() {
		try {
			log.debug("等待凑齐" + cbRef.getParties() + "个继续运行");
			cbRef.await();
			log.debug("已经凑齐" + cbRef.getParties() + "个");
		}catch(InterruptedException e) {
			
		}catch(BrokenBarrierException e) {
			
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		CyclicBarrier cbRef = new CyclicBarrier(2,new Runnable() {

			@Override
			public void run() {
				System.out.println("全来了!");
			}
		});
		
		for(int i=0;i<4;i++) {
			BoudleThread thread = new BoudleThread(cbRef);
			thread.start();
			Thread.sleep(2000);
		}
		
	}

}
