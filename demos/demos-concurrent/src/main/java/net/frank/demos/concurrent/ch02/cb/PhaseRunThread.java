package net.frank.demos.concurrent.ch02.cb;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import net.frank.demos.concurrent.LoggerSupportThread;

public class PhaseRunThread extends LoggerSupportThread {
	
	private CyclicBarrier cbRef;
	
	public PhaseRunThread(CyclicBarrier cbRef) {
		super();
		this.cbRef = cbRef;
	}
	
	@Override
	public void run() {
		try {
			long sleepValue = (int) (Math.random() * 10000);
			Thread.sleep(sleepValue);
			log.debug("begin 跑第1阶段     " + (cbRef.getNumberWaiting() +1) );
			cbRef.await();
			log.debug("end 跑第1阶段     " + (cbRef.getNumberWaiting()));
			sleepValue = (int) (Math.random() * 10000);
			Thread.sleep(sleepValue);
			log.debug("begin 跑第2阶段     " + (cbRef.getNumberWaiting() +1) );
			cbRef.await();
			log.debug("end 跑第2阶段     " + (cbRef.getNumberWaiting()));
			
		}catch(InterruptedException e) {
			log.error(e.getMessage(),e);
		} catch (BrokenBarrierException e) {
			log.error(e.getMessage(),e);
		}
	}
	
	
	public static void main(String[] args) {
		CyclicBarrier cbRef = new CyclicBarrier(2);
		for(int i=0;i<4;i++) {
			PhaseRunThread t = new PhaseRunThread(cbRef);
			t.start();
		}
	}

}
