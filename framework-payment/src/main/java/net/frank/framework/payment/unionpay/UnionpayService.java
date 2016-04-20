package net.frank.framework.payment.unionpay;

import java.util.Map;

public interface UnionpayService {

    /**
     * 订单推送请求,预交易
     * @param data * 必须; ? 根据情形选择;
     *  keys <a href="https://open.unionpay.com/ajweb/help2/api?id=22">请求报文</a>
     *  version   (*)
     *  encoding  (*)
     *  certId    (*)
     *  signature (*)
     *  signMethod(*)
     *  txnType   (*)
     *  txnSubType(*)
     *  bizType   (*)
     *  frontUrl  (?) 前台类交易(web)需要给支付成功后跳转的地址
     *  backUrl   (*) 异步回调地址
     *  merId     (*)
     *  subMerId  (?)
     *  subMerName(?)
     *  subMerAbbr(?)
     *  orderId   (*)不包含("_","-" )符号
     *  txnTime   (*)YYYYMMDDhhmmss
     *  payTimeout  订单失效时间
     *  defaultPayType
     *  currencyCode(*) 默认156,人民币
     *  customerInfo  格式如下：{子域名1=值&子域名2=值&子域名3=值}
     *  txnAmt    (*) 以分为单位
     *  reqReserved
     *  channelType(*)
     *  instalTransInfo(?)
     *  frontFailUrl
     *  orderDesc (?)
     * @return {tradeNo:交易流水号,tradeEnv:交易环境}
     */
    Map<String, String> preTrade(Map<String, String> data);

}
