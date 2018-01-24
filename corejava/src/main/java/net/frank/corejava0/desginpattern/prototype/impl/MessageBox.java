package net.frank.corejava0.desginpattern.prototype.impl;

import net.frank.corejava0.desginpattern.prototype.framework.Product;

public class MessageBox implements Product {
	
	private char decocher;
	
	public MessageBox(char decochar) {
		this.decocher = decochar;
	}
	
	@Override
	public void use(String s) {
		int length = s.getBytes().length;
		for(int i=0;i<length+4;i++) {
			System.out.print(decocher);
		}
		System.out.println("");
		System.out.println(decocher + " " + s + " " + decocher);
		for(int i=0;i<length+4;i++) {
			System.out.print(decocher);
		}
		System.out.println("");
	}

	@Override
	public Product createClone() {
		Product p = null;
		try {
			p= (Product) clone();
		}catch(CloneNotSupportedException e) {
			
		}
		return p;
	}

}
