package net.frank.framework.payment.face.domain;

import java.io.Serializable;

public class AliPartnerConfig implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -122299714650101863L;

	/***
     * ali公共配制
     */
    private AliConfig aliConfig;

    /**
     * 商户partner id
     */
    private String pid;

    /**
     * 商户应用id
     */
    private String appid;


    /**
     * RSA私钥，用于对商户请求报文加签
     */
    private String privateKey;

    /**
     * RSA公钥，仅用于验证开发者网关
     */
    private String publicKey;

    /**
     * 支付宝RSA公钥，用于验签支付宝应答
     */
    private String alipayPublicKey;

    /**
     * 签名类型
     */
    private String signType;

    /**
     * 最大查询次数
     */
    private int maxQueryRetry;

    /**
     * 查询间隔（毫秒）
     */
    private long queryDuration;

    /***
     * 最大撤销次数
     */
    private int maxCancelRetry;

    /**
     * 撤销间隔（毫秒）
     */
    private long cancelDuration;

    /**
     * 交易保障线程第一次调度延迟（秒）
     */
    private long heartbeatDelay;

    /**
     * 交易保障线程调度间隔（秒）
     */
    private long heartbeatDuration;


    public AliConfig getAliConfig() {
        return aliConfig;
    }

    public void setAliConfig(AliConfig aliConfig) {
        this.aliConfig = aliConfig;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getAlipayPublicKey() {
        return alipayPublicKey;
    }

    public void setAlipayPublicKey(String alipayPublicKey) {
        this.alipayPublicKey = alipayPublicKey;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public int getMaxQueryRetry() {
        return maxQueryRetry;
    }

    public void setMaxQueryRetry(int maxQueryRetry) {
        this.maxQueryRetry = maxQueryRetry;
    }

    public long getQueryDuration() {
        return queryDuration;
    }

    public void setQueryDuration(long queryDuration) {
        this.queryDuration = queryDuration;
    }

    public int getMaxCancelRetry() {
        return maxCancelRetry;
    }

    public void setMaxCancelRetry(int maxCancelRetry) {
        this.maxCancelRetry = maxCancelRetry;
    }

    public long getCancelDuration() {
        return cancelDuration;
    }

    public void setCancelDuration(long cancelDuration) {
        this.cancelDuration = cancelDuration;
    }

    public long getHeartbeatDelay() {
        return heartbeatDelay;
    }

    public void setHeartbeatDelay(long heartbeatDelay) {
        this.heartbeatDelay = heartbeatDelay;
    }

    public long getHeartbeatDuration() {
        return heartbeatDuration;
    }

    public void setHeartbeatDuration(long heartbeatDuration) {
        this.heartbeatDuration = heartbeatDuration;
    }

    @Override
    public String toString() {
        return "AliPartnerConfig{" +
                "aliConfig=" + aliConfig +
                ", pid='" + pid + '\'' +
                ", appid='" + appid + '\'' +
                ", privateKey='" + privateKey + '\'' +
                ", publicKey='" + publicKey + '\'' +
                ", alipayPublicKey='" + alipayPublicKey + '\'' +
                ", signType='" + signType + '\'' +
                ", maxQueryRetry=" + maxQueryRetry +
                ", queryDuration=" + queryDuration +
                ", maxCancelRetry=" + maxCancelRetry +
                ", cancelDuration=" + cancelDuration +
                ", heartbeatDelay=" + heartbeatDelay +
                ", heartbeatDuration=" + heartbeatDuration +
                '}';
    }
}
