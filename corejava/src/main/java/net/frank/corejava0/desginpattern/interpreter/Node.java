package net.frank.corejava0.desginpattern.interpreter;

public abstract class Node {
	public abstract void parse(Context context) throws ParseException;
}
