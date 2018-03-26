package com.shengtong.smartlamppost.commons.entity;

import java.io.Serializable;

public class AssetGroupInfo implements Serializable {
    private Integer groupId;

    private String groupCode;

    private String groupName;

    private Integer parentGroupId;

    private Integer areaId;

    private Integer isSubnode;

    private Long dateCreated;

    private Long dateModified;

    private String createdBy;

    private String modifiedBy;

    private String supplement;

    private Integer modifiedBySystem;

    private String parentGroupIds;

    private static final long serialVersionUID = 1L;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode == null ? null : groupCode.trim();
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public Integer getParentGroupId() {
        return parentGroupId;
    }

    public void setParentGroupId(Integer parentGroupId) {
        this.parentGroupId = parentGroupId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getIsSubnode() {
        return isSubnode;
    }

    public void setIsSubnode(Integer isSubnode) {
        this.isSubnode = isSubnode;
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

    public String getSupplement() {
        return supplement;
    }

    public void setSupplement(String supplement) {
        this.supplement = supplement == null ? null : supplement.trim();
    }

    public Integer getModifiedBySystem() {
        return modifiedBySystem;
    }

    public void setModifiedBySystem(Integer modifiedBySystem) {
        this.modifiedBySystem = modifiedBySystem;
    }

    public String getParentGroupIds() {
        return parentGroupIds;
    }

    public void setParentGroupIds(String parentGroupIds) {
        this.parentGroupIds = parentGroupIds == null ? null : parentGroupIds.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", groupId=").append(groupId);
        sb.append(", groupCode=").append(groupCode);
        sb.append(", groupName=").append(groupName);
        sb.append(", parentGroupId=").append(parentGroupId);
        sb.append(", areaId=").append(areaId);
        sb.append(", isSubnode=").append(isSubnode);
        sb.append(", dateCreated=").append(dateCreated);
        sb.append(", dateModified=").append(dateModified);
        sb.append(", createdBy=").append(createdBy);
        sb.append(", modifiedBy=").append(modifiedBy);
        sb.append(", supplement=").append(supplement);
        sb.append(", modifiedBySystem=").append(modifiedBySystem);
        sb.append(", parentGroupIds=").append(parentGroupIds);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}