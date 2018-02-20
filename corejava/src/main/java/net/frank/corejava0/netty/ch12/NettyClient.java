package net.frank.corejava0.netty.ch12;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.jboss.marshalling.MarshallerFactory;
import org.jboss.marshalling.Marshalling;
import org.jboss.marshalling.MarshallingConfiguration;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.marshalling.DefaultMarshallerProvider;
import io.netty.handler.codec.marshalling.DefaultUnmarshallerProvider;
import io.netty.handler.codec.marshalling.MarshallerProvider;
import io.netty.handler.codec.marshalling.MarshallingDecoder;
import io.netty.handler.codec.marshalling.MarshallingEncoder;
import io.netty.handler.codec.marshalling.UnmarshallerProvider;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.ReadTimeoutHandler;
import net.frank.corejava0.netty.ch12.handler.HeartBeatReqHandler;
import net.frank.corejava0.netty.ch12.handler.LoginAuthReqHandler;

public class NettyClient {
	
	private ScheduledExecutorService executor = 
			Executors.newScheduledThreadPool(1);
	EventLoopGroup group = new NioEventLoopGroup();
	public void connect(final int port, final String host) throws Exception {
		try {
			Bootstrap boot = new Bootstrap();
			boot.group(group).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true)
					.handler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							final MarshallerFactory marshallerFactory = Marshalling
									.getProvidedMarshallerFactory("serial");
							final MarshallingConfiguration configuration = new MarshallingConfiguration();
							configuration.setVersion(5);
							MarshallerProvider marshallerProvider = new DefaultMarshallerProvider(marshallerFactory,
									configuration);
							UnmarshallerProvider UnmarshallerProvider = new DefaultUnmarshallerProvider(
									marshallerFactory, configuration);
							ch.pipeline().addLast("logging",new LoggingHandler(LogLevel.INFO));
							ch.pipeline().addLast(new MarshallingDecoder(UnmarshallerProvider));
							ch.pipeline().addLast("MessageEncoder", new MarshallingEncoder(marshallerProvider));
							ch.pipeline().addLast("readTimeoutHandler",new ReadTimeoutHandler(50));
							ch.pipeline().addLast("LoginAuthHandler",new LoginAuthReqHandler());
							ch.pipeline().addLast("HeartBeatHandler",new HeartBeatReqHandler());
						}
					});
			ChannelFuture f = boot.connect(new InetSocketAddress(host, port)).sync();
			f.channel().closeFuture().sync();
		} finally {
			executor.execute(new Runnable() {
				@Override
				public void run() {
					try {
						TimeUnit.SECONDS.sleep(5);
						try {
							connect(port,host);
						}catch(Exception e) {
							e.printStackTrace();
						}
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
	}

	public static void main(String[] args) throws Exception {
		int port = 8080;
		if (args != null && args.length > 0) {
			try {
				port = Integer.valueOf(args[0]);
			} catch (NumberFormatException e) {
				port = 8080;
			}
		}
		new NettyClient().connect(port, "127.0.0.1");
	}
}
