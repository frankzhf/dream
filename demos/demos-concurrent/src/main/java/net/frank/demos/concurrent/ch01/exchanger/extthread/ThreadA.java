package net.frank.demos.concurrent.ch01.exchanger.extthread;

import java.util.concurrent.Exchanger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadA extends Thread {
	private transient Logger log = LoggerFactory.getLogger(ThreadA.class);
	
	private Exchanger<String> exchanger;
	public ThreadA(Exchanger<String> exchanger) {
		super();
		this.exchanger = exchanger;
	}
	@Override
	public void run() {
		try {
			log.debug("在线程ThradA中得到线程ThreadB的值=" + exchanger.exchange("中国人A"));
			/***
			 * Class java.util.concurrent.Exchanger
			 * public V exchange(V x) 
			 * public V exchange(V x, long timeout, TimeUnit unit)
			 * 后一个方法，确定了超时时间及单位
			 * 
			 */
		}catch(InterruptedException e) {
			
		}
	}
	
}
