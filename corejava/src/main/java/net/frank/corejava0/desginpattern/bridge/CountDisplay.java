package net.frank.corejava0.desginpattern.bridge;

public class CountDisplay extends Display {

	public CountDisplay(DisplayImpl impl) {
		super(impl);
	}
	
	public void multDisplay(int time) {
		open();
		for(int i=0;i<time;i++) {
			print();
		}
		close();
	}
}
