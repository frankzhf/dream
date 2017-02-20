package net.frank.corejava2.ch03;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class InterruptibleSocketTest {
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable(){

			@Override
			public void run() {
				JFrame frame = new InterruptibleSocketFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
			
		});
	}
}

class InterruptibleSocketFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6602117825226816533L;
	public static final int WIDTH = 300;
	public static final int HEIGHT = 300;
	
	private JTextArea messages;
	private JButton interruptibleButton;
	private JButton blockingButton;
	private JButton cancelButton;
	private Thread connectThread;
	private TestServer server;
	private Scanner in;
	
	public InterruptibleSocketFrame(){
		setSize(WIDTH,HEIGHT);
		setTitle("InterruptibleSocketTest");
		JPanel northPanel = new JPanel();
		add(northPanel,BorderLayout.NORTH);
		
		messages = new JTextArea();
		add(new JScrollPane(messages));
		
		interruptibleButton = new JButton("Interruptible");
		blockingButton = new JButton("Blocking");
		cancelButton = new JButton("Cancel");
		cancelButton.setEnabled(false);
		
		northPanel.add(interruptibleButton);
		northPanel.add(blockingButton);
		northPanel.add(cancelButton);
		
		interruptibleButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				interruptibleButton.setEnabled(false);
				blockingButton.setEnabled(false);
				cancelButton.setEnabled(true);
				connectThread = new Thread(new Runnable(){
					@Override
					public void run() {
						try{
							connectInterruptible();
						}catch(IOException e){
							messages.append("\nInterruptibleSocketTest.connectInterruptible.");
						}
						
					}
				});
				connectThread.start();
			}
		});
		
		blockingButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				interruptibleButton.setEnabled(false);
				blockingButton.setEnabled(false);
				cancelButton.setEnabled(true);
				connectThread = new Thread(new Runnable(){
					@Override
					public void run() {
						try{
							connectBlocking();
						}catch(IOException e){
							messages.append("\nInterruptibleSocketTest.connectBlocking.");
						}
						
					}
				});
				connectThread.start();
			}
		});
		
		cancelButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				connectThread.interrupt();
				cancelButton.setEnabled(false);
			}
		});
		
		server = new TestServer();
		new Thread(server).start();
		
		
	}
	
	public void connectInterruptible()throws IOException {
		messages.append("Interruptible:\n");
		SocketChannel channel = SocketChannel.open(new InetSocketAddress("localhost",8189));
		try{
			in = new Scanner(channel);
			while(!Thread.currentThread().isInterrupted()){
				messages.append("Reading ");
				if(in.hasNextLine()){
					String line = in.nextLine();
					messages.append(line);
					messages.append("\n");
				}
			}
		}finally{
			channel.close();
			EventQueue.invokeLater(new Runnable(){
				@Override
				public void run() {
					messages.append("Channel closed\n");
					interruptibleButton.setEnabled(true);
					blockingButton.setEnabled(true);
				}
				
			});
		}
	}
	
	public void connectBlocking()throws IOException {
		messages.append("Blocking:\n");
		Socket socket = new Socket("localhost",8189);
		try{
			in = new Scanner(socket.getInputStream());
			while(!Thread.currentThread().isInterrupted()){
				messages.append("Reading ");
				if(in.hasNextLine()){
					String line = in.nextLine();
					messages.append(line);
					messages.append("\n");
				}
			}
		}finally{
			socket.close();
			EventQueue.invokeLater(new Runnable(){
				@Override
				public void run() {
					messages.append("Socket closed\n");
					interruptibleButton.setEnabled(true);
					blockingButton.setEnabled(true);
				}
				
			});
		}
	}
	
	
	class TestServer implements Runnable{

		@Override
		public void run() {
			ServerSocket s = null;
			try{
				s= new ServerSocket(8189);
				while(true){
					Socket incoming = s.accept();
					Runnable r = new TestServerHandler(incoming);
					Thread t = new Thread(r);
					t.start();
				}
			}catch(IOException e){
				messages.append("\nTestServer.run: " + e);
			}finally{
				if(!s.isClosed()){
					try {
						s.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
	}
	
	class TestServerHandler implements Runnable{
		private Socket incoming;
		private int counter;
		public TestServerHandler(Socket i){
			this.incoming = i;
		}
		
		@Override
		public void run() {
			try{
				OutputStream outStream = incoming.getOutputStream();
				PrintWriter out = new PrintWriter(outStream,true);
				while(counter < 100){
					counter++;
					if(counter<=10){
						out.println(counter);
					}
					Thread.sleep(100);
				}
				incoming.close();
				messages.append("Closeing server\n");
			}catch(Exception e){
				messages.append("\nTestServerHandle.run: " + e);
			}
		}
		
	}
}
