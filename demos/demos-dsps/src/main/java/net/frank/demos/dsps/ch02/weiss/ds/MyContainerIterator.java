package net.frank.demos.dsps.ch02.weiss.ds;

public class MyContainerIterator<T> {
	private int current = -1;
	private MyContrainer<T> container;
	public MyContainerIterator(MyContrainer<T> c){
		this.container = c;
		if(c != null ) {
			current = 0;
		}
	}
	
	public boolean hasNext() {
		return current < container.size;
	}
	
	public Object next() {
		return container.items[current ++ ];
	}
}
