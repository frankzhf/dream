package com.shengtong.smartlamppost.commons.entity;

import java.io.Serializable;
import java.util.Date;

public class OpsDeviceLog implements Serializable {
    private String id;

    private String branchId;

    private String deviceCode;

    private String deviceName;

    private Date opsTime;

    private String opsClientIp;

    private String opsUserId;

    private String opsUserName;

    private String opsContent;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private String remarks;

    private String delFlag;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId == null ? null : branchId.trim();
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode == null ? null : deviceCode.trim();
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName == null ? null : deviceName.trim();
    }

    public Date getOpsTime() {
        return opsTime;
    }

    public void setOpsTime(Date opsTime) {
        this.opsTime = opsTime;
    }

    public String getOpsClientIp() {
        return opsClientIp;
    }

    public void setOpsClientIp(String opsClientIp) {
        this.opsClientIp = opsClientIp == null ? null : opsClientIp.trim();
    }

    public String getOpsUserId() {
        return opsUserId;
    }

    public void setOpsUserId(String opsUserId) {
        this.opsUserId = opsUserId == null ? null : opsUserId.trim();
    }

    public String getOpsUserName() {
        return opsUserName;
    }

    public void setOpsUserName(String opsUserName) {
        this.opsUserName = opsUserName == null ? null : opsUserName.trim();
    }

    public String getOpsContent() {
        return opsContent;
    }

    public void setOpsContent(String opsContent) {
        this.opsContent = opsContent == null ? null : opsContent.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", branchId=").append(branchId);
        sb.append(", deviceCode=").append(deviceCode);
        sb.append(", deviceName=").append(deviceName);
        sb.append(", opsTime=").append(opsTime);
        sb.append(", opsClientIp=").append(opsClientIp);
        sb.append(", opsUserId=").append(opsUserId);
        sb.append(", opsUserName=").append(opsUserName);
        sb.append(", opsContent=").append(opsContent);
        sb.append(", createBy=").append(createBy);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", remarks=").append(remarks);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}