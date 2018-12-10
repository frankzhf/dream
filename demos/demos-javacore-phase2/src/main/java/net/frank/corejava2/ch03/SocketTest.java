package net.frank.corejava2.ch03;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class SocketTest {
	public static void main(String[] args){
		try{
			Socket s = new Socket("time-A.timefreq.bldrdoc.gov",13);
			Scanner in = null;
			try{
				InputStream inStream = s.getInputStream();
				in = new Scanner(inStream);
				while(in.hasNextLine()){
					String line = in.nextLine();
					System.out.println(line);
				}
			}finally{
				if(in!=null){
					in.close();
				}
				if(s!=null){
					s.close();
				}
			}
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}


/****
 * java.net.Socket
 * 
 * Socket()
 * 创建一个未被连接的套接字
 * 
 * void connect(SocketAddress address)
 * 将套接字连接到给定的地址
 * 
 * void connect(SocketAddress address, int timeoutInMilliseconds)
 * 将套接字连接到给定的地址。如果在给定的时间内没有相应，则返回
 * 
 * void setSoTimeout(int timeoutInMilliseconds)
 * 设置该套接字上读请求的阻塞时间。如果超出给定时间，则抛出一个InterruptedIOExcetpion异常
 * 
 * boolean isConnected()
 * 如果该套接字已被连接，则返回true.
 * 
 * boolean isClosed()
 * 如果套接字已经被关闭，则返回true.
 * 
 * 
 */

