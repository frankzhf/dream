package net.frank.corejava0.netty.ch02;

public class NioTimerClient {
	public static void main(String[] args){
		int port = 8080;
		if(args!=null &&args.length>0){
			try{
				port = Integer.parseInt(args[0]);
			}catch(NumberFormatException e){
				
			}
		}
		new Thread(new NioTimeClientHandle("127.0.0.1",port),"TimeClient-001").start();
	}
}
