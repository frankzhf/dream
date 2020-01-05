package net.frank.demos.cassandra.dao.impl;

import net.frank.demos.cassandra.dao.ProductDao;
import net.frank.demos.cassandra.model.Comment;
import net.frank.demos.cassandra.model.Product;
import org.apache.cassandra.thrift.*;
import org.apache.cassandra.thrift.Cassandra.Client;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.safehaus.uuid.UUID;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDaoImpl implements ProductDao {

    Client cassandraClient = null;

    public ProductDaoImpl(String host, int port){
        TSocket socket = new TSocket(host,port);
        TTransport transport = new TFramedTransport(socket);
        TBinaryProtocol binaryProtocol = new TBinaryProtocol(transport,true,true);
        cassandraClient = new Client(binaryProtocol);
        try{
            transport.open();
        }catch (Exception e){
            e.printStackTrace();
            cassandraClient = null;
            return;
        }
        try{
            cassandraClient.set_keyspace(Product.KEY_SPACE);
        }catch (Exception e){
            e.printStackTrace();
            try{
                SchemaIniter.init(cassandraClient);
                cassandraClient.set_keyspace(Product.KEY_SPACE);
            }catch (Exception ee){
                ee.printStackTrace();
                cassandraClient = null;
            }
        }

    }

    @Override
    public void insertProduct(Product product) throws Exception {
        if(cassandraClient == null){
            throw new Exception("Can't connect to Cassandra");
        }
        if(product == null){
            throw new Exception("Can't insert null product to Cassandra");
        }
        if(product.getUuid() == null || product.getUuid().isNullUUID()){
            throw new Exception("Can't insert null product to Cassandra");
        }
        Map<ByteBuffer, Map<String, List<Mutation>>> mutationMap = new HashMap<>();
        Map<String,List<Mutation>> cfMutationMap = new HashMap<>();
        List<Mutation> mutationList = new ArrayList<>();

        if(product.getPrice() >0) {
            SchemaIniter.processColumn("price",String.valueOf(product.getPrice()),mutationList);
        }

        if(product.getDesc()!=null && !product.getDesc().isEmpty()){
            SchemaIniter.processColumn("desc",product.getDesc(),mutationList);
        }
        if(product.getName()!=null && !product.getName().isEmpty()){
            SchemaIniter.processColumn("name",product.getName(),mutationList);
        }
        if(product.getSellerUserName()!=null && !product.getSellerUserName().isEmpty()){
            SchemaIniter.processColumn("sellerUserName",product.getSellerUserName(),mutationList);
        }
        if(!mutationList.isEmpty()){
            cfMutationMap.put(Product.COLUMN_FAMILY,mutationList);
            mutationMap.put(ByteBuffer.wrap(product.getUuid().asByteArray()),cfMutationMap);
            cassandraClient.batch_mutate(mutationMap, ConsistencyLevel.ONE);
        }
    }

    @Override
    public void insertProductCategory(String category, UUID productUUID) throws Exception{
        if(cassandraClient == null){
            throw new Exception("Can't connect to Cassandra");
        }
        if(productUUID == null){
            throw new Exception("Can't insert null productUUID to Cassandra");
        }
        if(category == null || category.isEmpty()){
            throw new Exception("Can't insert null category to Cassandra");
        }

        ColumnParent columnParent = new ColumnParent();
        columnParent.column_family = "ProductCategory";

        Column column = new Column();
        column.name = ByteBuffer.wrap(productUUID.toByteArray());
        column.value = ByteBuffer.wrap(new byte[]{});
        column.timestamp = System.currentTimeMillis();

        cassandraClient.insert(ByteBuffer.wrap(category.getBytes(StandardCharsets.UTF_8)),
                columnParent, column,ConsistencyLevel.ONE);
    }

    @Override
    public void insertComment(UUID productUUID, Comment comment) throws Exception {
        if(cassandraClient == null){
            throw new Exception("Can't connect to Cassandra");
        }
        if(productUUID == null){
            throw new Exception("Can't insert null productUUID to Cassandra");
        }
        if(comment == null){
            throw new Exception("Can't insert null comment to Cassandra");
        }

        Map<ByteBuffer, Map<String, List<Mutation>>> mutationMap = new HashMap<>();
        Map<String,List<Mutation>> cfMutationMap = new HashMap<>();
        List<Mutation> mutationList = new ArrayList<>();
        List<Column> columns = new ArrayList<>();
        if(comment.getCommentUserName()!=null && !comment.getCommentUserName().isEmpty()){
            Column c = new Column();
            c.name = ByteBuffer.wrap("commentUserName".getBytes(StandardCharsets.UTF_8));
            c.value = ByteBuffer.wrap(comment.getCommentUserName().getBytes(StandardCharsets.UTF_8));
            c.timestamp = System.currentTimeMillis();
            columns.add(c);
        }

        if(comment.getContent()!=null && !comment.getContent().isEmpty()){
            Column c = new Column();
            c.name = ByteBuffer.wrap("content".getBytes(StandardCharsets.UTF_8));
            c.value = ByteBuffer.wrap(comment.getContent().getBytes(StandardCharsets.UTF_8));
            c.timestamp = System.currentTimeMillis();
            columns.add(c);
        }
        if(!columns.isEmpty()){
            SuperColumn sc = new SuperColumn();
            sc.name = ByteBuffer.wrap(comment.getUuid().toByteArray());
            sc.columns = columns;

            ColumnOrSuperColumn cosc = new ColumnOrSuperColumn();
            cosc.super_column = sc;
            Mutation mutation = new Mutation();
            mutation.column_or_supercolumn = cosc;
            mutationList.add(mutation);
            cfMutationMap.put(Comment.COLUMN_FAMILY,mutationList);
            mutationMap.put(ByteBuffer.wrap(productUUID.asByteArray()),cfMutationMap);
            cassandraClient.batch_mutate(mutationMap, ConsistencyLevel.ONE);
        }
    }

    @Override
    public Product getProduct(UUID productUUID) throws Exception {
        if(cassandraClient == null){
            throw new Exception("Can't connect to Cassandra");
        }
        if(productUUID == null){
            throw new Exception("Can't insert null productUUID to Cassandra");
        }
        ColumnParent columnParent = new ColumnParent();
        columnParent.setColumn_family(Product.COLUMN_FAMILY);
        SliceRange range = new SliceRange(ByteBuffer.wrap(new byte[]{}),
                ByteBuffer.wrap(new byte[]{}),true, Integer.MAX_VALUE);
        SlicePredicate slicePredicate = new SlicePredicate();
        slicePredicate.slice_range = range;
        List<ColumnOrSuperColumn> productColumns = cassandraClient.get_slice(
                ByteBuffer.wrap(productUUID.asByteArray()), columnParent, slicePredicate, ConsistencyLevel.ONE);

        Product product = new Product();
        product.setUuid(productUUID);

        for(ColumnOrSuperColumn cosc : productColumns){
            Column c = cosc.column;
            String label = new String(c.getName(),StandardCharsets.UTF_8);
            String value = new String(c.getValue(),StandardCharsets.UTF_8);
            if("sellerUserName".equals(label)){
                product.setSellerUserName(value);
            }else if("desc".equals(label)){
                product.setDesc(value);
            }else if("name".equals(label)){
                product.setName(value);
            }else if("price".equals(label)){
                product.setPrice(Double.parseDouble(value));
            }
        }
        return product;
    }

    @Override
    public List<Product> getTopCategoryProducts(String category, int topNum) throws Exception {
        if(cassandraClient == null){
            throw new Exception("Can't connect to Cassandra");
        }
        if(category == null || category.isEmpty()){
            throw new Exception("Can't get null category to Cassandra");
        }
        if(topNum < 1){
            throw new Exception("topNum must larger than 1");
        }

        ColumnParent columnParent = new ColumnParent();
        columnParent.column_family = "ProductCategory";
        SliceRange range = new SliceRange(ByteBuffer.wrap(new byte[]{}),
                ByteBuffer.wrap(new byte[]{}),true,topNum);
        SlicePredicate slicePredicate = new SlicePredicate();
        slicePredicate.slice_range = range;

        List<ColumnOrSuperColumn> productColumns = cassandraClient.get_slice(
                ByteBuffer.wrap(category.getBytes(StandardCharsets.UTF_8)),
                columnParent,slicePredicate,ConsistencyLevel.ONE);
        List<Product> products = new ArrayList<>();
        for(ColumnOrSuperColumn cosc : productColumns){
            Column c = cosc.column;
            UUID productUUID = new UUID(c.getName());
            products.add(getProduct(productUUID));
        }

        return products;
    }

    @Override
    public List<Comment> getTopProductComments(UUID productUUID, int topNum)throws Exception{
        if(cassandraClient == null){
            throw new Exception("Can't connect to Cassandra");
        }
        if(productUUID == null || productUUID.isNullUUID()){
            throw new Exception("Can't get null productUUID to Cassandra");
        }
        if(topNum < 1){
            throw new Exception("topNum must larger than 1");
        }

        ColumnParent columnParent = new ColumnParent();
        columnParent.column_family = Comment.COLUMN_FAMILY;
        SliceRange range = new SliceRange(ByteBuffer.wrap(new byte[]{}),ByteBuffer.wrap(new byte[]{}),true,topNum);
        SlicePredicate slicePredicate = new SlicePredicate();
        slicePredicate.slice_range = range;

        List<ColumnOrSuperColumn> commentColumns = cassandraClient.get_slice(ByteBuffer.wrap(productUUID.asByteArray()),
                columnParent,slicePredicate,ConsistencyLevel.ONE);
        List<Comment> comments = new ArrayList<>();
        for(ColumnOrSuperColumn cosc : commentColumns){
            SuperColumn sc = cosc.super_column;
            Comment comment = new Comment();
            comment.setUuid(new UUID(sc.getName()));
            for(Column c : sc.columns){
                String label = new String(c.getName(),StandardCharsets.UTF_8);
                String value = new String(c.getValue(),StandardCharsets.UTF_8);
                if("commentUserName".equals(label)){
                    comment.setCommentUserName(value);
                }else if("content".equals(label)){
                    comment.setContent(value);
                }
            }
            comments.add(comment);
        }
        return comments;
    }
}
