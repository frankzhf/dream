package net.frank.llin.prototype.config;

import net.frank.llin.prototype.Constant;

import java.io.Serializable;

public class DeviceRuntime implements Serializable,Cloneable {
    /**
     *
     */
    private static final long serialVersionUID = -3586223084916865442L;

    private String cloudId;

    private String socketAddress;

    private int deviceTypeCode;

    private int status = Constant.DeviceStatus.init;

    private String prevAlarmId;

    private long updated = System.currentTimeMillis();

    public String getCloudId() {
        return cloudId;
    }

    public void setCloudId(String cloudId) {
        this.cloudId = cloudId;
    }

    public String getSocketAddress() {
        return socketAddress;
    }

    public void setSocketAddress(String socketAddress) {
        this.socketAddress = socketAddress;
    }

    public int getDeviceTypeCode() {
        return deviceTypeCode;
    }

    public void setDeviceTypeCode(int deviceTypeCode) {
        this.deviceTypeCode = deviceTypeCode;
    }

    public int getStatus() {
        return status;
    }

    public String getPrevAlarmId() {
        return prevAlarmId;
    }

    public void setPrevAlarmId(String prevAlarmId) {
        this.prevAlarmId = prevAlarmId;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getUpdated() {
        return updated;
    }

    public void setUpdated(long updated) {
        this.updated = updated;
    }

    public DeviceRuntime clone() {
        DeviceRuntime clone = null;
        Object ref = null;
        try {
            ref = super.clone();
            if(ref instanceof DeviceRuntime) {
                clone = (DeviceRuntime)ref;
            }
        }catch(CloneNotSupportedException e) {
            return null;
        }
        return clone;
    }

    @Override
    public String toString() {
        return "DeviceRuntime [cloudId=" + cloudId + ", socketAddress=" + socketAddress + ", deviceTypeCode="
                + deviceTypeCode + ", status=" + status + ", prevAlarmId=" + prevAlarmId + ", updated=" + updated
                + "]";
    }
}
