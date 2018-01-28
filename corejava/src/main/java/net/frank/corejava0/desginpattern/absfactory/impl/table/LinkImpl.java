package net.frank.corejava0.desginpattern.absfactory.impl.table;

import net.frank.corejava0.desginpattern.absfactory.framework.Link;

public class LinkImpl extends Link {

	public LinkImpl(String caption, String url) {
		super(caption, url);
	}

	@Override
	public String makeHTML() {
		return "<td><a href=\""+url+"\">"+caption+"</a></td>\n";
	}
	
}
