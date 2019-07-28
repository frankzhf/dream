package net.frank.llin.http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

public class WebSocketChannelInitaializer extends ChannelInitializer<SocketChannel> {
	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();
		// HttpServerCodec: 针对http协议进行编解码
		pipeline.addLast(new HttpServerCodec());
		// ChunkedWriteHandler分块写处理，文件过大会将内存撑爆
		pipeline.addLast(new ChunkedWriteHandler());

		pipeline.addLast(new HttpObjectAggregator(8192));
		pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));
		pipeline.addLast(new VedioStreamHandler());
	}
}
