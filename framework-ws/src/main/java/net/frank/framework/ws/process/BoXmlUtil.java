package net.frank.framework.ws.process;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import net.frank.commons.CommonConstants;
import net.frank.framework.bo.Resource;
import net.frank.framework.ws.WsRenderProvider;
import net.frank.framework.ws.define.WsAaInfo;
import net.frank.framework.ws.define.WsRegister;
import net.frank.framework.ws.define.WsRequest;
import net.frank.framework.ws.define.WsResponse;

public class BoXmlUtil {

	private static final String RESOURCE_RENDER_KEY = "net.frank.framework.bo.Resource";

	private static final String WS_AA_INFO_RENDER_KEY = "net.frank.framework.ws.define.WsAaInfo";

	private static final String WS_REQUEST_RENDER_KEY = "net.frank.framework.ws.define.WsRequest";

	private static final String WS_RESPONSE_RENDER_KEY = "net.frank.framework.ws.define.WsResponse";
	
	private static final String WS_REGISTER_RENDER_KEY = "net.frank.framework.ws.define.WsRegister";
	

	private WsRenderProvider wsRenderProvider;

	public void setWsRenderProvider(WsRenderProvider wsRenderProvider) {
		this.wsRenderProvider = wsRenderProvider;
	}

	
	public String resource2Xml(Resource resource){
		StringBuffer sb = new StringBuffer(
				CommonConstants.DEFAULT_STRING_BUFFER_LENGTH);
		wsRenderProvider.getWsRender(RESOURCE_RENDER_KEY).outputXml(resource,null, sb);
		return sb.toString();
	}
	
	public Resource xml2Resource(String xml){
		Document document = null;
		Resource resource = new Resource();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		StringReader sr = new StringReader(xml);
		InputSource is = new InputSource(sr);
		try {
			builder = factory.newDocumentBuilder();
			document = builder.parse(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (document != null) {
			wsRenderProvider.getWsRender(RESOURCE_RENDER_KEY).setProperty(
					resource, document.getDocumentElement());
			return resource;
		} else {
			return null;
		}
	}
	
	
	public String aa2Xml(WsAaInfo wsAaInfo) {
		StringBuffer sb = new StringBuffer(
				CommonConstants.DEFAULT_STRING_BUFFER_LENGTH);
		wsRenderProvider.getWsRender(WS_AA_INFO_RENDER_KEY).outputXml(wsAaInfo,
				null, sb);
		return sb.toString();
	}

	public WsAaInfo xml2Aa(String xml) {
		Document document = null;
		WsAaInfo wsAaInfo = new WsAaInfo();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		StringReader sr = new StringReader(xml);
		InputSource is = new InputSource(sr);
		try {
			builder = factory.newDocumentBuilder();
			document = builder.parse(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (document != null) {
			wsRenderProvider.getWsRender(WS_AA_INFO_RENDER_KEY).setProperty(
					wsAaInfo, document.getDocumentElement());
			return wsAaInfo;
		} else {
			return null;
		}
	}

	public String wsRequest2Xml(WsRequest wsRequest) {
		StringBuffer sb = new StringBuffer(
				CommonConstants.DEFAULT_STRING_BUFFER_LENGTH);
		wsRenderProvider.getWsRender(WS_REQUEST_RENDER_KEY).outputXml(
				wsRequest, null, sb);
		return sb.toString();
	}

	public WsRequest xml2WsRequest(String xml) {
		Document document = null;
		WsRequest wsRequest = new WsRequest();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		StringReader sr = new StringReader(xml);
		InputSource is = new InputSource(sr);
		try {
			builder = factory.newDocumentBuilder();
			document = builder.parse(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (document != null) {
			wsRenderProvider.getWsRender(WS_REQUEST_RENDER_KEY).setProperty(
					wsRequest, document.getDocumentElement());
			return wsRequest;
		} else {
			return null;
		}
	}

	public String wsResponse2Xml(WsResponse wsResponse) {
		StringBuffer sb = new StringBuffer(
				CommonConstants.DEFAULT_STRING_BUFFER_LENGTH);
		wsRenderProvider.getWsRender(WS_RESPONSE_RENDER_KEY).outputXml(
				wsResponse, null, sb);
		return sb.toString();
	}

	public WsResponse xml2WsResponse(String xml) {
		Document document = null;
		WsResponse wsResponse = new WsResponse();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		StringReader sr = new StringReader(xml);
		InputSource is = new InputSource(sr);
		try {
			builder = factory.newDocumentBuilder();
			document = builder.parse(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (document != null) {
			wsRenderProvider.getWsRender(WS_RESPONSE_RENDER_KEY).setProperty(
					wsResponse, document.getDocumentElement());
			return wsResponse;
		} else {
			return null;
		}
	}
	
	public String wsRegister2Xml(WsRegister wsRegister) {
		StringBuffer sb = new StringBuffer(
				CommonConstants.DEFAULT_STRING_BUFFER_LENGTH);
		wsRenderProvider.getWsRender(WS_REGISTER_RENDER_KEY).outputXml(
				wsRegister, null, sb);
		return sb.toString();
	}
	
	public WsRegister xml2WsRegister(String xml) {
		Document document = null;
		WsRegister wsRegister = new WsRegister();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		StringReader sr = new StringReader(xml);
		InputSource is = new InputSource(sr);
		try {
			builder = factory.newDocumentBuilder();
			document = builder.parse(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (document != null) {
			wsRenderProvider.getWsRender(WS_REGISTER_RENDER_KEY).setProperty(
					wsRegister, document.getDocumentElement());
			return wsRegister;
		} else {
			return null;
		}
	}
	
}
