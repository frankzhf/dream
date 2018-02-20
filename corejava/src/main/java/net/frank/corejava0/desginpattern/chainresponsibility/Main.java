package net.frank.corejava0.desginpattern.chainresponsibility;

public class Main {

	public static void main(String[] args) {
		Support alice = new NoSupport("alice");
		Support bob = new LimitSupport("bob",100);
		Support charlie = new SpecialSupport("charlie",429);
		Support diana = new LimitSupport("diana",200);
		Support elmo = new OddSupport("elmo");
		Support fred = new LimitSupport("fred",300);
		
		alice.setNext(bob).setNext(charlie).setNext(diana).setNext(elmo).setNext(fred);
		
		for(int i=0;i<500;i+=33) {
			alice.process(new Trouble(i));
		}
		
	}

}
