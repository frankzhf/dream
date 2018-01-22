package net.frank.corejava0.netty.ch12.msgpack;

import java.io.IOException;

import org.msgpack.MessagePack;

import net.frank.corejava0.netty.ch12.NettyMessage;

public final class Global {
	static MessagePack pack = new MessagePack();
	
	public static byte[] writeMessage(NettyMessage msg) {
		try {
			return pack.write(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static NettyMessage readMessage(byte[] _msg) {
		try {
			return pack.convert(pack.read(_msg),NettyMessage.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
