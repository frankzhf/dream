package net.frank.llin.prototype.config;

public final class ConfigHolder {
    static NettyConfig holder = null;

    public static NettyConfig getConfig() {
        return holder;
    }
}