package net.frank.corejava2.ch03;

import java.net.InetAddress;

public class InetAddressTest {
	public static void main(String[] args){
		try{
			if(args.length>0) {
				String host = args[0];
				InetAddress[] addresses = InetAddress.getAllByName(host);
				for(InetAddress a : addresses){
					System.out.println(a);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

/***
 * 
 * java.net.InetAddress
 *
 * static InetAddress getByName(String host)
 * static InetAddress[] getAllbyName(String host)
 * 为给定的主机名，创建一个InetAddress对旬，或者一个包含了该主机名所对应的因特网地址数组
 *
 * static InetAddress getLocalHost()
 * 为本地主机创建一个InetAddress对象
 * 
 * byte[] getAddress()
 * 返加一个包含数字类型地址的字节数组
 * 
 * String getHostAddress()
 * 返回一个由十进制数组的字符串，各数字间用圆点符号隔开
 * 
 * String getHostName()
 * 返加主机名
 *
 *
 *
**/