package net.frank.corejava0.sort;

public class BubbleSort {
	public static void main(String[] args){
		int [] arr = {6,3,8,2,9,1};
		System.out.println("排序前数组为：");
		for(int num:arr){
			System.out.print(num + "\t");
		}
		System.out.println();
		for(int i=0;i< arr.length -1;i++){
			for(int j=0;j<arr.length-1-i;j++){
				if(arr[j] > arr[j+1]){
					arr[j] = arr[j]+ arr[j+1];
					arr[j+1] = arr[j] - arr[j+1];
					arr[j] = arr[j] - arr[j+1];
				}
			}
		}
		System.out.println("排序前数组为：");
		for(int num:arr){
			System.out.print(num + "\t");
		}
		System.out.println();
		
	}
}
