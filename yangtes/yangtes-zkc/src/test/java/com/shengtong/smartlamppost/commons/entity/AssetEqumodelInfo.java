package com.shengtong.smartlamppost.commons.entity;

import java.io.Serializable;

public class AssetEqumodelInfo implements Serializable {
    private Integer equmodelId;

    private String equmodelName;

    private Integer equclassId;

    private Integer equsectionId;

    private String supplement;

    private static final long serialVersionUID = 1L;

    public Integer getEqumodelId() {
        return equmodelId;
    }

    public void setEqumodelId(Integer equmodelId) {
        this.equmodelId = equmodelId;
    }

    public String getEqumodelName() {
        return equmodelName;
    }

    public void setEqumodelName(String equmodelName) {
        this.equmodelName = equmodelName == null ? null : equmodelName.trim();
    }

    public Integer getEquclassId() {
        return equclassId;
    }

    public void setEquclassId(Integer equclassId) {
        this.equclassId = equclassId;
    }

    public Integer getEqusectionId() {
        return equsectionId;
    }

    public void setEqusectionId(Integer equsectionId) {
        this.equsectionId = equsectionId;
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
        sb.append(", equmodelId=").append(equmodelId);
        sb.append(", equmodelName=").append(equmodelName);
        sb.append(", equclassId=").append(equclassId);
        sb.append(", equsectionId=").append(equsectionId);
        sb.append(", supplement=").append(supplement);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}