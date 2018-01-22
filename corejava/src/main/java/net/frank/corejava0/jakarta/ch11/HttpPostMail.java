package net.frank.corejava0.jakarta.ch11;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

public class HttpPostMail {

	public static void main(String[] args) {
		HttpClient client = new HttpClient();
		String url = "http://www.discursive.com/cgi-bin/jccook/param_list.cgi";
		PostMethod method = new PostMethod(url);
		try {
			method.setParameter("test1", "Hello World");
			method.addParameter("test2", "This is a Form Submission");
			method.addParameter("Blah", "Whoop");
			method.addParameter(new NameValuePair("Blah","Whoop2"));
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