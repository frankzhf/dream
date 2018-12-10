package net.frank.corejava2.ch01;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

public class ZipTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){

			@Override
			public void run() {
				ZipTestFrame frame = new ZipTestFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				
			}
			
		});

	}
	
}

class ZipTestFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5407223920994639886L;
	private static final int DEFAULT_WIDTH = 400;
	private static final int DEFAULT_HEIHGT = 300;
	private JComboBox<String> fileCombo;
	private JTextArea fileText;
	private String zipname;
	
	public ZipTestFrame(){
		setTitle("ZipTest");
		setSize(DEFAULT_WIDTH,DEFAULT_HEIHGT);
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("File");
		JMenuItem openItem = new JMenuItem("Open");
		menu.add(openItem);
		openItem.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new File("."));
				int r = chooser.showOpenDialog(ZipTestFrame.this);
				if(r == JFileChooser.APPROVE_OPTION){
					zipname = chooser.getSelectedFile().getPath();
					fileCombo.removeAllItems();
					scanZipFile();
				}
			}
		});
		
		JMenuItem exitItem = new JMenuItem("Exit");
		menu.add(exitItem);
		exitItem.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menuBar.add(menu);
		setJMenuBar(menuBar);
		
		fileText = new JTextArea();
		fileCombo = new JComboBox<String>();
		fileCombo.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				loadZipFile(fileCombo.getItemAt(
						fileCombo.getSelectedIndex()));
			}
		});
		add(fileCombo,BorderLayout.SOUTH);
		add(new JScrollPane(fileText),BorderLayout.CENTER);
		
	}
	
	public void scanZipFile(){
		new SwingWorker<Void,String>(){
			@Override
			protected Void doInBackground() throws Exception {
				ZipInputStream zin = new ZipInputStream(new FileInputStream(zipname));
				ZipEntry entry;
				while((entry = zin.getNextEntry())!=null){
					publish(entry.getName());
					zin.closeEntry();
				}
				zin.close();
				return null;
			}
			
			protected void process(List<String> names){
				for(String name:names){
					fileCombo.addItem(name);
				}
			}
		}.execute();
	}
	
	public void loadZipFile(final String name){
		fileCombo.setEnabled(false);
		fileText.setText("");
		new SwingWorker<Void,Void>(){
			@Override
			protected Void doInBackground() throws Exception {
				try{
					ZipInputStream zin = new ZipInputStream(
							new FileInputStream(zipname));
					ZipEntry entry;
					while((entry=zin.getNextEntry())!=null){
						if(entry.getName().equals(name)){
							Scanner in = new Scanner(zin);
							while(in.hasNext()){
								fileText.append(in.nextLine());
								fileText.append("\n");
							}
							in.close();
							zin.closeEntry();
							break;
						}
						zin.closeEntry();
					}
					zin.close();
				}catch(IOException e){
					e.printStackTrace();
				}
				return null;
			}
			
			protected void done() {
				fileCombo.setEnabled(true);
			}
		}.execute();
	}
}

/***
 * Class java.util.zip.ZipInputStream
 * ZipInputStrem(InputStream in)
 * 创建一个ZipInputStream, 使得我们可以给定的InputStream向其中填充数据
 * 
 * ZipEntry getNextEntry()
 * 为下一项返回ZipEntry对象，没有更多的项时返回null
 * 
 * void closeEntry()
 * 关闭这个Zip文件中当前打开的项
 * 
 * 
 * Class java.util.zip.ZipOutputStream
 * ZipOutputStrem(OutputStream out)
 * 创建一个将压缩数据写出到指定的OutputStream的ZipOutputStream
 * 
 * void putNextEntry(ZipEntry ze)
 * 将指定的ZipEntry中的信息写出到流中，并定为用于写出数据的流，当调用write方法时，数据可以写入到指定的流中
 * 
 * void closeEntry()
 * 关闭这个zip文件中当前打开的项。
 * 
 * void setLevel(int level)
 * 设置后续的各个DEFAULT项的默认压缩级别，默认是DEFAULT_COMPRESSION (-1) 可以设置0-9
 * 
 * void setMethod(int method)
 * 设置后续压缩方法 DEFLATED(0)，STORED(8),默认是DEFLATED(0)
 * 
 * 
 * Class java.util.zip.ZipEntry
 * ZipEntry(String name)
 * 构造
 * 
 * long getCrc()
 * 返回CRC32校验和的值
 * 
 * String getName()
 * 返回这一项的名称
 * 
 * long getSize()
 * 返回这一项不压缩的大小。或都在不可知的情况下返回-1
 * 
 * boolean isDirectory()
 * 是否是目录
 * 
 * void setMethod(int method)
 * 参见ZipOutputStream.setMethod(int method)
 * 
 * void setSize(long size)
 * 设置这项不被压缩的大小，只有在压缩方法为STORED时才是必需的
 * 
 * void setCrc(long crc)
 * 设置CRC32校验和。只有在压缩方法为STORED时才是必需的
 * 
 * Class java.util.zip.ZipFile
 * ZipFile(String file)
 * ZipFile(File file)
 * 构造函数
 * 
 * Enumeratio entries()
 * 获取所有的ZipEntry
 * 
 * ZipEntry getEntry(String name)
 * 返回给定名字的ZipEntry,没有对应时返回null
 * 
 * InputStream getInputStream(ZipEntry ze)
 * 返回给定项的inputStream
 * 
 * String getName()
 * 返回这个ZIP文件的路径
 * 
 */
