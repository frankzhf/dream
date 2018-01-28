package net.frank.corejava0.desginpattern.composite;

public abstract class Entry {
	public abstract String getName();
	public abstract int getSize();
	
	public Entry add(Entry entry) throws FileTreatementException{
		throw new FileTreatementException();
	}
	
	public void printList() {
		printList("");
	}
	
	protected abstract void printList(String prefix);
	
	public String toString() {
		return getName() + " (" + getSize() +")";
	}
	
}
