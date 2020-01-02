package net.frank.demos.netty.action.ch13;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.util.CharsetUtil;

import java.util.List;

public class LogEventDecoder extends MessageToMessageDecoder<DatagramPacket> {

    @Override
    protected void decode(ChannelHandlerContext ctx,
                          DatagramPacket datagramPacket, List<Object> out){
        ByteBuf data = datagramPacket.content();
        long sendTime = data.readLong();
        System.out.println("接受到" +sendTime+ "发送的消息");
        long msgId = data.readLong();
        byte sepa = data.readByte();
        int idx = data.readerIndex();
        String sendMsg = data.slice(idx,data.readableBytes()).toString(CharsetUtil.UTF_8);
        LogMsg event = new LogMsg(datagramPacket.sender(),msgId,sendMsg);
        out.add(event);
    }
}
