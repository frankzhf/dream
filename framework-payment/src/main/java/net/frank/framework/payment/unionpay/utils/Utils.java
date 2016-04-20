package net.frank.framework.payment.unionpay.utils;

import com.unionpay.acp.sdk.SDKUtil;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

public final class Utils {

    public Map<String,String> sign(Map<String,Object> params){
        //过滤字段
        params.remove("signature");
        Map<String,String> signParams = new HashMap<String,String>();
        for (String s : params.keySet()) {
            Object val = params.get(s);
            if(null!=val && StringUtils.isNotBlank(val.toString())){
                signParams.put(s,val.toString());
            }
        }
        SDKUtil.sign(signParams, "UTF-8");
        return signParams;
    }
}
