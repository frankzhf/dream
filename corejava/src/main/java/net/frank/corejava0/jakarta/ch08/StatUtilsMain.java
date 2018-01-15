package net.frank.corejava0.jakarta.ch08;

import org.apache.commons.math3.stat.StatUtils;

public class StatUtilsMain {

	public static void main(String[] args) {
		double [] values = new double[] {2.3,5.4,6.2,7.3,23.3};
		System.out.println("min:" + StatUtils.min(values));
		System.out.println("max:" + StatUtils.max(values));
		System.out.println("mean:" + StatUtils.mean(values));
		System.out.println("product:" + StatUtils.product(values));
		System.out.println("sum:" + StatUtils.sum(values));
		System.out.println("variance:" + StatUtils.variance(values));
		
	}

}
