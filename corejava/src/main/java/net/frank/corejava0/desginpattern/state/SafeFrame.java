package net.frank.corejava0.desginpattern.state;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SafeFrame extends JFrame implements Context {

	/**
	 * 
	 */
	private static final long serialVersionUID = -50977780306389279L;
	private JTextField textClock = new JTextField(60);
	private JTextArea textScreen = new JTextArea(10, 60);

	private JButton buttonUser = new JButton("使用金库");
	private JButton buttonAlarm = new JButton("按下警铃");
	private JButton buttonPhone = new JButton("正常通话");
	private JButton buttonExit = new JButton("结束");

	private State state = DayState.getInstance();

	private boolean end = false;

	public boolean isEnd() {
		return end;
	}

	public SafeFrame() {
		super("State sample");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		add(textClock, BorderLayout.NORTH);
		textClock.setEditable(false);
		add(textScreen, BorderLayout.CENTER);
		textScreen.setEditable(false);
		JPanel panel = new JPanel();
		panel.add(buttonUser);
		panel.add(buttonAlarm);
		panel.add(buttonPhone);
		panel.add(buttonExit);
		add(panel, BorderLayout.SOUTH);
		buttonUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				state.doUse(SafeFrame.this);
			}
		});
		buttonAlarm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				state.doAlarm(SafeFrame.this);
			}
		});
		buttonPhone.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				state.doPhone(SafeFrame.this);
			}
		});
		buttonExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				end = true;
			}
		});
	}

	@Override
	public void setClock(int hour) {
		String clockString = "现在时间是";
		if (hour < 10) {
			clockString += "0" + hour + ":00";
		} else {
			clockString += hour + ":00";
		}
		System.out.println(clockString);
		textClock.setText(clockString);
		state.doClock(this, hour);
	}

	@Override
	public void changeState(State state) {
		System.out.println("从" + this.state + "状态变成了" + state + "状态");
		this.state = state;
	}

	@Override
	public void callSecurityCenter(String msg) {
		textScreen.append("call! " + msg + "\n");
	}

	@Override
	public void recordLog(String msg) {
		textScreen.append("record ... " + msg + "\n");
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				SafeFrame f = new SafeFrame();
				f.setVisible(true);
				while (!f.isEnd()) {
					for (int hour = 0; hour < 24; hour++) {
						f.setClock(hour);
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {

						}
					}
				}
				System.exit(0);
			}
		});
	}
}
