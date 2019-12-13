package net.frank.demos.netty.action.ch08;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.Future;

import java.net.InetSocketAddress;

public class BootstrapServer {


    public void bootstrap(){
        NioEventLoopGroup group = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(group,new NioEventLoopGroup())
                .channel(NioServerSocketChannel.class)
                .childHandler(new SimpleChannelInboundHandler<ByteBuf>() {
                    @Override
                    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg){
                        System.out.println("Received data");
                    }
                });
        ChannelFuture future = bootstrap.bind(new InetSocketAddress(8080));
        future.addListener((channelFuture)->{
           if(channelFuture.isSuccess()){
               System.out.println("Server bound");
           }else{
               System.err.println("Bind attempt failed");
               channelFuture.cause().printStackTrace();
           }
        });
        try {
            Thread.sleep(10000);
        }catch (InterruptedException e){

        }

        Future shutdownFuture = group.shutdownGracefully();
        shutdownFuture.syncUninterruptibly();

    }

    public static void main(String[] args){
        new BootstrapServer().bootstrap();
    }

}
