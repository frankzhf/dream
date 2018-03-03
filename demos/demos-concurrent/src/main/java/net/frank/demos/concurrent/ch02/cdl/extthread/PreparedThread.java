package net.frank.demos.concurrent.ch02.cdl.extthread;

import net.frank.demos.concurrent.ch02.cdl.service.PreparedService;

public class PreparedThread extends Thread {
	
	private PreparedService service;
	
	public PreparedThread(PreparedService service) {
		super();
		this.service = service;
	}
	
	@Override
	public void run() {
		service.testMethod();
	}
	
	
	
	public static void main(String[] args) throws InterruptedException {
		PreparedService service = new PreparedService();
		PreparedThread[] threadArray = new PreparedThread[10];
		for(int i=0;i<threadArray.length;i++) {
			threadArray[i] = new PreparedThread(service);
			threadArray[i].setName("线程"+(i+1));
			threadArray[i].start();
		}
		Thread.sleep(2000);
		service.downMethod();
	}

}
