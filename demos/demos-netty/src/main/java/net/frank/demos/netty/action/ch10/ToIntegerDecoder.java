package net.frank.demos.netty.action.ch10;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class ToIntegerDecoder extends ByteToMessageDecoder {

    /**
     * 可读字节超过4，转换成整型
     * @param ctx
     * @param in
     * @param out
     */
    @Override
    public void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out){
        if(in.readableBytes()>=4){
            out.add(in.readInt());
        }
    }

}
