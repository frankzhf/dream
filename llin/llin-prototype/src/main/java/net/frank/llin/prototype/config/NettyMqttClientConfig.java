package net.frank.llin.prototype.config;

import net.frank.llin.mqtt.MqttClientConfig;

import java.io.Serializable;

public class NettyMqttClientConfig implements Serializable {

    private String clientLogicalName;
    private String remoteAddress;
    private int port;
    private String subscribeQueue;
    private String handlerClass;
    private MqttClientConfig config;

    public String getClientLogicalName() {
        return clientLogicalName;
    }
    public void setClientLogicalName(String clientLogicalName) {
        this.clientLogicalName = clientLogicalName;
    }

    public String getRemoteAddress() {
        return remoteAddress;
    }
    public void setRemoteAddress(String remoteAddress) {
        this.remoteAddress = remoteAddress;
    }
    public int getPort() {
        return port;
    }
    public void setPort(int port) {
        this.port = port;
    }
    public String getSubscribeQueue() {
        return subscribeQueue;
    }
    public void setSubscribeQueue(String subscribeQueue) {
        this.subscribeQueue = subscribeQueue;
    }

    public String getHandlerClass() {
        return handlerClass;
    }
    public void setHandlerClass(String handlerClass) {
        this.handlerClass = handlerClass;
    }
    public MqttClientConfig getConfig() {
        return config;
    }
    public void setConfig(MqttClientConfig config) {
        this.config = config;
    }
    @Override
    public String toString() {
        return "NettyMqttClientConfig [clientLogicalName=" + clientLogicalName + ", remoteAddress=" + remoteAddress
                + ", port=" + port + ", subscribeQueue=" + subscribeQueue + ", handlerClass=" + handlerClass
                + ", config=" + config + "]";
    }

}