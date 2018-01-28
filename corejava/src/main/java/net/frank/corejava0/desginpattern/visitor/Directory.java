package net.frank.corejava0.desginpattern.visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Directory extends Entry {
	
	private String name;
	private List<Entry> dir = new ArrayList<Entry>();
	
	public Directory(String name) {
		this.name = name;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getSize() {
		int _size = 0;
		Iterator<Entry> it = dir.iterator();
		while(it.hasNext()) {
			Entry entry = it.next();
			_size += entry.getSize();
		}
		return _size;
	}
	
	public Entry addEntry(Entry entry){
		dir.add(entry);
		return entry;
	}
	
	public Iterator<Entry> iterator(){
		return dir.iterator();
	}
	
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

	

}
