package net.frank.corejava1.ch09;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadioButtonTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame frame = new RadioButtonFrame();
				frame.setTitle("Radio Button Sample");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class RadioButtonFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1161776379664510495L;

	private JPanel buttonPanel;
	
	private ButtonGroup group;
	
	private JLabel label;
	
	private static final int DEFAULT_SIZE = 36;
	
	public RadioButtonFrame() {
		setLayout(new BorderLayout());
		label = new JLabel("The quick brown fox jumps over the lazy dog.");
		label.setFont(new Font("Serif", Font.PLAIN, DEFAULT_SIZE));
		add(label, BorderLayout.CENTER);
		
		buttonPanel = new JPanel();
		group = new ButtonGroup();
		
		addRadioButton("Small",8);
		addRadioButton("Medium",12);
		addRadioButton("Large",18);
		addRadioButton("Extra large",36);
		add(buttonPanel,BorderLayout.SOUTH);
		pack();
	}
	
	public void addRadioButton(String name,final int size) {
		boolean selected = size == DEFAULT_SIZE;
		JRadioButton button = new JRadioButton(name,selected);
		group.add(button);
		buttonPanel.add(button);
		ActionListener l = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				label.setFont(new Font("Serif",Font.PLAIN,size));
			}
			
		};
		button.addActionListener(l);
	}
}
/***
 * javax.swing.JRadioButton
 * JRadioButton(String label, Icon icon)
 * JRadioButton(String label, boolean state)
 * 构造一个单选按钮
 * 
 * javax.swing.ButtonGroup
 * void add(AbstractButton b)
 * 将按钮添加到组中
 * 
 * ButtonModel getSelection()
 * 返回被选择的按钮的按钮模型
 * 
 * javax.swing.ButtonModel
 * String getActionCommand()
 * 返回按钮模型的动作命令
 * 
 * javax.swing.AbstractButton
 * void setActionCommand(String s)
 * 设置按钮及其模型的动作命令
 */