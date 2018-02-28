package net.frank.demos.concurrent.ch01.semaphore.mpmc;

public class ProductThread extends Thread {
	private RepastService service;
	public ProductThread(RepastService service) {
		super();
		this.service = service;
	}
	
	@Override
	public void run() {
		service.set();
	}
}
