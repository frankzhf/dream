package net.frank.corejava0.desginpattern.iterator;

public class BookShelfIterator implements Iterator {
	
	private BookShelf bookShelf;
	private int index;
	
	public BookShelfIterator(BookShelf bookShelf) {
		this.bookShelf = bookShelf;
		index = 0;
	}
	
	@Override
	public boolean hasNext() {
		if(index < bookShelf.getLength()) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Object next() {
		Book book = bookShelf.getBookAt(index++);
		return book;
	}

}
