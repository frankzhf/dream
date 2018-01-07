package net.frank.corejava0.network.ch04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class SafeBufferedReader extends BufferedReader {
	
	public SafeBufferedReader(Reader in){
		this(in,1024);
	}
		
	public SafeBufferedReader(Reader in,int bufferSize) {
		super(in,bufferSize);
	}
	
	private boolean lookingForLineFeed = false;
	
	public String readLine()throws IOException {
		StringBuilder sb = new StringBuilder(16);
		while(true) {
			int c = read();
			if(c==-1) {
				if("".equals(sb.toString())) {
					return null;
				}
				return sb.toString();
			}else if (c=='\n'){
				if(lookingForLineFeed) {
					lookingForLineFeed = false;
					continue;
				}else {
					return sb.toString();
				}
			}else if(c=='\r') {
				lookingForLineFeed = true;
				return sb.toString();
			}else {
				lookingForLineFeed = false;
				sb.append((char)c);
			}
			
		}
		
		
		
	}
	
	
}
