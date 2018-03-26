package com.shengtong.smartlamppost.commons.entity;

import java.io.Serializable;

public class AssetUserInfo implements Serializable {
    private Integer userId;

    private String userName;

    private String password;

    private String name;

    private String mobilePhone;

    private Integer isadmin;

    private Integer userStatus;

    private Long loginTime;

    private Integer isauditing;

    private String businessReferenceId;

    private static final long serialVersionUID = 1L;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
    }

    public Integer getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(Integer isadmin) {
        this.isadmin = isadmin;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Long getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Long loginTime) {
        this.loginTime = loginTime;
    }

    public Integer getIsauditing() {
        return isauditing;
    }

    public void setIsauditing(Integer isauditing) {
        this.isauditing = isauditing;
    }

    public String getBusinessReferenceId() {
        return businessReferenceId;
    }

    public void setBusinessReferenceId(String businessReferenceId) {
        this.businessReferenceId = businessReferenceId == null ? null : businessReferenceId.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", userName=").append(userName);
        sb.append(", password=").append(password);
        sb.append(", name=").append(name);
        sb.append(", mobilePhone=").append(mobilePhone);
        sb.append(", isadmin=").append(isadmin);
        sb.append(", userStatus=").append(userStatus);
        sb.append(", loginTime=").append(loginTime);
        sb.append(", isauditing=").append(isauditing);
        sb.append(", businessReferenceId=").append(businessReferenceId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}