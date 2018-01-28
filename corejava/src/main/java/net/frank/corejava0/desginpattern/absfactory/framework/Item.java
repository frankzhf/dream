package net.frank.corejava0.desginpattern.absfactory.framework;

public abstract class Item {
	protected String caption;
	public Item(String caption) {
		this.caption = caption;
	}
	public abstract String makeHTML();
}
