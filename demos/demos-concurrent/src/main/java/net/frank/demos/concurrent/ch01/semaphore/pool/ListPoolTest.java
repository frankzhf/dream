package net.frank.demos.concurrent.ch01.semaphore.pool;

public class ListPoolTest {

	public static void main(String[] args) {
		ListPool pool = new ListPool();
		PoolThread[] threadArray = new PoolThread[12];
		for(int i=0;i<threadArray.length;i++) {
			threadArray[i] = new PoolThread(pool);
		}
		for(int i=0;i<threadArray.length;i++) {
			threadArray[i].start();
		}
	}

}
