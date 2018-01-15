package net.frank.corejava0.jakarta.ch08;

import org.apache.commons.math3.stat.regression.SimpleRegression;

public class RegressionMain {

	public static void main(String[] args) {
		SimpleRegression sr = new SimpleRegression();
		sr.addData(0,0);
		sr.addData(1,1.2);
		sr.addData(2,2.6);
		sr.addData(3,3.2);
		sr.addData(4,4);
		sr.addData(5,5);
		
		System.out.println("Intercept: " + sr.getIntercept());
		System.out.println("N: " + sr.getN());
		System.out.println("Slope: " + sr.getSlope());
		System.out.println("Slope Confidence: " + sr.getSlopeConfidenceInterval());
		System.out.println("RSquare: " + sr.getRSquare());
	}
}
