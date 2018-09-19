package net.frank.corejava1.ch08;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7481461633524417811L;

	private JPanel buttonPanel;
	
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	
	public ButtonFrame() {
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		
		JButton yellowButton = new JButton("Yellow");
		JButton blueButton = new JButton("Blue");
		JButton redButton = new JButton("Red");
		
		buttonPanel = new JPanel();
		
		buttonPanel.add(yellowButton);
		buttonPanel.add(blueButton);
		buttonPanel.add(redButton);

		add(buttonPanel);
		
		ColorAction yellowAction  = new ColorAction(Color.YELLOW);
		ColorAction blueActionn = new ColorAction(Color.BLUE);
		ColorAction redAction = new ColorAction(Color.RED);
		
		yellowButton.addActionListener(yellowAction);
		blueButton.addActionListener(blueActionn);
		redButton.addActionListener(redAction);
		
		
	}
	
	private class ColorAction implements ActionListener{
		private Color backgroundColor;
		
		public ColorAction(Color c) {
			backgroundColor = c;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			buttonPanel.setBackground(backgroundColor);
		}
	
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new ButtonFrame();
				frame.setTitle("ButtonFrame");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
			
		});
	}
}

/***
 * javax.swing.JButton
 * JButton(String label)
 * JButton(Icon icon)
 * JButton(String label, Icon icon)
 * 构造一个按。标签可以是常规文本，也可以是html。例如"<html><b>O.K</b></html>"
 * 
 * java.awt.Container
 * Component add(Component c)
 * 将组件增加到容器中
 * 
 * java.util.EventObject
 * Object getSource()
 * 返回发生事件的对象引用
 * 
 * java.awt.event.ActionEvent
 * String getActionCommand()
 * 返回与这个运作事件相关的命令字符串
 * 
 * java.beans.EventHandler
 * static Object create(Class listenerInterface, Object target, String action)
 * static Object create(Class listenerInterface, Object target, String action, String eventProperty)
 * static Object create(Class listenerInterface, Object target, String action, String eventProperty, String listenerMethod);
 * 构造实现给定接口的一个代理类对象
 * 例
 * EventHandler.create(ActionListener.class,frame "loadData","source.text");
 * 等价于
 * new ActionListener(){
 * 		public void actionPerformed(ActionEvent event){
 * 			frame.loadData(((JTextField) event.getSource()).getText());
 * 		}
 * }
 * 
 * 
 * 
 * 
 * 
**/ 
