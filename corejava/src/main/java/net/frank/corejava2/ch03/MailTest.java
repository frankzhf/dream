package net.frank.corejava2.ch03;

import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

import net.frank.corejava2.GBC;

public class MailTest {
	
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable(){

			@Override
			public void run() {
				JFrame frame = new MailTestFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
			
		});
	}
	
	
}


class MailTestFrame extends JFrame{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7947322949209539251L;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 300;
	
	private Scanner in;
	private PrintWriter out;
	private JTextField from;
	private JTextField to;
	private JTextField smtpServer;
	private JTextArea message;
	private JTextArea comm;
	
	public MailTestFrame(){
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		setTitle("MailTest");
		setLayout(new GridBagLayout());
		add(new JLabel("From:"), new GBC(0,0).setFill(GBC.HORIZONTAL));
		from = new JTextField(20);
		add(from,new GBC(1,0).setFill(GBC.HORIZONTAL).setWeight(100, 0));
		
		add(new JLabel("To:"), new GBC(0,1).setFill(GBC.HORIZONTAL));
		to = new JTextField(20);
		add(to,new GBC(1,1).setFill(GBC.HORIZONTAL).setWeight(100, 0));
		
		add(new JLabel("SMTP Server:"), new GBC(0,2).setFill(GBC.HORIZONTAL));
		smtpServer = new JTextField(20);
		add(smtpServer,new GBC(1,2).setFill(GBC.HORIZONTAL).setWeight(100, 0));
		
		message = new JTextArea();
		add(new JScrollPane(message),new GBC(0,3,2,1).setFill(GBC.BOTH).setWeight(100, 100));
		
		comm = new JTextArea();
		add(new JScrollPane(comm),new GBC(0,4,2,1).setFill(GBC.BOTH).setWeight(100, 100));
		
		JPanel buttonPanel = new JPanel();
		add(buttonPanel,new GBC(0,5,2,1));
		
		JButton sendButton = new JButton("Send");
		buttonPanel.add(sendButton);
		
		sendButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SwingWorker<Void,Void>(){
					@Override
					protected Void doInBackground() throws Exception {
						comm.setText("");
						sendMail();
						return null;
					}
				}.execute();
			}
		});
		
	}
	
	public void sendMail(){
		try{
			Socket s = new Socket(smtpServer.getText(),25);
			InputStream inStream = s.getInputStream();
			OutputStream outStream = s.getOutputStream();
			
			in = new Scanner(inStream);
			out = new PrintWriter(outStream,true/**auto Flush **/);
			
			String hostName = InetAddress.getLocalHost().getHostName();
			send("HELO " + hostName);
			receive();
			send("MAIL FOM: <" +from.getText()+ ">");
			receive();
			send("RCPT TO: <" +to.getText()+ ">");
			receive();
			send("DATA");
			receive();
			send(message.getText());
			send(".");
			receive();
			s.close();
		}catch(IOException e){
			comm.append("Error:" +e);
		}
		
	}
	
	public void send(String s)throws IOException{
		comm.append(s);
		comm.append("\n");
		out.print(s.replaceAll("\n", "\r\n"));
		out.print("\r\n");
		out.flush();
	}
	
	public void receive()throws IOException{
		String line = in.nextLine();
		comm.append(line);
		comm.append("\n");
	}
	
	
}
