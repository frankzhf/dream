package net.frank.corejava2.ch03;

import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class URLConnectionTest {
	
	
	
	public static void main(String[] args){
		try{
			String urlName;
			
			if(args.length >0){
				urlName = args[0];
			}else{
				urlName = "http://java.sun.com";
			}
			
			URL url = new URL(urlName);
			
			URLConnection connection = url.openConnection();
			if(args.length > 2){
				String username = args[1];
				String password = args[2];
				String input = username + ":" + password;
				String encoding = base64Encode(input);
				connection.setRequestProperty("Authorization", "Basic"+encoding);
			}
			connection.connect();
			
			Map<String,List<String>> headers = connection.getHeaderFields();
			for(Map.Entry<String, List<String>> entry:headers.entrySet()){
				String key = entry.getKey();
				for(String value:entry.getValue()){
					System.out.println(key+":"+value);
				}
			}
			
			System.out.println("---------------------------");
			System.out.println("getContentType:" + connection.getContentType());
			System.out.println("getContentLength:" + connection.getContentLength());
			System.out.println("getContentEncoding:" + connection.getContentEncoding());
			System.out.println("getDate:" +                                                                                                                                                          connection.getDate());
			System.out.println("getExpiration:" + connection.getExpiration());
			System.out.println("getLastModified:" + connection.getLastModified());
			
			Scanner in = new Scanner(connection.getInputStream());
			for(int n=1;in.hasNextLine()&& n<=10;n++){
				System.out.println(in.nextLine());
				if(in.hasNextLine()){
					System.out.println("...");
				}
			}
			in.close();
			
		}catch(IOException e){
			
		}
	}

	public static String base64Encode(String input) {
		ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		Base64OutputStream out = new Base64OutputStream(bOut);
		try{
			out.write(input.getBytes());
			out.flush();
		}catch(IOException e){
			
		}
		return bOut.toString();
	}
	
}



class Base64OutputStream extends FilterOutputStream{
	
	private int col = 0;
	private int i = 0;
	private int[] inbuff = new int[3];
	private static char[] toBase64 = {
			'A','B','C','D','E','F','G',
			'H','I','J','K','L','M','N',
			'O','P','Q','R','S','T','U',
			'V','W','X','Y','Z',
			'a','b','c','d','e','f','g',
			'h','i','j','k','l','m','n',
			'o','p','q','r','s','t','u',
			'v','w','x','y','z',
			'0','1','2','3','4','5','6',
			'7','8','9','+','/'
	};
	
	public Base64OutputStream(OutputStream out){
		super(out);
	}
	
	public void write(int c)throws IOException{
		inbuff[i] = c;
		i++;
		if(i == 3){
			super.write(toBase64[(inbuff[0] & 0xFC)>>2]);
			super.write(toBase64[((inbuff[0] & 0x03)<<4 | inbuff[1]&0xF0 >>4)]);
			super.write(toBase64[((inbuff[1] & 0x0F)<<2 | inbuff[2]&0xC0 >>6)]);
			super.write(toBase64[inbuff[2] & 0x3F]);
			col +=4;
			i = 0;
			if(col >= 76){
				super.write('\n');
				col = 0;
			}
		}
	}
	
	public void flush()throws IOException{
		if(i==1){
			super.write(toBase64[(inbuff[0] & 0xFC)>>2]);
			super.write(toBase64[(inbuff[0] & 0x03)<<4]);
			super.write('=');
			super.write('=');
			
		}else if(i == 2){
			super.write(toBase64[(inbuff[0] & 0xFC)>>2]);
			super.write(toBase64[((inbuff[0] & 0x03)<<4 | inbuff[1]&0xF0 >>4)]);
			super.write(toBase64[(inbuff[1] & 0x0F)<<2]);
		}
		if(col>0){
			super.write('\n');
			col = 0;
		}
	}
}
/***
 * java.net.URL
 * InputStream openStream();
 * 打开一个用于读取资源数据的输入流
 * 
 * UrlConnection openConnection()
 * 返回一个UrlConnection对象
 * 
 * 
 * java.net.URLConnection
 * void setDoInput(boolean doInput)
 * boolean getDoInput()
 * 如果doInput是true,那么用户可以接收来自UrlConnection的输入
 * 
 * void setDoOutput(boolean doOutput)
 * boolean getDoOutput()
 * 如果doOouput是true,那么用户可以将输出发送到该UrlConnection
 * 
 * void setIfModifiedSince(long time)
 * long getIfModifiedSince()
 * 只获取那些从某个给定时间以来修改过的数据
 * 
 * void setUseCaches(boolean useCaches)
 * boolean getUseCaches()
 * 是否从本地缓存中获取
 * 
 * void setAllowUserInteraction(boolean allowUserInteraction)
 * boolean getAllowUserInteraction()
 * 查询用户口令，查询必须由外部程序实现
 * 
 * void setConnectTimeout(int timeout)
 * int getConnectTimeout()
 * 连接超时的时限
 * 
 * void setReadTimeout(int timeout)
 * int getReadTimeout()
 * 读取数据超时的时限
 * 
 * void setRequestProperty(String key, String value)
 * 设置请求头的一个字段
 * 
 * Map<String,List<String>> getRequestProperties()
 * 返回请求头的属性的一个映射表
 * 
 * void connect()
 * 连接远程资源，并获取响应头信息
 * 
 * Map<String,List<String>> getHeaderFields()
 * 返回响应的一个映射表
 * 
 * String getHeaderFieldKey(int n)
 * 得到响应头的第n个字键，0或超出字段总数，返回null
 * 
 * String getHeaderField(int n)
 * 得到响应头的第n个值，0或超出字段总数，返回null
 * 
 * int getContentLength()
 * 如果知道内容长度，则返回该长度，否则为-1
 * 
 * String getContentType()
 * 获取内容类型 text/plain 或 image/gif
 * 
 * String getContentEncoding()
 * 获取内容编码
 * 
 * long getDate()
 * long getExpiration()
 * long getLastModifed()
 * 获取创建时间、过期时间及最后一次修改时间
 * 
 * InputStream getInputStream()
 * OutputStream getOutputStream()
 * 返回从资源读取信息或向资源写入信息的流
 * 
 * Object getContent()
 * 选择适当的内容处理器，以便读取资源数据并将它转换成对象
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

