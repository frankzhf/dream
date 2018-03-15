package net.frank.demos.concurrent.ch03;

import java.util.concurrent.Phaser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PhaserBaseMain {
	
	static transient Logger log = LoggerFactory.getLogger(PhaserBaseMain.class);
	
	public static Phaser phaser;
	
	public static void methodA() {
		log.debug(" A1 Begin");
		phaser.arriveAndAwaitAdvance();
		log.debug(" A1   End");
		log.debug(" A2 Begin");
		phaser.arriveAndAwaitAdvance();
		log.debug(" A2   End");
	}
	
	public static void methodB() {
		try {
			log.debug(" A1 Begin");
			Thread.sleep(5000);
			phaser.arriveAndAwaitAdvance();
			log.debug(" A1   End");
			log.debug(" A2 Begin");     //如果注释掉29 - 31,则计数不够，不会向下继续执行，控制台只会打印八条消息
			phaser.arriveAndAwaitAdvance();
			log.debug(" A2   End");
		}catch(InterruptedException e) {
			
		}
	}
	public static void main(String[] args) {
		Phaser phaser3 = new Phaser(3);
		PhaserBaseMain.phaser = phaser3;
		new Thread(new Runnable() {

			@Override
			public void run() {
				PhaserBaseMain.methodA();
			}
			
		}).start();
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				PhaserBaseMain.methodA();
			}
			
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				PhaserBaseMain.methodB();
			}
			
		}).start();
		
		
		
		
		
	}

}


