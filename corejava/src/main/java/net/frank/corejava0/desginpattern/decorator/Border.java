package net.frank.corejava0.desginpattern.decorator;

public abstract class Border extends Display {
	
	protected Display display;
	
	protected Border(Display display) {
		this.display = display;
	}
	

}
