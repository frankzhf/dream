package net.frank.corejava1.ch08;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.Icon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class ActionFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 878776061040502975L;

	private JPanel buttonPanel;
	
	private static final int DEFAULT_WIDTH = 300;
	
	private static final int DEFAULT_HEIGHT = 200;
	
	public ActionFrame() {
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		
		buttonPanel = new JPanel();
		Action yellowAction = new ColorAction("Yellow", null, Color.YELLOW);
		Action blueAction = new ColorAction("Blue", null, Color.BLUE);
		Action redAction = new ColorAction("Red", null, Color.RED);
		
		buttonPanel.add(new JButton(yellowAction));
		buttonPanel.add(new JButton(blueAction));
		buttonPanel.add(new JButton(redAction));
		
		add(buttonPanel);
		
		InputMap imap = buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
		imap.put(KeyStroke.getKeyStroke("ctrl Y"), "panel.yellow");
		imap.put(KeyStroke.getKeyStroke("ctrl B"), "panel.blue");
		imap.put(KeyStroke.getKeyStroke("ctrl R"), "panel.red");
		
		ActionMap amap = buttonPanel.getActionMap();
		amap.put("panel.yellow", yellowAction);
		amap.put("panel.blue", blueAction);
		amap.put("panel.red", redAction);
		
		
		
	}
	
	public class ColorAction extends AbstractAction{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -7489107995173522457L;

		public ColorAction(String name, Icon icon, Color c) {
			putValue(Action.NAME,name);
			putValue(Action.SMALL_ICON,icon);
			putValue(Action.SHORT_DESCRIPTION,"Set panel color to " + name.toLowerCase());
			putValue("color",c);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Color c = (Color) getValue("color");
			buttonPanel.setBackground(c);
		}
		
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new ActionFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("ActionFrame");
				frame.setVisible(true);
			}
			
		});
	}
}
/***
 * javax.swing.Action
 * boolean isEnabled()
 * void setEnabled(boolean b)
 * 获得或设置这个动作的enabled属性
 * 
 * void putValue(String key, Object value)
 * 将名/值对放置在动作对象中
 * 
 * Object getValue(String key)
 * 返回被存储的名/值对的值
 * 
 * javax.swing.KeyStroke 
 * static KeyStroke getKeyStroke(String description)
 * 根据一个便于人们阅读的说明创建一个按键（由空格分隔的字符串序列）。
 * 这个说明以0个或多个修饰符shift control ctrl meta alt altGraph开始，
 * 以由typed和单个字符串（例如 "typed a"）或都一个可选的事件说明符（pressed默认，或released）紧跟一个键码，
 * 以VK_前辍开始中的键码应该对应一个KeyEvent常量，例如，"INSERT"对应KeyEvent.VK_INSERT
 * 
 * javax.swing.JComponent
 * ActionMap getActionMap()
 * 返回关联动作映射（可以是任意的对象）和动作对象的映射
 * 
 * InputMap getInputMap(int flag)
 * 获得将按键映射到动作的输入映射
 * flag 对应
 * WHEN_FOCUSED								当这个组件拥有键盘集点时
 * WHEN_ANCESTOR_OF_FOCUSED_COMPONENT		当这个组件包含了拥用盘焦点的组件时
 * WHEN_IN_FOCUSED_WINDOW					当这个组件被包含在一个拥有键盘焦点组件的窗口中时
 * 
**/ 
