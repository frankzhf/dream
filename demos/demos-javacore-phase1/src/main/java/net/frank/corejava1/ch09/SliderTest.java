package net.frank.corejava1.ch09;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderTest {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame f = new SliderFrame();
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setTitle("SliderTest");
				f.setVisible(true);
			}
			
		});
	}
	
}

class SliderFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3623500879632598411L;
	private JPanel sliderPanel;
	private JTextField textField;
	private ChangeListener listener;
	
	
	public SliderFrame() {
		sliderPanel = new JPanel();
		sliderPanel.setLayout(new GridBagLayout());
		
		listener = new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider)e.getSource();
				textField.setText("" + source.getValue());
			}	
		};
		
		JSlider slider = new JSlider();
		addJSlider(slider,"Plain");
		
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		addJSlider(slider,"Ticks");
		
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setSnapToTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		addJSlider(slider,"Snap to ticks");
		
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		slider.setPaintTrack(false);
		addJSlider(slider,"No track");
		
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		slider.setInverted(true);
		addJSlider(slider,"Inverted");
		
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		addJSlider(slider,"Labels");
		textField = new JTextField();
		setLayout(new BorderLayout());
		add(sliderPanel,BorderLayout.CENTER);
		add(textField,BorderLayout.SOUTH);
		pack();
	}
	
	
	public void addJSlider(JSlider s, String description) {
		s.addChangeListener(listener);
		JPanel panel = new JPanel();
		panel.add(s);
		panel.add(new JLabel(description));
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridy = sliderPanel.getComponentCount();
		gbc.anchor = GridBagConstraints.WEST;
		sliderPanel.add(panel,gbc);
	}
}
/***
 * javax.swing.JSlider
 * JSlider()
 * JSlider(int direction)
 * JSlider(int min, int max)
 * JSLider(int min, int max, int initialValue)
 * JSLider(int direction, int min, int max, int initialValue)
 * 用组定的方向，最小值，最大值和初始化值构造一个水平的滑动条
 * 
 * void setPaintTicks(boolean b)
 * 如果b为true,显示标尺
 * 
 * void setMajorTickSpacing(int units)
 * void setMinorTickSpacing(int units)
 * 用给定的滑动条单位的倍数设置大标尺和小标尺
 * 
 * void setPaintLabels(boolean b)
 * 如果b是true，显示标尺标签
 * 
 * void setLabelTable(Dictinary table)
 * 设置用于作为标尺标签的组件。表中的每一个键/值对都采用new Integer(value)/component的格式
 * 
 * void setSnapToTicks(boolean b)
 * 如果b是true，每一次调整后滑块都楗对齐到最接近的标尺处
 * 
 * void setPaintTrack(boolean b)
 * 如果b是true，显示滑动条滑动的轨迹
 * 
***/