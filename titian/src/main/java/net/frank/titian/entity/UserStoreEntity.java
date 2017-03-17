package net.frank.titian.entity;

public class UserStoreEntity {
	
	private String retailerId = "";
    private String userId = "";
    private String storeId = "";
    private String dataType = "";
    private String url = "";
	public String getRetailerId() {
		return retailerId;
	}
	public void setRetailerId(String retailerId) {
		this.retailerId = retailerId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "UserStoreEntity [retailerId=" + retailerId + ", userId=" + userId + ", storeId=" + storeId
				+ ", dataType=" + dataType + ", url=" + url + "]";
	}
	
	
	
}
