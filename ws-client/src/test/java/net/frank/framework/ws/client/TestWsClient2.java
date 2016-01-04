package net.frank.framework.ws.client;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;

public class TestWsClient2 {
	private static HttpClient httpClient = null;
	public static void main(String[] args) throws Exception {
		if(httpClient == null){
			httpClient = new HttpClient();
		}
		long currentTime = System.currentTimeMillis();
		PostMethod post = new PostMethod(
				"http://localhost:18080/cms/jaxrs/rest/transferXml");
		FileInputStream fis = new FileInputStream(
				"D:/projects/frank/code/cms/src/main/webapp/ee.xml");
		byte[] bytes = new byte[fis.available()];
		fis.read(bytes);
		fis.close();
		post.setRequestEntity(new ByteArrayRequestEntity(bytes));
		httpClient.executeMethod(post);
		InputStream in = post.getResponseBodyAsStream();
		bytes = new byte[in.available()];
		in.read(bytes);
		String returnXml = new String(bytes);
		System.out.println(System.currentTimeMillis() - currentTime);
		System.out.println(returnXml);
	}
}
