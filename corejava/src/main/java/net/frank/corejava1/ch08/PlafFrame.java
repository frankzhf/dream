package net.frank.corejava1.ch08;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class PlafFrame extends JFrame {
	
	private JPanel buttonPanel;
	
	public PlafFrame() {
		buttonPanel = new JPanel();
		UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
		for(UIManager.LookAndFeelInfo info : infos) {
			makeButton(info.getName(),info.getClassName());
		}
		add(buttonPanel);
		pack();
	}
	
	
	private void makeButton(String name, String flafName) {
		// TODO Auto-generated method stub
		JButton button = new JButton(name);
		buttonPanel.add(button);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				try {
					UIManager.setLookAndFeel(flafName);
					SwingUtilities.updateComponentTreeUI(PlafFrame.this);
					pack();
				}catch(Exception e) {
					
				}
			}
			
		});
	}


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new PlafFrame();
				frame.setTitle("PlafFrame");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
			
		});
	}
}

/***
 * javax.swing.UIManager
 * static UIManager.LookAndFeelInfo[] getInstalledLookAndFeels()
 * 获得一个用于描述已经装的观感实现的对象数组
 * 
 * static setLookAndFeel(String classsName)
 * 利用给定的类名设置当前的观感
 * 
 * javax.swing.UIManager.LookAndFeelInfo
 * String getName()
 * 返回观感的显示名称
 * 
 * String getClassName()
 * 返回观感实现类的名称
 * 
 * java.awt.event.WindowListener
 * void windowOpened(WindowEvent e)
 * 窗口打开后调用这个方法
 * 
 * void windowClosing(WindowEvent e)
 * 
 * 
 * void windowClosed(WindowEvent e)
 * 
 * 
 * void windowIconified(WindowEvent e)
 * 
 * 
 * void windowDeiconified(WindowEvent e)
 * 
 * 
 * void windowActivated(WindowEvent e)
 * 
 * 
 * void windowDeactivated(WindowEvent e)
 * 
 * 
 * java.awt.event.WindowStateListener
 * void windowStateChanged(WindowEvent e)
 * 
 * 
 * java.awt.event.WindowEvent
 * int getNewState()
 * int getOldState()
 * 
 * 
**/ 
