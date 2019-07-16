package net.frank.llin.prototype.config;

import java.io.Serializable;
import java.util.List;

public class NettyServerChannelConfig implements Serializable {

    private static final long serialVersionUID = -5697967070833362300L;

    private String remoteAddress;

    private int port;

    private byte protocol;

    private List<String> handlerClasses;

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

}