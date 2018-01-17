package net.frank.corejava0.jakarta.ch10;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;

public class CopyFileStringUrlMail {

	public static void main(String[] args) {
		try {
			File src = new File("test.dat");
			File dest = new File("test.dat.bak");
			FileUtils.copyFile(src, dest);
		}catch(IOException e) {
			System.out.println("Problem copying file.");
		}
		
		try {
			File src = new File("test.dat");
			File dir = new File("./temp");
			FileUtils.copyFileToDirectory(src, dir);
		}catch(IOException e) {
			System.out.println("Problem copying file to dir.");
		}
		
		try {
			String string = "Blah blah blah";
			File dest = new File("test.tmp");
			FileUtils.writeStringToFile(dest, string, Charset.forName("UTF-8"), true);
		}catch(IOException e){
			System.out.println("Problem write String to file.");
		}
		
		
		try {
			URL src = new URL("http://news.163.com");
			File dest = new File("test.tmp");
			FileUtils.copyURLToFile(src, dest);
		}catch(IOException e){
			System.out.println("Error copying contents of a URL to a file.");
		}
		
		try {
			File dir = new File("temp");
			FileUtils.deleteDirectory(dir);
		}catch(IOException e){
			System.out.println("Error delete directory.");
		}
		
		try {
			File dir = new File("temp");
			FileUtils.cleanDirectory(dir);
		}catch(IOException e){
			System.out.println("Problem cleaning a directory.");
		}
		
		try {
			File file = new File("testFile.txt");
			FileUtils.touch(file);
		}catch(IOException e){
			System.out.println("Error touching testFile.");
		}
	}
}
