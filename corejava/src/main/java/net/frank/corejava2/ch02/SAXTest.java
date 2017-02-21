package net.frank.corejava2.ch02;

import java.io.InputStream;
import java.net.URL;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class SAXTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		String url;
		if (args.length == 0) {
			url = "http://www.w3c.org";
		} else {
			url = args[0];
		}
		DefaultHandler hander = new DefaultHandler() {

			public void startElement(String namespaceURI, 
					String lname, String qname, Attributes attrs) {
				if(lname.equals("a") && attrs!= null){
					for(int i=0;i<attrs.getLength();i++){
						String aname = attrs.getLocalName(i);
						if(aname.equals("href")){
							System.out.println(attrs.getValue(i));
						}
					}
				}
			}

		};
		SAXParserFactory factory = SAXParserFactory.newInstance();
		factory.setNamespaceAware(true);
		SAXParser saxParser = factory.newSAXParser();
		InputStream in = new URL(url).openStream();
		saxParser.parse(in, hander);
	}
}

/****
 * Class javax.xml.parsers.SAXParserFactory
 * static SAXParserFactory newInstance()
 * 返回SAXParserFactory类的一个实例
 * 
 * SAXParser newSAXParser()
 * 返回SAXParser类的一个实例
 * 
 * boolean isNamespaceAware()
 * void setNamespaceAware(boolean value)
 * 获取或设置工厂的namespaceAware属性
 * 
 * boolean isValidating()
 * void setValidating(boolean value)
 * 获取或设置工厂的validating属性
 * 
 * Class javax.xml.parsers.SAXParser
 * void parse(File f, DefaultHandler handler)
 * void parse(String url, DefaultHandler handler)
 * void parse(InputStream in, DefaultHandler handler)
 * 解析来自给定文件，URL或输入流的XML文档，并把解析事件报告给指定的处理器
 * 
 * Class org.xml.sax.ContentHandler
 * void startDocument()
 * void endDocument()
 * 在文档起始或结束时被调用，不用命名空间
 * 
 * void startDocument(String uri, String lname, String qname, Attributes attr)
 * void endDocument(String uri, String lname, String qname)
 * 在文档起始或结束时被调用，使用命名空间
 * 
 * void characters(char[] data,int start, int length)
 * 解析器报告字符数据时被调用
 * 
 * Class org.xml.sax.Attributes
 * int length()
 * 返回存储在该属性集合中属性数量
 * 
 * String getLocalName(int index)
 * 返回给定索引的属性的本地名，不支持命名空间则返回空
 * 
 * String getURI(int index)
 * 返回给定索引的属性的命名空间URI，不支持命名空间或属性没有uri则返回空
 * 
 * String getQName(int index)
 * 返回给定索引的属性的命名空间的限定名，不支持命名空间或属性没有uri则返回空
 * 
 * String getValue(int index)
 * String getValue(String qname)
 * String getValue(String uri, String lname)
 * 获取节点的值根所给定索引，限定名或命名空间+本地名；不存在时，返回null
 */