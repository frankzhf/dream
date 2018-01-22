package net.frank.corejava0.netty.ch12;

public interface Constants {
	interface MessageType {
		byte BNS_REQ = 0x00;
		byte BNS_RESP = 0x01;
		byte BNS_ONE_WAY = 0x02;
		byte LOGIN_REQ = 0x03;
		byte LOGIN_RESP = 0x04;
		byte HEART_REQ = 0x05;
		byte HEART_RESP = 0x06;
	}
	interface BooleanResult{
		byte TRUE = 0x00;
		byte FALSE = 0x01;
	}
}
