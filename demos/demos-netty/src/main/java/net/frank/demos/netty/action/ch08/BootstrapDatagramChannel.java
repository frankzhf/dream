package net.frank.demos.netty.action.ch08;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.oio.OioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.oio.OioDatagramChannel;

import java.net.InetSocketAddress;

public class BootstrapDatagramChannel {

    public void bootstrap(){
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(new OioEventLoopGroup())
                .channel(OioDatagramChannel.class)
                .handler(new SimpleChannelInboundHandler<DatagramPacket>() {
                    @Override
                    protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket msg){
                        //do something.
                    }
                });
        ChannelFuture future = bootstrap.bind(new InetSocketAddress(0));
        future.addListener((channelFuture)->{
           if(channelFuture.isSuccess()){
               System.out.println("Channel bound");
           }else{
               System.err.println("Bind attempt failed");
               channelFuture.cause().printStackTrace();
           }
        });
    }

    public static void main(String[] args){
        new BootstrapDatagramChannel().bootstrap();
    }
}
