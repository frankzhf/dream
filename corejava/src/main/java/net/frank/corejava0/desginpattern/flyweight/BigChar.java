package net.frank.corejava0.desginpattern.flyweight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BigChar {
	private char charname;
	private String fontdata;
	public BigChar(char charname) {
		this.charname = charname;
		String runtimeDir = 
				getClass().getResource("/").getFile();
		try(BufferedReader reader = new BufferedReader(
				new FileReader(runtimeDir +"net/frank/corejava0/desginpattern/flyweight/big" + charname +".txt"))) {
			String line;
			StringBuilder sb = new StringBuilder(96);
			while((line = reader.readLine() )!= null) {
				sb.append(line);
				sb.append("\n");
			}
			reader.close();
			this.fontdata = sb.toString();
		}catch(IOException e) {
			System.out.println("load fontdata error [" + this.charname +"]");
		}
	}
	
	public void print() {
		System.out.println(fontdata);
	}
	
	public static void main(String[] args) {
		BigChar zero = new BigChar('0');
		zero.print();
	}
	
}
