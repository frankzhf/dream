package net.frank.corejava1.ch03;

import java.math.BigInteger;
import java.util.Scanner;

public class BigIntegerTest {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("How many numbers do you need to draw?");
		int k = in.nextInt();
		System.out.print("What is the highest number you can draw?");
		int n = in.nextInt();
		BigInteger lotteryOdds = BigInteger.valueOf(1);
		
		for(int i=1;i<=k;i++) {
			lotteryOdds = lotteryOdds.multiply(BigInteger.valueOf(n-i+1)).divide(BigInteger.valueOf(i));
		}
		System.out.println("Your odds are 1 in " +lotteryOdds+  ". Good luck!");
		in.close();
	}

}

/***
 * 
 * class java.math.BigInteger
 * BigInteger add(BigInteger other)
 * BigInteger subtract(BigInteger other)
 * BigInteger multiply(BigInteger other)
 * BigInteger divide(BigInteger other)
 * BigInteger mod(BigInteger other)
 * 返回这个大整数和另一个大整数的和差积商以及余数
 * 
 * int compareTo(BigInteger other)
 * 比较二个大整数，相等，返回0，大于返回一个正数，小于返回一个负数
 * 
 * static BigInteger valueOf(long x)
 * 返回等于x的大整数
 * 
 * class java.math.BigDecimal
 * BigDecimal add(BigDecimal other)
 * BigDecimal subtract(BigDecimal other)
 * BigDecimal multiply(BigDecimal other)
 * BigDecimal divide(BigDecimal other,int bit, RoundingMode mode)
 * 返回这个大实数和另一个大实数的和差积商，除法需要指定小数多少位，及舍入模式
 * 
 * int compareTo(BigDecimal other)
 * 比较二个大实数，相等，返回0，大于返回一个正数，小于返回一个负数
 * 
 * static BigDecimal valueOf(long x)
 * static BigDecimal valueOf(long x, int scale)
 * 返回等于x或x*10 scale次方的大实数
 * 
 */
