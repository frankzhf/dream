package net.frank.demos.netty.udp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;
import java.util.List;

public class LogEventEncoder extends MessageToMessageEncoder<LogMsg> {

    private final InetSocketAddress remoteAddress;

    public LogEventEncoder(InetSocketAddress remoteAddress){
        this.remoteAddress = remoteAddress;
    }

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, LogMsg logMsg, List<Object> out){
        byte[] msg = logMsg.getMsg().getBytes(CharsetUtil.UTF_8);
        ByteBuf buf = channelHandlerContext.alloc()
                .buffer(8*2 + msg.length +1);
        buf.writeLong(logMsg.getTime());
        buf.writeLong(logMsg.getMsgId());
        buf.writeByte(LogMsg.SEPARATOR);
        buf.writeBytes(msg);
        out .add(new DatagramPacket(buf,remoteAddress));
    }

}
