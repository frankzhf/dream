package net.frank.demos.concurrent.ch02.cdl.extthread;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/***
 * 
 * 完整的比赛流程
 */

public class FullThread extends Thread {
	private transient Logger log = LoggerFactory.getLogger(FullThread.class);

	private CountDownLatch comingTag; // 裁判等待所有运动员到来
	private CountDownLatch waitTag; // 等待裁判说准备开动
	private CountDownLatch waitRunTag; // 等待起跑
	private CountDownLatch beginTag; // 起跑
	private CountDownLatch endTag; // 所有运动员到达终点

	public FullThread(CountDownLatch comingTag, CountDownLatch waitTag, CountDownLatch waitRunTag,
			CountDownLatch beginTag, CountDownLatch endTag) {
		super();
		this.comingTag = comingTag;
		this.waitTag = waitTag;
		this.waitRunTag = waitRunTag;
		this.beginTag = beginTag;
		this.endTag = endTag;
	}

	@Override
	public void run() {
		try {
			log.debug("运动员使用不同的交通工具不同速度到达起跑点，正向这头走！");
			Thread.sleep((int) (Math.random() * 10000));
			log.debug("到达起点了！");
			comingTag.countDown();
			log.debug("等待裁判说准备！");
			waitTag.await();
			log.debug("各就各位！准备起跑姿势！");
			Thread.sleep((int) (Math.random() * 10000));
			waitRunTag.countDown();
			beginTag.await();
			log.debug("运动员起跑，并且跑赛过程用时不确定");
			Thread.sleep((int) (Math.random() * 10000));
			endTag.countDown();
			log.debug("运动员到达终点");
		} catch (InterruptedException e) {

		}
	}

	public static void main(String[] args) {
		try {
			CountDownLatch comingTag = new CountDownLatch(10);
			CountDownLatch waitTag = new CountDownLatch(1);
			CountDownLatch waitRunTag = new CountDownLatch(10);
			CountDownLatch beginTag = new CountDownLatch(1);
			CountDownLatch endTag = new CountDownLatch(10);
	
			FullThread[] threadArray = new FullThread[10];
			for (int i = 0; i < threadArray.length; i++) {
				threadArray[i] = new FullThread(comingTag, waitTag, waitRunTag, beginTag, endTag);
				threadArray[i].start();
			}
			
			System.out.println("裁判员在等待选手的到来!");
			comingTag.await();
			System.out.println("裁判员看到所有运动员来了，各就各位前巡视用时5秒");
			Thread.sleep(5000);
			waitTag.countDown();
			System.out.println("各就各位！");
			waitRunTag.await();
			Thread.sleep(2000);
			System.out.println("发令枪响起！");
			beginTag.countDown();
			endTag.await();
			System.out.println("所有运动员到达，统计比赛名次！");
		}catch(InterruptedException e) {
			
		}
		
	}
	
	/***
	 * java.util.concurrent.CountDownLatch
	 * void await(long timeout, TimeUnit unit)
	 * 等待并设置超时时间
	 * 
	 * long getCount()
	 * 获取当前的计数值
	 * 
	 */
	
}
