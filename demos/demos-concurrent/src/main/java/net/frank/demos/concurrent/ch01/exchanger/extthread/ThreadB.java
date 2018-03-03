package net.frank.demos.concurrent.ch01.exchanger.extthread;

import java.util.concurrent.Exchanger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadB extends Thread {
	private transient Logger log = LoggerFactory.getLogger(ThreadB.class);
	
	private Exchanger<String> exchanger;
	public ThreadB(Exchanger<String> exchanger) {
		super();
		this.exchanger = exchanger;
	}
	@Override
	public void run() {
		try {
			log.debug("在线程ThradB中得到线程ThreadA的值=" + exchanger.exchange("中国人B"));
		}catch(InterruptedException e) {
			
		}
	}
	
}
