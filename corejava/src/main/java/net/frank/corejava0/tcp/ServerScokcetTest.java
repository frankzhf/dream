package net.frank.corejava0.tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerScokcetTest {
	public static void main(String[] args)throws Exception{
		ServerSocket server = new ServerSocket(8189);
		System.out.println("Server startup!");
		Socket socket = server.accept();
		System.out.println("Client connected!");
		PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		boolean run = true;
		Scanner outScanner = new Scanner(System.in);
		while(run){
			String income = in.readLine();
			if(income !=null){
				System.out.println("Receive Cleint message:" + income );
				System.out.print("Enter your reply :");
				if(outScanner.hasNextLine()){
					String outgo = outScanner.nextLine();
					if("quit".equals(outgo)){
						run = false;
					}
					out.println(outgo);
				}	
			}
		}
		outScanner.close();
		server.close();
	}
	
	
}
