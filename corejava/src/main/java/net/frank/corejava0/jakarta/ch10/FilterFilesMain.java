package net.frank.corejava0.jakarta.ch10;

import java.io.File;
import java.io.FilenameFilter;

import org.apache.commons.io.filefilter.AndFileFilter;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.NotFileFilter;
import org.apache.commons.io.filefilter.OrFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.apache.commons.lang.ArrayUtils;

public class FilterFilesMain {

	public static void main(String[] args) {
		File rootDir = new File(".");
		
		FilenameFilter fileFilter = new SuffixFileFilter(".xml");
		
		String[] xmlFiles = rootDir.list(fileFilter);
		System.out.println("*** XML Files");
		System.out.println(ArrayUtils.toString(xmlFiles));
		
		IOFileFilter htmlFilter = new OrFileFilter(new SuffixFileFilter(".htm"),
				new SuffixFileFilter(".html"));
		IOFileFilter notDirectory = new NotFileFilter(DirectoryFileFilter.INSTANCE);
		FilenameFilter file2Filter = new AndFileFilter(htmlFilter,notDirectory);
		
		String[] htmlFiles = rootDir.list(file2Filter);
		
		System.out.println("*** HTML Files");
		System.out.println(ArrayUtils.toString(htmlFiles));
		
	}

}
