package net.frank.corejava0.lucene.ch02;

import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.WhitespaceAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.Hits;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;

public class DocumentUpdateTest extends BaseIndexingTestCase {
	public void testUpdate()throws IOException{
		assertEquals(1,getHitCount("city","Amsterdam"));
		IndexReader reader = IndexReader.open(dir);
		reader.delete(new Term("city","Amsterdam"));
		reader.close();
		
		assertEquals(0,getHitCount("city","Amsterdam"));
		IndexWriter writer = new IndexWriter(dir,getAnalyzer(),false);
		
		Document doc = new Document();
		
		doc.add(Field.Keyword("id", "1"));
		doc.add(Field.UnIndexed("country", "Netherlands"));
		doc.add(Field.UnStored("contents", "Amsterdam has lots of bridges"));
		doc.add(Field.Text("city","Haag"));
		
		writer.addDocument(doc);
		writer.optimize();
		writer.close();
		
		assertEquals(1,getHitCount("city","Haag"));
		
	}
	
	protected Analyzer getAnalyzer(){
		return new WhitespaceAnalyzer();
	}
	
	public int getHitCount(String fieldName, String searchString)
		throws IOException{
		IndexSearcher searcher = new IndexSearcher(dir);
		Term t = new Term(fieldName,searchString);
		Query query = new TermQuery(t);
		Hits hits = searcher.search(query);
		int hitCount = hits.length();
		searcher.close();
		return hitCount;
	}
}
