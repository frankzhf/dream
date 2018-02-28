package net.frank.demos.concurrent.ch01.semaphore.mpmc;

public class MpmcTest {

	public static void main(String[] args) throws InterruptedException {
		RepastService service = new RepastService();
		ProductThread[] arrayP = new ProductThread[60];
		ConsumerThread[] arrayC = new ConsumerThread[60];
		
		for(int i=0;i<60;i++) {
			arrayP [i] = new ProductThread(service);
			arrayP [i].setName("生产者["+i+"]" );
			arrayC [i] = new ConsumerThread(service);
			arrayC [i].setName("消费者["+i+"]" );
		}
		Thread.sleep(2000);
		for(int i=0;i<60;i++) {
			arrayP [i].start();
			arrayC [i].start();
		}
	}

}
