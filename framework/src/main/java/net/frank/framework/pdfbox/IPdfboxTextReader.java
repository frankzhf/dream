package net.frank.framework.pdfbox;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public interface IPdfboxTextReader {
	Map<String,String> parse(InputStream pdfIs)throws IOException;
}
