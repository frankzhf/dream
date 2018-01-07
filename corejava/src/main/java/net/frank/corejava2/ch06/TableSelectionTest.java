package net.frank.corejava2.ch06;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class TableSelectionTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame frame = new TableSelectionFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class TableSelectionFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1940846407675814351L;
	private static final int DEFAULT_WIDTH = 400;
	private static final int DEFAULT_HEIGHT = 300;
	
	private DefaultTableModel model;
	private JTable table;
	private List<TableColumn> removedColumns;
	
	
	public TableSelectionFrame() {
		setTitle("TableSelectionTest");
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		model = new DefaultTableModel(10,10);
		for(int i=0;i<model.getRowCount();i++) {
			for(int j=0;j<model.getColumnCount();j++) {
				model.setValueAt((i+1)*(j+1), i, j);
			}
		}
		table = new JTable(model);
		add(new JScrollPane(table),"Center");
		removedColumns = new ArrayList<TableColumn>();
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu selectionMenu = new JMenu("Selection");
		menuBar.add(selectionMenu);
		
		final JCheckBoxMenuItem rowsItem = new JCheckBoxMenuItem("Rows");
		final JCheckBoxMenuItem colunsItem = new JCheckBoxMenuItem("Columns");
		final JCheckBoxMenuItem cellsItem = new JCheckBoxMenuItem("Cells");
		
		rowsItem.setSelected(table.getRowSelectionAllowed());
		colunsItem.setSelected(table.getColumnSelectionAllowed());
		cellsItem.setSelected(table.getCellSelectionEnabled());
		
		rowsItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				table.clearSelection();
				table.setRowSelectionAllowed(rowsItem.isSelected());
				cellsItem.setSelected(table.getCellSelectionEnabled());
			}
		});
		selectionMenu.add(rowsItem);
		
		colunsItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				table.clearSelection();
				table.setColumnSelectionAllowed(colunsItem.isSelected());
				cellsItem.setSelected(table.getCellSelectionEnabled());
			}
		});
		selectionMenu.add(colunsItem);
		
		cellsItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				table.clearSelection();
				table.setCellSelectionEnabled(cellsItem.isSelected());
				rowsItem.setSelected(table.getRowSelectionAllowed());
				colunsItem.setSelected(table.getColumnSelectionAllowed());
			}
		});
		selectionMenu.add(cellsItem);
		
		JMenu tableMenu = new JMenu("Edit");
		menuBar.add(tableMenu);
		
		JMenuItem hideColumnsItem = new JMenuItem("Hide Columns");
		hideColumnsItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int [] selected = table.getSelectedColumns();
				TableColumnModel columnModel = table.getColumnModel();
				for(int i=selected.length-1;i>=0;i--) {
					TableColumn column = columnModel.getColumn(selected[i]);
					table.removeColumn(column);
					removedColumns.add(column);
				}
				
			}
		});
		tableMenu.add(hideColumnsItem);
		
		JMenuItem showColumnsItem = new JMenuItem("Show Columns");
		showColumnsItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for(TableColumn tc:removedColumns) {
					table.addColumn(tc);
				}
				removedColumns.clear();
			}
		});
		tableMenu.add(showColumnsItem);
		
		JMenuItem addRowItem = new JMenuItem("Add Row");
		addRowItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer[] newCells = new Integer[model.getColumnCount()];
				for(int i=0;i<newCells.length;i++) {
					newCells[i] = (i+1) * (model.getRowCount() +1);
				}
				model.addRow(newCells);
			}
		});
		tableMenu.add(addRowItem);
		
		JMenuItem removeRowsItem = new JMenuItem("Remove Rows");
		removeRowsItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int[] selected = table.getSelectedRows();
				for(int i=selected.length-1;i>=0;i--) {
					model.removeRow(selected[i]);
				}
			}
		});
		tableMenu.add(removeRowsItem);
		
		JMenuItem clearCellsItem = new JMenuItem("Clear Cells");
		clearCellsItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<table.getRowCount();i++) {
					for(int j=0;j<table.getColumnCount();j++) {
						if(table.isCellSelected(i, j)) {
							table.setValueAt(0, i, j);
						}
					}
				}
			}
		});
		tableMenu.add(clearCellsItem);
	}
}
/***
 * 
 *  javax.swing.JTable.TableModel
 *  Class getColumnClass(int columnIndex)
 * 
 * 
 *  javax.swing.JTable
 *  TableColumnModel getColumnModel()
 * 
 *  
 *  void setAutoResizeMode(int model)
 *  
 *  
 *  int getRowMargin()
 *  void setRowMargin(int margin)
 *  
 *  
 *  int getRowHeight()
 *  void setRowHeihgt(int height)
 *  
 *  
 *  int getRowHeight(int row)
 *  void setRowHeihgt(ine row,int height)
 *  
 *  
 *  ListSelectionModel getSelectionModel()
 *  
 *  
 *  boolean getRowSelectionAllowed()
 *  void setRowSelectionAllowed(boolean b)
 *  
 *  
 *  boolean getColumnSelectionAllowed()
 *  void setColumnSelectionAllowed(boolean b)
 *  
 *  
 *  boolean getCellSelectionEnabled()
 *  
 *  
 *  void setCellSelectionEnabled(boolean b)
 *  
 *  
 *  void addColumn(TableColumn column)
 *  
 *  
 *  void moveColumn(int from, int to)
 *  
 *  
 *  void removeColumn(TableColumn column)
 *  
 *  
 *  int convertRowIndexToModel(int index)
 *  int convertColumnIndexToModel(int index)
 *  
 *  
 *  void setRowSorter(RowSorter<? extends TableMOdel> sorter)
 *  
 *  
 *  javax.swing.table.TableColumnModel
 *  TabelColumn getColumn(int index)
 *  
 *  
 *  javax.swing.table.TableColumn
 *  TableColun(int modelColumnIndex)
 *  
 *  
 *  void setPreferredWidth(int width)
 *  void setMinWidth(int width)
 *  void setMaxWidth(int width)
 *  
 *  
 *  void setWidth(int width)
 *  
 *  
 *  void setResizable(boolean b)
 *  
 *  
 *  javax.swing.ListSelectionModel
 *  void setSelectionModel(int model)
 *  
 *  
 *  javax.swing.DefaultRowSorter<M,I>
 *  void setComparator(int column,Comparator<?> comparator)
 *  
 *  
 *  void setSortable(int column,boolean enabled)
 *  
 *  
 *  void setRowFilter(RowFilter<? super M,? super I> filter)
 *  
 *  
 *  javax.swing.table.TableRowSorter<M extends TableModel>
 *  void setStringConverter(TableStringConverter stringConverter)
 *  
 *  
 *  javax.swing.table.TableStringConverter<M extends TableModel>
 *  abstract String toString(TableModel model,int row, int column)
 *  
 *  
 *  javax.swing.RowFilter<M,I>
 *  boolean include(RowFilter.Entry<? extends M,? extends I> entry)
 *  
 *  
 *  
 *  
 * 
 */

