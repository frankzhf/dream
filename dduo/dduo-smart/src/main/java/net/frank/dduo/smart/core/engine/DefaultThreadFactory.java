package net.frank.dduo.smart.core.engine;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DefaultThreadFactory implements ThreadFactory {
	private transient Log log = LogFactory.getLog(DefaultThreadFactory.class);
	private final AtomicInteger threadNumber = new AtomicInteger(1);
	private final String namePrefix;

	public DefaultThreadFactory(String threadNamePrefix) {
		this.namePrefix = threadNamePrefix + "-thread-";
	}

	public Thread newThread(Runnable r) {
		log.debug("DefaultThreadFactory.newThread trigger...");
		Thread t = new Thread(r, namePrefix + threadNumber.getAndIncrement());
		if (t.isDaemon()) {
			t.setDaemon(false);
		}
		if (t.getPriority() != Thread.NORM_PRIORITY) {
			t.setPriority(Thread.NORM_PRIORITY);
		}
		return t;
	}
}
