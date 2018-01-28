package net.frank.corejava0.desginpattern.absfactory.impl.table;

import net.frank.corejava0.desginpattern.absfactory.framework.Factory;
import net.frank.corejava0.desginpattern.absfactory.framework.Link;
import net.frank.corejava0.desginpattern.absfactory.framework.Page;
import net.frank.corejava0.desginpattern.absfactory.framework.Tray;

public class FactoryImpl extends Factory {

	@Override
	public Link crateLink(String caption, String url) {
		return new LinkImpl(caption,url);
	}

	@Override
	public Tray createTray(String caption) {
		return new TrayImpl(caption);
	}

	@Override
	public Page createPage(String title, String author) {
		return new PageImpl(title,author);
	}

}
