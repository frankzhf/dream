package net.frank.framework.payment.wxpay;


public class UserBizException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = -2509476332961736224L;

	public UserBizException(String message){
        super(message);
    }

    public UserBizException(String message,Throwable throwable){
        super(message,throwable);
    }
}
