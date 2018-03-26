package com.shengtong.smartlamppost.commons.entity;

import java.io.Serializable;
import java.util.Date;

public class DeviceCoverConfigHistory implements Serializable {
    private String id;

    private String deviceCoverId;

    private String branchId;

    private String coverId;

    private String baseStationId;

    private String setupResult;

    private String callbackBaseStationId;

    private String callbackCoverId;

    private Integer hearbeatTime;

    private Integer coverInclinationThreshold;

    private Integer coverCalibration;

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

    public String getDeviceCoverId() {
        return deviceCoverId;
    }

    public void setDeviceCoverId(String deviceCoverId) {
        this.deviceCoverId = deviceCoverId == null ? null : deviceCoverId.trim();
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId == null ? null : branchId.trim();
    }

    public String getCoverId() {
        return coverId;
    }

    public void setCoverId(String coverId) {
        this.coverId = coverId == null ? null : coverId.trim();
    }

    public String getBaseStationId() {
        return baseStationId;
    }

    public void setBaseStationId(String baseStationId) {
        this.baseStationId = baseStationId == null ? null : baseStationId.trim();
    }

    public String getSetupResult() {
        return setupResult;
    }

    public void setSetupResult(String setupResult) {
        this.setupResult = setupResult == null ? null : setupResult.trim();
    }

    public String getCallbackBaseStationId() {
        return callbackBaseStationId;
    }

    public void setCallbackBaseStationId(String callbackBaseStationId) {
        this.callbackBaseStationId = callbackBaseStationId == null ? null : callbackBaseStationId.trim();
    }

    public String getCallbackCoverId() {
        return callbackCoverId;
    }

    public void setCallbackCoverId(String callbackCoverId) {
        this.callbackCoverId = callbackCoverId == null ? null : callbackCoverId.trim();
    }

    public Integer getHearbeatTime() {
        return hearbeatTime;
    }

    public void setHearbeatTime(Integer hearbeatTime) {
        this.hearbeatTime = hearbeatTime;
    }

    public Integer getCoverInclinationThreshold() {
        return coverInclinationThreshold;
    }

    public void setCoverInclinationThreshold(Integer coverInclinationThreshold) {
        this.coverInclinationThreshold = coverInclinationThreshold;
    }

    public Integer getCoverCalibration() {
        return coverCalibration;
    }

    public void setCoverCalibration(Integer coverCalibration) {
        this.coverCalibration = coverCalibration;
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
        sb.append(", deviceCoverId=").append(deviceCoverId);
        sb.append(", branchId=").append(branchId);
        sb.append(", coverId=").append(coverId);
        sb.append(", baseStationId=").append(baseStationId);
        sb.append(", setupResult=").append(setupResult);
        sb.append(", callbackBaseStationId=").append(callbackBaseStationId);
        sb.append(", callbackCoverId=").append(callbackCoverId);
        sb.append(", hearbeatTime=").append(hearbeatTime);
        sb.append(", coverInclinationThreshold=").append(coverInclinationThreshold);
        sb.append(", coverCalibration=").append(coverCalibration);
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