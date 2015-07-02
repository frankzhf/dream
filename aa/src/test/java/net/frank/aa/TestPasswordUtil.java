package net.frank.aa;

import net.frank.commons.util.PasswordUtil;

public class TestPasswordUtil {
	public static void main(String[] args){
		System.out.println(PasswordUtil.MD5encode(null));
		System.out.println(PasswordUtil.MD5encode(""));
	}
}
