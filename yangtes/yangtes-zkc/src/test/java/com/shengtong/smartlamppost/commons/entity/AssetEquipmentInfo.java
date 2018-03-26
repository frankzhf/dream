package com.shengtong.smartlamppost.commons.entity;

import java.io.Serializable;

public class AssetEquipmentInfo implements Serializable {
    private Integer equipmentId;

    private String equipmentCode;

    private String equipmentName;

    private Integer lampId;

    private Integer equclassId;

    private Integer equsectionId;

    private Integer equmodelId;

    private Integer groupId;

    private String equipmentIp;

    private String equipmentPort;

    private String macAddr;

    private String sn;

    private Integer factoryId;

    private Long dateFactory;

    private String equipmentLoginName;

    private String equipmentLoginPassword;

    private Long dateCreated;

    private Long dateModified;

    private String createdBy;

    private String modifiedBy;

    private Integer isAvailable;

    private String supplement;

    private String serviceIp;

    private String servicePort;

    private String serviceLoginName;

    private String serviceLoginPassword;

    private String controlcardSerialnum;

    private Integer relatedEquipmentId;

    private String subnetMask;

    private String gateway;

    private String dns;

    private String gisPosX;

    private String gisPosY;

    private String equipmentAddr;

    private String businessCode;

    private static final long serialVersionUID = 1L;

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getEquipmentCode() {
        return equipmentCode;
    }

    public void setEquipmentCode(String equipmentCode) {
        this.equipmentCode = equipmentCode == null ? null : equipmentCode.trim();
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName == null ? null : equipmentName.trim();
    }

    public Integer getLampId() {
        return lampId;
    }

    public void setLampId(Integer lampId) {
        this.lampId = lampId;
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

    public Integer getEqumodelId() {
        return equmodelId;
    }

    public void setEqumodelId(Integer equmodelId) {
        this.equmodelId = equmodelId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getEquipmentIp() {
        return equipmentIp;
    }

    public void setEquipmentIp(String equipmentIp) {
        this.equipmentIp = equipmentIp == null ? null : equipmentIp.trim();
    }

    public String getEquipmentPort() {
        return equipmentPort;
    }

    public void setEquipmentPort(String equipmentPort) {
        this.equipmentPort = equipmentPort == null ? null : equipmentPort.trim();
    }

    public String getMacAddr() {
        return macAddr;
    }

    public void setMacAddr(String macAddr) {
        this.macAddr = macAddr == null ? null : macAddr.trim();
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
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

    public String getEquipmentLoginName() {
        return equipmentLoginName;
    }

    public void setEquipmentLoginName(String equipmentLoginName) {
        this.equipmentLoginName = equipmentLoginName == null ? null : equipmentLoginName.trim();
    }

    public String getEquipmentLoginPassword() {
        return equipmentLoginPassword;
    }

    public void setEquipmentLoginPassword(String equipmentLoginPassword) {
        this.equipmentLoginPassword = equipmentLoginPassword == null ? null : equipmentLoginPassword.trim();
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

    public String getServiceIp() {
        return serviceIp;
    }

    public void setServiceIp(String serviceIp) {
        this.serviceIp = serviceIp == null ? null : serviceIp.trim();
    }

    public String getServicePort() {
        return servicePort;
    }

    public void setServicePort(String servicePort) {
        this.servicePort = servicePort == null ? null : servicePort.trim();
    }

    public String getServiceLoginName() {
        return serviceLoginName;
    }

    public void setServiceLoginName(String serviceLoginName) {
        this.serviceLoginName = serviceLoginName == null ? null : serviceLoginName.trim();
    }

    public String getServiceLoginPassword() {
        return serviceLoginPassword;
    }

    public void setServiceLoginPassword(String serviceLoginPassword) {
        this.serviceLoginPassword = serviceLoginPassword == null ? null : serviceLoginPassword.trim();
    }

    public String getControlcardSerialnum() {
        return controlcardSerialnum;
    }

    public void setControlcardSerialnum(String controlcardSerialnum) {
        this.controlcardSerialnum = controlcardSerialnum == null ? null : controlcardSerialnum.trim();
    }

    public Integer getRelatedEquipmentId() {
        return relatedEquipmentId;
    }

    public void setRelatedEquipmentId(Integer relatedEquipmentId) {
        this.relatedEquipmentId = relatedEquipmentId;
    }

    public String getSubnetMask() {
        return subnetMask;
    }

    public void setSubnetMask(String subnetMask) {
        this.subnetMask = subnetMask == null ? null : subnetMask.trim();
    }

    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway == null ? null : gateway.trim();
    }

    public String getDns() {
        return dns;
    }

    public void setDns(String dns) {
        this.dns = dns == null ? null : dns.trim();
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

    public String getEquipmentAddr() {
        return equipmentAddr;
    }

    public void setEquipmentAddr(String equipmentAddr) {
        this.equipmentAddr = equipmentAddr == null ? null : equipmentAddr.trim();
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode == null ? null : businessCode.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", equipmentId=").append(equipmentId);
        sb.append(", equipmentCode=").append(equipmentCode);
        sb.append(", equipmentName=").append(equipmentName);
        sb.append(", lampId=").append(lampId);
        sb.append(", equclassId=").append(equclassId);
        sb.append(", equsectionId=").append(equsectionId);
        sb.append(", equmodelId=").append(equmodelId);
        sb.append(", groupId=").append(groupId);
        sb.append(", equipmentIp=").append(equipmentIp);
        sb.append(", equipmentPort=").append(equipmentPort);
        sb.append(", macAddr=").append(macAddr);
        sb.append(", sn=").append(sn);
        sb.append(", factoryId=").append(factoryId);
        sb.append(", dateFactory=").append(dateFactory);
        sb.append(", equipmentLoginName=").append(equipmentLoginName);
        sb.append(", equipmentLoginPassword=").append(equipmentLoginPassword);
        sb.append(", dateCreated=").append(dateCreated);
        sb.append(", dateModified=").append(dateModified);
        sb.append(", createdBy=").append(createdBy);
        sb.append(", modifiedBy=").append(modifiedBy);
        sb.append(", isAvailable=").append(isAvailable);
        sb.append(", supplement=").append(supplement);
        sb.append(", serviceIp=").append(serviceIp);
        sb.append(", servicePort=").append(servicePort);
        sb.append(", serviceLoginName=").append(serviceLoginName);
        sb.append(", serviceLoginPassword=").append(serviceLoginPassword);
        sb.append(", controlcardSerialnum=").append(controlcardSerialnum);
        sb.append(", relatedEquipmentId=").append(relatedEquipmentId);
        sb.append(", subnetMask=").append(subnetMask);
        sb.append(", gateway=").append(gateway);
        sb.append(", dns=").append(dns);
        sb.append(", gisPosX=").append(gisPosX);
        sb.append(", gisPosY=").append(gisPosY);
        sb.append(", equipmentAddr=").append(equipmentAddr);
        sb.append(", businessCode=").append(businessCode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}