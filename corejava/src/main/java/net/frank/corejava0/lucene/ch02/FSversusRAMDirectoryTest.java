package net.frank.corejava0.lucene.ch02;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.lucene.analysis.SimpleAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.RAMDirectory;

import junit.framework.TestCase;

public class FSversusRAMDirectoryTest extends TestCase {
	
	private Directory fsDir;
	private Directory ramDir;
	
	private Collection<String> docs = loadDocuments(3000,5);
	
	protected void setUp()throws Exception{
		String fsIndexDir = System.getProperty("java.io.tmpdir","tmp") 
				+ File.separator + "index-dir";
		ramDir = new RAMDirectory();
		fsDir = FSDirectory.getDirectory(fsIndexDir, true);
	}
	
	public void testTiming()throws IOException{
		long ramTiming = timeIndexWriter(ramDir);
		long fsTiming = timeIndexWriter(fsDir);
		assertTrue(fsTiming > ramTiming);
		System.out.println("RAMDirectory Time: " + (ramTiming) + " ms" );
		System.out.println("FSDirectory Time: " + (fsTiming) + " ms" );
	}
	
	private long timeIndexWriter(Directory dir) throws IOException{
		long start = System.currentTimeMillis();
		addDocuments(dir);
		long stop = System.currentTimeMillis();
		return (stop - start);
	}
	
	
	private void addDocuments(Directory dir) throws IOException {
		IndexWriter writer = new IndexWriter(dir,new SimpleAnalyzer(),true);
		for(Iterator<String> iter = docs.iterator();iter.hasNext();){
			Document doc = new Document();
			String word = iter.next();
			doc.add(Field.Keyword("keyword", word));
			doc.add(Field.Keyword("unindexed", word));
			doc.add(Field.Keyword("unstored", word));
			doc.add(Field.Keyword("text", word));
			writer.addDocument(doc);
		}
		writer.optimize();
		writer.close();
	}

	private Collection<String> loadDocuments(int numDocs, int wordsPerDoc) {
		Collection<String> docs = new ArrayList<String>(numDocs);
		for(int i=0;i<numDocs;i++){
			StringBuffer sb = new StringBuffer(wordsPerDoc);
			for(int j=0;j<wordsPerDoc;j++){
				sb.append("Bibamus ");
			}
			docs.add(sb.toString());
		}
		
		return docs;
	}
	
	
}
