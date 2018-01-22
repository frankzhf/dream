package net.frank.corejava0.jakarta.ch10;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.io.output.TeeOutputStream;

public class TeeOutputStreamMain {

	public static void main(String[] args) {
		File test1 = new File("split1.txt");
		File test2 = new File("split2.txt");
		try(
			FileOutputStream fos1 = new FileOutputStream(test1);
			FileOutputStream fos2 = new FileOutputStream(test2);
			OutputStream outStream = new TeeOutputStream(fos1,fos2);
				){
			outStream.write("One Two Three, Test.".getBytes());
			outStream.flush();
		}catch(IOException e) {
			System.out.println("Error writing to split output stream.");
		}
	}

}
