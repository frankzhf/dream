package net.frank.demos.concurrent.ch01.semaphore.mpmc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * mpmc
 * More product More consumer
 *
 */

public class RepastService {
	private transient Logger log = LoggerFactory.getLogger(RepastService.class);
	volatile private Semaphore setSemaphore = new Semaphore(10);
	volatile private Semaphore getSemaphore = new Semaphore(20);
	volatile private ReentrantLock lock = new ReentrantLock();
	volatile private Condition setCondition = lock.newCondition();
	volatile private Condition getCondition = lock.newCondition();
	
	private static long id = 1000000000l;
	
	volatile private Object[] producePosition = new Object[4];
	
	private boolean isEmpty() {
		boolean isEmpty = true;
		for(int i=0;i<producePosition.length;i++) {
			if(producePosition[i] !=null) {
				isEmpty = false;
				break;
			}
		}
		return isEmpty;
	}
	
	private boolean isFull() {
		boolean isFull = true;
		for(int i=0;i<producePosition.length;i++) {
			if(producePosition[i] ==null) {
				isFull = false;
				break;
			}
		}
		return isFull;
	}
	
	public void set() {
		try {
			setSemaphore.acquire();
			lock.lock();
			while(isFull()) {
				setCondition.await();
			}
			for(int i=0;i<producePosition.length;i++) {
				if(producePosition[i] == null) {
					producePosition[i] = "数据" + (++id) ;
					log.debug("生产了[" + i + "]" +   producePosition[i]);
					break;
				}
			}
			getCondition.signalAll();
			lock.unlock();
		}catch(InterruptedException e) {
			log.error(e.getMessage(),e);
		}finally {
			setSemaphore.release();
		}
	}
	
	public void get() {
		try {
			getSemaphore.acquire();
			lock.lock();
			while(isEmpty()) {
				getCondition.await();
			}
			for(int i=0;i<producePosition.length;i++) {
				if(producePosition[i]!=null) {
					log.debug("消费了["+i+"]" + producePosition[i]);
					producePosition[i] = null;
					break;
				}
			}
			setCondition.signalAll();
			lock.unlock();
		}catch(InterruptedException e) {
			log.error(e.getMessage(),e);
		}finally {
			getSemaphore.release();
		}
	}
	
	
}
