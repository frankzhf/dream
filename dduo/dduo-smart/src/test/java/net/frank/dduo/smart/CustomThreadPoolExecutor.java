package net.frank.dduo.smart;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CustomThreadPoolExecutor {
	
	private AtomicInteger count = new AtomicInteger(0);
	
	private transient Log log = LogFactory.getLog(CustomThreadPoolExecutor.class);

	private ThreadPoolExecutor pool = null;

	public void init() {
		pool = new ThreadPoolExecutor(10, 30, 30, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(10),
				new CustomThreadFactory(), new CustomRejectedExecutionHandler());
	}

	public void destory() {
		if (pool != null) {
			pool.shutdown();
		}
	}

	public ExecutorService getExecutor() {
		return pool;
	}

	private class CustomThreadFactory implements ThreadFactory {
		
		@Override
		public Thread newThread(Runnable r) {
			Thread t = new Thread(r);
			String threadName = CustomThreadPoolExecutor.class.getSimpleName() + count.addAndGet(1);
			t.setName(threadName);
			return t;
		}
	}

	private class CustomRejectedExecutionHandler implements RejectedExecutionHandler {
		@Override
		public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
			try {
				log.debug("join queue!");
				executor.getQueue().put(r);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		CustomThreadPoolExecutor exec = new CustomThreadPoolExecutor();
		exec.init();
		ExecutorService pool = exec.getExecutor();
		for (int i = 1; i <= 100; i++) {
			System.out.println("提交第" + i + "个任务!");
			final int index = i;
			pool.execute(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("running=====" + index);
				}
			});
		}
		
		pool.shutdown();
		
		
	}
}
