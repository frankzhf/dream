package net.frank.corejava0.desginpattern.visitor;


public class Main {
	public static void main(String[] args) {
		System.out.println("Making root entries...");
		
		Directory rootdir = new Directory("root");
		Directory binDir = new Directory("bin");
		Directory tmpDir = new Directory("tmp");
		Directory usrDir = new Directory("usr");
		
		rootdir.addEntry(binDir);
		rootdir.addEntry(tmpDir);
		rootdir.addEntry(usrDir);
		
		
		binDir.addEntry(new File("vi",10000));
		binDir.addEntry(new File("latex",20000));
		
		rootdir.accept(new ListVisitor());
		
		
		System.out.println();
		System.out.println("Making user entries...");
		Directory yuki = new Directory("yuki");
		Directory hanako = new Directory("hanako");
		Directory tomura = new Directory("tomura");
		
		usrDir.addEntry(yuki);
		usrDir.addEntry(hanako);
		usrDir.addEntry(tomura);
		
		yuki.addEntry(new File("diary.html",100));
		yuki.addEntry(new File("Composite.java",200));
		
		hanako.addEntry(new File("memo.tex",300));
		tomura.addEntry(new File("game.doc",400));
		tomura.addEntry(new File("junk.mail",500));
		
		rootdir.accept(new ListVisitor());
		
		
	}
}
