package net.frank.corejava0.jakarta.ch08;

import org.apache.commons.lang.math.RandomUtils;

public class RandomUtilsMain {

	public static void main(String[] args) {
		int maxVal= 30;
		for(int i=0;i<1000;i++) {
			int randomInt= RandomUtils.nextInt(maxVal);
			System.out.println("Variable [randomInt] -> " + randomInt);
		}
		
		boolean randomBool = RandomUtils.nextBoolean();
		System.out.println("Variable [randomBool] -> " + randomBool);
	}

}
