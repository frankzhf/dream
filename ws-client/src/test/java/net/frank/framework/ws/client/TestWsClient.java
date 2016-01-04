package net.frank.framework.ws.client;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import net.frank.commons.CommonConstants;
import net.frank.framework.bo.Resource;
import net.frank.framework.bo.Type;
import net.frank.framework.service.CacheService;
import net.frank.framework.ws.define.WsAaInfo;
import net.frank.framework.ws.define.WsRequest;
import net.frank.framework.ws.define.WsResponse;
import net.frank.framework.ws.process.BoXmlUtil;
import net.frank.framework.ws.render.type.ResourceTypeRender;
import net.frank.framework.ws.service.impl.TypeContextSetHolder;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class TestWsClient {

	private static final Integer DEFAULT_BUFFER_LENGTH = 4096;

	private static HttpClient httpClient = null;

	private static final String WS_LOGIN_URL = "http://localhost:18080/cms/jaxrs/welcome/login";

	private static final String WS_GET_PATH_URL = "http://localhost:18080/cms/jaxrs/rest/getByPath/";

	private static final String WS_GET_URL = "http://localhost:18080/cms/jaxrs/rest/get";

	private static final String typeFolderPath = "resType";

	public static void main(String[] args) throws Exception {
		if (httpClient == null) {
			httpClient = new HttpClient();
		}
		long currentTime = System.currentTimeMillis();
		WsAaInfo wsAaInfo = new WsAaInfo();
		wsAaInfo.setLoginName("root");
		wsAaInfo.setPassword("p@ssw0rd");
		BoXmlUtil boXmlUtil = (BoXmlUtil) ClientUtils.getInstance().getBean("boXmlUtil");
		String xml = boXmlUtil.aa2Xml(wsAaInfo);
		PostMethod post = new PostMethod(WS_LOGIN_URL);
		post.setRequestEntity(new ByteArrayRequestEntity(xml.getBytes()));
		httpClient.executeMethod(post);
		String returnXml = inputStream2String(post.getResponseBodyAsStream());
		wsAaInfo = boXmlUtil.xml2Aa(returnXml);
		System.out.println(wsAaInfo.getLoginStatus());
		GetMethod get = new GetMethod(WS_GET_PATH_URL + typeFolderPath);
		httpClient.executeMethod(get);
		returnXml = inputStream2String(get.getResponseBodyAsStream());
		WsResponse rt = boXmlUtil.xml2WsResponse(returnXml);
		if (rt != null
				&& CommonConstants.CMS_CODE.MESSAGE_OK.equals(rt
						.getMessageNumber()) && rt.getResource() != null
				&& !rt.getResource().getChildren().isEmpty()) {
			Map<Long, Type> _typeContent = new HashMap<Long, Type>();
			for (Iterator<Resource> it = rt.getResource().getChildren()
					.iterator(); it.hasNext();) {
				Resource child = it.next();
				WsRequest wsr = new WsRequest();
				wsr.setResource(child);
				String childXml = boXmlUtil.wsRequest2Xml(wsr);
				post = new PostMethod(WS_GET_URL);
				post.setRequestEntity(new ByteArrayRequestEntity(childXml
						.getBytes()));
				httpClient.executeMethod(post);
				String childReturnXml = inputStream2String(post.getResponseBodyAsStream());
				WsResponse childrt = boXmlUtil.xml2WsResponse(childReturnXml);
				if(childrt!=null &&  CommonConstants.CMS_CODE.MESSAGE_OK.equals(childrt.getMessageNumber())){
					Resource replyChild = childrt.getResource();
					if(CommonConstants.TYPE.TYPE.equals(replyChild.getTypeId())){
						_typeContent.put(replyChild.getId(), (Type)replyChild.getObject());
					}
				}
			}
			TypeContextSetHolder.setTypeContent(_typeContent);
		}
		CacheService cacheService = (CacheService)ClientUtils.getInstance().getBean("cacheService");
		System.out.println(cacheService.getTypeContent().size());
		ResourceTypeRender resourceTypeRender = (ResourceTypeRender)ClientUtils.getInstance().getBean("resourceWsRender");
		System.out.println(resourceTypeRender);
		System.out.println(System.currentTimeMillis() - currentTime);
	}

	protected static String inputStream2String(InputStream inputStrem)
			throws IOException {
		byte[] buf = new byte[DEFAULT_BUFFER_LENGTH];
		int flag = -1;
		ByteArrayOutputStream bis = new ByteArrayOutputStream();
		while ((flag = inputStrem.read(buf)) != -1) {
			bis.write(buf, 0, flag);
		}
		return bis.toString();
	}
}