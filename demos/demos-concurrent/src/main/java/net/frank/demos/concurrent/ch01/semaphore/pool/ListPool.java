package net.frank.demos.concurrent.ch01.semaphore.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ListPool {
	
	private int poolMaxSize = 3;
	private int semaphorePermits = 5;
	private List<String> list = new ArrayList<String>();
	private Semaphore concurrentSemaphore = new Semaphore(semaphorePermits);
	private ReentrantLock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	
	public ListPool() {
		super();
		for(int i=0;i<poolMaxSize;i ++ ) {
			list.add("frank" + (i+1));
		}
	}
	
	public String get() {
		String value = null;
		try {
			concurrentSemaphore.acquire();
			lock.lock();
			while(list.size() == 0) {
				condition.await();
			}
			value = list.remove(0);
			lock.unlock();
		}catch(InterruptedException e) {
			
		}
		return value;
	}
	
	public void put(String value) {
		lock.lock();
		list.add(value);
		condition.signalAll();
		lock.unlock();
		concurrentSemaphore.release();
	}
}
