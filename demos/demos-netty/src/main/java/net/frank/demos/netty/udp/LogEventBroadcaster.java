package net.frank.demos.netty.udp;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;

import java.net.InetSocketAddress;

public class LogEventBroadcaster {

    private final EventLoopGroup group;
    private final Bootstrap bootstrap;

    public LogEventBroadcaster(InetSocketAddress remoteAddress){
        group = new NioEventLoopGroup();
        bootstrap = new Bootstrap();
        bootstrap.group(group).channel(NioDatagramChannel.class)
                .option(ChannelOption.SO_BROADCAST,true)
                .handler(new LogEventEncoder(remoteAddress));
    }

    public void run()throws Exception{
        Channel ch = bootstrap.bind(0).sync().channel();
        long count = 0;
        for(;;){
            ch.writeAndFlush(new LogMsg(null,++count,LogConst.getLogInfo()));
            try{
                Thread.sleep(2000);
            }catch (InterruptedException e){
                Thread.interrupted();
                break;
            }
        }
    }

    public void stop(){
        group.shutdownGracefully();
    }

    public static void main(String[] args) throws Exception{
        LogEventBroadcaster broadcaster = new LogEventBroadcaster(
                new InetSocketAddress("255.255.255.255", LogConst.MONITOR_SIDE_PORT)
        );
        try{
            broadcaster.run();
        }finally {
            broadcaster.stop();
        }
    }

}
