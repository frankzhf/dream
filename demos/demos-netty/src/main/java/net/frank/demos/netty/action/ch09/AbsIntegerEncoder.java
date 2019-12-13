package net.frank.demos.netty.action.ch09;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

public class AbsIntegerEncoder  extends MessageToMessageEncoder<ByteBuf>{
    @Override
    protected void encode(ChannelHandlerContext ctc, ByteBuf in, List<Object> out){
        while(in.readableBytes() >=4){
            int value = Math.abs(in.readInt());
            out.add(value);
        }
    }
}
