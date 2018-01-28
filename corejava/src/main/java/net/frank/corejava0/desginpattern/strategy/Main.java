package net.frank.corejava0.desginpattern.strategy;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Random r = new Random();
		int seed0 = r.nextInt(1000);
		int seed1 = r.nextInt(1000);
		Player player0 = new Player("Taro",new WinningStrategy(seed0));
		Player player1 = new Player("Hana",new ProbStrategy(seed1));
		for(int i=0;i<10000;i++) {
			Hand nextHand0 = player0.nextHand();
			Hand nextHand1 = player1.nextHand();
			System.out.println(nextHand0 +" vs " +  nextHand1);
			if(nextHand0.isStrongerThan(nextHand1)) {
				System.out.println("Winner: " + player0);
				player0.win();
				player1.lose();
			}else if(nextHand0.isWeakerThan(nextHand1)) {
				System.out.println("Winner: " + player1);
				player1.win();
				player0.lose();
			}else {
				System.out.println("Even ...");
				player0.even();
				player1.even();
			}
		}
		System.out.println("Total result:");
		System.out.println(player0);
		System.out.println(player1);
		
	}

}
