package net.frank.framework.payment.wxpay;

import java.util.Map;

public interface WxPayService {

    String UNIFIED_ORDER_API = "https://api.mch.weixin.qq.com/pay/unifiedorder";

    String CLOSE_ORDER_API = "https://api.mch.weixin.qq.com/pay/closeorder";

    /**
     * @See <a href="https://pay.weixin.qq.com/wiki/doc/api/app.php?chapter=9_1">统一下单</a>
     * @param params 中的 key
     *  appid           公众账号ID(*)
     *  mch_id          商户号(*)
     *  device_info 	设备号
     *  nonce_str       随机字符串(*)
     *  sign            签名(*)
     *  body            商品描述(*)
     *  detail          商品详情
     *  attach          附加数据
     *  out_trade_no    商户订单号(*)
     *  fee_type        货币类型 默认CNY人民币
     *  total_fee       总金额(*)
     *  spbill_create_ip终端IP(*)
     *  time_start      交易起始时间 格式为yyyyMMddHHmmss
     *  time_expire     交易结束时间
     *  goods_tag       商品标记
     *  notify_url      通知地址(*)
     *  trade_type      交易类型(*) enum(JSAPI,NATIVE,APP,WAP)
     *  product_id      商品ID
     *  limit_pay       指定支付方式
     *  openid          用户标识 (tade_type 为 JSAPI 时,此项为必填项 )
     * @return
     */
    Map<String,Object> prePay(Map<String, Object> params) throws Exception;

    /**
     *  JS调起支付
     * @param params 同prePay
     * @return
     * @throws Exception
     */
    Map<String,Object> prePayInvokeByJS(Map<String, Object> params) throws Exception;
    
    Map<String,String> prePaySHA1(String jsTicket,String url) throws Exception;
 

    /**
     * 关闭超时,或者取消的订单 的交易
     * @param outTradeNo 交易号
     */
    void closeExisTransItem(String outTradeNo);


}
