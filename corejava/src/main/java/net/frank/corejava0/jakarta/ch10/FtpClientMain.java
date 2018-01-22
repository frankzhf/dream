package net.frank.corejava0.jakarta.ch10;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class FtpClientMain {

	public static void main(String[] args) {
		download();
		listFiles();
	}
	
	
	private static void listFiles() {
		FTPClient client = new FTPClient();
		try {
			client.connect("ftp.ibiblio.org");
			client.login("anonymous", "");
			String remoteDir = "/pub/mirrors/apache/jakarta/ecs/binaries";
			FTPFile[] remoteFiles = client.listFiles(remoteDir);
			System.out.println("Files in " + remoteDir);
			for(int i=0;i<remoteFiles.length;i++) {
				String name = remoteFiles[i].getName();
				long length = remoteFiles[i].getSize();
				String readableLength = FileUtils.byteCountToDisplaySize(length);
				System.out.println(name+":\t\t"+readableLength);
			}
		}catch(IOException e) {
			System.out.println("Error communicating with FTP server.");
		}finally {
			try {
				client.disconnect();
			}catch(IOException e) {
				System.out.println("Problem disconnectiong from FTP server.");
			}
		}
	}


	private static void download() {
		FTPClient client = new FTPClient();
		try (OutputStream outStream = new FileOutputStream("c64bus.gif");){
			client.connect("ftp.ibiblio.org");
			client.login("anonymous", "");
			String remoteFile = "/pub/micro/commodore/schematics/computers/c64/c64bus.gif";
			client.retrieveFile(remoteFile, outStream);
		}catch(IOException e) {
			System.out.println("Error communicating with FTP server.");
		}finally {
			try {
				client.disconnect();
			}catch(IOException e) {
				System.out.println("Problem disconnectiong from FTP server.");
			}
		}
	}

}
