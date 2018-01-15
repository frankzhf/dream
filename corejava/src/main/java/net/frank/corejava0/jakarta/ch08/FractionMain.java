package net.frank.corejava0.jakarta.ch08;

import org.apache.commons.lang.math.Fraction;

public class FractionMain {
	public static void main(String[] args) {
		
		String userInput = "23 31/37";
		Fraction fraction = Fraction.getFraction(userInput);
		double value = fraction.doubleValue();
		System.out.println("Variable [value] -> " + value);
		
		Fraction number1 = Fraction.getFraction(3, 4);
		Fraction number2 = Fraction.getFraction(51, 3509);
		
		Fraction numerator = number1.multiplyBy(number2);
		Fraction denominator = Fraction.getFraction(41, 59);
		Fraction fraction2 = numerator.divideBy(denominator);
		Fraction result = fraction2.reduce();
		
		System.out.println("Variable [result] as Fraction ->" + result.reduce().toString());
		System.out.println("Variable [result] as double ->" + result.doubleValue());
		/*
		 * 多多调用reduce,化简，否则会有想不到的结果
		 * 
		 * Fraction常用的方法
		 * 
		 *	abs()							返回绝对值
		 *	add(Fraction fraction)			加法
		 *	subtract(Fraction fraction)		减法
		 *	multiplyBy(Fraction fraction)	乘法
		 *	divideBy(Fraction fraction)		除法
		 *	reduce()							化简最小分母
		 *	negate()							返回-1乘以这个值
		 *	invert()							交换分子和分母
		 *	getNumberor()					返回分子值
		 *	getDenominator()					返回分母值
		 *	getProperWhole()					返回相应真分数的分子
		 *	pow(int)							对Fraction加幂
		 */
		
	}
}
