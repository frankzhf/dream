package net.frank.corejava0.desginpattern.absfactory.impl.table;

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
		sb.append("<td>");
		sb.append("<table width=\"100%\" border=\"1\">");
		sb.append("<tr>");
			sb.append("<td bgcolor=\"#cccccc\" align=\"center\" colspan=\""+tray.size()+"\" >");
				sb.append("<b>").append(caption).append("</b>");
			sb.append("</td>");
		sb.append("</tr>");
		
		sb.append("<tr>");
		Iterator<Item> it = tray.iterator();
		while(it.hasNext()) {
			Item item = it.next();
			sb.append(item.makeHTML());
		}
		sb.append("</tr>");
		sb.append("</table>");
		sb.append("</td>");
		return sb.toString();
	}

}
