package net.frank.corejava1.ch09;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TextComponentFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7381238882464284601L;
	public static final int TEXTAREA_ROWS = 8;
	public static final int TEXTAREA_COLUNMS = 20;
	
	public TextComponentFrame() {
		final JTextField textField = new JTextField();
		final JPasswordField passwordField = new JPasswordField();
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(2,2));
		northPanel.add(new JLabel("User name:",SwingConstants.RIGHT));
		northPanel.add(textField);
		northPanel.add(new JLabel("Password:",SwingConstants.RIGHT));
		northPanel.add(passwordField);
		
		add(northPanel, BorderLayout.NORTH);
		
		final JTextArea textArea = new JTextArea(TEXTAREA_ROWS,TEXTAREA_COLUNMS);
		JScrollPane scrollPane = new JScrollPane(textArea);
		add(scrollPane, BorderLayout.CENTER);
		
		JPanel southPanel = new JPanel();
		JButton insertButton = new JButton("Insert");
		southPanel.add(insertButton);
		insertButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.append("User name: " + textField.getText()
						+" Password: " + new String(passwordField.getPassword()) + "\n");
			}
		});
		add(southPanel,BorderLayout.SOUTH);
		pack();
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new TextComponentFrame();
				frame.setTitle("Text Component Sample");
				frame.setSize(300, 200);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
			
		});
	}
	
	/****
	 * javax.swing.JTextArea
	 * JTextArea()
	 * JTextArea(int rows, int cols)
	 * JTextArea(String text, int rows, int cols)
	 * 构造一个新的文本区对象
	 * 
	 * void setColumns(int cols)
	 * 设备文本区应该使用的首选列数
	 * 
	 * void setRows(int rows)
	 * 设备文本区应该使用的首选行数
	 * 
	 * void append(String newText)
	 * 将给定的文本追加到文本区中已有文本的尾部
	 * 
	 * void setLineWrap(boolean wrap)
	 * 打开或关闭换行
	 * 
	 * void setWrapStyleWord(boolean word)
	 * 设置超长的行是否会在字边框处换行
	 * 
	 * void setTabSize(int c)
	 * 设置制表符的列宽
	 * 
	 * javax.swing.JScrollPane
	 * JScrollPane
	 * 创建一个滚动窗格，用来显示指定组件的内容
	 * 
	 */
	
}
