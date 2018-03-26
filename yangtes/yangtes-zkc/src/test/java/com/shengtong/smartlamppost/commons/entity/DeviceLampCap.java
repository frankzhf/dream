package com.shengtong.smartlamppost.commons.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DeviceLampCap implements Serializable {
    private String id;

    private String deviceLampControlId;

    private String branchId;

    private Integer lampId;

    private String lampOnStatus;

    private String faultStatus;

    private String leakageStatus;

    private String powerStatus;

    private BigDecimal voltage;

    private BigDecimal power;

    private BigDecimal current;

    private BigDecimal electricity;

    private BigDecimal softwareElectricity;

    private BigDecimal runTime;

    private BigDecimal softwareRunTime;

    private Integer lampSaving;

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

    public String getDeviceLampControlId() {
        return deviceLampControlId;
    }

    public void setDeviceLampControlId(String deviceLampControlId) {
        this.deviceLampControlId = deviceLampControlId == null ? null : deviceLampControlId.trim();
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId == null ? null : branchId.trim();
    }

    public Integer getLampId() {
        return lampId;
    }

    public void setLampId(Integer lampId) {
        this.lampId = lampId;
    }

    public String getLampOnStatus() {
        return lampOnStatus;
    }

    public void setLampOnStatus(String lampOnStatus) {
        this.lampOnStatus = lampOnStatus == null ? null : lampOnStatus.trim();
    }

    public String getFaultStatus() {
        return faultStatus;
    }

    public void setFaultStatus(String faultStatus) {
        this.faultStatus = faultStatus == null ? null : faultStatus.trim();
    }

    public String getLeakageStatus() {
        return leakageStatus;
    }

    public void setLeakageStatus(String leakageStatus) {
        this.leakageStatus = leakageStatus == null ? null : leakageStatus.trim();
    }

    public String getPowerStatus() {
        return powerStatus;
    }

    public void setPowerStatus(String powerStatus) {
        this.powerStatus = powerStatus == null ? null : powerStatus.trim();
    }

    public BigDecimal getVoltage() {
        return voltage;
    }

    public void setVoltage(BigDecimal voltage) {
        this.voltage = voltage;
    }

    public BigDecimal getPower() {
        return power;
    }

    public void setPower(BigDecimal power) {
        this.power = power;
    }

    public BigDecimal getCurrent() {
        return current;
    }

    public void setCurrent(BigDecimal current) {
        this.current = current;
    }

    public BigDecimal getElectricity() {
        return electricity;
    }

    public void setElectricity(BigDecimal electricity) {
        this.electricity = electricity;
    }

    public BigDecimal getSoftwareElectricity() {
        return softwareElectricity;
    }

    public void setSoftwareElectricity(BigDecimal softwareElectricity) {
        this.softwareElectricity = softwareElectricity;
    }

    public BigDecimal getRunTime() {
        return runTime;
    }

    public void setRunTime(BigDecimal runTime) {
        this.runTime = runTime;
    }

    public BigDecimal getSoftwareRunTime() {
        return softwareRunTime;
    }

    public void setSoftwareRunTime(BigDecimal softwareRunTime) {
        this.softwareRunTime = softwareRunTime;
    }

    public Integer getLampSaving() {
        return lampSaving;
    }

    public void setLampSaving(Integer lampSaving) {
        this.lampSaving = lampSaving;
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
        sb.append(", deviceLampControlId=").append(deviceLampControlId);
        sb.append(", branchId=").append(branchId);
        sb.append(", lampId=").append(lampId);
        sb.append(", lampOnStatus=").append(lampOnStatus);
        sb.append(", faultStatus=").append(faultStatus);
        sb.append(", leakageStatus=").append(leakageStatus);
        sb.append(", powerStatus=").append(powerStatus);
        sb.append(", voltage=").append(voltage);
        sb.append(", power=").append(power);
        sb.append(", current=").append(current);
        sb.append(", electricity=").append(electricity);
        sb.append(", softwareElectricity=").append(softwareElectricity);
        sb.append(", runTime=").append(runTime);
        sb.append(", softwareRunTime=").append(softwareRunTime);
        sb.append(", lampSaving=").append(lampSaving);
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