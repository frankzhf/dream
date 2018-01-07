package net.frank.corejava0.dsps.ch01;

public class Cubic{
	
	private static int seqStart = -1;
	private static int seqEnd = -1;
	
	public static void main(String[] args) {
		int[] input = new int[]{-2,11,-4,13,-5,2};
		
		System.out.println(maxSubsequenceSum(input));
		System.out.println(seqStart);
		System.out.println(seqEnd);
		
		input = new int[]{1,-3,4,-2,-1,6};
		
		System.out.println(maxSubsequenceSum(input));
		System.out.println(seqStart);
		System.out.println(seqEnd);
		
		
	}

	public static int maxSubsequenceSum(int [] input) {
		int maxSum = Integer.MIN_VALUE;
		for(int i=0;i<input.length;i++) {
			
			for(int j=i;j<input.length;j++) {
				int thisSum = 0;
				for(int k=i;k<=j;k++) {
					thisSum += input[k];
				}
				if(thisSum > maxSum) {
					maxSum = thisSum;
					seqStart = i;
					seqEnd = j;
				}
			}
		}
		
		return maxSum;
	}
}
