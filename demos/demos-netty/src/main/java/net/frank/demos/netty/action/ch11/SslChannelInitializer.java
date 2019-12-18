package net.frank.demos.netty.action.ch11;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslHandler;

import javax.net.ssl.SSLEngine;

public class SslChannelInitializer extends ChannelInitializer<Channel>{

    private final SslContext context;
    private final boolean startTls;

    public SslChannelInitializer(SslContext context, boolean startTls){
        this.context = context;
        this.startTls = startTls;
    }


    @Override
    protected void initChannel(Channel ch){
        SSLEngine engine = context.newEngine(ch.alloc());
        ch.pipeline().addFirst(
                new SslHandler(engine,startTls)
        );
    }
}
