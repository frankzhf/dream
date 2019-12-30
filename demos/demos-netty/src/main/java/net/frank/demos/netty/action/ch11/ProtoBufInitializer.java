package net.frank.demos.netty.action.ch11;

import com.google.protobuf.MessageLite;
import io.netty.channel.*;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;

public class ProtoBufInitializer extends ChannelInitializer<Channel> {

    private final MessageLite lite;

    public ProtoBufInitializer(MessageLite lite){
        this.lite = lite;
    }

    @Override
    protected void initChannel(Channel channel){
        ChannelPipeline pipeline = channel.pipeline();
        pipeline.addLast(new ProtobufVarint32FrameDecoder());
        pipeline.addLast(new ProtobufEncoder());
        pipeline.addLast(new ProtobufDecoder(lite));
        pipeline.addLast(new ObjectHandler());
    }


    public static final class ObjectHandler
            extends SimpleChannelInboundHandler<Object>{
        @Override
        public void channelRead0(ChannelHandlerContext ctx, Object msg){

        }
    }

}
