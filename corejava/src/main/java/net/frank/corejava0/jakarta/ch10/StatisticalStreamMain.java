package net.frank.corejava0.jakarta.ch10;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.output.CountingOutputStream;

public class StatisticalStreamMain {
	public static void main(String[] args) {
		File test = new File("test.dat");
		CountingOutputStream countStream = null;
		try(FileOutputStream fos = new FileOutputStream(test)) {
			countStream = new CountingOutputStream(fos);
			countStream.write("Hello".getBytes());
			int bytesWritten = countStream.getCount();
			System.out.println("Wrote "+ bytesWritten + " bytes to test.dat");
		}catch(IOException e) {
			System.out.println("Error writing bytes to file.");
		}
		/***
		 * CountingInputStream 反过来读的时候用
		 */
		
	}
}
