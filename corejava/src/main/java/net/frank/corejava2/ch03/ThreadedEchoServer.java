package net.frank.corejava2.ch03;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ThreadedEchoServer {
	public static void main(String[] args)throws IOException{
		int i=0;
		ServerSocket s = new ServerSocket(8189);
		try{
			while(true){
				Socket incoming = s.accept();
				System.out.println("Spawning " + (++i));
				Runnable r = new ThreadedEchoHandler(incoming);
				Thread t = new Thread(r);
				t.start();
			}
		}finally{
			if(s!=null){
				s.close();
			}
		}
		
	}
}

class ThreadedEchoHandler implements Runnable{
	
	private Socket incoming;
	
	public ThreadedEchoHandler(Socket i){
		incoming = i;
	}
	
	@Override
	public void run() {
		try{
			Scanner in=null;
			try{
				InputStream _in = incoming.getInputStream();
				OutputStream _out = incoming.getOutputStream();
				in = new Scanner(_in);
				PrintWriter out = new PrintWriter(_out,true);
				out.println("Hello! Enter BYE to exit.");
				boolean exit = false;
				while(!exit && in.hasNextLine()){
					String line = in.nextLine();
					out.println("Echo:"+line);
					if(line.trim().equals("BYE")){
						exit = true;
					}
				}
			}finally{
				if(in!=null){
					in.close();
				}
				if(incoming!=null){
					incoming.close();
				}
			}	
		}catch(IOException e){
			e.printStackTrace();
		}	
	}	
}
/**
 * half close 
 * java.net.Socket
 * 
 * void shutdownOutput()
 * 将输出流设为流结束
 * 
 * void shutdownInput
 * 将输入流设为流结束
 * 
 * boolean isOutputShutdown()
 * 如果输出流已被关闭，则返回true
 * 
 * boolean isInputShutdown()
 * 如果输入流已被关闭，则返回true
 * 
 */
