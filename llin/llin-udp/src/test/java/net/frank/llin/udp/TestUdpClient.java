package net.frank.llin.udp;

import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.concurrent.Promise;

public class TestUdpClient {
	public static void main(String[] args) {
		UdpClient client = new UdpClientImpl();
		client.connect("localhost", 10001, new UdpHandler() {
			@Override
			public void getPacketChannel(NioDatagramChannel ch, Promise<UdpConnectResult> connectFuture) {
				// TODO Auto-generated method stub
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
		for(int i=0;i<3;i++) {
			client.sendAndFlushPacket("aa"+i);
		}
	}
}
