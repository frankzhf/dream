package net.frank.corejava0.netty.ch02;

public class AIOTimeServer {
	public static void main(String[] args){
		int port = 8080;
		if(args!=null && args.length >0 ){
			try{
				port = Integer.valueOf(args[0]);
			}catch(NumberFormatException e){
				
			}	
		}
		AsyncTimeServerHandler timeHandler = new AsyncTimeServerHandler(port);
		new Thread(timeHandler,"AIO-AsyncTimeServerHandler-001").start();
	}
}
