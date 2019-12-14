package net.frank.demos.netty.action.ch10;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.TooLongFrameException;

import java.util.List;

public class SafeByteToMessageDecoder extends ByteToMessageDecoder {

    private static final int MAX_FRAME_SIZE = 1024;

    @Override
    public void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out){
        int readable = in.readableBytes();
        if(readable > MAX_FRAME_SIZE){
            in.skipBytes(readable);
            throw new TooLongFrameException("Frame too big.");
        }
    }

}
