package net.frank.corejava0.desginpattern.singleton;

public class Singleton {
	private static Singleton instance = new Singleton();
	private Singleton() {
		System.out.println("生成了一个实例。");
	}
	
	public static Singleton getInstnace(){
		return instance;
	}
	
	
	
}
