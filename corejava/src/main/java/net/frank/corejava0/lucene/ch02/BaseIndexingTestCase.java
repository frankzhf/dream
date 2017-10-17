package net.frank.corejava0.lucene.ch02;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.SimpleAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import junit.framework.TestCase;

/***
 * 
 * 1.转换成文本
 * 2.分析
 * 3.将分析后的数据写入索引
 * 
 * @author zhaofeng
 *
 */

public abstract class BaseIndexingTestCase extends TestCase {
	protected String[] keywords = {"1","2"};
	protected String[] unindexed = {"Netherlands","Italy"};
	protected String[] unstored = {"Amsterdam has lots of bridges","Venice has lots of canals"};
	protected String[] text = {"Amsterdam","Venice"};
	
	protected Directory dir;
	
	protected void setUp()throws IOException{
		String indexDir = System.getProperty("java.io.tmpdir","tmp") 
				+ File.separator + "index-dir";
		dir = FSDirectory.getDirectory(indexDir,true);
		addDocuments(dir);
	}

	protected void addDocuments(Directory index)
		throws IOException{
		IndexWriter writer = new IndexWriter(dir,getAnalyzer(),true);
		writer.setUseCompoundFile(isCompound());
		
		for(int i=0;i<keywords.length;i++){
			Document doc = new Document();
			doc.add(Field.Keyword("id", keywords[i]));
			doc.add(Field.UnIndexed("country", unindexed[i]));
			doc.add(Field.UnStored("contents", unstored[i]));
			doc.add(Field.Text("city", text[i]));
			
			writer.addDocument(doc);
		}
		
		
		writer.optimize();
		writer.close();
	}
	
	protected Analyzer getAnalyzer(){
		return new SimpleAnalyzer();
	}
	
	protected boolean isCompound(){
		return true;
	}
	
}
