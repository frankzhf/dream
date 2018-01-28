package net.frank.corejava0.desginpattern.visitor;

import java.util.Iterator;

public abstract class Entry implements Element {
	
	
	public abstract String getName();
	
	public abstract int getSize();
	
	public Entry addEntry(Entry entry) throws FileTreatmentException{
		throw new FileTreatmentException();
	}
	
	public Iterator<Entry> iterator()throws FileTreatmentException{
		throw new FileTreatmentException();
	}

	public String toString() {
		return getName() + "(" + getSize() + ")";
	}

}
