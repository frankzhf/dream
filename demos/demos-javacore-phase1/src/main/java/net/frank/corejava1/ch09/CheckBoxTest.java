package net.frank.corejava1.ch09;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CheckBoxTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame frame = new CheckBoxFrame();
				frame.setTitle("Check Box Sample");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}


class CheckBoxFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4452316626220142628L;
	private JLabel label;
	private JCheckBox bold;
	private JCheckBox italic;
	private static final int FONT_SIZE=24;
	public CheckBoxFrame() {
		setLayout(new BorderLayout());
		label = new JLabel("The quick browm fox jump over the lazy dog");
		label.setFont(new Font("Serif",Font.BOLD,FONT_SIZE));
		add(label,BorderLayout.CENTER);
		
		ActionListener l = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int mode = 0;
				if(bold.isSelected()) {
					mode += Font.BOLD;
				}
				if(italic.isSelected()) {
					mode += Font.ITALIC;
				}
				label.setFont(new Font("Serif",mode,FONT_SIZE));
			}
			
		};
		
		bold = new JCheckBox("BOLD");
		bold.setSelected(true);
		bold.addActionListener(l);
		italic =  new JCheckBox("ITALIC");
		italic.setSelected(false);
		italic.addActionListener(l);
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(bold);
		buttonPanel.add(italic);
		
		add(buttonPanel,BorderLayout.SOUTH);
		pack();
	}
}

/***
 * javax.swing.JCheckBox
 * JCheckBox(String label)
 * JCheckBox(String label, Icon icon)
 * JCheckBox(String label, boolean state)
 * 构造一个复选框
 * 
 * boolean isSelected();
 * void setSelected(boolean state)
 * 获取或设置复选框的选择状态
 * 
 */

