package net.frank.corejava0.netty.ch07;

import org.msgpack.MessagePack;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class MsgpackEncoder extends MessageToByteEncoder<UserInfo> {
	
	@Override
	protected void encode(ChannelHandlerContext ctx, UserInfo msg, ByteBuf out) throws Exception {
		MessagePack  msgpack = new MessagePack();
		byte[] raw = msgpack.write(msg);
		out.writeBytes(raw);
	}

}
