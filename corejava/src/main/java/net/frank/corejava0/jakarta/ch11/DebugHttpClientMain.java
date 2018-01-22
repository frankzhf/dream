package net.frank.corejava0.jakarta.ch11;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;

public class DebugHttpClientMain {
	
	public static void main(String[] args) throws Exception {
		String logging = "org.apache.commons.logging";
		System.setProperty(logging + ".Log",logging + ".impl.SimpleLog");
		System.setProperty(logging + ".logging.simplelog.showdatetime","true");
		System.setProperty(logging + ".simplelog.log.httpclient.wire", "debug");
		System.setProperty(logging + ".simplelog.log.org.apache.commons.httpclient", "debug");
		
		HttpClient client = new HttpClient();
		String url = "http://www.baidu.com";
		HttpMethod method = new GetMethod(url);
		
		try {
			client.executeMethod(method);
			if(method.getStatusCode() == HttpStatus.SC_OK) {
				String response = method.getResponseBodyAsString();
				System.out.println(response);
			}
		}catch(HttpException he) {
			System.out.println("HTTP Problem: " + he.getMessage());
		}catch(IOException ioe) {
			System.out.println("IO Exception: " + ioe.getMessage());
		}finally {
			method.releaseConnection();
		}
		
	}

}
