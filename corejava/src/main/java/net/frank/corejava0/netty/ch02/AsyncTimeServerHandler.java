package net.frank.corejava0.netty.ch02;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

public class AsyncTimeServerHandler implements Runnable {
	
	private int port;
	
	private CountDownLatch latch;
	
	private AsynchronousServerSocketChannel asynchronousServerSocketChannel;
	
	public AsyncTimeServerHandler(int port){
		this.port = port;
		try{
			asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open();
			asynchronousServerSocketChannel.bind(new InetSocketAddress(this.port));
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void run() {
		latch = new CountDownLatch(1);
		doAccept();
		try{
			latch.await();
		}catch(InterruptedException e){
			
		}

	}
	private void doAccept() {
		asynchronousServerSocketChannel.accept(this,
				new CompletionHandler<AsynchronousSocketChannel, AsyncTimeServerHandler>() {
			@Override
			public void completed(final AsynchronousSocketChannel result, AsyncTimeServerHandler attachment) {
				attachment.asynchronousServerSocketChannel.accept(attachment,this);
				ByteBuffer buffer = ByteBuffer.allocate(1024);
				result.read(buffer,buffer,new CompletionHandler<Integer,ByteBuffer>(){

					@Override
					public void completed(Integer result, ByteBuffer attachment) {
						attachment.flip();
						byte[] body = new byte[attachment.remaining()];
						attachment.get(body);
						try{
							String req = new String(body,"UTF-8");
							System.out.println("The time server receive order :" + req);
							String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(req)? 
									new Date(System.currentTimeMillis()).toString() : "BAD ORDER";
							doWrite(currentTime);
						}catch(UnsupportedEncodingException e){
							
						}
					}

					private void doWrite(String currentTime) {
						if(currentTime!=null && currentTime.trim().length()>0){
							byte[] bytes = currentTime.getBytes();
							ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
							writeBuffer.put(bytes);
							writeBuffer.flip();
							result.write(writeBuffer, writeBuffer, new CompletionHandler<Integer,ByteBuffer>(){

								@Override
								public void completed(Integer _result, ByteBuffer attachment) {
									if(attachment.hasRemaining()){
										result.write(attachment,attachment,this);
									}
								}

								@Override
								public void failed(Throwable exc, ByteBuffer attachment) {
									try{
										result.close();
									}catch(IOException e){
										
									}
								}
								
							});
						}
						
					}

					@Override
					public void failed(Throwable exc, ByteBuffer attachment) {
						try{
							asynchronousServerSocketChannel.close();
						}catch(IOException e){
							e.printStackTrace();
						}
					}
					
				});
			}
	
			@Override
			public void failed(Throwable exc, AsyncTimeServerHandler attachment) {
				exc.printStackTrace();
				attachment.latch.countDown();
			}
		});
	}

}
