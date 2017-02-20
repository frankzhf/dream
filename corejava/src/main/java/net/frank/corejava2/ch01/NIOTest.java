package net.frank.corejava2.ch01;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.zip.CRC32;

public class NIOTest {
	
	public static long checksumInputStrem(String filename)throws IOException{
		InputStream in = null;
		try{
			in =new FileInputStream(filename);
			CRC32 crc = new CRC32();
			int c;
			while((c=in.read())!=-1){
				crc.update(c);
			}
			return crc.getValue();
		}finally{
			if(in!=null){
				in.close();
			}
		}
	}
	
	
	public static long checksumBufferedInputStream(String filename)throws IOException{
		InputStream in = null;
		try{
			in =new BufferedInputStream(new FileInputStream(filename));
			CRC32 crc = new CRC32();
			int c;
			while((c=in.read())!=-1){
				crc.update(c);
			}
			return crc.getValue();
		}finally{
			if(in!=null){
				in.close();
			}
		}
	}
	
	public static long checksumRandomAccessFile(String filename)throws IOException{
		RandomAccessFile file = null;
		try{
			file = new RandomAccessFile(filename,"r");
			long length = file.length();
			CRC32 crc = new CRC32();
			for(long p=0;p<length;p++){
				file.seek(p);
				int c = file.readByte();
				crc.update(c);
			}
			return crc.getValue();
		}finally{
			if(file!=null){
				file.close();
			}
		}
	}
	
	public static long checksumMappedFile(String filename)throws IOException{
		FileInputStream in = null;
		FileChannel channel = null;
		try{
			in = new FileInputStream(filename);
			channel = in.getChannel();
			CRC32 crc = new CRC32();
			MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
			for(int p=0;p<channel.size();p++){
				int c = buffer.get(p);
				crc.update(c);
			}
			return crc.getValue();
		}finally{
			if(in!=null){
				in.close();
			}
		}
	}
	
	private static final String TEST_FILE = "C:/Program Files/Java/jdk1.7.0_79/src.zip";
	
	public static void main(String[] args)throws IOException{
		
		//args[0] = fileName;
		System.out.println("Input Stream:");
		long start = System.currentTimeMillis();
		long crcValue = checksumInputStrem(TEST_FILE);
		long end = System.currentTimeMillis();
		System.out.println(Long.toHexString(crcValue));
		System.out.println((end-start)+" milliseconds");
		
		System.out.println("Buffered Input Stream:");
		start = System.currentTimeMillis();
		crcValue = checksumBufferedInputStream(TEST_FILE);
		end = System.currentTimeMillis();
		System.out.println(Long.toHexString(crcValue));
		System.out.println((end-start)+" milliseconds");
		
		System.out.println("Random Access File:");
		start = System.currentTimeMillis();
		crcValue = checksumRandomAccessFile(TEST_FILE);
		end = System.currentTimeMillis();
		System.out.println(Long.toHexString(crcValue));
		System.out.println((end-start)+" milliseconds");
		
		System.out.println("Mapped File");
		start = System.currentTimeMillis();
		crcValue = checksumMappedFile(TEST_FILE);
		end = System.currentTimeMillis();
		System.out.println(Long.toHexString(crcValue));
		System.out.println((end-start)+" milliseconds");	
	}
}
/***
 * Class java.io.FileInputStream
 * FileChannel getChannel()
 * 返回用于访问这个流的通道
 * 
 * 
 * Class java.io.FileOutputStream
 * FileChannel getChannel()
 * 返回用于访问这个流的通道
 * 
 * 
 * Class java.io.RandomAccessFile
 * FileChannel getChannel()
 * 返回用于访问这个流的通道
 * 
 * 
 * Class java.nio.Buffer
 * boolean hasRemaining()
 * 当前缓冲区的位置没有到达界限位置，则返回true
 * 
 * int limit()
 * 返回这个缓冲区的位置，即没有何任可用的第一个位置 
 * 
 * 
 * Class java.nio.ByteBuffer
 * byte get()
 * 从当前位置获得一个字节，并将当前位置推到下一个字节
 * 
 * byte get(int index)
 * 从指定索引处获得一个字节
 * 
 * byteBuffer put(byte b)
 * 从当前位置推入一个字节，并将当前位置推到下一个字节。返回对这个缓冲区的引用
 * 
 * byteBuffer put(int index, byte b)
 * 向指定索引处推入一个字节。返回对这个缓冲区的引用
 * 
 * ByteBuffer get(byte[] destination)
 * ByteBuffer get(byte[] destination, int offset, int length)
 * 用缓冲区中的字节来填充字节数组
 * 
 * ByteBuffer put(byte[] source)
 * ByteBuffer put(byte[] source, int offset, int length)
 * 将字节数组推入缓冲区
 * 
 * Xxx getXxx()
 * Xxx getXxx(int index)
 * ByteBuffer putXxx(xxx value)
 * ByteBuffer putXxx(int index, xxx value)
 * 获取或放置一个二进制数, Int, Long, Short, Char, Float或 Double
 * 
 * ByteBuffer order(ByteOrder order)
 * ByteOrder order();
 * 设置或获得字节顺序
 * 
 * 		read/write          none-read/write         unuse
 * -------------------------------------------------------------
 * |                    |                     |                |
 * -------------------------------------------------------------
 * 0    mark		 position               limit           capacity
 * 
 * Buffer是一个抽象类，它有众多具体子类， 包括ByteBuffer, CharBuffer, DoubleBuffer, IntBuffer, LongBuffer 和ShortBuffer
 * 每个缓冲区都会有
 * 一个容量
 * 一个读写位置，下一个值将在些进行读写
 * 一个界限，超过它进行读写没有意义
 * 一个可先的标记，用于重复一个读入或写出操作
 * 
 * 
 * Class java.nio.Buffer
 * Buffer clear()
 * 位置和limit复位
 * 
 * Buffer flip()
 * 界限设置以位置，并将位置复位到0
 * 
 * Buffer rewind()
 * 读写位置复位到0,并保持极限不变
 * 
 * Buffer mark()
 * 将缓冲区标记设置到读写位置
 * 
 * Buffer reset()
 * 将缓冲区的位置设置到标记
 * 
 * int remaining()
 * 返回剩余可读入或写出的值的数量，即界限与位置之间的差异
 * 
 * int position()
 * 返回这个缓冲区的位置
 * 
 * int capacity()
 * 返回这个缓冲区的容量
 * 
 * Class java.nio.CharBuffer
 * char get()
 * CharBuffer get(char[] destination)
 * CharBuffer get(char[] destination, int offset, int length)
 * 从缓冲区位置开始获取char
 * 
 * CharBuffer put(char c)
 * CharBuffer put(char[] source)
 * CharBuffer put(char[] source, int offset, int length)
 * CharBuffer put(String source)
 * CharBuffer put(CharBuffer source)
 * 从缓冲区的位置开始处，推入一个char值
 * 
 * CharBuffer read(CharBuffer destination)
 * 从缓冲区位置开始获取char
 * 
 */