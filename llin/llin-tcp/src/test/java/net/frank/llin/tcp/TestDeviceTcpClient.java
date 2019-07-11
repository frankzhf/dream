package net.frank.llin.tcp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.concurrent.Promise;
import net.frank.llin.commons.SocketConnectResult;

public class TestDeviceTcpClient {
	public static void main(String[] args) {
		TcpClient client = new TcpClientImpl();
		client.connect("localhost", 10002, new TcpHandler() {
			@Override
			public void getPacketChannel(SocketChannel ch, Promise<SocketConnectResult> connectFuture) {
				ByteBuf delimiter = Unpooled.copiedBuffer("\r".getBytes());
				ch.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, delimiter));
				ch.pipeline().addLast(new StringEncoder());
				ch.pipeline().addLast(new StringDecoder());
			}
		});
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		client.sendAndFlushPacket("H 1 0 0 \r");
	}
}
