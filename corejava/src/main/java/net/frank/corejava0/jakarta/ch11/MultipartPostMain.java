package net.frank.corejava0.jakarta.ch11;

import java.io.File;
import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class MultipartPostMain {

	public static void main(String[] args) {
		HttpClient client = new HttpClient();
		String url = "http://www.discursive.com/cgi-bin/jccook/param_list.cgi";
		PostMethod method = new PostMethod(url);
		try {
			File file = new File("data","test.txt");
			File file2 = new File("data","sample.txt");
			
			FilePart filePart = new FilePart("test.txt",file,"text/plain","ISO-8859-1");
			FilePart filePart2 = new FilePart("sample.txt",file2,"text/plain","ISO-8859-1");
			
			FilePart[] parts = new FilePart[] {filePart,filePart2};
			MultipartRequestEntity multEntity = new MultipartRequestEntity(parts,new HttpMethodParams());
			method.setRequestEntity(multEntity);
			
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
