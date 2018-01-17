package net.frank.corejava0.jakarta.ch10;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;

import org.apache.commons.io.IOUtils;

public class CopyStreamsMail {

	public static void main(String[] args) {
		try {
			Writer writer = new FileWriter("test.dat");
			InputStream inputStream = CopyStreamsMail.class.getResourceAsStream("./test.resource");
			IOUtils.copy(inputStream, writer,"UTF-8");
			writer.close();
			inputStream.close();
		}catch(IOException e) {
			System.out.println("Error copying data.");
		}
	}

}
