package net.frank.framework.payment.face.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alipay.demo.trade.model.builder.AlipayTradePayRequestBuilder;
import com.alipay.demo.trade.model.result.AlipayF2FPayResult;
import com.alipay.demo.trade.service.AlipayTradeService;
import com.alipay.demo.trade.service.impl.AlipayTradeServiceImpl;
import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayUtil;
import com.github.wxpay.sdk.WxPartnerPayConfig;

import net.frank.framework.payment.face.domain.AliPartnerConfig;
import net.frank.framework.payment.face.domain.FaceCallback;

public class FacePayService {
	private static final String ALI_DEFAULT_TIMEOUT_EXPRESS = "5m";

    private transient Logger log = LoggerFactory.getLogger(getClass());

    private static final String DEFAULT_BODY = "小微医房订单支付";

    private interface INNER_CONSTANTS {
        /**
         *  // 卖家支付宝账号ID，用于支持一个签约账号下支持打款到不同的收款账号，(打款到sellerId对应的支付宝账号)
         *         // 如果该字段为空，则默认为与支付宝签约的商户的PID，也就是appid对应的PID
         *         String sellerId = "";
         *         // 订单描述，可以对交易或商品进行一个详细地描述，比如填写"购买商品2件共15.00元"
         *         //String body = "";
         *
         *         // 商户操作员编号，添加此参数可以为商户操作员做销售统计
         *         String operatorId = "test_operator_id";
         *
         *         // (必填) 商户门店编号，通过门店号和商家后台可以配置精准到门店的折扣信息，详询支付宝技术支持
         *         String storeId = "test_store_id";
         */
        interface ALI{
            String SELLER_ID = "";
            String OPERATOR_ID = "test_operator_id";
            String STORE_ID = "test_store_id";
        }

        interface WX{
            String DEVICE_INFO = "1000";
            int MAX_CHECK_TIME = 20;
            long EACH_SLEEP_SECOND = 3L;

            interface PAY_STATUS{
                String PAY_SUCCESS = "SUCCESS";
                String PAY_USERPAYING = "USERPAYING";
            }
        }
    }

    /***
     *
     * @param outTradeNo
     *  系统的订单号，用于通知支付成功时修改订单状态
     *
     * @param subject
     *  标题
     *
     * @param totalAmount
     *  支付金额
     *
     * @param authCode
     *  客户条形码扫描的值
     *
     * @param undiscountableAmount
     *  订单不可打折金额
     *
     * @param aliPartnerConfig
     *  商户安全信息
     */

    public void ali(
            String outTradeNo,
            String subject,
            String totalAmount,
            String authCode,
            String undiscountableAmount,
            AliPartnerConfig aliPartnerConfig,
            FaceCallback callback){
        AlipayTradeServiceImpl.ClientBuilder clientBuilder =
                new AlipayTradeServiceImpl.ClientBuilder();

        clientBuilder.setGatewayUrl(aliPartnerConfig.getAliConfig().getOpenApiDomain())
                .setAppid(aliPartnerConfig.getAppid())
                .setPrivateKey(aliPartnerConfig.getPrivateKey())
                .setAlipayPublicKey(aliPartnerConfig.getAlipayPublicKey())
                .setSignType(aliPartnerConfig.getSignType());

        log.info(clientBuilder.toString());

        AlipayTradeService tradeService = clientBuilder.build();


        AlipayTradePayRequestBuilder builder = new AlipayTradePayRequestBuilder()
                .setOutTradeNo(outTradeNo)
                .setSubject(subject)
                .setAuthCode(authCode)
                .setTotalAmount(totalAmount)
                .setStoreId(INNER_CONSTANTS.ALI.STORE_ID)
                .setUndiscountableAmount(undiscountableAmount)
                .setBody(DEFAULT_BODY)
                .setOperatorId(INNER_CONSTANTS.ALI.OPERATOR_ID)
                //.setExtendParams(extendParams)
                .setSellerId(INNER_CONSTANTS.ALI.SELLER_ID)
                //.setGoodsDetailList(goodsDetailList)
                .setTimeoutExpress(ALI_DEFAULT_TIMEOUT_EXPRESS);

        // 调用tradePay方法获取当面付应答
        AlipayF2FPayResult result = tradeService.tradePay(builder);
        switch (result.getTradeStatus()) {
            case SUCCESS:
                log.info("支付宝支付成功: )");
                if(callback!=null){
                    callback.onSuccess();
                }
                break;

            case FAILED:
                log.error("支付宝支付失败!!!");
                if(callback!=null){
                    callback.onFailure();
                }
                break;

            case UNKNOWN:
                log.error("系统异常，订单状态未知!!!");
                if(callback!=null){
                    callback.onUnknown();
                }
                break;

            default:
                log.error("不支持的交易状态，交易返回异常!!!");
                if(callback!=null){
                    callback.onDefault();
                }
                break;
        }
    }



    public void wx(String outTradeNo,
                   String subject,
                   String totalAmount,
                   String authCode,
                   WxPartnerPayConfig wxPartnerPayConfig,
                   FaceCallback callback){
        try {
            WXPay wxpay = new WXPay(wxPartnerPayConfig);
            Map<String, String> map = new HashMap<>(16);
            map.put("attach", subject);
            map.put("auth_code", authCode);
            map.put("body", DEFAULT_BODY);
            map.put("device_info", INNER_CONSTANTS.WX.DEVICE_INFO);
            map.put("nonce_str", WXPayUtil.generateNonceStr());
            map.put("out_trade_no", outTradeNo);
            //map.put("spbill_create_ip", "14.17.22.52");
            map.put("total_fee", totalAmount);

            String sign = WXPayUtil.generateSignature(map, wxPartnerPayConfig.getKey());
            map.put("sign", sign);
            String mapToXml = null;
            try {
                Map<String, String> resp = wxpay.microPay(map);
                mapToXml = WXPayUtil.mapToXml(resp);
                log.debug("Variable [mapToXml] -> " + mapToXml);
            } catch (Exception e) {
                log.error(e.getMessage(),e);
            }
            processResult(mapToXml,outTradeNo,wxpay,callback);
        }catch(Exception e){
            log.error(e.getMessage(),e);
        }
    }


    private void processResult(String responseTxt, String outTradeNo,WXPay wxpay, FaceCallback callback){
        try {
            String return_code = null;
            String result_code = null;
            String err_code_des = null;
            String err_code = null;
            Document doc = DocumentHelper.parseText(responseTxt);
            Element rootElement = doc.getRootElement();

            List<Element> elements = rootElement.elements();
            for (Element element : elements) {
                if(element.getName().equals("return_code")){
                    return_code = element.getTextTrim();
                } else if(element.getName().equals("result_code")){
                    result_code = element.getTextTrim();
                } else if(element.getName().equals("err_code_des")){
                    err_code_des = element.getTextTrim();
                } else if(element.getName().equals("err_code")){
                    err_code = element.getTextTrim();
                }
            }

            if(INNER_CONSTANTS.WX.PAY_STATUS.PAY_SUCCESS.equals(return_code)
                    && INNER_CONSTANTS.WX.PAY_STATUS.PAY_SUCCESS.equals(result_code)) {
                log.info("微信免密支付成功！");
                if(callback != null){
                    callback.onSuccess();
                }
                return;
            }else if (INNER_CONSTANTS.WX.PAY_STATUS.PAY_USERPAYING.equals(err_code)){

                for(int i = 1; i <= INNER_CONSTANTS.WX.MAX_CHECK_TIME; i++){
                    log.info("微信等待支付成功"+(i)+"次");
                    Thread.sleep(INNER_CONSTANTS.WX.EACH_SLEEP_SECOND * 1000L);
                    Map<String, String> data = new HashMap<>(16);
                    data.put("out_trade_no", outTradeNo);
                    Map<String, String> orderQuery = wxpay.orderQuery(data);
                    String orderResp = WXPayUtil.mapToXml(orderQuery);
                    String trade_state = null;
                    //获取Document对象
                    Document orderDoc = DocumentHelper.parseText(orderResp);
                    //获取对象的根节点<xml>
                    Element rootElement1 = orderDoc.getRootElement();
                    //获取对象的子节点
                    List<Element> elements1 = rootElement1.elements();
                    for (Element element : elements1) {
                        if(element.getName().equals("trade_state")){
                            trade_state = element.getTextTrim();
                        }
                    }
                    if(INNER_CONSTANTS.WX.PAY_STATUS.PAY_SUCCESS
                            .equals(trade_state)){
                        log.info("微信加密支付成功！");
                        if(callback != null){
                            callback.onSuccess();
                        }
                        return;
                    }
                }
            }else{
                log.warn("微信支付不成功,详细描述：" + err_code_des);                
                if(callback != null){
                    callback.onFailure();
                }
            }
        }catch(Exception e){
            log.error(e.getMessage(),e);
        }
    }
}
