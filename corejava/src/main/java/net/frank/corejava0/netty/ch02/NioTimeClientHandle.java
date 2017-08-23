package net.frank.corejava0.netty.ch02;

import java.io.IOException;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class NioTimeClientHandle implements Runnable {
	
	private String host;
	
	private int port;
	
	private Selector selector;

	private SocketChannel socketChannel;

	private volatile boolean stop = Boolean.FALSE;
	
	public NioTimeClientHandle(String string, int port) {
		this.host = host == null ? "127.0.0.1" :host;
		this.port = port;
		try{
			selector = Selector.open();
			socketChannel = SocketChannel.open();
			socketChannel.configureBlocking(false);	
		}catch(IOException e){
			e.printStackTrace();
			System.exit(1);
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
