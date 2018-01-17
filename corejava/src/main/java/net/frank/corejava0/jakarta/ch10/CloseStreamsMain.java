package net.frank.corejava0.jakarta.ch10;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.io.IOUtils;

public class CloseStreamsMain {
	public static void main(String[] args){
		String result = "";
		File file = new File("test.dat");
		try(Reader reader = new FileReader(file)){
			result = IOUtils.toString(reader);
			System.out.println("Variable [result] -> " + result);
		}catch(IOException ioe) {
			System.out.println("Unable to copy file test.dat to a String.");
		}
	}
}
