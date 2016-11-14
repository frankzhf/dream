package net.frank.framework.payment;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import net.frank.framework.payment.unionpay.UnionpayService;
import net.frank.framework.payment.unionpay.core.UnionPayConfig;

public class TestScpSdk {
	public static void main(String[] args){
		UnionPayConfig config = new UnionPayConfig();
		config.setEnv("00");
		config.setMerId("700000000000001");
		
		PayServiceFactory factory = new PayServiceFactory();
		factory.setConfigs(config);
		
		Map<String,String> params = new HashMap<String,String>();
		//"outTradeNo", "payAmount", "orderDetail", "orderDesc", "channelType"
		params.put("orderId","10000100001");
		params.put("txnAmt","10000");
		params.put("reqReserved","testReqReserved");
		params.put("orderDesc","items(1)");
		params.put("channelType","08");
		
		UnionpayService service = PayServiceFactory.instanceUnionService();
		params.put("backUrl",  "http://www.frank.com/async/pay/union-notify");
		Map<String, String> txnInfo = service.preTrade(params);
		
		if(txnInfo!=null && !txnInfo.isEmpty()){
			for(Iterator<String> it=txnInfo.keySet().iterator();it.hasNext();){
				String key = it.next();
				System.out.println(key +":" +txnInfo.get(key));
			}
		}
		
		
	}
}
