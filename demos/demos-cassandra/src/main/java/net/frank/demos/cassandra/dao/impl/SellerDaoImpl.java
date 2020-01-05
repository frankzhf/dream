package net.frank.demos.cassandra.dao.impl;

import net.frank.demos.cassandra.dao.SellerDao;
import net.frank.demos.cassandra.model.Seller;
import org.apache.cassandra.thrift.*;
import org.apache.cassandra.thrift.Cassandra.Client;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SellerDaoImpl implements SellerDao {

    Client cassandraClient = null;

    public SellerDaoImpl(String host, int port){
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
            cassandraClient.set_keyspace(Seller.KEY_SPACE);
        }catch (Exception e){
            e.printStackTrace();
            try {
                SchemaIniter.init(cassandraClient);
                cassandraClient.set_keyspace(Seller.KEY_SPACE);
            }catch (Exception ee){
                ee.printStackTrace();
                cassandraClient = null;
            }
        }
    }

    @Override
    public void insertSeller(Seller seller)throws Exception{
        if(cassandraClient == null){
            throw new Exception("Can't connect to Cassandra");
        }
        if(seller == null){
            throw new Exception("Can't insert null seller to Cassandra");
        }
        if(seller.getUserName() == null ||
            seller.getUserName().isEmpty()){
            throw new Exception("Can't insert null sellerUserName to Cassandra");
        }

        Map<ByteBuffer, Map<String, List<Mutation>>> mutationMap = new HashMap<>();
        Map<String,List<Mutation>> cfMutationMap = new HashMap<>();
        List<Mutation> mutationList = new ArrayList<>();

        if(seller.getAge()>0){
            SchemaIniter.processColumn("age",String.valueOf(seller.getAge()),mutationList);
        }

        if(seller.getAddress()!=null &&  !seller.getAddress().isEmpty()){
            SchemaIniter.processColumn("address",seller.getAddress(),mutationList);
        }

        if(seller.getSex()!=null && !seller.getSex().isEmpty()) {
            SchemaIniter.processColumn("sex", seller.getSex(), mutationList);
        }

        if(seller.getName()!=null && !seller.getName().isEmpty()){
            SchemaIniter.processColumn("name",seller.getName(),mutationList);
        }

        if(!mutationList.isEmpty()){
            cfMutationMap.put(Seller.COLUMN_FAMILY,mutationList);
            mutationMap.put(ByteBuffer.wrap(seller.getUserName()
                    .getBytes(StandardCharsets.UTF_8)),cfMutationMap);
            cassandraClient.batch_mutate(mutationMap, ConsistencyLevel.ONE);
        }
    }


    @Override
    public Seller getSeller(String sellerUserName) throws Exception {
        if(cassandraClient == null){
            throw new Exception("Can't connect to Cassandra");
        }
        if(sellerUserName == null || sellerUserName.isEmpty()){
            throw new Exception("Can't get null seller to Cassandra");
        }
        ColumnParent columnParent = new ColumnParent();
        columnParent.setColumn_family(Seller.COLUMN_FAMILY);
        SliceRange range = new SliceRange(ByteBuffer.wrap(new byte[]{}),
                ByteBuffer.wrap(new byte[]{}),true, Integer.MAX_VALUE);
        SlicePredicate slicePredicate = new SlicePredicate();
        slicePredicate.slice_range = range;
        List<ColumnOrSuperColumn> sellerColumns = cassandraClient.get_slice(
                ByteBuffer.wrap(sellerUserName.getBytes(StandardCharsets.UTF_8)),
                columnParent, slicePredicate, ConsistencyLevel.ONE);
        Seller seller = new Seller();
        seller.setUserName(sellerUserName);
        for(ColumnOrSuperColumn cosc: sellerColumns){
            Column c = cosc.column;
            String label = new String(c.getName(),StandardCharsets.UTF_8);
            String value =  new String(c.getValue(),StandardCharsets.UTF_8);
            if("age".equals(label)){
                seller.setAge(Integer.parseInt(value));
            }else if("address".equals(label)){
                seller.setAddress(value);
            }else if("sex".equals(label)){
                seller.setSex(value);
            }else if("name".equals(label)){
                seller.setName(value);
            }
        }
        return seller;
    }
}
