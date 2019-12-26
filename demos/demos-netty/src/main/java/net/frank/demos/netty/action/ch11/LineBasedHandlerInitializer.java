package net.frank.demos.netty.action.ch11;

import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.handler.codec.LineBasedFrameDecoder;

public class LineBasedHandlerInitializer extends ChannelInitializer<Channel> {


    /***
     * 二个常用到的分割符协议
     * DelimiterBasedFrameDecoder       指定分割符
     * LineBasedFrameDecoder            行分割
     *
     */


    @Override
    protected void initChannel(Channel ch){
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new LineBasedFrameDecoder(64*1024));
        pipeline.addLast(new FrameHandler());
    }


    public static final class FrameHandler extends SimpleChannelInboundHandler<ByteBuf> {

        @Override
        public void channelRead0(ChannelHandlerContext ctx, ByteBuf msg){

        }

    }


}
