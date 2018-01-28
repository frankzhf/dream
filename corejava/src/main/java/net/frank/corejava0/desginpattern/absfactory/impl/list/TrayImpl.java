package net.frank.corejava0.desginpattern.absfactory.impl.list;

import java.util.Iterator;

import net.frank.corejava0.desginpattern.absfactory.framework.Item;
import net.frank.corejava0.desginpattern.absfactory.framework.Tray;

public class TrayImpl extends Tray {

	public TrayImpl(String caption) {
		super(caption);
	}

	@Override
	public String makeHTML() {
		StringBuilder sb = new StringBuilder();
		sb.append("<li>\n");
		sb.append(caption).append("\n");
		sb.append("<ul>").append("\n");
		Iterator<Item> it = tray.iterator();
		while(it.hasNext()) {
			Item item = it.next();
			sb.append(item.makeHTML());
		}
		sb.append("</ul>").append("\n");
		sb.append("</li>").append("\n");
		return sb.toString();
	}

}
