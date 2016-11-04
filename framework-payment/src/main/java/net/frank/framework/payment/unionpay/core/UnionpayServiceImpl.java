package net.frank.framework.payment.unionpay.core;

import com.unionpay.acp.sdk.HttpClient;
import com.unionpay.acp.sdk.SDKConfig;
import com.unionpay.acp.sdk.SDKUtil;

import net.frank.framework.payment.unionpay.UnionpayService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class UnionpayServiceImpl implements UnionpayService {

    private static final String ENCODING = "UTF-8";

    private Logger logger = LoggerFactory.getLogger(UnionpayServiceImpl.class);

    private SDKConfig sdkConfig;

    private UnionPayConfig config;

    public UnionpayServiceImpl(UnionPayConfig config, SDKConfig sdkConfig) {
        this.config = config;
        this.sdkConfig = sdkConfig;
    }

    @Override
    public Map<String, String> preTrade(Map<String, String> data) {
        data.put("version","5.0.0");
        data.put("encoding",ENCODING);
        data.put("signMethod","01");
        data.put("txnType","01");
        data.put("txnSubType","01");
        data.put("bizType","000201");
        data.put("accessType","0");
        data.put("currencyCode","156");
        data.put("merId",config.getMerId());
        data.put("txnTime",new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        SDKUtil.sign(data,ENCODING);
        HttpClient client = new HttpClient(sdkConfig.getAppRequestUrl(),30000,30000);
        String resultString = "";
        try {
            int status = client.send(data, ENCODING);
            if(200 == status){
                resultString = client.getResult();
            }
        } catch (Exception e) {
            //
            logger.error("Unionpay prepay request error : " +e.getMessage());
        }
        Map<String, String> resData = null;
        Map<String,String> ret = null;
        /**
         * 验证签名
         */
        if (null != resultString && !"".equals(resultString)) {
            // 将返回结果转换为map
            resData = SDKUtil.convertResultStringToMap(resultString);
            logger.info("打印返回报文：" + resultString);
            if (SDKUtil.validate(resData, ENCODING)) {
               logger.info("Return result success.");
                if(resData.get("respCode").equals("00")&&resData.get("merId").equals(config.getMerId())){
                    resultString = resData.get("tn");
                    ret = new HashMap<String,String>();
                    ret.put("tradeNo",resultString);
                    ret.put("tradeEnv",config.getEnv());
                }else{
                    logger.warn("Does not match merchant info or response has error .");
                }
            } else {
                logger.warn("Return result failed.");
            }
        }
        return ret;
    }
}
