package net.frank.llin.http;

import java.io.Serializable;

import io.netty.channel.ChannelHandlerContext;

public class Client implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6025820752563101902L;

	private String rtcId;
	
	private String nickname;
	
	private ChannelHandlerContext context;
	
	public Client(ChannelHandlerContext context) {
		this.context = context;
	}

	public String getRtcId() {
		return rtcId;
	}

	public void setRtcId(String rtcId) {
		this.rtcId = rtcId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public void sendMsg(String msg) {
		this.context.writeAndFlush(msg);
	}
	
}
