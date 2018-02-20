package net.frank.corejava0.desginpattern.chainresponsibility;

public class OddSupport extends Support {
	
	public OddSupport(String name) {
		super(name);
	}

	@Override
	protected boolean resolve(Trouble trouble) {
		if(trouble.getNumber() %2 == 0) {
			return true;
		}else {
			return false;
		}
	}

}