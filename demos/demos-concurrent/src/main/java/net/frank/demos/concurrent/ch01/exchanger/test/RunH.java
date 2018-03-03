package net.frank.demos.concurrent.ch01.exchanger.test;

import java.util.concurrent.Exchanger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.frank.demos.concurrent.ch01.exchanger.extthread.ThreadA;
import net.frank.demos.concurrent.ch01.exchanger.extthread.ThreadB;

public class RunH {
	private transient static Logger log = LoggerFactory.getLogger(RunH.class);
	public static void main(String[] args) {
		Exchanger<String> exchanger = new Exchanger<String>();
		ThreadA a = new ThreadA(exchanger);
		ThreadB b = new ThreadB(exchanger);
		a.start();
		b.start();
		log.debug("End");
	}

}
