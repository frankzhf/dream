package net.frank.framework.writer;

import java.io.IOException;
import java.io.Writer;
import java.util.Stack;

public class MarkupWriter {
	private Writer writer;
	private Stack<String> tagStack;

	private boolean tagOpened = false;

	public MarkupWriter(Writer writer) {
		this.writer = writer;
		tagStack = new Stack<String>();
	}

	public void begin(String tagName) throws IOException {
		if (tagOpened) {
			closeTag();
		}

		tagStack.push(tagName);

		writer.write("<");
		writer.write(tagName);

		tagOpened = true;
	}

	public void attribute(String name, String value) throws IOException {
		writer.write(' ');
		writer.write(name);
		writer.write("=\"");
		writer.write(value);
		writer.write('"');
	}

	public void end() throws IOException {
		if (tagOpened) {
			closeTag();
		}

		writer.write("</");
		writer.write((String) tagStack.pop());
		writer.write('>');
	}

	public MarkupWriter write(String value) throws IOException {
		if (tagOpened) {
			closeTag();
		}

		writer.write(value);

		return this;
	}

	public MarkupWriter write(int value) throws IOException {
		if (tagOpened) {
			closeTag();
		}

		writer.write(String.valueOf(value));
		return this;
	}

	public void flush() throws IOException {
		writer.flush();
	}

	protected void closeTag() throws IOException {
		writer.write(">");
		tagOpened = false;
	}
}