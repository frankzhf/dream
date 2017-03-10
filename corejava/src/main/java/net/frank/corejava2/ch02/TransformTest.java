package net.frank.corejava2.ch02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.AttributesImpl;

public class TransformTest {

	public static void main(String[] args) throws Exception {
		InputStream xslFile;
		if (args.length > 0) {
			xslFile = new FileInputStream(args[0]);
		} else {
			xslFile = Thread.currentThread().getContextClassLoader().getResourceAsStream("net/frank/corejava2/ch02/makehtml.xsl");
																							
		}
		StreamSource styleSource = new StreamSource(xslFile);

		Transformer t = TransformerFactory.newInstance().newTransformer(styleSource);
		t.setOutputProperty(OutputKeys.INDENT, "yes");
		t.setOutputProperty(OutputKeys.METHOD, "xml");
		t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
		t.transform(
				new SAXSource(new EmployeeReader(),new InputSource(Thread.currentThread().getContextClassLoader().getResourceAsStream("net/frank/corejava2/ch02/employee.dat"))), 
				new StreamResult(System.out));
	}

}

class EmployeeReader implements XMLReader {
	
	private ContentHandler handler;
	
	@Override
	public boolean getFeature(String name) throws SAXNotRecognizedException, SAXNotSupportedException {
		return false;
	}

	@Override
	public void setFeature(String name, boolean value) throws SAXNotRecognizedException, SAXNotSupportedException {
	}

	@Override
	public Object getProperty(String name) throws SAXNotRecognizedException, SAXNotSupportedException {
		
		return null;
	}

	@Override
	public void setProperty(String name, Object value) throws SAXNotRecognizedException, SAXNotSupportedException {

	}

	@Override
	public void setEntityResolver(EntityResolver resolver) {

	}

	@Override
	public EntityResolver getEntityResolver() {
		return null;
	}

	@Override
	public void setDTDHandler(DTDHandler handler) {

	}

	@Override
	public DTDHandler getDTDHandler() {
		return null;
	}

	@Override
	public void setContentHandler(ContentHandler handler) {
		this.handler = handler;
	}

	@Override
	public ContentHandler getContentHandler() {
		return handler;
	}

	@Override
	public void setErrorHandler(ErrorHandler handler) {
	}

	@Override
	public ErrorHandler getErrorHandler() {
		return null;
	}

	@Override
	public void parse(InputSource input) throws IOException, SAXException {
		InputStream stream = input.getByteStream();
		BufferedReader in = new BufferedReader(new InputStreamReader(stream));
		String  rootElement = "staff";
		AttributesImpl atts = new AttributesImpl();
		if(handler == null) throw new SAXException("No content handler");
		
		handler.startDocument();
		handler.startElement("", rootElement, rootElement, atts);
		String line;
		while((line = in.readLine())!=null){
			handler.startElement("", "employee", "employee", atts);
			StringTokenizer t = new StringTokenizer(line,"|");
			
			handler.startElement("", "name", "name", atts);
			String s = t.nextToken();
			handler.characters(s.toCharArray(), 0, s.length());
			handler.endElement("","name","name");
			
			handler.startElement("", "salary", "salary", atts);
			s = t.nextToken();
			handler.characters(s.toCharArray(), 0, s.length());
			handler.endElement("","salary","salary");
			
			atts.addAttribute("","year", "year", "CDATA", t.nextToken());
			atts.addAttribute("","month", "month", "CDATA", t.nextToken());
			atts.addAttribute("","day", "day", "CDATA", t.nextToken());
			
			handler.startElement("", "hiredate", "hiredate", atts);
			handler.endElement("", "hiredate", "hiredate");
			atts.clear();
			
			handler.endElement("", "employee", "employee");
		}		
		handler.endElement("", rootElement, rootElement);
		handler.endDocument();
		
	}

	@Override
	public void parse(String systemId) throws IOException, SAXException {
		
	}

}

/****
 * Class javax.xml.transform.TransformerFactory
 * Transformer newTransformer(Source stylesheet)
 * 返回一个Transformer实例，用来从指定的源中读取样式
 * 
 * Class javax.xml.transform.stream.StreamSource
 * StreamSource(File f)
 * StreamSource(InputStream in)
 * StreamSource(Reader in)
 * StreamSource(String systemID)
 * 根据一个文件，流，阅读器或系统ID(通常是相对或绝对的URL)，来构建一个数据流源
 * 
 * Class javax.xml.transform.sax.SAXSource
 * SAXSource(XMLReader reader, InputSource source)
 * 构建一个SAX数据源
 * 
 * Class org.xml.sax.XMLReader
 * void setContentHandler(ContentHandler handler)
 * 设置在输入被解析时会被告知解析事件的处理器
 * 
 * void parse(InputSource source)
 * 根据给定国输入源解析输入数据，并将解析事件发送到内容处理器
 * 
 * Class javax.xml.transform.dom.DOMResult
 * DOMResult(Node n)
 * 根据给定节点构建一个数据源。通常，n是一个新文档的节点
 * 
 * Class org.xml.sax.helpers.AttributesImpl
 * void addAttribute(String uri, String lname, String qname, String type, String value)
 * 将属性添加到该属性集合
 * uri		名字空间的uri
 * lname	无别名前缀的本地名
 * qname	带别名前缀的限定名
 * type		类型	CDATA，ID，IDREF，IDREFS，NMTOKEN，NMTOKENS,ENTITY,ENTITIES,NOTATION
 * value	属性值
 * 
 * void clear()
 * 删除属性集合中的所有属性
 */

