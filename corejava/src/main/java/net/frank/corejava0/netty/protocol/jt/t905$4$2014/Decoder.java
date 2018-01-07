package net.frank.corejava0.netty.protocol.jt.t905$4$2014;

import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public class Decoder extends ByteToMessageDecoder {
	
	private int maxLengthLimit;
	//private byte
	
	
	//private byte
	
	
	
	public Decoder(int maxLengthLimit, ByteBuf startFlag,ByteBuf endFlage, boolean stripDelimiter, boolean failFast) {
		
	}
	
	
	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
		int dataLength = in.readableBytes();
		Object last = null;
		
		for(int i=0;i<dataLength;i++) {
			
		}
	}

}
