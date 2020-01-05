package net.frank.demos.cassandra.dao.impl;

import net.frank.demos.cassandra.model.Buyer;
import net.frank.demos.cassandra.model.Comment;
import net.frank.demos.cassandra.model.Product;
import net.frank.demos.cassandra.model.Seller;
import org.apache.cassandra.thrift.*;
import org.apache.cassandra.thrift.Cassandra.Client;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public final class SchemaIniter {

    public static void init(Client cassandraClient)
        throws Exception{
        List<CfDef> cfDefs = new ArrayList<>();
        CfDef buyerCfDef = new CfDef();
        buyerCfDef.keyspace = Buyer.KEY_SPACE;
        buyerCfDef.name = Buyer.COLUMN_FAMILY;
        buyerCfDef.comparator_type="UTF8Type";
        cfDefs.add(buyerCfDef);

        CfDef sellerCfDef = new CfDef();
        sellerCfDef.keyspace = Seller.KEY_SPACE;
        sellerCfDef.name = Seller.COLUMN_FAMILY;
        sellerCfDef.comparator_type="UTF8Type";
        cfDefs.add(sellerCfDef);

        CfDef pcCfDef = new CfDef();
        pcCfDef.keyspace = Product.KEY_SPACE;
        pcCfDef.name = "ProductCategory";
        pcCfDef.comparator_type="TimeUUIDType";
        cfDefs.add(pcCfDef);

        CfDef productCfDef = new CfDef();
        productCfDef.keyspace = Product.KEY_SPACE;
        productCfDef.name = Product.COLUMN_FAMILY;
        productCfDef.comparator_type="UTF8Type";
        cfDefs.add(productCfDef);

        CfDef commentCfDef = new CfDef();
        commentCfDef.keyspace = Comment.KEY_SPACE;
        commentCfDef.name = Comment.COLUMN_FAMILY;
        commentCfDef.column_type="Super";
        commentCfDef.comparator_type="TimeUUIDType";
        commentCfDef.setSubcomparator_type("UTF8Type");
        cfDefs.add(commentCfDef);

        KsDef ksDef = new KsDef();
        ksDef.name = Buyer.KEY_SPACE;
        ksDef.replication_factor = 1;
        ksDef.strategy_class = "org.apache.cassandra.locator.SimpleStrategy";
        ksDef.cf_defs = cfDefs;


        cassandraClient.system_add_keyspace(ksDef);


    }


    public static void processColumn(String label, String value,
                               List<Mutation> mutationList){
        Column c = new Column();
        c.name = ByteBuffer.wrap(label.
                getBytes(StandardCharsets.UTF_8));
        c.value = ByteBuffer.wrap(value
                .getBytes(StandardCharsets.UTF_8));
        c.timestamp = System.currentTimeMillis();
        ColumnOrSuperColumn cosc = new ColumnOrSuperColumn();
        cosc.column = c;
        Mutation mutation = new Mutation();
        mutation.column_or_supercolumn = cosc;
        mutationList.add(mutation);
    }

}
