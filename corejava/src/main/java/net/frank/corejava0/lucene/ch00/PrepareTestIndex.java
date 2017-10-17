package net.frank.corejava0.lucene.ch00;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;

import net.frank.corejava0.lucene.LuceneConstants;

public class PrepareTestIndex {


	public static void main(String[] args) throws Exception {
		File indexDir = new File(LuceneConstants.DEFAULT_INDEX_DIR);
		File dataDir = new File(LuceneConstants.DEFAULT_DATA_DIR);

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
			} else if (f.getName().endsWith(".properties")) {
				indexFile(writer, f, baseDir);
			}
		}
	}

	private static void indexFile(IndexWriter writer, File file, File baseDir) throws IOException {
		Properties props = new Properties();
		try {
			props.load(new FileInputStream(file));
		} catch (IOException e) {
		}

		Document doc = new Document();

		// category comes from relative path below the base directory
		String category = file.getParent().substring(baseDir.getPath().length());
		category = category.replace(File.separatorChar, '/');

		String isbn = props.getProperty("isbn");
		String title = props.getProperty("title");
		String author = props.getProperty("author");
		String url = props.getProperty("url");
		String subject = props.getProperty("subject");
		String pubmonth = props.getProperty("pubmonth");

		System.out.println(title + "\n" + author + "\n" + subject + "\n" + category + "\n---------");

		doc.add(Field.Keyword("isbn", isbn));
		doc.add(Field.Keyword("category", category));
		doc.add(Field.Text("title", title));

		// split multiple authors into unique field instances
		String[] authors = author.split(",");
		for (int i = 0; i < authors.length; i++) {
			doc.add(Field.Keyword("author", authors[i]));
		}
		doc.add(Field.UnIndexed("url", url));
		doc.add(Field.UnStored("subject", subject, true));
		doc.add(Field.Keyword("pubmonth", pubmonth));
		doc.add(Field.UnStored("contents", aggregate(new String[] { title, subject, author })));

		writer.addDocument(doc);

	}

	private static String aggregate(String[] strings) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < strings.length; i++) {
			buffer.append(strings[i]);
			buffer.append(" ");
		}
		return buffer.toString();
	}
}
