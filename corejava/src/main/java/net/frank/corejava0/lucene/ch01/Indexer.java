package net.frank.corejava0.lucene.ch01;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;


public class Indexer {

	private static final String DEFAULT_INDEX_DIR = "/Users/zhaofeng/projects/frank/source/dream/corejava/src/lucene/j3s5index";

	private static final String DEFAULT_DATA_DIR = "/Users/zhaofeng/projects/frank/source/dream";

	public static void main(String[] args) throws Exception {
		File indexDir = new File(DEFAULT_INDEX_DIR);
		File dataDir = new File(DEFAULT_DATA_DIR);

		long start = new Date().getTime();
		int numIndexed = index(indexDir, dataDir);
		long end = new Date().getTime();

		System.out.println("Indexing " + numIndexed + " files took " + (end - start) + " milliseconds");

	}

	private static int index(File indexDir, File dataDir) throws IOException {
		if (!dataDir.exists() || !dataDir.isDirectory()) {
			throw new IOException(dataDir + " does not exist or is not a directory");
		}
		IndexWriter writer = new IndexWriter(indexDir, new StandardAnalyzer(), true);
		writer.setUseCompoundFile(false);
		indexDirectory(writer, dataDir, dataDir);
		int numIndexed = writer.docCount();
		writer.optimize();
		writer.close();
		return numIndexed;
	}

	private static void indexDirectory(IndexWriter writer, File dataDir, File baseDir) throws IOException {
		File[] files = dataDir.listFiles();
		for (int i = 0; i < files.length; i++) {
			File f = files[i];
			if (f.isDirectory()) {
				indexDirectory(writer, f, baseDir);
			} else if (f.getName().endsWith(".java")) {
				indexFile(writer, f, baseDir);
			}
		}
	}

	private static void indexFile(IndexWriter writer, File f, File baseDir) throws IOException {
		if(f.isHidden() || !f.exists() || !f.canRead()){
			return;
		}
		System.out.println("Indexing " + f.getCanonicalPath());
		Document doc = new Document();
		doc.add(Field.Text("contents", new FileReader(f)));
		doc.add(Field.Keyword("fileName", f.getCanonicalPath()));
		writer.addDocument(doc);
	}
}
