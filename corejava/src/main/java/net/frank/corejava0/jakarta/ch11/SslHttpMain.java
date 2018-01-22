package net.frank.corejava0.jakarta.ch11;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.contrib.ssl.EasySSLProtocolSocketFactory;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;

public class SslHttpMain {

	public static void main(String[] args) throws Exception {
		HttpClient client = new HttpClient();
		String url = "https://www.baidu.com";
		/***
		 * more @see http://svn.apache.org/viewvc/httpcomponents/oac.hc3x/trunk/src/contrib/org/apache/commons/httpclient/contrib/ssl/
		 */
		ProtocolSocketFactory socketFactory = new EasySSLProtocolSocketFactory();
		Protocol https = new Protocol("https",socketFactory,443);
		Protocol.registerProtocol("https", https);
		
		HttpMethod method = new GetMethod(url);
		client.executeMethod(method);
		if(method.getStatusCode() == HttpStatus.SC_OK) {
			String response = method.getResponseBodyAsString();
			System.out.println(response);
		}
		method.releaseConnection();
		
	}

}
