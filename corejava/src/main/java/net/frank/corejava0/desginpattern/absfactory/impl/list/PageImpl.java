package net.frank.corejava0.desginpattern.absfactory.impl.list;

import java.util.Iterator;

import net.frank.corejava0.desginpattern.absfactory.framework.Item;
import net.frank.corejava0.desginpattern.absfactory.framework.Page;

public class PageImpl extends Page {

	public PageImpl(String title, String author) {
		super(title, author);
	}

	@Override
	public String makeHTML() {
		StringBuilder sb = new StringBuilder();
		sb.append("<html><head><title>").append(title).append("</title></head>").append("\n");
		sb.append("<body>").append("\n");
		sb.append("<h1>").append(title).append("</h1>").append("\n");
		sb.append("<ul>").append("\n");
		Iterator<Item> it = content.iterator();
		while(it.hasNext()) {
			Item item = it.next();
			sb.append(item.makeHTML());
		}
		sb.append("</ul>").append("\n");
		sb.append("<hr>").append("<address>").append(author).append("</address>");
		sb.append("</body></html>").append("\n");
		return sb.toString();
	}

}
