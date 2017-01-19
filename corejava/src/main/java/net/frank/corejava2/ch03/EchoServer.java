package net.frank.corejava2.ch03;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {

	public static void main(String[] args)throws Exception {
		ServerSocket s = new ServerSocket(8189);
		Socket incoming = s.accept();
		try{
			InputStream _in = incoming.getInputStream();
			OutputStream _out = incoming.getOutputStream();
			
			Scanner in = new Scanner(_in);
			PrintWriter out = new PrintWriter(_out,true);
			out.println("Hello! Enter BYE to exit.");
			
			boolean exits = false;
			while(!exits && in.hasNextLine()){
				String line = in.nextLine();
				out.println("Echo:" + line);
				if(line.trim().equals("BYE")){
					exits = true;
				}
			}
			if(in!=null)
				in.close();
		}finally{
			if(incoming!=null){
				incoming.close();
			}
			
			if(s!=null){
				s.close();
			}
			
		}
	}
}

/*
 * java.net.ServerSocket
 * 
 * ServerSocket(int port)
 * 创建一个监控端口的服务器套接字
 * 
 * Socket accept()
 * 等待连接。该方法阻塞 当前线程只到建立连接为止
 * 
 * 
 */