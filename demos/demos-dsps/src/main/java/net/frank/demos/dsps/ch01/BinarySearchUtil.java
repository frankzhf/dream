package net.frank.demos.dsps.ch01;

public class BinarySearchUtil {
	
	public static final int NOT_FOUND = -1;
	
	/**
	 * 三路比较二分搜索
	 * @param a
	 * @param x
	 * @return
	 */
	public static <T  extends Comparable<T>>
		int binarySearchFor3way(T[] a, T x) {
		int low = 0 ;
		int high = a.length -1 ;
		int mid;
		while(low <= high) {
			mid = (low + high) /2;
			if(a[mid].compareTo(x)<0) {
				low = mid + 1;
			}else if(a[mid].compareTo(x) >0 ) {
				high = mid -1;
			}else {
				return mid;
			}
		}
		return NOT_FOUND;
	}
	
	/**
	 * 二路比较二分搜索
	 * @param a
	 * @param x
	 * @return
	 */
	
	public static <T  extends Comparable<T>>
		int binarySearchFor2way(T[] a, T x) {
		if(a.length == 0) {
			return NOT_FOUND;
		}
		int low = 0;
		int high = a.length -1;
		int mid;
		while(low < high) {
			mid = (low + high)/2;
			if(a[mid].compareTo(x)<0) {
				low = mid + 1;
			}else {
				high = mid;
			}
		}	
		if(a[low].compareTo(x)==0) {
			return low;
		}
		return NOT_FOUND;
	}
}
