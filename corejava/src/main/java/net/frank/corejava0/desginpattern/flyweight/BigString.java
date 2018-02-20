package net.frank.corejava0.desginpattern.flyweight;

public class BigString {
	private BigChar[] bigchars;
	public BigString(String string) {
		bigchars = new BigChar[string.length()];
		BigCharFactory factory = BigCharFactory.getInstance();
		for(int i=0;i<bigchars.length;i++) {
			bigchars[i]= factory.getBigChar(string.charAt(i));
		}
	}
	public void print() {
		for(int i=0;i<bigchars.length;i++) {
			bigchars[i].print();
		}
	}
	
	public static void main(String[] args) {
		String value = "1211203222";
		BigString bs = new BigString(value);
		bs.print();
	}
}
