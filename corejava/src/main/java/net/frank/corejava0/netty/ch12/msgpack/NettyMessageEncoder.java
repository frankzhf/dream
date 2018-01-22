package net.frank.corejava0.netty.ch12.msgpack;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import net.frank.corejava0.netty.ch12.NettyMessage;

public final class NettyMessageEncoder extends MessageToByteEncoder<NettyMessage> {
	@Override
	protected void encode(ChannelHandlerContext ctx, NettyMessage msg, ByteBuf out) throws Exception {
		byte[] _msg = Global.writeMessage(msg);
		out.writeBytes(_msg);
	}
}
