package net.frank.llin.prototype.config;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class NettyConfig<T> implements Serializable{

    private String gatewayId;

    private List<NettyClientChannelConfig> clientConfigs;

    private List<NettyServerChannelConfig> serverConfigs;

    private List<NettyMqttClientConfig> mqttConfigs;

    private Map<String,String> param;//mqtt队列参数

    private T model;

    private List<DeviceRuntime> runtimes;

    public String getGatewayId() {
        return gatewayId;
    }

    public void setGatewayId(String gatewayId) {
        this.gatewayId = gatewayId;
    }

    public List<NettyClientChannelConfig> getClientConfigs() {
        return clientConfigs;
    }

    public void setClientConfigs(List<NettyClientChannelConfig> clientConfigs) {
        this.clientConfigs = clientConfigs;
    }

    public List<NettyServerChannelConfig> getServerConfigs() {
        return serverConfigs;
    }

    public void setServerConfigs(List<NettyServerChannelConfig> serverConfigs) {
        this.serverConfigs = serverConfigs;
    }

    public List<NettyMqttClientConfig> getMqttConfigs() {
        return mqttConfigs;
    }

    public void setMqttConfigs(List<NettyMqttClientConfig> mqttConfigs) {
        this.mqttConfigs = mqttConfigs;
    }

    public Map<String,String> getParam() {
        return param;
    }

    public void setParam(Map<String,String> param) {
        this.param = param;
    }

    public T getModel(){
        return model;
    }

    public void setModel(T t){
        this.model = t;
    }

    public List<DeviceRuntime> getRuntimes() {
        return runtimes;
    }

    public void setRuntimes(List<DeviceRuntime> runtimes) {
        this.runtimes = runtimes;
    }
    @Override
    public String toString() {
        return "NettyConfig{" +
                "gatewayId='" + gatewayId + '\'' +
                ", clientConfigs=" + clientConfigs +
                ", serverConfigs=" + serverConfigs +
                ", mqttConfigs=" + mqttConfigs +
                ", param=" + param +
                ", model=" + model +
                ", runtimes=" + runtimes +
                '}';
    }
}