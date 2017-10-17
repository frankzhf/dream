package net.frank.corejava0.lucene.ch02;

import java.io.File;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class IndexTuningDemo {

	public static void main(String[] args) throws Exception{
		int docsInIndex = Integer.parseInt(args[0]);
		String indexDir = System.getProperty("java.io.tmpdir","tmp") 
				+ File.separator + "index-dir";
		Directory dir = FSDirectory.getDirectory(indexDir, true);
		IndexWriter writer = new IndexWriter(dir,new StandardAnalyzer(),true);
		writer.mergeFactor = Integer.parseInt(args[1]);
		writer.maxMergeDocs = Integer.parseInt(args[2]);
		writer.minMergeDocs = Integer.parseInt(args[3]);
		writer.infoStream = System.out;
		
		System.out.println("Merge factor: " + writer.mergeFactor);
		System.out.println("Max merge docs: " + writer.maxMergeDocs);
		System.out.println("Min merge docs: " + writer.minMergeDocs);
		
		long start = System.currentTimeMillis();
		
		for(int i=0; i<docsInIndex;i++){
			Document doc = new Document();
			doc.add(Field.Text("fieldName", "bibamus"));
			writer.addDocument(doc);
		}
		
		
		writer.close();
		long stop = System.currentTimeMillis();
		System.out.println("Time: " +(stop-start) + " ms");
		
	}

}
