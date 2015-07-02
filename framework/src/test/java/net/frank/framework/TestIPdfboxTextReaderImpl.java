package net.frank.framework;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Map;

import net.frank.framework.pdfbox.IPdfboxTextReader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;

public class TestIPdfboxTextReaderImpl extends TestCase {
	protected Log logger = LogFactory.getLog(getClass());

	protected ApplicationContext context = new ClassPathXmlApplicationContext(
			new String[] { "/applicationContext-pdfbox.xml" });

	public void setUp() throws Exception {
		super.setUp();
	}

	public void tearDown() throws Exception {
		super.tearDown();
	}

	public void testFunction() throws Exception {
		/**
		IPdfboxTextReader reader = (IPdfboxTextReader)context.getBean("testPdfBoxTextReader");
		FileInputStream fin = new FileInputStream("D:/java/test/b13691.pdf");
		Map<String,String>result = reader.parse(fin);
		
		**/
		FileInputStream fin = null;
		try{
			IPdfboxTextReader reader = (IPdfboxTextReader)context.getBean("testPdfBoxOcrTextReader");
			fin = new FileInputStream("D:/java/test/b13691.pdf");
			Map<String,String>result = reader.parse(fin);
			for(Iterator<String> it=result.keySet().iterator();it.hasNext();){
				String key= it.next();
				System.out.print(result.get(key));
			}
		
		}finally{
			if(fin!=null){
				fin.close();
			}
		}
		
		
	}

}
