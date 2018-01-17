package net.frank.corejava0.jakarta.ch10;

import java.io.File;

import org.apache.commons.io.FileUtils;

public class FileSizeMail {
	public static void main(String[] args) {
		
		
		File file = new File("project.xml");
		long bytes = file.length();
		String display = FileUtils.byteCountToDisplaySize(bytes);
		System.out.println("File: project.xml");
		System.out.println("  bytes: " + bytes);
		System.out.println("  size: " + display);
		
		File dir = new File("temp");
		bytes = FileUtils.sizeOfDirectory(dir);
		display = FileUtils.byteCountToDisplaySize(bytes);
		System.out.println("Directory: "+dir.getAbsolutePath());
		System.out.println("  bytes: " + bytes);
		System.out.println("  size: " + display);
		
	}
}
