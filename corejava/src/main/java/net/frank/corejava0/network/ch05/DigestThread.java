package net.frank.corejava0.network.ch05;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DigestThread extends Thread {
	private File input;
	public DigestThread(File input) {
		this.input = input;
	}
	
	public void run() {
		try {
			FileInputStream in = new FileInputStream(input);
			MessageDigest sha = MessageDigest.getInstance("SHA");
			DigestInputStream din = new DigestInputStream(in,sha);
			@SuppressWarnings("unused")
			int b =-1;
			while((b =din.read())!=-1);
			din.close();
			byte[] digest = sha.digest();
			StringBuilder result = new StringBuilder(input.toString());
			result.append(":");
			for(int i=0;i<digest.length;i++) {
				result.append(digest[i] + " ");
			}
			System.out.println(result.toString());
		}catch(IOException e) {
			System.err.println(e);
		}catch(NoSuchAlgorithmException e) {
			System.err.println(e);
		}
	}
	
	public static void main(String[] args) {
		File f = new File("/Users/zhaofeng/hongzhi/git/hongzhi2017/src/net/zhongzhi/basejava/demo/ch06");
		File[] list = f.listFiles();
		
		
		for(int i=0;i<list.length;i++) {
			File child =list[i];
			Thread t = new DigestThread(child);
			t.start();
		}
		
		
		
		
		
	}
	
}
