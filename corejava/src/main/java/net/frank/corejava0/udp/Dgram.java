package net.frank.corejava0.udp;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.nio.charset.Charset;

import net.frank.corejava0.crc.Crc16;

public class Dgram {
	public static DatagramPacket toDatagram(String s, InetAddress destIA, int destPort) {
		byte[] buf = new byte[s.length() + 1];
		s.getBytes(Charset.forName("utf-8"));
		return new DatagramPacket(buf, buf.length, destIA, destPort);
	}

	public static String toString(DatagramPacket p) {
		return new String(p.getData(), 0, p.getLength());
	}

	public static void main(String[] args) {
		byte[] value = new byte[6];

		value[0] = (byte) 0xaa;
		value[1] = 0x1;
		value[2] = 0x10;
		value[3] = 0x1;
		value[4] = 0x0;
		value[5] = (byte) 0xaa;

		int crc = Crc16.calcCrc16(value);
		System.out.println(crc);
	}

}
