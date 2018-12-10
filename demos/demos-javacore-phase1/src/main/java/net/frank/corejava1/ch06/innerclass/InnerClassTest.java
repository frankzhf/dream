package net.frank.corejava1.ch06.innerclass;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class InnerClassTest {

	public static void main(String[] args) {
		TalkingClock clock = new TalkingClock(10000,true);
		//clock.new TimePrinter();
		clock.start();
		JOptionPane.showMessageDialog(null,"Quit Program");
		System.exit(0);
	}

}


class TalkingClock{
	private int interval;
	private boolean beep;
	
	public TalkingClock(int interval, boolean beep) {
		this.interval = interval;
		this.beep = beep;
	}
	
	public void start() {
		ActionListener listener = new TimePrinter();
		Timer t = new Timer(interval, listener);
		t.start();
	}
	
	public class TimePrinter implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Date now = new Date();
			System.out.println("At the tone, the time is " + now);
			if(beep) { //TalkingClock.this.beep
				Toolkit.getDefaultToolkit().beep();
			}
		
		}
		
	}
	
}