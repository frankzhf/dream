package net.frank.corejava2.ch02;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class GridBagTest {
	public static void main(final String[] args) {
		EventQueue.invokeLater(new Runnable(){
			@Override
			public void run() {
				String filename = args.length ==0 ? 
						"/Users/zhaofeng/projects/frank/source/dream/corejava/src/main/resources/net/frank/corejava2/ch02/fontdialog.xml":args[0];
				JFrame frame = new FontFrame(filename);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
			
		});

	}
}

class FontFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2311590512457347359L;

	private GridBagPane gridbag;
	
	private JComboBox<String> face;
	private JComboBox<String> size;
	private JCheckBox bold;
	private JCheckBox italic;
	
	private static final int DEFAULT_WIDTH = 400;
	private static final int DEFAULT_HEIHGT = 400;
	
	public FontFrame(String fileName){
		setSize(DEFAULT_WIDTH,DEFAULT_HEIHGT);
		setTitle("GridBagTest");
		
		gridbag = new GridBagPane(fileName);
		
		add(gridbag);
		
		face = (JComboBox) gridbag.get("face");
		size = (JComboBox) gridbag.get("size");
		bold = (JCheckBox) gridbag.get("bold");
		italic = (JCheckBox) gridbag.get("italic");
		
		face.setModel(new DefaultComboBoxModel<String>(new String[]{
				"Serif","SansSerif","Monospaced","Dialog","DialogInput"
		}));
		
		size.setModel(new DefaultComboBoxModel<String>(new String[]{
				"8","10","12","15","18","24","36","48"
		}));
		
		ActionListener listener = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				setSample();		
			}
		};
		face.addActionListener(listener);
		size.addActionListener(listener);
		bold.addActionListener(listener);
		italic.addActionListener(listener);
		setSample();
	}	
	
	public void setSample() {
		String fontFace = (String) face.getSelectedItem();
		int fontSize = Integer.parseInt((String)size.getSelectedItem());
		JTextArea sample = (JTextArea) gridbag.get("sample");
		int fontStyle = (bold.isSelected() ? Font.BOLD : 0)
				+ (italic.isSelected() ? Font.ITALIC : 0);
		
		sample.setFont(new Font(fontFace,fontStyle,fontSize));
		sample.repaint();
		
	}
	
	
	
}