package com.shengtong.smartlamppost.commons.entity;

import java.io.Serializable;
import java.util.Date;

public class DeviceCoverFault implements Serializable {
    private String id;

    private String deviceCoverId;

    private String branchId;

    private String coverId;

    private String baseStationId;

    private String deviceStationCode;

    private String deviceCoverCode;

    private String coverOpenStatus;

    private String powerStatus;

    private String waterLevelStatus;

    private String faultStatus;

    private Date faultResloveDate;

    private Date collectDate;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private String remarks;

    private String delFlag;

    private Integer coverInclination;

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

    public String getDeviceStationCode() {
        return deviceStationCode;
    }

    public void setDeviceStationCode(String deviceStationCode) {
        this.deviceStationCode = deviceStationCode == null ? null : deviceStationCode.trim();
    }

    public String getDeviceCoverCode() {
        return deviceCoverCode;
    }

    public void setDeviceCoverCode(String deviceCoverCode) {
        this.deviceCoverCode = deviceCoverCode == null ? null : deviceCoverCode.trim();
    }

    public String getCoverOpenStatus() {
        return coverOpenStatus;
    }

    public void setCoverOpenStatus(String coverOpenStatus) {
        this.coverOpenStatus = coverOpenStatus == null ? null : coverOpenStatus.trim();
    }

    public String getPowerStatus() {
        return powerStatus;
    }

    public void setPowerStatus(String powerStatus) {
        this.powerStatus = powerStatus == null ? null : powerStatus.trim();
    }

    public String getWaterLevelStatus() {
        return waterLevelStatus;
    }

    public void setWaterLevelStatus(String waterLevelStatus) {
        this.waterLevelStatus = waterLevelStatus == null ? null : waterLevelStatus.trim();
    }

    public String getFaultStatus() {
        return faultStatus;
    }

    public void setFaultStatus(String faultStatus) {
        this.faultStatus = faultStatus == null ? null : faultStatus.trim();
    }

    public Date getFaultResloveDate() {
        return faultResloveDate;
    }

    public void setFaultResloveDate(Date faultResloveDate) {
        this.faultResloveDate = faultResloveDate;
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

    public Integer getCoverInclination() {
        return coverInclination;
    }

    public void setCoverInclination(Integer coverInclination) {
        this.coverInclination = coverInclination;
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
        sb.append(", deviceStationCode=").append(deviceStationCode);
        sb.append(", deviceCoverCode=").append(deviceCoverCode);
        sb.append(", coverOpenStatus=").append(coverOpenStatus);
        sb.append(", powerStatus=").append(powerStatus);
        sb.append(", waterLevelStatus=").append(waterLevelStatus);
        sb.append(", faultStatus=").append(faultStatus);
        sb.append(", faultResloveDate=").append(faultResloveDate);
        sb.append(", collectDate=").append(collectDate);
        sb.append(", createBy=").append(createBy);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", remarks=").append(remarks);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", coverInclination=").append(coverInclination);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}