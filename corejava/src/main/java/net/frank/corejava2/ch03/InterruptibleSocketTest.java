package net.frank.corejava2.ch03;

import java.awt.EventQueue;

import javax.swing.JFrame;

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
	public static final int WIDTH = 300;
	public static final int HEIGHT = 300;
	
	public InterruptibleSocketFrame(){
		
	}
	
	
}
