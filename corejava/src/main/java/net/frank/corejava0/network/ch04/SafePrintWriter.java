package net.frank.corejava0.network.ch04;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class SafePrintWriter extends Writer {
	
	protected Writer out;
	private boolean autoFlush = false;
	private String lineSeparator;
	private boolean closed = false; 
	
	public SafePrintWriter(Writer out,String lineSeparator) {
		this(out,false,lineSeparator);
	}
			
	public SafePrintWriter(Writer out, char lineSeparator) {
		this(out,false,String.valueOf(lineSeparator));
	}
	
	public SafePrintWriter(Writer out, boolean autoFlush, String lineSeparator) {
		super(out);
		this.out = out;
		this.autoFlush = autoFlush;
		if(lineSeparator == null) {
			throw new NullPointerException("Null line separater");
		}
		this.lineSeparator = lineSeparator;
	}
	
	public SafePrintWriter(OutputStream out, boolean autoFlush,
			String encoding, String lineSeparator) throws UnsupportedEncodingException {
		this(new OutputStreamWriter(out,encoding),autoFlush,lineSeparator);
	}

	@Override
	public void flush() throws IOException {
		synchronized(lock) {
			if(closed) {
				throw new IOException("Stream closed");
			}
			out.flush();
		}
	}

	@Override
	public void close() throws IOException {
		try {
			flush();
		}catch(IOException e) {
			
		}
		synchronized(lock){
			out.close();
			closed = true;
		}
	}
	
	public void write(int c) throws IOException {
		synchronized(lock) {
			if(closed) {
				throw new IOException("Stream closed");
			}
			out.write(c);
		}
	}
	
	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		synchronized(lock) {
			if(closed) {
				throw new IOException("Stream closed");
			}
			out.write(cbuf, off, len);
		}
	}
	
	public void write(char[] text) throws IOException {
		synchronized(lock) {
			if(closed) {
				throw new IOException("Stream closed");
			}
			out.write(text, 0, text.length);
		}
	}
	
	public void write(String s, int off, int len) throws IOException {
		synchronized(lock) {
			if(closed) {
				throw new IOException("Stream closed");
			}
			out.write(s, off, len);
		}
	}
	
	public void print(boolean b) throws IOException{
		if(b){
			write("true");
		}else {
			write("false");
		}
	}
	
	public void println(boolean b) throws IOException{
		print(b);
		println();
	}
	
	public void print(char c) throws IOException{
		write(String.valueOf(c));
	}
	
	public void println(char c) throws IOException{
		print(c);
		println();
	}
	
	public void print(int i) throws IOException{
		write(String.valueOf(i));
	}
	
	public void println(int i) throws IOException{
		print(i);
		println();
	}
	
	public void print(long l) throws IOException{
		write(String.valueOf(l));
	}
	
	public void println(long l) throws IOException{
		print(l);
		println();
	}
	
	public void print(float f) throws IOException{
		write(String.valueOf(f));
	}
	
	public void println(float f) throws IOException{
		print(f);
		println();
	}
	
	public void print(double d) throws IOException{
		write(String.valueOf(d));
	}
	
	public void println(double d) throws IOException{
		print(d);
		println();
	}
	
	public void print(char[] text) throws IOException{
		write(String.valueOf(text));
	}
	
	public void println(char[] text) throws IOException{
		print(text);
		println();
	}
	
	public void print(String s) throws IOException{
		if(s == null) {
			write("null");
		}else {
			write(s);
		}
	}
	
	public void println(String s) throws IOException{
		print(s);
		println();
	}
	
	public void print(Object o) throws IOException{
		if(o == null) {
			write("null");
		}else {
			write(o.toString());
		}
	}
	
	public void println(Object o) throws IOException{
		print(o);
		println();
	}
	
	public void println() throws IOException{
		write(lineSeparator);
		if(autoFlush) {
			out.flush();
		}
	}
	
	
	
	
	
	
	
}
