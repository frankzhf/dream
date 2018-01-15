package net.frank.corejava0.netty.ch09;

import java.io.Serializable;

public class SubRequest implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4533386022276782008L;
	private Integer subReq;
    private String userName;
    private String productName;
    private String address;
	public Integer getSubReq() {
		return subReq;
	}
	public void setSubReq(Integer subReq) {
		this.subReq = subReq;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "SubRequest [subReq=" + subReq + ", userName=" + userName + ", productName=" + productName + ", address="
				+ address + "]";
	}
    
	
    
}
