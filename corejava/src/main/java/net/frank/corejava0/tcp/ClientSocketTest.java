package net.frank.corejava0.tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocketTest {

	public static void main(String[] args)throws Exception {
		Socket socket = new Socket("127.0.0.1",8189);
		System.out.println("Connected server");
		PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		boolean run = true;
		//Scanner scanner = new Scanner(in);
		Scanner outScanner = new Scanner(System.in);
		while(run){
			System.out.print("Enter your msg :");
			if(outScanner.hasNextLine()){
				String outgo = outScanner.nextLine();
				if("quit".equals(outgo)){
					run = false;
				}
				out.println(outgo);
			}
			String income = in.readLine();
			if(income !=null){
				System.out.println("Receive Server message:" + income );
				
			}
		}
		//scanner.close();
		outScanner.close();
		socket.close();
	}

}
