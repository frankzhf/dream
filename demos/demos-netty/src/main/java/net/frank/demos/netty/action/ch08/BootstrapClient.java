package net.frank.demos.netty.action.ch08;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

public class BootstrapClient {

    public static void main(String[] args){
        new BootstrapClient().bootstrap();
    }

    public void bootstrap(){
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .handler(new SimpleChannelInboundHandler<ByteBuf>() {
                    @Override
                    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg){
                        System.out.println("Received data");
                    }
                });
        ChannelFuture future = bootstrap.connect(new InetSocketAddress("www.manning.com",80));
        future.addListener((channelFuture)-> {
            if(channelFuture.isSuccess()){
                System.out.println("Connection established");
            }else{
                System.err.println("Connection attempt failed");
                channelFuture.cause().printStackTrace();
            }
        });

    }

    /****

     channel
        |----nio
        |           NioEventLoopGroup
        |----oio
        |           OioEventLoopGroup
        |
        |----socket
                |---nio
                |       NioDatagramChannel
                |       NioServerSocketChannel
                |       NioSocketChannel
                |
                |---oio
                        OioDatagramChannel
                        OioServerSocketChannel
                        OioSocketChannel





     */

}
