package net.frank.framework.payment;

import net.frank.framework.payment.unionpay.UnionpayService;
import net.frank.framework.payment.unionpay.core.UnionPayConfig;
import net.frank.framework.payment.unionpay.core.UnionpayServiceImpl;

import com.unionpay.acp.sdk.SDKConfig;

public final class PayServiceFactory {

    private static UnionpayService unionpayService;

    public void setConfigs(UnionPayConfig upc){
        final SDKConfig config = SDKConfig.getConfig();
        config.loadPropertiesFromSrc();
        UnionpayServiceImpl impl = new UnionpayServiceImpl(upc,config);
        unionpayService = impl;

    }

    public static UnionpayService instanceUnionService(){
        if(null == unionpayService) {
            throw new IllegalArgumentException("Can't find unionpay configs and sdk configs");
        }
        return unionpayService;
    }
}
