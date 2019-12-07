package net.frank.demos.netty.action.ch06;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.socket.nio.NioSocketChannel;

public class ChannelFutures {
	private static final Channel CHANNEL_FROM_SOMEWHERE
		= new NioSocketChannel();
	
	private static final ByteBuf SOME_MSG_FROM_SOMEWHERE
		= Unpooled.buffer(1024);
	
	public static void ajddingChannelFutureListener() {
		Channel channel = CHANNEL_FROM_SOMEWHERE;
		ByteBuf someMessage = SOME_MSG_FROM_SOMEWHERE;
		
		ChannelFuture f = channel.write(someMessage);
		f.addListener(new ChannelFutureListener() {
			@Override
			public void operationComplete(ChannelFuture future) throws Exception {
				if(!future.isSuccess()) {
					future.cause().printStackTrace();
					future.channel().close();
				}
			}
		});
	}
}
