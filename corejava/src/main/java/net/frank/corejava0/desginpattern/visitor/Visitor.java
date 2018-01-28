package net.frank.corejava0.desginpattern.visitor;

public abstract class Visitor {
	public abstract void visit(File file);
	public abstract void visit(Directory directory);
}
