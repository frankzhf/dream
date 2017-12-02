package net.frank.corejava0.netty.ch07;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.msgpack.MessagePack;
import org.msgpack.template.Templates;

public class SimpleSample {
	
	public static void main(String[] args) throws IOException{
		List<String> src = new ArrayList<String>();
		src.add("msgpack");
		src.add("kumofs");
		src.add("viver");
		
		MessagePack msgpack = new MessagePack();
		byte[] raw = msgpack.write(src);
		System.out.println(Arrays.toString(raw));
		
		List<String> dst1 = msgpack.read(raw, Templates.tList(Templates.TString));
		System.out.println(dst1.get(0));
		System.out.println(dst1.get(1));
		System.out.println(dst1.get(2));
		
	}
	
}
