package net.frank.demos.dsps.ch02.weiss.nonstandard;

public interface SimpleContainer<T> {
	void insert (T x);
	void remove(T x);
	T find(T x);
	boolean isEmpty();
	void makeEmpty();
}
