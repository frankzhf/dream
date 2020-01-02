package net.frank.demos.netty.action.ch12;

import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslHandler;

import javax.net.ssl.SSLEngine;

public class SecureChatServerInitialzer extends ChatServerInitializer{

    private final SslContext context;

    public SecureChatServerInitialzer(ChannelGroup group, SslContext context){
        super(group);
        this.context = context;
    }

    @Override
    protected void initChannel(Channel ch){
        super.initChannel(ch);
        SSLEngine engine = context.newEngine(ch.alloc());
        engine.setUseClientMode(false);
        ch.pipeline().addFirst(new SslHandler(engine));
    }

}