package net.frank.yangtes.modules.zkc.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class JsonResult {

	/**
	 * 执行结果
	 */
	private boolean success;
	/**
	 * 信息
	 */
	private String message;
	
	/**
	 * 通过指定参数创建json返回值对象
	 * @param success 是否成功
	 * @param message 信息
	 */
	public JsonResult(boolean success, String message){
		this.success = success;
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}
}

