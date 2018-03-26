package com.shengtong.smartlamppost.commons.entity;

import java.io.Serializable;
import java.util.Date;

public class OpsGatewayService implements Serializable {
    private String id;

    private String branchId;

    private String gatewayCode;

    private String gatewayName;

    private Date onlineDate;

    private Date offlineDate;

    private String gatewayIpAddr;

    private String gatewayPort;

    private String getwayStatus;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private String remarks;

    private String delFlag;

    private String getwayStatuscopy;

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

    public String getGatewayCode() {
        return gatewayCode;
    }

    public void setGatewayCode(String gatewayCode) {
        this.gatewayCode = gatewayCode == null ? null : gatewayCode.trim();
    }

    public String getGatewayName() {
        return gatewayName;
    }

    public void setGatewayName(String gatewayName) {
        this.gatewayName = gatewayName == null ? null : gatewayName.trim();
    }

    public Date getOnlineDate() {
        return onlineDate;
    }

    public void setOnlineDate(Date onlineDate) {
        this.onlineDate = onlineDate;
    }

    public Date getOfflineDate() {
        return offlineDate;
    }

    public void setOfflineDate(Date offlineDate) {
        this.offlineDate = offlineDate;
    }

    public String getGatewayIpAddr() {
        return gatewayIpAddr;
    }

    public void setGatewayIpAddr(String gatewayIpAddr) {
        this.gatewayIpAddr = gatewayIpAddr == null ? null : gatewayIpAddr.trim();
    }

    public String getGatewayPort() {
        return gatewayPort;
    }

    public void setGatewayPort(String gatewayPort) {
        this.gatewayPort = gatewayPort == null ? null : gatewayPort.trim();
    }

    public String getGetwayStatus() {
        return getwayStatus;
    }

    public void setGetwayStatus(String getwayStatus) {
        this.getwayStatus = getwayStatus == null ? null : getwayStatus.trim();
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

    public String getGetwayStatuscopy() {
        return getwayStatuscopy;
    }

    public void setGetwayStatuscopy(String getwayStatuscopy) {
        this.getwayStatuscopy = getwayStatuscopy == null ? null : getwayStatuscopy.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", branchId=").append(branchId);
        sb.append(", gatewayCode=").append(gatewayCode);
        sb.append(", gatewayName=").append(gatewayName);
        sb.append(", onlineDate=").append(onlineDate);
        sb.append(", offlineDate=").append(offlineDate);
        sb.append(", gatewayIpAddr=").append(gatewayIpAddr);
        sb.append(", gatewayPort=").append(gatewayPort);
        sb.append(", getwayStatus=").append(getwayStatus);
        sb.append(", createBy=").append(createBy);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", remarks=").append(remarks);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", getwayStatuscopy=").append(getwayStatuscopy);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}