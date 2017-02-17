package net.frank.corejava2.ch02;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileFilter;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XPathTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			@Override
			public void run() {
				JFrame frame = new XPathFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

}

class XPathFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2788198461746107658L;

	private DocumentBuilder builder;
	
	private Document doc;
	
	private XPath path;
	
	private JTextField expression;
	
	private JTextField result;
	
	private JTextArea docText;
	
	private JComboBox<String> typeCombo;
	
	public XPathFrame(){
		setTitle("XPathTest");
		JMenu fileMenu = new JMenu("File");
		JMenuItem openItem = new JMenuItem("Open");
		openItem.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				openFile();
			}

			
		});
		fileMenu.add(openItem);
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		fileMenu.add(exitItem);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(fileMenu);
		setJMenuBar(menuBar);
		
		ActionListener listener = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				eavluate();
			}
		};
		
		expression = new JTextField(20);
		expression.addActionListener(listener);
		JButton evaluateButton = new JButton("Evaluate");
		evaluateButton.addActionListener(listener);
		
		typeCombo = new JComboBox<String>(new String[]{"STRING","NODE","NODESET","NUMBER","BOOLEAN"});
		typeCombo.setSelectedItem("STRING");
		
		JPanel panel = new JPanel();
		panel.add(expression);
		panel.add(typeCombo);
		panel.add(evaluateButton);
		docText = new JTextArea(10,40);
		result = new JTextField();
		result.setBorder(new TitledBorder("Result"));
		
		add(panel,BorderLayout.NORTH);
		add(new JScrollPane(docText),BorderLayout.CENTER);
		add(result,BorderLayout.SOUTH);
		
		try{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
		}catch(ParserConfigurationException e){
			JOptionPane.showMessageDialog(this, e);
		}
		XPathFactory xpfactory = XPathFactory.newInstance();
		path = xpfactory.newXPath();
		pack();
	}
	
	public void openFile() {
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("."));
		chooser.setFileFilter(new FileFilter(){
			@Override
			public boolean accept(File f) {
				return f.isDirectory() || f.getName().toLowerCase().endsWith(".xml");
			}

			@Override
			public String getDescription() {
				return "XML files";
			}	
		});
		
		int r= chooser.showOpenDialog(this);
		if(r!=JFileChooser.APPROVE_OPTION)
			return;
		File f = chooser.getSelectedFile();
		FileInputStream input = null;
		try{
			byte[] bytes = new byte[(int)f.length()];
			input = new FileInputStream(f);
			input.read(bytes);
			docText.setText(new String(bytes));
			doc = builder.parse(f);
		}catch(IOException | SAXException e){
			JOptionPane.showMessageDialog(this, e);
		}finally{
			try{
				if(input!=null){
					input.close();
				}
			}catch(IOException e){
				JOptionPane.showMessageDialog(this, e);
			}
		}
		
			
	}
	
	public void eavluate(){
		try{
			String typeName = (String) typeCombo.getSelectedItem();
			QName returnType = (QName) XPathConstants.class.getField(typeName).get(null);
			Object evalResult = path.evaluate(expression.getText(),doc, returnType);
			if(typeName.equals("NODESET")){
				NodeList list = (NodeList) evalResult;
				StringBuilder builder = new StringBuilder();
				builder.append("{");
				for(int i=0;i<list.getLength();i++){
					if(i>0){
						builder.append(",");
					}
					builder.append("" + list.item(i));
				}
				builder.append("}");
				result.setText(""+builder);
			}else{
				result.setText(""+evalResult);
			}
			
		}catch(XPathExpressionException e){
			result.setText(""+e);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
/***
 * Class javax.xml.xpath.XPathFactory
 * static XPathFactory newInstance()
 * 返回工厂实例
 * 
 * XPath newXpath();
 * 构造一个XPath对象
 * 
 * Class javax.xml.xpath.XPath
 * String evaluate(String expression, Object startingPoint)
 * 从给定起点计算表达式，如果结果是一个节点或节点集，则返回了字符串包含所有文本节点子元素的数据
 * 
 * String evaluate(String expression, Object startingPoint, QName resultType)
 * 指定返回类型
 * XPathConstants STRING|NODE|NODESET|NUMBER|BOOLEAN
 * 				  String|Node|NodeList|Number|Boolean
 * 
 */
