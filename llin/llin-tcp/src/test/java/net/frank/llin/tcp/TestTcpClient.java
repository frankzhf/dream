package net.frank.llin.tcp;

import java.nio.charset.Charset;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.concurrent.Promise;

import net.frank.llin.commons.SocketConnectResult;

public class TestTcpClient {

	public static void main(String[] args) {
		TcpClient client = new TcpClientImpl();
		client.connect("192.168.1.101", 14000, new TcpHandler() {

			@Override
			public void getPacketChannel(SocketChannel ch, Promise<SocketConnectResult> connectFuture) {
				ByteBuf byteBuf = Unpooled.copiedBuffer("\r".getBytes());
				ch.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, byteBuf));
				ch.pipeline().addLast(new StringEncoder());
				ch.pipeline().addLast(new StringDecoder());
				ch.pipeline().addLast(new MyHandle());
			}
		});
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			// E
		}

		String json = "{\"station_id\":\"liancang_wuxi1\",\"username\":\"admin\",\"userpwd\":\"shudt666\"}";
		ByteBuf dataBuf = Unpooled.copiedBuffer(json, Charset.forName("UTF-8"));
		client.sendAndFlushPacket(dataBuf);
	}
}
