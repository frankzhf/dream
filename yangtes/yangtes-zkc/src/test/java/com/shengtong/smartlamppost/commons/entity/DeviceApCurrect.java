package com.shengtong.smartlamppost.commons.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DeviceApCurrect implements Serializable {
    private String id;

    private String branchId;

    private String apIdAddress;

    private String acIdAddress;

    private String deviceApCode;

    private String deviceAcCode;

    private String acRunningStatus;

    private String apRunningStatus;

    private String deviceAcStatus;

    private String deviceApStatus;

    private Integer userAccessCount;

    private BigDecimal apSendSpeed;

    private BigDecimal apRecvSpeed;

    private Date collectDate;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private String remarks;

    private String delFlag;

    private String apGroupId;

    private String apGroupName;

    private Integer userProbeCount;

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

    public String getApIdAddress() {
        return apIdAddress;
    }

    public void setApIdAddress(String apIdAddress) {
        this.apIdAddress = apIdAddress == null ? null : apIdAddress.trim();
    }

    public String getAcIdAddress() {
        return acIdAddress;
    }

    public void setAcIdAddress(String acIdAddress) {
        this.acIdAddress = acIdAddress == null ? null : acIdAddress.trim();
    }

    public String getDeviceApCode() {
        return deviceApCode;
    }

    public void setDeviceApCode(String deviceApCode) {
        this.deviceApCode = deviceApCode == null ? null : deviceApCode.trim();
    }

    public String getDeviceAcCode() {
        return deviceAcCode;
    }

    public void setDeviceAcCode(String deviceAcCode) {
        this.deviceAcCode = deviceAcCode == null ? null : deviceAcCode.trim();
    }

    public String getAcRunningStatus() {
        return acRunningStatus;
    }

    public void setAcRunningStatus(String acRunningStatus) {
        this.acRunningStatus = acRunningStatus == null ? null : acRunningStatus.trim();
    }

    public String getApRunningStatus() {
        return apRunningStatus;
    }

    public void setApRunningStatus(String apRunningStatus) {
        this.apRunningStatus = apRunningStatus == null ? null : apRunningStatus.trim();
    }

    public String getDeviceAcStatus() {
        return deviceAcStatus;
    }

    public void setDeviceAcStatus(String deviceAcStatus) {
        this.deviceAcStatus = deviceAcStatus == null ? null : deviceAcStatus.trim();
    }

    public String getDeviceApStatus() {
        return deviceApStatus;
    }

    public void setDeviceApStatus(String deviceApStatus) {
        this.deviceApStatus = deviceApStatus == null ? null : deviceApStatus.trim();
    }

    public Integer getUserAccessCount() {
        return userAccessCount;
    }

    public void setUserAccessCount(Integer userAccessCount) {
        this.userAccessCount = userAccessCount;
    }

    public BigDecimal getApSendSpeed() {
        return apSendSpeed;
    }

    public void setApSendSpeed(BigDecimal apSendSpeed) {
        this.apSendSpeed = apSendSpeed;
    }

    public BigDecimal getApRecvSpeed() {
        return apRecvSpeed;
    }

    public void setApRecvSpeed(BigDecimal apRecvSpeed) {
        this.apRecvSpeed = apRecvSpeed;
    }

    public Date getCollectDate() {
        return collectDate;
    }

    public void setCollectDate(Date collectDate) {
        this.collectDate = collectDate;
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

    public String getApGroupId() {
        return apGroupId;
    }

    public void setApGroupId(String apGroupId) {
        this.apGroupId = apGroupId == null ? null : apGroupId.trim();
    }

    public String getApGroupName() {
        return apGroupName;
    }

    public void setApGroupName(String apGroupName) {
        this.apGroupName = apGroupName == null ? null : apGroupName.trim();
    }

    public Integer getUserProbeCount() {
        return userProbeCount;
    }

    public void setUserProbeCount(Integer userProbeCount) {
        this.userProbeCount = userProbeCount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", branchId=").append(branchId);
        sb.append(", apIdAddress=").append(apIdAddress);
        sb.append(", acIdAddress=").append(acIdAddress);
        sb.append(", deviceApCode=").append(deviceApCode);
        sb.append(", deviceAcCode=").append(deviceAcCode);
        sb.append(", acRunningStatus=").append(acRunningStatus);
        sb.append(", apRunningStatus=").append(apRunningStatus);
        sb.append(", deviceAcStatus=").append(deviceAcStatus);
        sb.append(", deviceApStatus=").append(deviceApStatus);
        sb.append(", userAccessCount=").append(userAccessCount);
        sb.append(", apSendSpeed=").append(apSendSpeed);
        sb.append(", apRecvSpeed=").append(apRecvSpeed);
        sb.append(", collectDate=").append(collectDate);
        sb.append(", createBy=").append(createBy);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", remarks=").append(remarks);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", apGroupId=").append(apGroupId);
        sb.append(", apGroupName=").append(apGroupName);
        sb.append(", userProbeCount=").append(userProbeCount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}