package net.frank.corejava2.ch06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class InvestmentTable {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame frame = new InvestmentTableFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class InvestmentTableFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6550780457165346923L;
	private static final int DEFAULT_WIDTH = 600;
	private static final int DEFAULT_HEIGHT = 300;
	
	public InvestmentTableFrame() {
		setTitle("InvestmentTable");
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		TableModel model = new InverstmentTableModel(30,5,10);
		JTable table = new JTable(model);
		add(new JScrollPane(table));
	}
}

class InverstmentTableModel extends AbstractTableModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2960397615462687499L;
	private int years;
	private int minRate;
	private int maxRate;
	
	private static double INITIAL_BALANCE = 100000.0;
	
	public InverstmentTableModel(int years,int minRate,int maxRate) {
		this.years = years;
		this.minRate = minRate;
		this.maxRate = maxRate;
	}
	
	@Override
	public int getRowCount() {
		return years;
	}

	@Override
	public int getColumnCount() {
		return maxRate - minRate +1;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		double rate = (columnIndex + minRate)/100.0;
		int nperiods = rowIndex;
		double futureBalance = INITIAL_BALANCE * Math.pow(1+rate, nperiods);
		return String.format("%.2f", futureBalance);
	}
	
	public String getColumnName(int columnIndex) {
		return  (columnIndex + minRate) +"%";
	}
}
/**
 * javax.swing.table.TableModel
 * int getRowCount()
 * int getColumnCount()
 * 获取表格模型中的行和列的数量
 *  
 * Object getValueAt(int rowIndex, int columnIndex)
 * 获取在给定行和列所确定的位置处的值
 * 
 * void setValueAt(Object newValue, int rowIndex, int columnIndex)
 * 设置在给定的行和列所确定的位置处的值
 * 
 * boolean isCellEditable(int rowIndex, int colunmIndex)
 * 如果在给定的行和列所确定的位置处的值是可编辑的，则返回true
 * 
 * String getColumnName(int columnIndex)
 * 获取列的名字
 * 
 **/
