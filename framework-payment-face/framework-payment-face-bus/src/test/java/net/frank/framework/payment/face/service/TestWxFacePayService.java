package net.frank.framework.payment.face.service;

import com.github.wxpay.sdk.WxPartnerPayConfig;

public class TestWxFacePayService {

	public static void main(String[] args) {
		WxPartnerPayConfig config = new
                WxPartnerPayConfig("wx40d639295c1674a9","10061875","d8e48c92af5958096516dde54968cfdf",
                "/Users/zhaofeng/projects/frank/payment/wx/10061875_20190705_cert/apiclient_cert.p12");

        FacePayService service = new FacePayService();


        service.wx("1110110111011122","小微药房微信付款码支付","1","135076656133952285",
                config,null);
	}

}
