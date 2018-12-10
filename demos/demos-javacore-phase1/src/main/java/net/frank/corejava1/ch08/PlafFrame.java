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
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1565430858060715933L;
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
 * 在用户发出窗口管理命令关闭窗口时调用这个方法。需要注意的是，公当调用hide或dispose方法后窗口才能够关闭
 * 
 * void windowClosed(WindowEvent e)
 * 窗口关闭后调用的方法
 * 
 * void windowIconified(WindowEvent e)
 * 窗口图标化（最小化）后调用的方法
 * 
 * void windowDeiconified(WindowEvent e)
 * 窗口非图标化后调用的方法
 * 
 * void windowActivated(WindowEvent e)
 * 源活窗口后调用这个方法。只有框架（JFrame）或对话框可以被激活
 * 
 * void windowDeactivated(WindowEvent e)
 * 窗口变成未源活状态后调用这个方法
 * 
 * java.awt.event.WindowStateListener
 * void windowStateChanged(WindowEvent e)
 * 窗口状态切换时（最大化，图标化，恢复正常大小时）调用这个方法
 * 
 * java.awt.event.WindowEvent
 * int getNewState()
 * int getOldState()
 * 返回窗口状态改变事件中窗口新、旧状态。返回的整型值是下列数值之一
 * Frame.NORMAL
 * Frame.ICONIFIED
 * Frame.MAXIMIZED_HORIZ
 * Frame.MAXIMIZED_VERT
 * Frame.MAXIMIZED_BOTH
 *  
**/ 
