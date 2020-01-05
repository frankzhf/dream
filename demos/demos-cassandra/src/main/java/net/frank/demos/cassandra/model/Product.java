package net.frank.demos.cassandra.model;

import org.safehaus.uuid.UUID;

public class Product {

    public static final String KEY_SPACE = "CassSeller";
    public static final String COLUMN_FAMILY = "Product";

    private UUID uuid;
    private String name;
    private String sellerUserName;
    private String desc;
    private double price;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSellerUserName() {
        return sellerUserName;
    }

    public void setSellerUserName(String sellerUserName) {
        this.sellerUserName = sellerUserName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
