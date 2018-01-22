package net.frank.corejava0.desginpattern.adapter.delegation;

import net.frank.corejava0.desginpattern.adapter.Banner;

public class PrintBanner extends Print {
	private Banner banner;
	
	public PrintBanner(String string) {
		banner = new Banner(string);
	}
	
	
	@Override
	public void printWeak() {
		banner.showWithParen();
	}

	@Override
	public void printStrong() {
		banner.showWithAster();
	}

}
