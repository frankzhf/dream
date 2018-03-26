package com.shengtong.smartlamppost.commons.entity;

import java.io.Serializable;
import java.util.Date;

public class SysHeatmap implements Serializable {
    private String id;

    private String branchId;

    private String parameterCode;

    private String parameterDesc;

    private String parameterUnit;

    private String areaMaxValue1;

    private String areaMaxValue2;

    private String areaMaxValue3;

    private String areaMaxValue4;

    private String areaMaxValue5;

    private Integer sort;

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

    public String getParameterCode() {
        return parameterCode;
    }

    public void setParameterCode(String parameterCode) {
        this.parameterCode = parameterCode == null ? null : parameterCode.trim();
    }

    public String getParameterDesc() {
        return parameterDesc;
    }

    public void setParameterDesc(String parameterDesc) {
        this.parameterDesc = parameterDesc == null ? null : parameterDesc.trim();
    }

    public String getParameterUnit() {
        return parameterUnit;
    }

    public void setParameterUnit(String parameterUnit) {
        this.parameterUnit = parameterUnit == null ? null : parameterUnit.trim();
    }

    public String getAreaMaxValue1() {
        return areaMaxValue1;
    }

    public void setAreaMaxValue1(String areaMaxValue1) {
        this.areaMaxValue1 = areaMaxValue1 == null ? null : areaMaxValue1.trim();
    }

    public String getAreaMaxValue2() {
        return areaMaxValue2;
    }

    public void setAreaMaxValue2(String areaMaxValue2) {
        this.areaMaxValue2 = areaMaxValue2 == null ? null : areaMaxValue2.trim();
    }

    public String getAreaMaxValue3() {
        return areaMaxValue3;
    }

    public void setAreaMaxValue3(String areaMaxValue3) {
        this.areaMaxValue3 = areaMaxValue3 == null ? null : areaMaxValue3.trim();
    }

    public String getAreaMaxValue4() {
        return areaMaxValue4;
    }

    public void setAreaMaxValue4(String areaMaxValue4) {
        this.areaMaxValue4 = areaMaxValue4 == null ? null : areaMaxValue4.trim();
    }

    public String getAreaMaxValue5() {
        return areaMaxValue5;
    }

    public void setAreaMaxValue5(String areaMaxValue5) {
        this.areaMaxValue5 = areaMaxValue5 == null ? null : areaMaxValue5.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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
        sb.append(", parameterCode=").append(parameterCode);
        sb.append(", parameterDesc=").append(parameterDesc);
        sb.append(", parameterUnit=").append(parameterUnit);
        sb.append(", areaMaxValue1=").append(areaMaxValue1);
        sb.append(", areaMaxValue2=").append(areaMaxValue2);
        sb.append(", areaMaxValue3=").append(areaMaxValue3);
        sb.append(", areaMaxValue4=").append(areaMaxValue4);
        sb.append(", areaMaxValue5=").append(areaMaxValue5);
        sb.append(", sort=").append(sort);
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