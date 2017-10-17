package net.frank.corejava0.lucene.ch01;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Hits;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class Searcher {
	static String queryString = "job | xargs ls -l";
	static String indexDir = "/Users/zhaofeng/projects/frank/source/dream/corejava/src/lucene/j3s5index";
	public static void main(String[] args) throws Exception {
		File indexFile = new File(indexDir);
		if(!indexFile.exists() || !indexFile.isDirectory()){
			throw new Exception(indexDir + 
					" does not exist or is not a directory.");
		}
		search(indexFile,queryString);
	}
	private static void search(File indexFile, String q) throws IOException {
		Directory fsDir = FSDirectory.getDirectory(indexFile, false);
		IndexSearcher is = new IndexSearcher(fsDir);
		try{
			Query query = QueryParser.parse(q, "contents", new StandardAnalyzer());
			long start = new Date().getTime();
			Hits hits = is.search(query);
			long end = new Date().getTime();
			
			System.out.println("Found " + hits.length() + " document(s) (in "+ 
					(end -start) + " milliseconds) that matched query '" + q + "':" );
			
			for(int i=0;i<hits.length();i++){
				Document doc = hits.doc(i);
				System.out.println(doc.get("fileName"));
			}
			
		}catch(ParseException e){
			
		}
	}

	/********
	域方法类型								被分析		被索引		被存储					使用举例
	Field.Keyword(String,String) 					yes			yes						电话和社会保险号码，URL， 个人姓名，日期
	Field.Keyword(String,Date) 						yes			yes						
	
	Field.UnIndexed(String,String)								yes						不作为搜索标准的文档类型（PDF、HTML等）
	
	Field.UnStored(String,String)		yes			yes									文档标题和内容
	
	Field.Text(String,String)			yes			yes			yes						文档标题和内容			
	
	Field.Text(String,Reader)			yes			yes									文档标题和内容						
	
	***/
}