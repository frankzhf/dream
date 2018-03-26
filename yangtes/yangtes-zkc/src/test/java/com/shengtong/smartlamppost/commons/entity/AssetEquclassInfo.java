package com.shengtong.smartlamppost.commons.entity;

import java.io.Serializable;

public class AssetEquclassInfo implements Serializable {
    private Integer equclassId;

    private String equclassCode;

    private String equclassName;

    private String supplement;

    private static final long serialVersionUID = 1L;

    public Integer getEquclassId() {
        return equclassId;
    }

    public void setEquclassId(Integer equclassId) {
        this.equclassId = equclassId;
    }

    public String getEquclassCode() {
        return equclassCode;
    }

    public void setEquclassCode(String equclassCode) {
        this.equclassCode = equclassCode == null ? null : equclassCode.trim();
    }

    public String getEquclassName() {
        return equclassName;
    }

    public void setEquclassName(String equclassName) {
        this.equclassName = equclassName == null ? null : equclassName.trim();
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
        sb.append(", equclassId=").append(equclassId);
        sb.append(", equclassCode=").append(equclassCode);
        sb.append(", equclassName=").append(equclassName);
        sb.append(", supplement=").append(supplement);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}