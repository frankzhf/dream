package net.frank.corejava0.desginpattern.absfactory;

import net.frank.corejava0.desginpattern.absfactory.framework.Factory;
import net.frank.corejava0.desginpattern.absfactory.framework.Link;
import net.frank.corejava0.desginpattern.absfactory.framework.Page;
import net.frank.corejava0.desginpattern.absfactory.framework.Tray;

public class Main {
	public static void main(String[] args) {
		/***
		if(args.length != 1) {
			System.out.println("Usage: java Main class.name.of.ConcreateFactory");
			System.out.println("Example 1: java Main net.frank.corejava0.desginpattern.absfactory.impl.ListFactory");
			System.out.println("Example 2: java Main net.frank.corejava0.desginpattern.absfactory.impl.TableFactory");
		}***/
		//Factory factory = Factory.getFactory(args[0]);
		Factory factory = Factory.getFactory("net.frank.corejava0.desginpattern.absfactory.impl.list.FactoryImpl");
		Link people = factory.crateLink("人民日报", "http://www.people.com.cn/");
		Link gmw = factory.crateLink("光明日报", "http://www.gmw.cn/");
		
		Link us_yahoo = factory.crateLink("Yahoo!", "http://www.yahoo.com");
		Link jp_yahoo = factory.crateLink("Yahoo!Japan", "http://www.yahoo.co.jp");
		
		Link excite = factory.crateLink("Excite", "http://www.excite.com");
		Link google = factory.crateLink("Google", "http://www.google.com");
		
		Tray traynews = factory.createTray("日报");
		traynews.add(people);
		traynews.add(gmw);
		
		Tray trayyahoo = factory.createTray("Yahoo!");
		trayyahoo.add(us_yahoo);
		trayyahoo.add(jp_yahoo);
		
		Tray traysearch = factory.createTray("检索引擎");
		traysearch.add(trayyahoo);
		traysearch.add(excite);
		traysearch.add(google);
		
		Page page = factory.createPage("LinkPage", "frank");		
		page.add(traynews);
		page.add(traysearch);
		
		page.output();
	}
}
