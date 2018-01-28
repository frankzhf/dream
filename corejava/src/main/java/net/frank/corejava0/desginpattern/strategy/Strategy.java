package net.frank.corejava0.desginpattern.strategy;

public interface Strategy {
	public abstract Hand nextHand();
	public abstract void study(boolean win);
}
