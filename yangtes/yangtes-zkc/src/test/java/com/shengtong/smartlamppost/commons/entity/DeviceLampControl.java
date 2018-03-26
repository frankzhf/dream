package com.shengtong.smartlamppost.commons.entity;

import java.io.Serializable;
import java.util.Date;

public class DeviceLampControl implements Serializable {
    private String id;

    private String concentratorId;

    private String branchId;

    private String deviceLogicalAddr;

    private String devicePhysicalAddr;

    private Date collectDate;

    private String parameterErrorStatus;

    private String runningStatus;

    private String eepromStatus;

    private String alertStatus;

    private String workParameterStatus;

    private String correctStatus;

    private String status;

    private Integer temperature;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private String remarks;

    private String delFlag;

    private Date dtCache;

    private String offstreamStatus;

    private String deviceStatus;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getConcentratorId() {
        return concentratorId;
    }

    public void setConcentratorId(String concentratorId) {
        this.concentratorId = concentratorId == null ? null : concentratorId.trim();
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

    public String getParameterErrorStatus() {
        return parameterErrorStatus;
    }

    public void setParameterErrorStatus(String parameterErrorStatus) {
        this.parameterErrorStatus = parameterErrorStatus == null ? null : parameterErrorStatus.trim();
    }

    public String getRunningStatus() {
        return runningStatus;
    }

    public void setRunningStatus(String runningStatus) {
        this.runningStatus = runningStatus == null ? null : runningStatus.trim();
    }

    public String getEepromStatus() {
        return eepromStatus;
    }

    public void setEepromStatus(String eepromStatus) {
        this.eepromStatus = eepromStatus == null ? null : eepromStatus.trim();
    }

    public String getAlertStatus() {
        return alertStatus;
    }

    public void setAlertStatus(String alertStatus) {
        this.alertStatus = alertStatus == null ? null : alertStatus.trim();
    }

    public String getWorkParameterStatus() {
        return workParameterStatus;
    }

    public void setWorkParameterStatus(String workParameterStatus) {
        this.workParameterStatus = workParameterStatus == null ? null : workParameterStatus.trim();
    }

    public String getCorrectStatus() {
        return correctStatus;
    }

    public void setCorrectStatus(String correctStatus) {
        this.correctStatus = correctStatus == null ? null : correctStatus.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
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

    public Date getDtCache() {
        return dtCache;
    }

    public void setDtCache(Date dtCache) {
        this.dtCache = dtCache;
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
        sb.append(", concentratorId=").append(concentratorId);
        sb.append(", branchId=").append(branchId);
        sb.append(", deviceLogicalAddr=").append(deviceLogicalAddr);
        sb.append(", devicePhysicalAddr=").append(devicePhysicalAddr);
        sb.append(", collectDate=").append(collectDate);
        sb.append(", parameterErrorStatus=").append(parameterErrorStatus);
        sb.append(", runningStatus=").append(runningStatus);
        sb.append(", eepromStatus=").append(eepromStatus);
        sb.append(", alertStatus=").append(alertStatus);
        sb.append(", workParameterStatus=").append(workParameterStatus);
        sb.append(", correctStatus=").append(correctStatus);
        sb.append(", status=").append(status);
        sb.append(", temperature=").append(temperature);
        sb.append(", createBy=").append(createBy);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", remarks=").append(remarks);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", dtCache=").append(dtCache);
        sb.append(", offstreamStatus=").append(offstreamStatus);
        sb.append(", deviceStatus=").append(deviceStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}