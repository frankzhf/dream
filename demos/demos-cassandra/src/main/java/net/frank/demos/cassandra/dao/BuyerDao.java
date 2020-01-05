package net.frank.demos.cassandra.dao;

import net.frank.demos.cassandra.model.Buyer;

public interface BuyerDao{

    void insertBuyer(Buyer buyer)throws Exception;

    Buyer getBuyer(String buyerUserName)throws Exception;
}
