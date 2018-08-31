package net.frank.corejava1.ch06.timer;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class TimerTest {

	public static void main(String[] args) {
		ActionListener listener = new TimePrinter();
		Timer t = new Timer(10000,listener);
		t.start();
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
	}

}


class TimePrinter implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		Date now = new Date();
		System.out.println("At the tone, the time is " + now);
		Toolkit.getDefaultToolkit().beep();
	}
}

/***
 * javax.swing.JOptionPane
 * static void showMesssageDialog(Component parent, Object message)
 * 
 * 
 * javax.swing.Timer
 * Timer(int interval,ActionListener listener)
 * 
 * 
 * void start()
 * 启动定时器，一旦启动成功，定时器将调用监听器的actionPerformed.
 * 
 * void stop()
 * 停止定时器，一旦停止成功，定时器将不再调用监听器的actionPerformed.
 * 
 * java.awt.Toolkit
 * static Toolkit getDefaultToolkit()
 * 获得默认的工具箱。工具臬包含有关GUI环境的信息
 * 
 * void beep()
 * 发出一声铃响
 *
***/
