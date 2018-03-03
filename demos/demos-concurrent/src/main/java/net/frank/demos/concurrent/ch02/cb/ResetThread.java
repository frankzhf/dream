package net.frank.demos.concurrent.ch02.cb;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import net.frank.demos.concurrent.LoggerSupportThread;

public class ResetThread extends LoggerSupportThread {
	
	private CyclicBarrier cbRef;
	
	public ResetThread(CyclicBarrier cbRef) {
		super();
		this.cbRef = cbRef;
	}
	
	@Override
	public void run() {
		try {
			cbRef.await();
		}catch(InterruptedException e) {
			log.error(e.getMessage(),e);
		}catch(BrokenBarrierException e) {
			log.error(e.getMessage(),e);
		}
		
	}

	public static void main(String[] args)throws InterruptedException {
		CyclicBarrier cbRef = new CyclicBarrier(3);
		for(int i=0;i<4;i++) {
			ResetThread t = new ResetThread(cbRef);
			t.start();
			Thread.sleep(500);
			System.out.println(cbRef.getNumberWaiting());
		}
	}
}
