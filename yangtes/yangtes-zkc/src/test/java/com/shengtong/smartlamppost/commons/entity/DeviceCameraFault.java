package com.shengtong.smartlamppost.commons.entity;

import java.io.Serializable;
import java.util.Date;

public class DeviceCameraFault implements Serializable {
    private String id;

    private String branchId;

    private String deviceCameraId;

    private String deviceCode;

    private String faultLevel;

    private String faultType;

    private String faultCode;

    private String faultDesc;

    private String faultStatus;

    private Date faultCreateDate;

    private Date faultResloveDate;

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

    public String getDeviceCameraId() {
        return deviceCameraId;
    }

    public void setDeviceCameraId(String deviceCameraId) {
        this.deviceCameraId = deviceCameraId == null ? null : deviceCameraId.trim();
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode == null ? null : deviceCode.trim();
    }

    public String getFaultLevel() {
        return faultLevel;
    }

    public void setFaultLevel(String faultLevel) {
        this.faultLevel = faultLevel == null ? null : faultLevel.trim();
    }

    public String getFaultType() {
        return faultType;
    }

    public void setFaultType(String faultType) {
        this.faultType = faultType == null ? null : faultType.trim();
    }

    public String getFaultCode() {
        return faultCode;
    }

    public void setFaultCode(String faultCode) {
        this.faultCode = faultCode == null ? null : faultCode.trim();
    }

    public String getFaultDesc() {
        return faultDesc;
    }

    public void setFaultDesc(String faultDesc) {
        this.faultDesc = faultDesc == null ? null : faultDesc.trim();
    }

    public String getFaultStatus() {
        return faultStatus;
    }

    public void setFaultStatus(String faultStatus) {
        this.faultStatus = faultStatus == null ? null : faultStatus.trim();
    }

    public Date getFaultCreateDate() {
        return faultCreateDate;
    }

    public void setFaultCreateDate(Date faultCreateDate) {
        this.faultCreateDate = faultCreateDate;
    }

    public Date getFaultResloveDate() {
        return faultResloveDate;
    }

    public void setFaultResloveDate(Date faultResloveDate) {
        this.faultResloveDate = faultResloveDate;
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
        sb.append(", deviceCameraId=").append(deviceCameraId);
        sb.append(", deviceCode=").append(deviceCode);
        sb.append(", faultLevel=").append(faultLevel);
        sb.append(", faultType=").append(faultType);
        sb.append(", faultCode=").append(faultCode);
        sb.append(", faultDesc=").append(faultDesc);
        sb.append(", faultStatus=").append(faultStatus);
        sb.append(", faultCreateDate=").append(faultCreateDate);
        sb.append(", faultResloveDate=").append(faultResloveDate);
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