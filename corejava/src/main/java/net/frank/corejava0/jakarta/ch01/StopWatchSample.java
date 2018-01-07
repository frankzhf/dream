package net.frank.corejava0.jakarta.ch01;

import org.apache.commons.lang3.time.StopWatch;

public class StopWatchSample {

	public static void main(String[] args) {
		StopWatch clock = new StopWatch();
		System.out.println("Time to Math.sin(0.34) ten million times?");
		clock.start();
		
		for(int i=0;i<10000000;i++) {
			Math.sin(0.34);
		}
		clock.stop();
		System.out.println("It takes " + clock.getTime() + " milliseconds");
		clock.reset();
		System.out.println("How long to multiply 2 doubules one billion times");
		clock.start();
		for(int i=0;i<1000000000;i++) {
			double result = 3423.2234 * 23e-4;
		}
		clock.stop();
		System.out.println("It takes " + clock.getTime() + " milliseconds");
		
		System.out.println("Testing the split() method.");
		clock.reset();
		
		clock.start();
		
		try {
			Thread.sleep(1000);
		}catch(Exception e) {
			
		}
		clock.split();
		System.out.println("Split time after 1 sec :" + clock.getSplitTime());
		try {
			Thread.sleep(1000);
		}catch(Exception e) {
			
		}
		System.out.println("Split time after 2 sec :" + clock.getSplitTime());
		clock.unsplit();
		try {
			Thread.sleep(1000);
		}catch(Exception e) {
			
		}
		System.out.println("Split time after 3 sec :" + clock.getTime());
		
		
	}

}
