package net.frank.demos.cassandra.dao;

import net.frank.demos.cassandra.model.Seller;

public interface SellerDao {

    void insertSeller(Seller seller) throws Exception;

    Seller getSeller(String sellerUserName) throws Exception;

}
