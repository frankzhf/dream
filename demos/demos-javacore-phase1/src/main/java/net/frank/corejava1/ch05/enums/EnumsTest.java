package net.frank.corejava1.ch05.enums;

import java.util.Scanner;

public class EnumsTest {

	public static void main(String[] args) {
		try(Scanner in = new Scanner(System.in)){
			System.out.println("Enter a size:(SMALL,MEDIUM,LARGE,EXTRA_LARGE) ");
			String input = in.next().toUpperCase();
			Size size = Enum.valueOf(Size.class, input);
			System.out.println("size=" + size);
			System.out.println("abbrevation=" +size.getAbbrevation());
			if(size == Size.EXTRA_LARGE) {
				System.out.println("Good job--you paid attention to the_.");
			}
		}
	}
}

enum Size{
	SMALL("S"),MEDIUM("M"),LARGE("L"),EXTRA_LARGE("XL");
	
	private String abbrevation;
	
	private Size(String abbrevation) {
		this.abbrevation = abbrevation;
	}
	
	public String getAbbrevation() {
		return abbrevation;
	}
	/***
	 * java.lang.Enum
	 * static Enum valueOf(Class enumClass,String name)
	 * 返回指定名字，给定类的枚举常量
	 * 
	 * String toString()
	 * 返回枚举常量名
	 * 
	 * int ordinal;
	 * 返回枚举常理在enum声明中的位置，位置从0开始
	 * 
	 * int compareTo(E other)
	 * 对比枚举值，在之前返回负数，相等返回0，在之后返回正数
	 */
}