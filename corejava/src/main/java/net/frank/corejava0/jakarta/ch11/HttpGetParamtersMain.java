package net.frank.corejava0.jakarta.ch11;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.util.URIUtil;

public class HttpGetParamtersMain {

	public static void main(String[] args) {
		callSetParameters();
		callNameValuePair();
	}

	private static void callNameValuePair() {
		HttpClient client = new HttpClient();
		String url = "http://www.discursive.com/cgi-bin/jccook/param_list.cgi";
		HttpMethod method = new GetMethod(url);
		try {
			NameValuePair pair0 = new NameValuePair("test1",URIUtil.encodeQuery("O Reilly"));
			NameValuePair pair1 = new NameValuePair("hlah",URIUtil.encodeQuery("Whoop"));
			NameValuePair[] params = new NameValuePair[] {pair0,pair1};
			method.setQueryString(params);
			System.out.println("With Query String:" + method.getURI());
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

	private static void callSetParameters() {
		HttpClient client = new HttpClient();
		String url = "http://www.discursive.com/cgi-bin/jccook/param_list.cgi";
		HttpMethod method = new GetMethod(url);
		try {
			method.setQueryString(URIUtil.encodeQuery("test1=O Reilly&blah=Whoop"));
			System.out.println("With Query String:" + method.getURI());
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
