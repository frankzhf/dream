package com.shengtong.smartlamppost.commons.entity;

import java.io.Serializable;
import java.util.Date;

public class DeviceRfidPunchCardRecord implements Serializable {
    private String id;

    private String branchId;

    private String rfidReaderDeviceId;

    private String rfidReaderDeviceCode;

    private String rfidId;

    private String rfidDeviceCode;

    private String punchCardLocation;

    private Date punchCardDate;

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

    public String getRfidReaderDeviceId() {
        return rfidReaderDeviceId;
    }

    public void setRfidReaderDeviceId(String rfidReaderDeviceId) {
        this.rfidReaderDeviceId = rfidReaderDeviceId == null ? null : rfidReaderDeviceId.trim();
    }

    public String getRfidReaderDeviceCode() {
        return rfidReaderDeviceCode;
    }

    public void setRfidReaderDeviceCode(String rfidReaderDeviceCode) {
        this.rfidReaderDeviceCode = rfidReaderDeviceCode == null ? null : rfidReaderDeviceCode.trim();
    }

    public String getRfidId() {
        return rfidId;
    }

    public void setRfidId(String rfidId) {
        this.rfidId = rfidId == null ? null : rfidId.trim();
    }

    public String getRfidDeviceCode() {
        return rfidDeviceCode;
    }

    public void setRfidDeviceCode(String rfidDeviceCode) {
        this.rfidDeviceCode = rfidDeviceCode == null ? null : rfidDeviceCode.trim();
    }

    public String getPunchCardLocation() {
        return punchCardLocation;
    }

    public void setPunchCardLocation(String punchCardLocation) {
        this.punchCardLocation = punchCardLocation == null ? null : punchCardLocation.trim();
    }

    public Date getPunchCardDate() {
        return punchCardDate;
    }

    public void setPunchCardDate(Date punchCardDate) {
        this.punchCardDate = punchCardDate;
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
        sb.append(", rfidReaderDeviceId=").append(rfidReaderDeviceId);
        sb.append(", rfidReaderDeviceCode=").append(rfidReaderDeviceCode);
        sb.append(", rfidId=").append(rfidId);
        sb.append(", rfidDeviceCode=").append(rfidDeviceCode);
        sb.append(", punchCardLocation=").append(punchCardLocation);
        sb.append(", punchCardDate=").append(punchCardDate);
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