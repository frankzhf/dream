package net.frank.corejava2.ch06;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PlanetTable {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new PlanetTableFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
			
		});
	}
}


class PlanetTableFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9147043208500379459L;
	
	private final static int DEFAULT_WIDTH = 400;
	private final static int DEFAULT_HEIGHT = 200;
	
	private Object[][] cells = {
			{"Mercury",2440.0,0,false,Color.YELLOW},
			{"Venus",6052.0,0,false,Color.YELLOW},
			{"Earth",6378.0,1,false,Color.BLUE},
			{"Mars",3397.0,2,false,Color.RED},
			{"Jupiter",71492.0,16,true,Color.ORANGE},
			{"Saturn",60268.0,18,true,Color.ORANGE},
			{"Uranus",25559.0,17,true,Color.BLUE},
			{"Neptune",24766.0,8,true,Color.BLUE},
			{"Pluto",1137.0,1,false,Color.BLACK}
	};
	
	private String[] columnNames = {"Planet","Radius","Moons","Gaseous","Color"};
	
	
	public PlanetTableFrame() {
		setTitle("PlanetTable");
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		final JTable table = new JTable(cells,columnNames);
		table.setAutoCreateRowSorter(true);
		table.setFillsViewportHeight(true);
		add(new JScrollPane(table),BorderLayout.CENTER);
		JButton printButton = new JButton("Print");
		printButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				try{
					table.print();
				}catch(PrinterException e) {
					e.printStackTrace();
				}
			}
		});
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(printButton);
		add(buttonPanel,BorderLayout.SOUTH);
	}
	
}

/***
 * javax.swing.JTable
 * JTable(Object[][] entries,Object[] columns)
 * 用默认的表格模型构建一个表格
 * 
 * void print()
 * 显示打印对话框，并打印该表格
 * 
 * boolean getAutoCreateRowSorter()
 * void setAutoCreateRowSorter(boolean newValue)
 * 获取或设置AutoCreateRowSorter属性,默认值为false。如果进行了设置,只要模型发生了变化，就会自动设置一个默认的行排序器
 * 
 * boolean getFillsViewportHeight()
 * void setFillsViewportHeight(boolean newValue)
 * 获取或设置fillsViewportHeight属性，默认值为false。如果进行了设置，该表格就总是会填充一个封装在外边的视图
 * 
 * 
 */

