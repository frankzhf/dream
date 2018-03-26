package com.shengtong.smartlamppost.commons.entity;

import java.io.Serializable;

public class OpsSyncSubnodeRecord extends OpsSyncSubnodeRecordKey implements Serializable {
    private String pkName;

    private String lastUpdate;

    private String status;

    private Integer times;

    private static final long serialVersionUID = 1L;

    public String getPkName() {
        return pkName;
    }

    public void setPkName(String pkName) {
        this.pkName = pkName == null ? null : pkName.trim();
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate == null ? null : lastUpdate.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pkName=").append(pkName);
        sb.append(", lastUpdate=").append(lastUpdate);
        sb.append(", status=").append(status);
        sb.append(", times=").append(times);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}