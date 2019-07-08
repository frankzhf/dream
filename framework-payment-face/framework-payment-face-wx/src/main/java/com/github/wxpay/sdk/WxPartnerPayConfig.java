package com.github.wxpay.sdk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class WxPartnerPayConfig extends WXPayConfig {


    private transient Logger log = LoggerFactory.getLogger(getClass());
    /**
     * 加载证书  这里证书需要到微信商户平台进行下载
     */
    private byte[] certData;

    private String appID;

    private String mchID;

    private String key;


    public WxPartnerPayConfig(String appID, String mchID,
                              String key, String certPath){
        this.appID = appID;
        this.mchID = mchID;
        this.key = key;
        File certFile = new File(certPath);
        try(InputStream is = new FileInputStream(certFile)){
            certData = new byte[is.available()];
            is.read(certData);
        }catch(FileNotFoundException e){
            log.debug(e.getMessage(),e);
            throw new RuntimeException(e);
        }catch(IOException e){
            log.debug(e.getMessage(),e);
            throw new RuntimeException(e);
        }
    }


    /**
     * 获取 App ID
     *
     * @return App ID
     */
    @Override
    public String getAppID() {
        return appID;
    }


    /**
     * 获取 Mch ID
     *
     * @return Mch ID
     */
    @Override
    public String getMchID() {
        return mchID;
    }


    /**
     * 获取 API 密钥
     *
     * @return API密钥
     */
    @Override
    public String getKey() {
        return key;
    }


    /**
     * 获取商户证书内容
     *
     * @return 商户证书内容
     */
    @Override
    public InputStream getCertStream() {
        ByteArrayInputStream certBis = new ByteArrayInputStream(this.certData);
        return certBis;
    }

    @Override
    IWXPayDomain getWXPayDomain(){
        IWXPayDomain iwxPayDomain = new IWXPayDomain(){

            @Override
            public void report(String domain, long elapsedTimeMillis, Exception ex) {

            }

            @Override
            public DomainInfo getDomain(WXPayConfig config) {
                return new IWXPayDomain.DomainInfo(
                        "api.mch.weixin.qq.com",
                        true);
            }
        };

        return iwxPayDomain;
    };
}
