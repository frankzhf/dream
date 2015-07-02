package net.frank.repository;

public class TestSum {
	
	public static int sum(int a, int b){
		if(a != 0 && b!=0){
			int x = a;
			int y = b;
			
			do{
				int xt= x; 
				x = xt & y;
				x <<=1;
				y = xt^y;
			}while(x!=0 && y!=0);
			return x==0?y:x;
		}else{
			return a!=0? a: b;
		}
		
	}
	
	
	public static void main(String[] args){
		int sum = sum(10,141);
		System.out.println( sum);
		
	}
	
}
