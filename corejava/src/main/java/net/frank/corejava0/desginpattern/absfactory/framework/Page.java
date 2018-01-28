package net.frank.corejava0.desginpattern.absfactory.framework;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public abstract class Page {
	protected String title;
	protected String author;
	protected List<Item> content = new ArrayList<Item>();
	public Page(String title, String author) {
		this.title = title;
		this.author = author;
	}
	
	public void add(Item item) {
		content.add(item);
	}
	
	public void output() {
		try {
			String fileName = title+".html";
			Writer writer = new FileWriter(fileName);
			writer.write(makeHTML());
			writer.close();
			System.out.println(fileName + "completed."); 
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public abstract String makeHTML();
}
