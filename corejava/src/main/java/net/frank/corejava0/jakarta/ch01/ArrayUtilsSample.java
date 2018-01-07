package net.frank.corejava0.jakarta.ch01;

import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;

public class ArrayUtilsSample {

	public static void main(String[] args) {
		long [] array = {1,2,3,4,5,6};
		long [] reversed = ArrayUtils.clone(array);
		ArrayUtils.reverse(reversed);
		
		System.out.println("Original:" + ArrayUtils.toString(array));
		System.out.println("Reversed:" + ArrayUtils.toString(reversed));
		
		String [] stringArray = {"Red","Orange","Blue","Brown","Red"};
		boolean containsBlue = ArrayUtils.contains(stringArray, "Blue");
		int indexOfRed = ArrayUtils.indexOf(stringArray,"Red");
		int lastIndexOfRed = ArrayUtils.lastIndexOf(stringArray,"Red");
		
		System.out.println("Array contains 'Blue'?" + containsBlue);
		System.out.println("Index of 'Red'?" + indexOfRed);
		System.out.println("Last index of 'Red'?" + lastIndexOfRed);
		
		
		Object[] weightArray = new Object [][] {
			{"H", new Double(1.007)},
			{"He", new Double(4.002)},
			{"Li", new Double(6.941)},
			{"Be", new Double(9.012)},
			{"B", new Double(10.811)},
			{"C", new Double(12.010)},
			{"N", new Double(14.007)},
			{"O", new Double(15.999)},
			{"F", new Double(18.998)},
			{"Ne", new Double(20.180)}
		};
		
		Map<Object,Object> weights = ArrayUtils.toMap(weightArray);
		
		Double hydrogenWeight = (Double) weights.get("H");
		
		System.out.println(hydrogenWeight);
	}

}
