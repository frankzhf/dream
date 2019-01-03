package net.frank.corejava1.ch09;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ComboBoxFrameTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new ComboBoxFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("ComboBox Test");
				frame.setVisible(true);
			}
			
		});
	}

}


class ComboBoxFrame extends JFrame{
	private JComboBox<String> faceCombo;
	private JLabel label;
	private static final int DEFAULT_SIZE = 24;
	
	
	public ComboBoxFrame() {
		label = new JLabel("The quick brown fox jumps over the lazy dog.");
		label.setFont(new Font("Serif",Font.PLAIN,DEFAULT_SIZE));
		setLayout(new BorderLayout());
		add(label,BorderLayout.CENTER);
		
		faceCombo = new JComboBox<String>();
		faceCombo.addItem("Serif");
		faceCombo.addItem("SansSerif");
		faceCombo.addItem("Monospaced");
		faceCombo.addItem("Dialog");
		faceCombo.addItem("DialogInput");
		
		faceCombo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				label.setFont(new Font(faceCombo.getItemAt(faceCombo.getSelectedIndex()),Font.PLAIN,DEFAULT_SIZE));
			}
		});
		JPanel comboPanel = new JPanel();
		comboPanel.add(faceCombo);
		add(comboPanel,BorderLayout.SOUTH);
		pack();
		
	}
	
}
/***
 * javax.swing.JComboBox
 * boolean isEditable()
 * void setEditable(boolean b)
 * 获取或设置组合框的可编辑特性
 * 
 * void addItem(Object item)
 * 把一个选项添加到选项列表中
 * 
 * void insertItemAt(Object item, int index)
 * 将一个选项添加到选项列表的指定位置
 * 
 * void removeItem(Object item)
 * 从选项列表中删除一个选项
 * 
 * void removeItemAt(int index)
 * 删除指定位置的选项
 * 
 * void removeAllItems()
 * 从选项列表中删除所有选项
 * 
 * Object getSelectedItem()
 * 返回当前选择的选项
 * 
 * 
***/

