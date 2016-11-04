package net.frank.framework.payment.alipay;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Config {
	
	private transient static Logger logger = LoggerFactory.getLogger(Config.class);
	
	private static final String COFNIG_FILE = "alipay";
	private static final String ALI_PARTNER_KEY = "app.payment.ali.partner";
	private static final String ALI_SELLER_ID_KEY = "app.payment.ali.seller";
	private static final String ALI_MD5_KEY_KEY = "app.payment.ali.md5.key";
	private static final String ALI_PRIVATE_KEY_KEY = "app.payment.ali.private.key";
	private static final String ALI_LOG_PATH_KEY = "app.payment.ali.log.path";
	private static final String ALI_INPUT_CHARSET_KEY = "app.payment.ali.input.charset";
	private static final String ALI_SIGN_TYPE_KEY = "app.payment.ali.sign.type";
	
	
	public static String ali_public_key  = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";
	
	private static Properties p;
	
	static{
		init();
	}
	
	private static void init(){
		synchronized (Config.class) {
			try{
				p = new Properties ();
				p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(COFNIG_FILE));
			}catch(IOException e){
				logger.error("Read ali config file error" + e,e);
			}
		}
	}
	
	public static String getPartner(){
		return p.getProperty(ALI_PARTNER_KEY);
	}
	
	public static String getSellId(){
		return p.getProperty(ALI_SELLER_ID_KEY);
	}
	
	public static String getMd5Key(){
		return p.getProperty(ALI_MD5_KEY_KEY);
	}
	
	public static String getPrivateKey(){
		return p.getProperty(ALI_PRIVATE_KEY_KEY);
	}
	
	public static String getLogPath(){
		return p.getProperty(ALI_LOG_PATH_KEY);
	}
	
	public static String getInputCharset(){
		return p.getProperty(ALI_INPUT_CHARSET_KEY);
	}
	
	public static String getSignType(){
		return p.getProperty(ALI_SIGN_TYPE_KEY);
	}
}
