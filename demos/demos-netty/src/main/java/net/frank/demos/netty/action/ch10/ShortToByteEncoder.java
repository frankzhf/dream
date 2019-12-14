package net.frank.demos.netty.action.ch10;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class ShortToByteEncoder extends MessageToByteEncoder<Short> {

    @Override
    public void encode(ChannelHandlerContext ctx, Short msg, ByteBuf out){
        out.writeShort(msg);
    }
}
