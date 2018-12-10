package net.frank.corejava2.ch02;

import java.io.InputStream;
import java.net.URL;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;

public class StAXTest {
	
	public static void main(String[] args) throws Exception {
		String url = null;
		if(args.length ==0){
			url = "http://www.w3c.org";
		}else{
			url = args[0];
		}
		
		URL _url = new URL(url);
		InputStream in = _url.openStream();
		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLStreamReader parser = factory.createXMLStreamReader(in);
		while(parser.hasNext()){
			int event = parser.next();
			/**
			 * 解析器依次产生的事件
			 * START_ELEMENT
			 * END_ELEMENT
			 * PROCESSING_INSTRUCTION
			 * CHARACTERS
			 * COMMENT
			 * SPACE
			 * START_DOCUMENT
			 * END_DOCUMENT
			 * ENTITY_REFERENCE
			 * ATTRIBUTE
			 * DTD
			 * CDATA
			 * NAMESPACE
			 * NOTATION_DECLARATION
			 * ENTITY_DECLARATION
			 */
			if(event == XMLStreamConstants.START_ELEMENT){
				if(parser.getLocalName().equals("a")){
					String href = parser.getAttributeValue(null,"href");
					if(href!=null){
						System.out.println(href);
					}
				}
			}
		}	
	}
}
/***
 * 
 * Class javax.xml.stream.XMLInputFactory
 * static XMLInputFactory newInstance()
 * 返回XMLInputFactory类的一个实例
 * 
 * void setProperty(String name, Object value)
 * 设置工厂属性
 * javax.xml.stream.isValidating						这个文档是否需要验证			默认是false
 * javax.xml.stream.isNamespaceAware					这个文档虽否需要处理命名空间		默认是true
 * javax.xml.stream.isCoalescing						这个文档虽否需要连接邻近字符		默认是false
 * javax.xml.stream.isReplaceingEntityReferences		实体引用将作为字符数据被引用和报告	默认是true
 * javax.xml.stream.isSupportingExternalEntities		外部实体将被解析				默认是true
 * javax.xml.stream.supportDTD							DTD将作为事件被报靠			默认是true
 * 
 * 
 * XMLStreamReader createXMLStreamReader(InputStream in)
 * XMLStreamReader createXMLStreamReader(InputStream in, String chanracterEncoding)
 * XMLStreamReader createXMLStreamReader(Reader in)
 * XMLStreamReader createXMLStreamReader(Source in)
 * 创建一个从给定的流，阅读器或JAXP源读入的解析器
 * 
 * Class javax.xml.stream.XMLStreamReader
 * boolean hasNext()
 * 如果有另一个事件，则返回true
 * 
 * int next()
 * 将解析器的状态设置为下一个解析事件，并返回XMLStreamConstants定义的常量
 * 
 * boolean isStartElement()
 * boolean isEndElement()
 * boolean isCharacters()
 * boolean isWhiteSpace()
 * 
 * 
 * QName getName()
 * String getLocalName()
 * 
 * 
 * String getText()
 * 
 * 
 * int getAttributeCount()
 * 
 * 
 * QName getAttributeName(int index)
 * String getAttributeLocalName(int index)
 * String getAttributeValue(int index)
 * 
 * 
 * String getAttributeValue(String namespaceURI, String name)
 * 
 */

