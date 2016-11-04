package net.frank.framework.payment.wxpay;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import net.frank.framework.payment.wxpay.common.Configure;
import net.frank.framework.payment.wxpay.common.HttpsRequest;
import net.frank.framework.payment.wxpay.common.RandomStringGenerator;
import net.frank.framework.payment.wxpay.common.Signature;
import net.frank.framework.payment.wxpay.common.XMLParser;

import org.slf4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.util.HashMap;
import java.util.Map;

public class WxPayServiceImpl implements WxPayService {

    private Logger log = org.slf4j.LoggerFactory.getLogger(WxPayServiceImpl.class);

    private ObjectMapper mapper  = new XmlMapper();

    @Override
    public Map<String, Object> prePay(Map<String, Object> params) throws Exception {
        params.remove("sign");
        params.put("appid",Configure.getAppid());
        params.put("mch_id",Configure.getMchid());
        params.put("nonce_str",RandomStringGenerator.getRandomStringByLength(32));
        String sign = Signature.getSign(params);
        params.put("sign",sign);
        try {
            log.info("Prepare sign : /r/n" + mapper.writeValueAsString(new Xml(params)));
        } catch (JsonProcessingException e) {
            //
        }
        try {
            HttpsRequest request  = new HttpsRequest();

            String response = request.sendPost(WxPayService.UNIFIED_ORDER_API,new Xml(params));
            if(log.isDebugEnabled()){
                log.debug("Prepay response => "+response);
            }
            boolean isSign = Signature.checkIsSignValidFromResponseString(Configure.getKey(),response);
            String errorMsg = "";
            if(isSign) {
                Map<String, Object> result = XMLParser.getMapFromXML(response);
                log.info("Prepay response resign : /r/n"+mapper.writeValueAsString(new Xml(result)));
                if(result.get("return_code").equals("SUCCESS")){
                    if(result.get("result_code").equals("SUCCESS")){
                        // 重组参数和签名
                        Map<String,Object> ret = new HashMap<String,Object>();
                        ret.put("appid", Configure.getAppid());
                        ret.put("partnerid",Configure.getMchid());
                        ret.put("prepayid",result.get("prepay_id"));
                        ret.put("package","Sign=WXPay");
                        ret.put("noncestr", RandomStringGenerator.getRandomStringByLength(32));
                        ret.put("timestamp", Utils.getTimeStampWithSecond());
                        String resign = Signature.getSign(ret);
                        ret.put("sign",resign);
                        return ret;
                    }
                    errorMsg = result.get("err_code_des").toString();
                    throw  new UserBizException(errorMsg);
                }
                    errorMsg = result.get("return_msg").toString();
            }
            log.error("Invalid return response string {"+response+"}");
            throw new IllegalArgumentException(errorMsg);

        } catch (Exception e) {
            //
            log.error("Prepare pay failed : "+e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void closeExisTransItem(String outTradeNo) {
        Xml data = new Xml();
        data.put("appid",Configure.getAppid());
        data.put("mch_id",Configure.getMchid());
        data.put("out_trade_no",outTradeNo);
        data.put("nonce_str",RandomStringGenerator.getRandomStringByLength(32));
        String sign = Signature.getSign(data);
        data.put("sign",sign);
        try {
            HttpsRequest request = new HttpsRequest();
            String response = request.sendPost(WxPayService.CLOSE_ORDER_API,data);
            boolean isSign = Signature.checkIsSignValidFromResponseString(Configure.getKey(),response);
            if(isSign){
                //移除
                Map<String,Object> ret = XMLParser.getMapFromXML(response);
                if(!ret.get("return_code").equals("SUCCESS")){
                    throw new IllegalArgumentException("return_msg");
                }
            }
        } catch (Exception e) {
            //
            throw new IllegalArgumentException(e.getMessage());
        }
    }

	@Override
	 public Map<String, Object> prePayInvokeByJS(Map<String, Object> params) throws UserBizException {
        final String key = "9DDD5B1AE2FD40D086AA14A360D22346";
        params.remove("sign");
        params.put("appid", "wx5a32e7c69f3792a6");
        params.put("mch_id", "1270481901");
        params.put("nonce_str", RandomStringGenerator.getRandomStringByLength(32));
        String sign = Signature.getSign(key,params);
        params.put("sign", sign);
        try {
            log.info("Prepare sign : /r/n" + mapper.writeValueAsString(new Xml(params)));
        } catch (JsonProcessingException e) {
            //
        }

        HttpsRequest request = null;
        try {
            request = new HttpsRequest();
            String response = request.sendPost(WxPayService.UNIFIED_ORDER_API, new Xml(params));
            if (log.isDebugEnabled()) {
                log.debug("Prepay response => " + response);
            }
            boolean isSign = Signature.checkIsSignValidFromResponseString(key,response);
            String errorMsg = "";
            if (isSign) {
                Map<String, Object> result = XMLParser.getMapFromXML(response);
                log.info("Prepay response resign : /r/n" + mapper.writeValueAsString(new Xml(result)));
                if (result.get("return_code").equals("SUCCESS")) {
                    if (result.get("result_code").equals("SUCCESS")) {
                        // 重组参数和签名
                        Map<String, Object> ret = new HashMap<String, Object>();
                        ret.put("appId", params.get("appid"));
                        ret.put("package", "prepay_id=" + result.get("prepay_id"));
                        ret.put("nonceStr", RandomStringGenerator.getRandomStringByLength(32));
                        ret.put("signType", "MD5");
                        ret.put("timeStamp", Utils.getTimeStampWithSecond());
                        String resign = Signature.getSign(key,ret);
                        ret.put("paySign", resign);
                        log.info("Presign {" + mapper.writeValueAsString(ret) + "}");
                        return ret;
                    }
                    errorMsg = result.get("err_code_des").toString();
                    throw new UserBizException(errorMsg);
                }
                errorMsg = result.get("return_msg").toString();
            }
            log.error("Invalid return response string {" + response + "}");
            throw new IllegalArgumentException(errorMsg);
        } catch (UnrecoverableKeyException e) {
            log.error("Request exception "+e.getMessage());
        } catch (KeyManagementException e) {
            log.error("Request exception " + e.getMessage());
        } catch (NoSuchAlgorithmException e) {
            log.error("Request exception " + e.getMessage());
        } catch (KeyStoreException e) {
            log.error("Request exception " + e.getMessage());
        } catch (IOException e) {
            log.error("Request exception " + e.getMessage());
        } catch (ParserConfigurationException e) {
            log.error("Request exception " + e.getMessage());
        } catch (SAXException e) {
            log.error("Request exception "+e.getMessage());
        }
        return null;
    }

    /**
     * JS SDK授权签名
     * @param jsTicket
     * @param url
     * @return {url:"",noncestr:"",timestamp:"",signature:"","jsapi_ticket"}
     */
	  public Map<String,String> prePaySHA1(String jsTicket,String url) {
          Map<String, String> ret = new HashMap<String, String>();
          String nonce_str = RandomStringGenerator.getRandomStringByLength(32);
          String timestamp = Utils.getTimeStampWithSecond()+"";

          //注意这里参数名必须全部小写，且必须有序
          String string1 = "jsapi_ticket=" + jsTicket +
                  "&noncestr=" + nonce_str +
                  "&timestamp=" + timestamp +
                  "&url=" + url;
          try
          {
             String signature = Signature.signSHA1(string1);
              ret.put("url", url);
              ret.put("nonceStr", nonce_str);
              ret.put("timestamp", timestamp);
              ret.put("signature", signature);
              ret.put("jsapi_ticket",jsTicket);
          }
          catch (NoSuchAlgorithmException e)
          {
             log.error("Grant js-sdk error :"+e.getClass().getSimpleName()+","+e.getMessage());
          }
          catch (UnsupportedEncodingException e)
          {
              log.error("Grant js-sdk error :" + e.getClass().getSimpleName() + "," + e.getMessage());
          }
          return ret;
	    }
}
