package net.frank.framework.payment.alipay;

import java.math.BigDecimal;
import java.util.List;

import net.frank.commons.util.StringUtil;

public final class AlipayUtil {

    /**
     * 获取批量退款单笔数据集
     * @param items
     * @return
     */
    public static String getRefundDetailDatas(List<RefundItem> items){
        if(!items.isEmpty()){
            StringBuilder sb = new StringBuilder();
            for (RefundItem item : items) {
                sb.append("#").append(getRefundDetailData(item));
            }
            return sb.substring(1);
        }
        return null;
    }

    /**
     * 获取退款单笔数据集
     * @param item
     * @return
     */
    public static String getRefundDetailData(RefundItem item){
        if(StringUtil.isNotEmpty(item.getOriginAlipayTradeNo())&&null!=item.getRefundAmount()&&StringUtil.isNotEmpty(item.getRefundDesc())){
            return item.getOriginAlipayTradeNo()+"^"+item.getRefundAmount().toString()+"^"+item.getRefundDesc();
        }
        return null;
    }

    /**
     * 退款项信息
     * 单笔交易退款次数不应该超过99次
     */
    public static class RefundItem{
        //原支付宝交易号
        private String originAlipayTradeNo;
        //退款金额 ,退款总金额不大于原交易付款金额
        private BigDecimal refundAmount;
        //退款理由 ,剔除 ^ | $ # 字符,长度不应该超过256个字符
        private String refundDesc;

        public RefundItem(String originAlipayTradeNo, BigDecimal refundAmount, String refundDesc) {
            this.originAlipayTradeNo = originAlipayTradeNo;
            this.refundAmount = refundAmount;
            if(StringUtil.isNotEmpty(refundDesc)){
                refundDesc = refundDesc.replaceAll("[\\^\\|\\$#]","*");
            }
            this.refundDesc = refundDesc;
        }

        public String getOriginAlipayTradeNo() {
            return originAlipayTradeNo;
        }

        public void setOriginAlipayTradeNo(String originAlipayTradeNo) {
            this.originAlipayTradeNo = originAlipayTradeNo;
        }

        public BigDecimal getRefundAmount() {
            return refundAmount;
        }

        public void setRefundAmount(BigDecimal refundAmount) {
            this.refundAmount = refundAmount;
        }

        public String getRefundDesc() {
            return refundDesc;
        }

        public void setRefundDesc(String refundDesc) {
            if(StringUtil.isNotEmpty(refundDesc)){
                refundDesc = refundDesc.replaceAll("[\\^\\|\\$#]","*");
            }
            this.refundDesc = refundDesc;
        }
    }
}
