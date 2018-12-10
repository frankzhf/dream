package net.frank.corejava1.ch03;

import java.util.Arrays;
import java.util.Scanner;

public class LotteryDrawing {
	
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		System.out.println("How many numbers do you need to draw?");
		int k = in.nextInt();
		
		System.out.println("What is the highest number you can draw?");
		int n = in.nextInt();
		
		int[] numbers = new int[n];
		for(int i=0; i<numbers.length;i++){
			numbers[i] = i+1;
		}
		
		int[] result = new int[k];
		for(int i=0;i<result.length;i++){
			int r = (int) (Math.random()*n);
			result[i] = numbers[r];
			numbers[r] = numbers[r-1]; 
			n--;
		}
		Arrays.sort(result);
		
		System.out.println("Bet the following combination. It'll make you rich!");
		for(int r: result) {
			System.out.println(r);
		}
		in.close();
	}
	
	
}
/***
 * Class java.util.Arrays
 * static String toString(type[] a)
 * 返回包含a中数据元素的字符串，这些数据元素被放在括号内，并用逗号分离
 * 
 * static type copyOf(type[] a, int length)
 * static type copyOf(type[] a, int start, int end)
 * 返回与a类型相同的一个数组，其长度为length或者end-start,数据元素为a的值
 * 
 * static void sort(type[] a)
 * 采用优化的快速排序算法对数据进行排序
 * 
 * static int binarySearch(type[] a, type v)
 * static int binarySearch(type[] a, int start, int end, type v)
 * 采用二分法查找值v。如果查找成功，则返回相应的下标；否则返回一个负数r。-r是保a有序v应插入的位置
 * 
 * static void fill(type[] a, type v)
 * 将数据所有元素值设为v
 * 
 * static boolean equals(type[] a, type[] b)
 * 比较二个数组
 * 
 */


