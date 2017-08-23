package net.frank.corejava0.netty.ch02;

public class NioTimerServer {
	public static void main(String[] args){
		int port = 8080;
		if(args!=null &&args.length>0){
			try{
				port = Integer.parseInt(args[0]);
			}catch(NumberFormatException e){
				
			}
		}
		
		MultipexerTimeServer timeServer = new MultipexerTimeServer(port);
		new Thread(timeServer,"NIO-MultiplexerTimeServer-01").start();
	}
}
