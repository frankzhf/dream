package com.shengtong.smartlamppost.commons.entity;

import java.io.Serializable;

public class AssetLampInfo implements Serializable {
    private Integer lampId;

    private String lampCode;

    private String lampName;

    private Integer equmodelId;

    private Integer equclassId;

    private Integer equsectionId;

    private Integer groupId;

    private Integer factoryId;

    private Long dateFactory;

    private String gisPosX;

    private String gisPosY;

    private Long dateCreated;

    private Long dateModified;

    private String createdBy;

    private String modifiedBy;

    private Integer isAvailable;

    private String supplement;

    private String lampAddr;

    private static final long serialVersionUID = 1L;

    public Integer getLampId() {
        return lampId;
    }

    public void setLampId(Integer lampId) {
        this.lampId = lampId;
    }

    public String getLampCode() {
        return lampCode;
    }

    public void setLampCode(String lampCode) {
        this.lampCode = lampCode == null ? null : lampCode.trim();
    }

    public String getLampName() {
        return lampName;
    }

    public void setLampName(String lampName) {
        this.lampName = lampName == null ? null : lampName.trim();
    }

    public Integer getEqumodelId() {
        return equmodelId;
    }

    public void setEqumodelId(Integer equmodelId) {
        this.equmodelId = equmodelId;
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

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(Integer factoryId) {
        this.factoryId = factoryId;
    }

    public Long getDateFactory() {
        return dateFactory;
    }

    public void setDateFactory(Long dateFactory) {
        this.dateFactory = dateFactory;
    }

    public String getGisPosX() {
        return gisPosX;
    }

    public void setGisPosX(String gisPosX) {
        this.gisPosX = gisPosX == null ? null : gisPosX.trim();
    }

    public String getGisPosY() {
        return gisPosY;
    }

    public void setGisPosY(String gisPosY) {
        this.gisPosY = gisPosY == null ? null : gisPosY.trim();
    }

    public Long getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Long dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Long getDateModified() {
        return dateModified;
    }

    public void setDateModified(Long dateModified) {
        this.dateModified = dateModified;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy == null ? null : modifiedBy.trim();
    }

    public Integer getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Integer isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getSupplement() {
        return supplement;
    }

    public void setSupplement(String supplement) {
        this.supplement = supplement == null ? null : supplement.trim();
    }

    public String getLampAddr() {
        return lampAddr;
    }

    public void setLampAddr(String lampAddr) {
        this.lampAddr = lampAddr == null ? null : lampAddr.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", lampId=").append(lampId);
        sb.append(", lampCode=").append(lampCode);
        sb.append(", lampName=").append(lampName);
        sb.append(", equmodelId=").append(equmodelId);
        sb.append(", equclassId=").append(equclassId);
        sb.append(", equsectionId=").append(equsectionId);
        sb.append(", groupId=").append(groupId);
        sb.append(", factoryId=").append(factoryId);
        sb.append(", dateFactory=").append(dateFactory);
        sb.append(", gisPosX=").append(gisPosX);
        sb.append(", gisPosY=").append(gisPosY);
        sb.append(", dateCreated=").append(dateCreated);
        sb.append(", dateModified=").append(dateModified);
        sb.append(", createdBy=").append(createdBy);
        sb.append(", modifiedBy=").append(modifiedBy);
        sb.append(", isAvailable=").append(isAvailable);
        sb.append(", supplement=").append(supplement);
        sb.append(", lampAddr=").append(lampAddr);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}