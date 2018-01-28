package net.frank.corejava0.desginpattern.absfactory.framework;

public abstract class Factory {
	public static Factory getFactory(String className) {
		Factory factory = null;
		try {
			factory = (Factory) Class.forName(className).newInstance();
		}catch(ClassNotFoundException e){
			System.err.println(e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return factory;
	}
	
	public abstract Link crateLink(String caption, String url);
	public abstract Tray createTray(String caption);
	public abstract Page createPage(String title, String author);
	
	
}
