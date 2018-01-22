package net.frank.corejava0.desginpattern.adapter.inherit;

import net.frank.corejava0.desginpattern.adapter.Banner;

public class PrintBanner extends Banner implements Print {
	
	public PrintBanner(String string) {
		super(string);
	}
	
	@Override
	public void printWeak() {
		showWithParen();
	}

	@Override
	public void printStrong() {
		showWithAster();
	}

}
