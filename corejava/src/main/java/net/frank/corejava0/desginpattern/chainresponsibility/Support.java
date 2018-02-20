package net.frank.corejava0.desginpattern.chainresponsibility;

public abstract class Support {
	private String name;
	private Support next;
	
	public Support(String name) {
		this.name = name;
	}
	
	public Support setNext (Support next) {
		this.next = next;
		return next;
	}
	
	public final void process(Trouble trouble) {
		if(resolve(trouble)) {
			done(trouble);
		}else if(next!=null) {
			next.process(trouble);
		}else {
			fail(trouble);
		}
	}
	
	public String toString() {
		return "[" +name+ "]";
	}
	
	protected void done(Trouble trouble) {
		System.out.println(trouble + " is resolved by " + this + ".");
	}
	
	protected void fail(Trouble trouble) {
		System.out.println(trouble + " cannot be resolved.");
	}
	
	protected abstract boolean resolve(Trouble trouble);
}
