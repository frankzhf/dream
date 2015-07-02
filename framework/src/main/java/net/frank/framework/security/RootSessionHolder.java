package net.frank.framework.security;

public final class RootSessionHolder {
	
	private static Session root = null;
	
	public static Session getDefaultRootSession(){
		if(root == null){
			root = new RootSession();
		}
		return root;
	}
}
