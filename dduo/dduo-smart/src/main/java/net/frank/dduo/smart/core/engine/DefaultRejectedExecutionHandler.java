package net.frank.dduo.smart.core.engine;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DefaultRejectedExecutionHandler implements RejectedExecutionHandler {
	private transient Log log = LogFactory.getLog(getClass()); 
	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		try {
			log.debug("join executor queue!");
			executor.getQueue().put(r);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
