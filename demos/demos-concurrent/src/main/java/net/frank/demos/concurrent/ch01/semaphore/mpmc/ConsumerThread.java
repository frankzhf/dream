package net.frank.demos.concurrent.ch01.semaphore.mpmc;

public class ConsumerThread extends Thread {
	private RepastService service;
	public ConsumerThread(RepastService service) {
		super();
		this.service = service;
	}
	
	@Override
	public void run() {
		service.get();
	}
}
