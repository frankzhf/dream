package net.frank.corejava0.desginpattern.adapter.delegation;

public class Main {

	public static void main(String[] args) {
		Print p = new PrintBanner("World");
		p.printWeak();
		p.printStrong();
	}

}
