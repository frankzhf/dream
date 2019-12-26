package net.frank.demos.netty.action.ch11;

import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

public class LengthBasedInitializer extends ChannelInitializer<Channel> {


    /***
     *
     * FixedLengthFrameDecoder              指定帧长度
     * LengthFieldBasedFrameDecoder         从指定的帧长度定义中解码
     */

    @Override
    protected void initChannel(Channel ch){
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new LengthFieldBasedFrameDecoder(64*1024,0,8));
        pipeline.addLast(new FrameHandler());
    }


    public static final class FrameHandler extends SimpleChannelInboundHandler<ByteBuf>{
        @Override
        public void channelRead0(ChannelHandlerContext ctx, ByteBuf msg){

        }
    }


}
