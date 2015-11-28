package net.frank.framework.payment.wxpay;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;

import java.util.Date;
import java.util.Random;


public final class Utils {
    /**
     * 获取当前时间 以秒为单位表示
     * @return 当前时间换算为秒的值
     */
    public final static long getTimeStampWithSecond(){
        Date date = new Date();
        return date.getTime()/1000;
    }

    /**
     *获取当前时间
     * @return  当前完整时间
     */
    public final static Date getCurrentTime(){
        return new Date();
    }

    /**
     * 获取年月日信息 (yyyyMMdd)
     * @return
     */
    public final static String getYearToDayString(){
        return DateFormatUtils.format(new Date(),"yyyyMMdd");
    }

    /**
     * 生成外部交易号
     * @param date  yyyyMMdd字符串 @Size(8)
     * @param serverId  生成该单号服务器编号 @Size(4)
     * @param orderId   订单编号 @Size(16)
     * @return {date}{serverId}{orderId}
     */
    public final static String getOutTradeNo(Date date,String serverId,String orderId){
        if(StringUtils.isBlank(serverId)){
            serverId = "0001";
        }
        return DateFormatUtils.format(date,"yyyyMMdd")+fillMask('0',4,serverId)+fillMask('0',16,orderId);
    }


    /**
     * eg: 12 ,想要获取 XXXX12,固定长度的字符串
     * @param mask 不足时用来填充的字符
     * @param length  填充后反回字符串的总长度
     * @param input  需要填充的字符串
     * @return  填充后的字符串
     */
    public static String fillMask(char mask,int length,String input){
        final int inputLen = input.length();
        if(inputLen >= length) {
            return input;
        }
        int maskLen = length - inputLen;
        char[] chars = new char[maskLen];
        for(int i=0;i<maskLen;i++){
            chars[i] = mask;
        }
        return new String(chars)+input;
    }

    /**
     * 从已有交易订单号中获取业务系统中的订单号
     * @param outTradeNo
     * @return
     */
    public static String getOrderIdFromOutTradeNo(String outTradeNo){
        if(StringUtils.isNotBlank(outTradeNo)){
            if(outTradeNo.matches("\\d{16}-\\d{16}")){
                //第一批系统中 out_trade_no 是按 {user_id}-{order_id} 生成的
                return outTradeNo.substring(outTradeNo.indexOf('-')+1);
            }
            //
            if(outTradeNo.length()== 28){
                return outTradeNo.substring(12);
            }
        }
        return outTradeNo;
    }
    
    
    /**
     * 生成随机6位数的验证码
     * @param null
     * @return
     */
    public static String getIdentifyCode(){
    	Random rand= new Random(); 
    	int temp=Math.abs(rand.nextInt());
        int validCode=temp%(999999 - 100000 + 1) + 100000;
        return String.valueOf(validCode);
    }

}
