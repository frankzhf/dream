package com.shengtong.smartlamppost.commons.entity;

import java.io.Serializable;
import java.util.Date;

public class SysBranch implements Serializable {
    private String id;

    private String branchCode;

    private String branchName;

    private String branchAddr;

    private String branchInterfaceAddr;

    private String branchInterfaceKey;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private String remarks;

    private String delFlag;

    private String lampServiceUrl;

    private String uuid;

    private Integer branchSort;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode == null ? null : branchCode.trim();
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName == null ? null : branchName.trim();
    }

    public String getBranchAddr() {
        return branchAddr;
    }

    public void setBranchAddr(String branchAddr) {
        this.branchAddr = branchAddr == null ? null : branchAddr.trim();
    }

    public String getBranchInterfaceAddr() {
        return branchInterfaceAddr;
    }

    public void setBranchInterfaceAddr(String branchInterfaceAddr) {
        this.branchInterfaceAddr = branchInterfaceAddr == null ? null : branchInterfaceAddr.trim();
    }

    public String getBranchInterfaceKey() {
        return branchInterfaceKey;
    }

    public void setBranchInterfaceKey(String branchInterfaceKey) {
        this.branchInterfaceKey = branchInterfaceKey == null ? null : branchInterfaceKey.trim();
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

    public String getLampServiceUrl() {
        return lampServiceUrl;
    }

    public void setLampServiceUrl(String lampServiceUrl) {
        this.lampServiceUrl = lampServiceUrl == null ? null : lampServiceUrl.trim();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public Integer getBranchSort() {
        return branchSort;
    }

    public void setBranchSort(Integer branchSort) {
        this.branchSort = branchSort;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", branchCode=").append(branchCode);
        sb.append(", branchName=").append(branchName);
        sb.append(", branchAddr=").append(branchAddr);
        sb.append(", branchInterfaceAddr=").append(branchInterfaceAddr);
        sb.append(", branchInterfaceKey=").append(branchInterfaceKey);
        sb.append(", createBy=").append(createBy);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", remarks=").append(remarks);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", lampServiceUrl=").append(lampServiceUrl);
        sb.append(", uuid=").append(uuid);
        sb.append(", branchSort=").append(branchSort);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}