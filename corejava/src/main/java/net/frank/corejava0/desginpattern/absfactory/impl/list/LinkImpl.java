package net.frank.corejava0.desginpattern.absfactory.impl.list;

import net.frank.corejava0.desginpattern.absfactory.framework.Link;

public class LinkImpl extends Link{

	public LinkImpl(String caption, String url) {
		super(caption, url);
	}

	@Override
	public String makeHTML() {
		return "<li><a href=\""+url+"\">"+caption+"</a></li>\n";
	}

}
