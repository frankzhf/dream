package net.frank.demos.dsps.ch02.weiss.ds;


public class MyContrainer<T> {
	T[] items;
	int size;
	
	@SuppressWarnings("unchecked")
	public MyContrainer(int capacity) {
		items =  (T[]) new Object[capacity];
	}
	
	public MyContainerIterator<T> iterator(){
		return new MyContainerIterator<T>(this);
	}
	
	public void add(T value) {
		items[size++] = value;
	}
	
	
	public static void main(String[] args) {
		MyContrainer<String> v = new MyContrainer<String>(10);
		v.add("3");
		v.add("2");
		
		System.out.println("Container contents:");
		MyContainerIterator<String> itr = v.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
	}
	
	
}
