package net.frank.demos.concurrent.ch02.cb;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 *	CyclicBarrier 最基本的使用
 */

public class BaseThread extends Thread{
	private transient Logger log = LoggerFactory.getLogger(BaseThread.class);
	private CyclicBarrier cbRef;
	
	public BaseThread(CyclicBarrier cbRef) {
		super();
		this.cbRef = cbRef;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep((int)(Math.random() * 10000));
			log.debug("到了");
			cbRef.await();
		}catch(InterruptedException e) {
			log.error(e.getMessage(),e);
		}catch(BrokenBarrierException e) {
			log.error(e.getMessage(),e);
		}
	}
	
	
	public static void main(String[] args) {
		CyclicBarrier cbRef = new CyclicBarrier(5, new Runnable() {
			@Override
			public void run() {
				System.out.println("全都到了！");
			}	
		});
		
		BaseThread[] threadArray = new BaseThread[5];
		for(int i=0;i<threadArray.length;i++) {
			threadArray[i] = new BaseThread(cbRef);
			threadArray[i].start();
		}
		
	}

}
