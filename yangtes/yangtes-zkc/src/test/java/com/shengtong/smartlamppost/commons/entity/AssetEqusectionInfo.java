package com.shengtong.smartlamppost.commons.entity;

import java.io.Serializable;

public class AssetEqusectionInfo implements Serializable {
    private Integer equsectionId;

    private String equsectionCode;

    private Integer equclassId;

    private String equsectionName;

    private String supplement;

    private static final long serialVersionUID = 1L;

    public Integer getEqusectionId() {
        return equsectionId;
    }

    public void setEqusectionId(Integer equsectionId) {
        this.equsectionId = equsectionId;
    }

    public String getEqusectionCode() {
        return equsectionCode;
    }

    public void setEqusectionCode(String equsectionCode) {
        this.equsectionCode = equsectionCode == null ? null : equsectionCode.trim();
    }

    public Integer getEquclassId() {
        return equclassId;
    }

    public void setEquclassId(Integer equclassId) {
        this.equclassId = equclassId;
    }

    public String getEqusectionName() {
        return equsectionName;
    }

    public void setEqusectionName(String equsectionName) {
        this.equsectionName = equsectionName == null ? null : equsectionName.trim();
    }

    public String getSupplement() {
        return supplement;
    }

    public void setSupplement(String supplement) {
        this.supplement = supplement == null ? null : supplement.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", equsectionId=").append(equsectionId);
        sb.append(", equsectionCode=").append(equsectionCode);
        sb.append(", equclassId=").append(equclassId);
        sb.append(", equsectionName=").append(equsectionName);
        sb.append(", supplement=").append(supplement);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}