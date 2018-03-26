package com.shengtong.smartlamppost.commons.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DeviceLampTerminalLoop implements Serializable {
    private String id;

    private String deviceLampTerminalId;

    private String branchId;

    private Integer loopId;

    private String loopName;

    private BigDecimal current;

    private BigDecimal power;

    private BigDecimal voltage;

    private BigDecimal rate;

    private String factor;

    private String switchInputStatus;

    private String voltageOverRange;

    private String currentOverRange;

    private Integer lampOnTime;

    private Double estimatePowerCapacity;

    private Double electricity;

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

    public String getDeviceLampTerminalId() {
        return deviceLampTerminalId;
    }

    public void setDeviceLampTerminalId(String deviceLampTerminalId) {
        this.deviceLampTerminalId = deviceLampTerminalId == null ? null : deviceLampTerminalId.trim();
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId == null ? null : branchId.trim();
    }

    public Integer getLoopId() {
        return loopId;
    }

    public void setLoopId(Integer loopId) {
        this.loopId = loopId;
    }

    public String getLoopName() {
        return loopName;
    }

    public void setLoopName(String loopName) {
        this.loopName = loopName == null ? null : loopName.trim();
    }

    public BigDecimal getCurrent() {
        return current;
    }

    public void setCurrent(BigDecimal current) {
        this.current = current;
    }

    public BigDecimal getPower() {
        return power;
    }

    public void setPower(BigDecimal power) {
        this.power = power;
    }

    public BigDecimal getVoltage() {
        return voltage;
    }

    public void setVoltage(BigDecimal voltage) {
        this.voltage = voltage;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public String getFactor() {
        return factor;
    }

    public void setFactor(String factor) {
        this.factor = factor == null ? null : factor.trim();
    }

    public String getSwitchInputStatus() {
        return switchInputStatus;
    }

    public void setSwitchInputStatus(String switchInputStatus) {
        this.switchInputStatus = switchInputStatus == null ? null : switchInputStatus.trim();
    }

    public String getVoltageOverRange() {
        return voltageOverRange;
    }

    public void setVoltageOverRange(String voltageOverRange) {
        this.voltageOverRange = voltageOverRange == null ? null : voltageOverRange.trim();
    }

    public String getCurrentOverRange() {
        return currentOverRange;
    }

    public void setCurrentOverRange(String currentOverRange) {
        this.currentOverRange = currentOverRange == null ? null : currentOverRange.trim();
    }

    public Integer getLampOnTime() {
        return lampOnTime;
    }

    public void setLampOnTime(Integer lampOnTime) {
        this.lampOnTime = lampOnTime;
    }

    public Double getEstimatePowerCapacity() {
        return estimatePowerCapacity;
    }

    public void setEstimatePowerCapacity(Double estimatePowerCapacity) {
        this.estimatePowerCapacity = estimatePowerCapacity;
    }

    public Double getElectricity() {
        return electricity;
    }

    public void setElectricity(Double electricity) {
        this.electricity = electricity;
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
        sb.append(", deviceLampTerminalId=").append(deviceLampTerminalId);
        sb.append(", branchId=").append(branchId);
        sb.append(", loopId=").append(loopId);
        sb.append(", loopName=").append(loopName);
        sb.append(", current=").append(current);
        sb.append(", power=").append(power);
        sb.append(", voltage=").append(voltage);
        sb.append(", rate=").append(rate);
        sb.append(", factor=").append(factor);
        sb.append(", switchInputStatus=").append(switchInputStatus);
        sb.append(", voltageOverRange=").append(voltageOverRange);
        sb.append(", currentOverRange=").append(currentOverRange);
        sb.append(", lampOnTime=").append(lampOnTime);
        sb.append(", estimatePowerCapacity=").append(estimatePowerCapacity);
        sb.append(", electricity=").append(electricity);
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