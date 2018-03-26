package com.shengtong.smartlamppost.commons.entity;

import java.io.Serializable;

public class AssetFactoryInfo implements Serializable {
    private Integer factoryId;

    private String factoryName;

    private String factoryTel;

    private String factoryAddr;

    private String factoryAttn;

    private String supplement;

    private static final long serialVersionUID = 1L;

    public Integer getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(Integer factoryId) {
        this.factoryId = factoryId;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName == null ? null : factoryName.trim();
    }

    public String getFactoryTel() {
        return factoryTel;
    }

    public void setFactoryTel(String factoryTel) {
        this.factoryTel = factoryTel == null ? null : factoryTel.trim();
    }

    public String getFactoryAddr() {
        return factoryAddr;
    }

    public void setFactoryAddr(String factoryAddr) {
        this.factoryAddr = factoryAddr == null ? null : factoryAddr.trim();
    }

    public String getFactoryAttn() {
        return factoryAttn;
    }

    public void setFactoryAttn(String factoryAttn) {
        this.factoryAttn = factoryAttn == null ? null : factoryAttn.trim();
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
        sb.append(", factoryId=").append(factoryId);
        sb.append(", factoryName=").append(factoryName);
        sb.append(", factoryTel=").append(factoryTel);
        sb.append(", factoryAddr=").append(factoryAddr);
        sb.append(", factoryAttn=").append(factoryAttn);
        sb.append(", supplement=").append(supplement);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}