package net.frank.framework.payment.wxpay;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "xml")
public class Xml extends HashMap<String,Object> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 409789008592435442L;

	public Xml(){}

    public Xml (Map<String,Object> map){
        super(map);
    }

}
