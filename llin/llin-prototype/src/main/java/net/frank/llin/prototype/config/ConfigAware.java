package net.frank.llin.prototype.config;

public final class ConfigAware {
    public static void setConfig(NettyConfig config) {
        ConfigHolder.holder = config;
    }

}
