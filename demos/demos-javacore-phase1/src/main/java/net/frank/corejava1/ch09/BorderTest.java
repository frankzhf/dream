package net.frank.corejava1.ch09;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

public class BorderTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new BorderFrame();
				frame.setTitle("Border Sample");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
			
		});
	}
}

class BorderFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6196907389327034065L;
	private JPanel demoPanel;
	private JPanel buttonPanel;
	private ButtonGroup group;
	
	public BorderFrame() {
		demoPanel = new JPanel();
		buttonPanel = new JPanel();
		group = new ButtonGroup();
		addRadioButton("Lowered bevel",BorderFactory.createLoweredBevelBorder());
		addRadioButton("Raised bevel",BorderFactory.createRaisedBevelBorder());
		addRadioButton("Etched",BorderFactory.createEtchedBorder());
		addRadioButton("Line",BorderFactory.createLineBorder(Color.BLUE));
		addRadioButton("Matte",BorderFactory.createMatteBorder(10, 10, 10, 10, Color.BLUE));
		addRadioButton("Empty",BorderFactory.createEmptyBorder());
		
		Border etched = BorderFactory.createEtchedBorder();
		Border titled = BorderFactory.createTitledBorder(etched, "Border types");
		buttonPanel.setBorder(titled);
		
		setLayout(new GridLayout(2,1));
		add(buttonPanel);
		add(demoPanel);
		pack();
	}
	
	
	public void addRadioButton(String buttonName, final Border b) {
		JRadioButton button = new JRadioButton(buttonName);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				demoPanel.setBorder(b);
			}
			
		});
		group.add(button);
		buttonPanel.add(button);
	}
}

/***
 * javax.swing.BorderFactory
 * static Border createLineBorder(Color color)
 * static Border createLineBorder(Color color, int thickness)
 * 创建一个直线边框
 * 
 * static MatteBorder createMatteBorder(int top, int left, int bottom, int right, Color color)
 * static MatteBorder createMatteBorder(int top, int left, int bottom, int right, Icon tileIcon)
 * 创建一个粗边框
 * 
 * static Border createEmptyBorder()
 * static Border createEmptyBorder(int top, int left, int bottom, int right)
 * 
 * 
 * static Border createEtchedBorder()
 * static Border createEtchedBorder(Color highlight, Color shadow)
 * static Border createEtchedBorder(int type)
 * static Border createEtchedBorder(int type, Color highlight, Color shadow)
 * 创建一个具有3D效果的直线边框
 * 
 * static Border createBevelBorder(int type)
 * static Border createBevelBorder(int type, Color highlight, Color shadow)
 * static Border createLoweredBevelBorder()
 * static Border createRaisedBevelBorder()
 * 创建一个具有凹面或凸面的边框
 * 
 * static TitledBorder createTitledBorder(String title)
 * static TitledBorder createTitledBorder(Border border)
 * static TitledBorder createTitledBorder(Border border, String title)
 * static TitledBorder createTitledBorder(Border border, String title, int justification, int position)
 * static TitledBorder createTitledBorder(Border border, String title, int justification, int position, Font font)
 * static TitledBorder createTitledBorder(Border border, String title, int justification, int position, Font font, Color color)
 * 创建一个具有给定特性的带标题的边框
 * 
 * static CompoundBorder createCompoundBorder(Border outsideBorder, Border insideBorder)
 * 将两个边框给合成一个新的边框
 * 
 * javax.swing.border.SoftBevelBorder
 * SoftBevelBorder(int type)
 * SoftBevelBorder(int type, Color highlight, Color shadow)
 * 创建一个带有柔和边角的斜面边框
 * 
 * javax.swing.border.LineBorder
 * LineBorder(Color color, int thickness, boolean roundedCorners)
 * 用指定的颜色和粗细创建军一个直线边框。如果roundedCorners为真，则边框具有圆角
 * 
 * javax.swing.JComponent
 * void setBorder(Border border)
 * 设置这个组件的边框
 * 
 */