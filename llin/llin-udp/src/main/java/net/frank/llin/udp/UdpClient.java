package net.frank.llin.udp;

import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.util.concurrent.Future;
import net.frank.llin.commons.IClient;
import net.frank.llin.commons.SocketConnectResult;

public interface UdpClient extends IClient {

	/***
	 * 
	 * @param host
	 * @param port
	 * @return
	 */
	Future<SocketConnectResult> connect(String host, int port, UdpHandler udpHandler);

	/**
	 * 获取 netty {@link EventLoopGroup}
	 * 
	 * @return
	 */
	EventLoopGroup getEventLoop();

	/**
	 * 设置 netty {@link EventLoopGroup}
	 *
	 * @param eventLoop
	 */
	void setEventLoop(EventLoopGroup eventLoop);

	/**
	 * tcp发消息
	 * 
	 * @param message
	 * @return
	 */
	ChannelFuture sendAndFlushPacket(Object message);
}