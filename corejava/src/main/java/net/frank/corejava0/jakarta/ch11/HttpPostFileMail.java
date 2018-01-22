package net.frank.corejava0.jakarta.ch11;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;

public class HttpPostFileMail {
	public static void main(String[] args) {
		HttpClient client = new HttpClient();
		String url = "http://www.discursive.com/cgi-bin/cgi.tcl/echo.cgi";
		PostMethod method = new PostMethod(url);		
		try {
			File file = new File("project.xml");
			method.setRequestEntity(new InputStreamRequestEntity(new FileInputStream(file)));
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