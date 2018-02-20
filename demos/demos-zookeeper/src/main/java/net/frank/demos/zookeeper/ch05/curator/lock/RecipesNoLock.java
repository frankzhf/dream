package net.frank.demos.zookeeper.ch05.curator.lock;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RecipesNoLock {
	private static Logger log = LoggerFactory.getLogger(RecipesNoLock.class);
	
	public static void main(String[] args) {
		final CountDownLatch down = new CountDownLatch(1);
		for(int i=0;i<10;i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					try {
						down.await();
					}catch(Exception e) {
						
					}
					SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss|SSS");
					String orderNo = sdf.format(new Date());
					log.error("生成的订单号是:" + orderNo);
				}
				
			}).start();
		}
		down.countDown();
	}

}
