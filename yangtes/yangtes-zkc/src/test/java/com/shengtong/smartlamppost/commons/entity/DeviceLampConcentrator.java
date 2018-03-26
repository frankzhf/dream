package com.shengtong.smartlamppost.commons.entity;

import java.io.Serializable;
import java.util.Date;

public class DeviceLampConcentrator implements Serializable {
    private String id;

    private String branchId;

    private String deviceLogicalAddr;

    private String devicePhysicalAddr;

    private Date collectDate;

    private String runningStatus;

    private String argvStatus;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private String remarks;

    private String delFlag;

    private String offstreamStatus;

    private String deviceStatus;

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

    public String getDeviceLogicalAddr() {
        return deviceLogicalAddr;
    }

    public void setDeviceLogicalAddr(String deviceLogicalAddr) {
        this.deviceLogicalAddr = deviceLogicalAddr == null ? null : deviceLogicalAddr.trim();
    }

    public String getDevicePhysicalAddr() {
        return devicePhysicalAddr;
    }

    public void setDevicePhysicalAddr(String devicePhysicalAddr) {
        this.devicePhysicalAddr = devicePhysicalAddr == null ? null : devicePhysicalAddr.trim();
    }

    public Date getCollectDate() {
        return collectDate;
    }

    public void setCollectDate(Date collectDate) {
        this.collectDate = collectDate;
    }

    public String getRunningStatus() {
        return runningStatus;
    }

    public void setRunningStatus(String runningStatus) {
        this.runningStatus = runningStatus == null ? null : runningStatus.trim();
    }

    public String getArgvStatus() {
        return argvStatus;
    }

    public void setArgvStatus(String argvStatus) {
        this.argvStatus = argvStatus == null ? null : argvStatus.trim();
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

    public String getOffstreamStatus() {
        return offstreamStatus;
    }

    public void setOffstreamStatus(String offstreamStatus) {
        this.offstreamStatus = offstreamStatus == null ? null : offstreamStatus.trim();
    }

    public String getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(String deviceStatus) {
        this.deviceStatus = deviceStatus == null ? null : deviceStatus.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", branchId=").append(branchId);
        sb.append(", deviceLogicalAddr=").append(deviceLogicalAddr);
        sb.append(", devicePhysicalAddr=").append(devicePhysicalAddr);
        sb.append(", collectDate=").append(collectDate);
        sb.append(", runningStatus=").append(runningStatus);
        sb.append(", argvStatus=").append(argvStatus);
        sb.append(", createBy=").append(createBy);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", remarks=").append(remarks);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", offstreamStatus=").append(offstreamStatus);
        sb.append(", deviceStatus=").append(deviceStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}