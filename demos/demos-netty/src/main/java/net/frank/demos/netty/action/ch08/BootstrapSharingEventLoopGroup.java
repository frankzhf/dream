package net.frank.demos.netty.action.ch08;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

public class BootstrapSharingEventLoopGroup {


    public void bootstrap(){
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(new NioEventLoopGroup(),new NioEventLoopGroup())
                .channel(NioServerSocketChannel.class)
                .childHandler(new SimpleChannelInboundHandler<ByteBuf>() {
                    private ChannelFuture connectFuture;

                    @Override
                    public void channelActive(ChannelHandlerContext ctx){
                        Bootstrap bootstrap = new Bootstrap();
                        bootstrap.group(ctx.channel().eventLoop())
                                .channel(NioSocketChannel.class)
                                .handler(new SimpleChannelInboundHandler<ByteBuf>() {
                                    @Override
                                    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg){
                                        System.out.println("Received data");
                                    }
                                });
                        connectFuture = bootstrap.connect(
                                new InetSocketAddress("www.manning.com",80));

                    }

                    @Override
                    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg){
                        if(connectFuture.isDone()){
                            System.out.println("Client connect success.");
                        }
                    }
                });
        ChannelFuture future = bootstrap.bind(new InetSocketAddress(8080));
        future.addListener((channelFuture)->{
           if(channelFuture.isSuccess()){
               System.out.println("Server bound");
           }else{
               System.err.println("Bind attempt failed.");
               channelFuture.cause().printStackTrace();
           }
        });
    }

    public static void main(String[] args){
        new BootstrapSharingEventLoopGroup().bootstrap();
    }


}
