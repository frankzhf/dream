package net.frank.tiger.netty;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;

public class TigerServer {
	
	private transient Logger log = LoggerFactory.getLogger(getClass());
	
	static private ZipOutputStream zip = null;
	static private final int _4M = 4*1024*1024;
	static private Robot robot = null;
	static private BufferedImage mouseIcon = null;
	
	static private Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	static private Rectangle rect = new Rectangle(screen);
	
	public TigerServer() {
		try {
			robot= new Robot();
			mouseIcon = ImageIO
					.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("mouse.jpg"));
		}catch(Exception e) {
			log.error(e.getMessage(),e);
		}
	}
	
	
	public void connect(int port) throws Exception {
		EventLoopGroup group = new NioEventLoopGroup();
		
		new Timer().scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				try(ZipOutputStream innerZip = new ZipOutputStream(
						new DataOutputStream(new ByteBufOutputStream(Unpooled.buffer(_4M))))){
					innerZip.setLevel(9);
					BufferedImage img = robot.createScreenCapture(rect);
					Point point = MouseInfo.getPointerInfo().getLocation();
					Graphics graphics = img.createGraphics();
					graphics.drawImage(mouseIcon, point.x, point.y, 10, 10, null);
					
					innerZip.putNextEntry(new ZipEntry("screen.jpg"));
					ImageIO.write(img, "jpg", zip);
					zip = innerZip;
				}catch(IOException e) {
					log.error(e.getMessage(),e );
				}
				
			}
		}, 10, 50);
		
		
		try {
			Bootstrap b = new Bootstrap();
			b.group(group).channel(NioDatagramChannel.class).
				option(ChannelOption.SO_BROADCAST, true).// 支持广播
				handler(new TigerHandler());
			ChannelFuture f = b.bind(port).sync();
			f.channel().closeFuture().sync();
		} finally {
			group.shutdownGracefully();
		}
	}

	public static void main(String[] args) throws Exception {
		new TigerServer().connect(8002);
	}

	static class TigerHandler extends SimpleChannelInboundHandler<DatagramPacket> {
		
		@Override
	    public void channelActive(ChannelHandlerContext ctx) throws Exception {
			InetSocketAddress insocket = (InetSocketAddress) ctx.channel().localAddress();
			String localIp = insocket.getAddress().getHostAddress();
			String broadcaseIp = localIp.substring(0,localIp.lastIndexOf(".")) + ".255";
			InetSocketAddress targetAddress = InetSocketAddress.createUnresolved(broadcaseIp, 8002);
	        ctx.executor().scheduleAtFixedRate(new Runnable() {
				@Override
				public void run() {
					ByteBuf dataBuf = Unpooled.copiedBuffer("TTTTTTTTTTT", Charset.forName("UTF-8"));
					DatagramPacket datagramPacket = new DatagramPacket(dataBuf, targetAddress);
					ctx.writeAndFlush(datagramPacket);
				}
	        }, 100, 50, TimeUnit.MILLISECONDS);
	    }

		@Override
		protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket msg) throws Exception {
			
		}

	}
	
}
