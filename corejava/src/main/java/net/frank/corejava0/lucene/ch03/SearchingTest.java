package net.frank.corejava0.lucene.ch03;

import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;

import net.frank.corejava0.lucene.ch00.LiaTestCase;

public class SearchingTest extends LiaTestCase {
	
	public void testTerm()throws Exception{
		IndexSearcher searcher = new IndexSearcher(directory);
		Term t = new Term("subject","ant");
	}
	
	
}
