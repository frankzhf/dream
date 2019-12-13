package net.frank.demos.netty.action.ch09;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class FixedLengthFremeDecoder extends ByteToMessageDecoder {

    private final int frameLength;

    public FixedLengthFremeDecoder(int frameLength){
        if(frameLength <= 0){
            throw new IllegalArgumentException("frameLength must be apositive integer: " + frameLength);
        }
        this.frameLength = frameLength;
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out){
        while(in.readableBytes() >= frameLength){
            ByteBuf buf = in.readBytes(frameLength);
            out.add(buf);
        }
    }

}
