package net.frank.llin.prototype.config;

import java.io.Serializable;
import java.util.List;

public class NettyClientChannelConfig implements Serializable {

    private String clientLogicalName;
    private String remoteAddress;
    private int port;
    private byte protocol;

    private List<String> handlerClasses;

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

    public byte getProtocol() {
        return protocol;
    }

    public void setProtocol(byte protocol) {
        this.protocol = protocol;
    }

    public List<String> getHandlerClasses() {
        return handlerClasses;
    }

    public void setHandlerClasses(List<String> handlerClasses) {
        this.handlerClasses = handlerClasses;
    }

    @Override
    public String toString() {
        return "NettyClientChannelConfig [clientLogicalName=" + clientLogicalName + ", remoteAddress=" + remoteAddress
                + ", port=" + port + ", protocol=" + protocol + ", handlerClasses=" + handlerClasses + "]";
    }



}