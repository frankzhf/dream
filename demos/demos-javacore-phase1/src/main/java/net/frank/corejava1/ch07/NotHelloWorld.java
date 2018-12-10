package net.frank.corejava1.ch07;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class NotHelloWorld {
	
	/***
	 * 
	 * 由外到内的层次
	 * 
	 * 框架
	 * 根窗格
	 * 层级窗格
	 * 菜单框 （可选项）
	 * 内容窖格
	 * 玻璃窗格
	 * 
	 * 
	 * 
	 */
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame frame = new NotHelloWorldFrame();
				frame.setTitle("NotHelloWorld");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

}

class NotHelloWorldFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7738710460660014509L;

	public NotHelloWorldFrame() {
		add(new NotHelloWorldComponent());
		pack();
	}
}

class NotHelloWorldComponent extends JComponent{
	/**
	 * 
	 */
	private static final long serialVersionUID = 362312324819486300L;
	private static final int MESSAGE_X = 75;
	private static final int MESSAGE_Y = 100;
	
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	
	public void paintComponent(Graphics g) {
		g.drawString("Not a Hello, World program", MESSAGE_X, MESSAGE_Y);
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
	}
	
}
/***
 * javax.swing.JFrame
 * Container getContentPane()
 * 返回这个框架的内容窗格对象
 * 
 * Component add(Component c)
 * 将一个给定的组件添加到核框架的内容窖格中
 * 
 * java.awt.Component
 * void repaint()
 * 尽可能快的重新绘制组件
 * 
 * Dimension getPreferredSize()
 * 要覆盖这个方法，返回这个组件的首选大小
 * 
 * javax.swing.JComponent
 * void paintComponent(Grphics g)
 * 覆盖这个方法来描述应该如何给制自己的组件
 * 
 * java.awt.Window
 * void pack()
 * 调整窗口大小，要考虑到其组件的首选大小
 * 
 * 
**/ 
