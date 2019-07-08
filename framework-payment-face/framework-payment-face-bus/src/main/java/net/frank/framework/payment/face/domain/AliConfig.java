package net.frank.framework.payment.face.domain;

import java.io.Serializable;

public class AliConfig implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 5872093678877985678L;
	/**
     * 支付宝openapi域名
     */
    private String openApiDomain;
    /**
     * 支付宝mcloudmonitor域名
     */
    private String mcloudApiDomain;

    public String getOpenApiDomain() {
        return openApiDomain;
    }

    public void setOpenApiDomain(String openApiDomain) {
        this.openApiDomain = openApiDomain;
    }

    public String getMcloudApiDomain() {
        return mcloudApiDomain;
    }

    public void setMcloudApiDomain(String mcloudApiDomain) {
        this.mcloudApiDomain = mcloudApiDomain;
    }

    @Override
    public String toString() {
        return "AliConfig{" +
                "openApiDomain='" + openApiDomain + '\'' +
                ", mcloudApiDomain='" + mcloudApiDomain + '\'' +
                '}';
    }
}
