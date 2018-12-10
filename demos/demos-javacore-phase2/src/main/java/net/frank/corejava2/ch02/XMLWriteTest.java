package net.frank.corejava2.ch02;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLWriteTest {
	
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable(){

			@Override
			public void run() {
				XMLWriteFrame frame = new XMLWriteFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
	
}


class XMLWriteFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1367891528287442514L;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	
	private JFileChooser chooser;
	private RectangleComponent comp;
	
	
	public XMLWriteFrame(){
		setTitle("XMLWriteTest");
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		chooser = new JFileChooser();
		comp = new RectangleComponent();
		add(comp);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("File");
		menuBar.add(menu);
		
		JMenuItem newItem = new JMenuItem("New");
		menu.add(newItem);
		newItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comp.newDrawing();
			}
		});
		
		JMenuItem saveItem = new JMenuItem("Save with DOM/XSLT");
		menu.add(saveItem);
		saveItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				try{
					saveDocument();
				}catch(Exception e){
					JOptionPane.showMessageDialog(XMLWriteFrame.this, e.toString());
				}
			}
		});
		
		JMenuItem saveStAXItem = new JMenuItem("Save with StAX");
		menu.add(saveStAXItem);
		saveStAXItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				try{
					saveStAX();
				}catch(Exception e){
					JOptionPane.showMessageDialog(XMLWriteFrame.this, e.toString());
				}
			}
		});
		
		JMenuItem exitItem = new JMenuItem("Exit");
		menu.add(exitItem);
		exitItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	public void saveDocument()throws TransformerException, IOException{
		if(chooser.showOpenDialog(this)!=JFileChooser.APPROVE_OPTION){
			return;
		}
		File f = chooser.getSelectedFile();
		Document doc = comp.buildDocument();
		Transformer t = TransformerFactory.newInstance().newTransformer();
		t.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "http://www.w3.org/TR/2000/CK-SVG-20000802/DTD/svg-20000802.dtd");
		t.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "-//W3C/DTD SVG 20000802//EN");
		t.setOutputProperty(OutputKeys.INDENT, "yes");
		t.setOutputProperty(OutputKeys.METHOD, "xml");
		t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
		t.transform(new DOMSource(doc), new StreamResult(new FileOutputStream(f)));
	}
	
	public void saveStAX()throws FileNotFoundException,XMLStreamException{
		if(chooser.showOpenDialog(this)!=JFileChooser.APPROVE_OPTION){
			return;
		}
		File f = chooser.getSelectedFile();
		XMLOutputFactory factory = XMLOutputFactory.newInstance();
		XMLStreamWriter writer = factory.createXMLStreamWriter(new FileOutputStream(f));
		comp.writeDocument(writer);
		writer.close();
	}
}

class RectangleComponent extends JComponent{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7046215377727315829L;
	private List<Rectangle2D> rects;
	private List<Color> colors;
	private Random generator;
	private DocumentBuilder builder;
	
	public RectangleComponent(){
		rects = new ArrayList<Rectangle2D>();
		colors = new ArrayList<Color>();
		generator = new Random();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try{
			builder = factory.newDocumentBuilder();
		}catch(ParserConfigurationException e){
			e.printStackTrace();
		}
	}
	
	public void newDrawing(){
		int n = 10+ generator.nextInt(20);
		rects.clear();
		colors.clear();
		for(int i=1;i<=n;i++){
			int x = generator.nextInt(getWidth());
			int y = generator.nextInt(getHeight());
			int width = generator.nextInt(getWidth() - x);
			int height = generator.nextInt(getHeight() - y);
			rects.add(new Rectangle(x,y,width,height));
			int r = generator.nextInt(256);
			int g = generator.nextInt(256);
			int b = generator.nextInt(256);
			colors.add(new Color(r,g,b));
		}
		repaint();
	}
	
	public void paintComponent(Graphics g){
		if(rects.isEmpty()){
			newDrawing();
		}
		Graphics2D g2 = (Graphics2D) g;
		for(int i = 0;i <rects.size();i++){
			g2.setPaint(colors.get(i));
			g2.fill(rects.get(i));
		}
		
	}
	
	public Document buildDocument(){
		Document doc = builder.newDocument();
		Element svgElement = doc.createElement("svg");
		doc.appendChild(svgElement);
		svgElement.setAttribute("width", getWidth()+"");
		svgElement.setAttribute("height", getHeight()+"");
		for(int i=0;i<rects.size();i++){
			Color c = colors.get(i);
			Rectangle2D r = rects.get(i);
			Element rectElement = doc.createElement("rect");
			rectElement.setAttribute("x", r.getX()+"");
			rectElement.setAttribute("y", r.getY()+"");
			rectElement.setAttribute("width", r.getWidth()+"");
			rectElement.setAttribute("height", r.getHeight()+"");
			rectElement.setAttribute("fill", colorToString(c));
			svgElement.appendChild(rectElement);
		}
		
		
		return doc;
	}
	
	public void writeDocument(XMLStreamWriter writer) throws XMLStreamException{
		writer.writeStartDocument();
		writer.writeDTD("<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 20000802//EN\""
				+ "\"http://w3.org/TR/2000/CR-SVG-20000802/DTD/svg-20000802.dtd\">");
		writer.writeStartElement("svg");
		writer.writeAttribute("width", getWidth()+"");
		writer.writeAttribute("height", getHeight()+"");
		for(int i=0;i<rects.size();i++){
			Color c = colors.get(i);
			Rectangle2D r = rects.get(i);
			writer.writeStartElement("rect");
			writer.writeAttribute("x", r.getX()+"");
			writer.writeAttribute("y", r.getY()+"");
			writer.writeAttribute("width", r.getWidth()+"");
			writer.writeAttribute("height",r.getHeight()+"");
			writer.writeAttribute("fill", colorToString(c)+"");
			
			writer.writeEndElement();
		}
		
		writer.writeEndElement();
	}
	
	private String colorToString(Color c) {
		StringBuffer buffer = new StringBuffer(16);
		buffer.append(Integer.toHexString(c.getRGB() & 0xFFFFFF));
		while(buffer.length()>6){
			buffer.insert(0, '0');
		}
		buffer.insert(0,'#');
		return buffer.toString();
	}
}
/***
 * 
 *  Class javax.xml.stream.XMLOutputFactoy
 *  static XMLOutputFactory newInstance()
 *  返回一个工厂实例
 *  
 *  XMLStreamWriter createXMLStreamWriter(OutputStream in)
 *  XMLStreamWriter createXMLStreamWriter(OutputStream in, String characterEncoding)
 *  XMLStreamWriter createXMLStreamWriter(Writer in)
 *  XMLStreamWriter createXMLStreamWriter(Result in)
 *  创建一个给定的流的写出器
 *  
 *  Class javax.xml.stream.XMLStreamWriter
 *  void writeStartDocument()
 *  void writeStartDocument(String xmlVersion)
 *  void writeStartDocument(String encoding, String xmlVersion)
 *  在文档顶部定入XML指令，注意encoding参数只被用来写入这个属性，不会设置输入的字符编码机制
 *  
 *  void setDefaultNamespace(String namespaceURI)
 *  void setPrefix(String prefix, String namespaceURI)
 *  设置默认的名命空间
 *  
 *  void writeStartElement(String localName)
 *  void writeStartElement(String namespaceURI, String localName)
 *  写一个开始标签
 *  
 *  void writeEndElement()
 *  关闭当前元素
 *  
 *  void writeEndDocument()
 *  关闭所有打开元素
 *  
 *  void writeEmptyElement(String localName)
 *  void writeEmptyElement(String namespaceURI, String localName)
 *  写出一个自闭合的标签。
 *  
 *  void writeAttribute(String localName, String value)
 *  void writeAttribute(String namespaceURI, String localName, String value)
 *  写出一个当前元素的属性
 *  
 *  void writeCharacters(String text)
 *  写出一个字符数据
 *  
 *  void writeCDdata(String text)
 *  写出一个CData块
 *  
 *  void writeDTD(String dtd)
 *  写出一个DTD字符串
 *  
 *  void writeComment(String comment)
 *  写出一个注释
 *  
 *  void close()
 *  关闭这个写出器
 * 
 */
