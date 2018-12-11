package net.frank.corejava1.ch09;

import java.awt.BorderLayout;
//import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
//import javax.swing.JFrame;
import javax.swing.JPanel;

/***
 * java.awt.Container
 * void setLayout(LayoutManager c)
 * 为容器设置布局管理器
 * 
 * Component add(Component c)
 * Component add(Component c, Object constraints)
 * 将组件添加到容器中,并返回组件引用
 * 
 * java.awt.FlowLayout
 * FlowLayout()
 * FlowLayout(int align)
 * FlowLayout(int align, int hgap, int vgap)
 * 构造一个流布局
 * 
 * java.awt.BorderLayout
 * BorderLayout()
 * BorderLayout(int hgap, int vgap)
 * 构造一个新的边框布局
 * 
 * java.awt.GridLayout
 * GridLayout(int rows, int columns)
 * GridLayout(int rows, int columns, int hgap, int vgap)
 * 构造一个网格布局
 * 
 */



public class CalculatorPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5366306483765420434L;
	private JButton display;
	private JPanel panel;
	private double result;
	private String lastCommand;
	private boolean start;
	
	public CalculatorPanel() {
		setLayout(new BorderLayout());
		result = 0;
		lastCommand = "=";
		start = true;
		display = new JButton("0");
		display.setEnabled(false);
		add(display,BorderLayout.NORTH);
		
		ActionListener insert = new InsertAction();
		ActionListener command = new CommandAction();
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(4,4));
		addButton("7",insert);
		addButton("8",insert);
		addButton("9",insert);
		addButton("/",command);
		
		addButton("4",insert);
		addButton("5",insert);
		addButton("6",insert);
		addButton("*",command);
		
		addButton("1",insert);
		addButton("2",insert);
		addButton("3",insert);
		addButton("-",command);
		
		addButton("0",insert);
		addButton(".",insert);
		addButton("=",insert);
		addButton("+",command);
		
		add(panel,BorderLayout.CENTER);
	}
	
	private void addButton(String label, ActionListener listener) {
		JButton button = new JButton(label);
		button.addActionListener(listener);
		panel.add(button);
	}
	
	private class InsertAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String input = e.getActionCommand();
			if(start) {
				display.setText("");
				start = false;
			}
			display.setText(display.getText() + input);
			
		}
		
	}
	
	private class CommandAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			if(start) {
				if(command.equals("-")) {
					display.setText(command);
					start = false;
				}else {
					lastCommand = command;
				}
			}else {
				calculate(Double.parseDouble(display.getText()));
				lastCommand = command;
				start = true;
			}
		}
		
	}
	
	
	public void calculate(double x) {
		if(lastCommand.equals("+")) {
			result +=x;
		}else if(lastCommand.equals("-")) {
			result -=x;
		}else if(lastCommand.equals("*")) {
			result *=x;
		}else if(lastCommand.equals("/")) {
			result /=x;
		}else if(lastCommand.equals("=")) {
			result =x;
		}
		display.setText(""+result);
	}
	
	/**
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame f = new JFrame();
				f.setSize(200, 160);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setTitle("Calculator");
				f.add(new CalculatorPanel());
				f.setVisible(true);
			}
			
		});
	}
	***/
	
	/***
	 * javax.swing.text.JTextComponent
	 * String getText()
	 * void setText(String text)
	 * 获取或设置文本给件中的文本
	 * 
	 * boolean isEditable()
	 * void setEditable(boolean b)
	 * 获取或设置editable特性
	 * 
	 * javax.swing.JTextField
	 * JTextField(int cols)
	 * JTextField(String text, int cols)
	 * 构造一个文档域
	 * 
	 * int getColumns
	 * void setColumns(int cols)
	 * 获取或设文本域的列数
	 * 
	 * javax.swing.JComponent
	 * void revalidate()
	 * 重新计算组件的位置和大小
	 * 
	 * void setFont(Font f)
	 * 设备组件的字体
	 * 
	 * java.awt.Component
	 * void validate()
	 * 重新计算组件的位置和大小，如果组件是容器，其包含的所有组件的位置和大小也被重新计算
	 * 
	 * Font getFont()
	 * 获取组件的字体
	 * 
	 * javax.swing.JLabel
	 * JLabel(String text)
	 * JLabel(Icon icon)
	 * JLabel(String text, int align)
	 * JLabel(String text, Icon icon, int align
	 * 构造一个标签
	 * 
	 * String getText()
	 * void setText(String text)
	 * 获取或设置标签的文本
	 * 
	 * Icon getIcon()
	 * void setIcon(Icon icon)
	 * 获取或设置标签的图标
	 * 
	 * javax.swing.JPasswordField
	 * JPasswordField(String text, int columns)
	 * 构造一个新的密码域对象
	 * 
	 * void setEchoChar(char echo)
	 * 为密码设置回显字符
	 * 
	 * char[] getPassword()
	 * 返回密码域中的文本
	 * 
	 */
	
}
