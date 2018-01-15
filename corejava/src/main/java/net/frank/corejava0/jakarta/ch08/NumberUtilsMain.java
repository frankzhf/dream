package net.frank.corejava0.jakarta.ch08;

import org.apache.commons.lang.math.NumberUtils;

public class NumberUtilsMain {

	public static void main(String[] args) {
		double [] array = {0.2,0.4,0.5,-3.0,4.223,4.226};
		
		double max = NumberUtils.max(array);
		double min = NumberUtils.min(array);
		
		System.out.println("Variable [max] -> " + max);
		System.out.println("Variable [min] -> " + min);
		
		
		/***
		 * NumberRange, DoubleRange, FloatRange, IntRange, LongRange
		 */
		
		
	}

}
