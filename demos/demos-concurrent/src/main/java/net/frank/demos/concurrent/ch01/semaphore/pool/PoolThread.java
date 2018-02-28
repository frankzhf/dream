package net.frank.demos.concurrent.ch01.semaphore.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PoolThread extends Thread {
	private transient Logger log = LoggerFactory.getLogger(PoolThread.class);
	private ListPool listPool;
	public PoolThread(ListPool listPool) {
		super();
		this.listPool = listPool;
	}
	
	@Override
	public void run() {
		int top = 20;
		for(int i=0;i<top;i++) {
			String value = listPool.get();
			log.debug("Get value: [" +i+ "]" + value );
			listPool.put(value);
		}
	}
}
