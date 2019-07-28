package net.frank.llin.http;

import java.net.InetSocketAddress;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class WebSocketServer {
	public static void main(String args[]) throws Exception {
        EventLoopGroup boosGrop = new NioEventLoopGroup();
        EventLoopGroup workerGrop = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            //使用服务端初始化自定义类WebSocketChannelInitaializer
            serverBootstrap.group(boosGrop, workerGrop).
            	channel(NioServerSocketChannel.class).
            	childHandler(new WebSocketChannelInitaializer());
 
            //使用了不同的端口绑定方式
            ChannelFuture channelFuture = serverBootstrap.bind(new InetSocketAddress(8899)).sync();
            //关闭连接
            channelFuture.channel().closeFuture().sync();
        } finally {
            //优雅关闭
            boosGrop.shutdownGracefully();
            workerGrop.shutdownGracefully();
        }
    }

}
