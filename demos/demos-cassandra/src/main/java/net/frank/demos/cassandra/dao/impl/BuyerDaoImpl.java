package net.frank.demos.cassandra.dao.impl;

import net.frank.demos.cassandra.dao.BuyerDao;
import net.frank.demos.cassandra.model.Buyer;
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

public class BuyerDaoImpl implements BuyerDao {

    Client cassandraClient = null;

    public BuyerDaoImpl(String host, int port){
        TSocket socket = new TSocket(host,port);
        TTransport transport = new TFramedTransport(socket);
        TBinaryProtocol binaryProtocol = new TBinaryProtocol(
                transport,true,true);
        cassandraClient = new Client(binaryProtocol);
        try{
            transport.open();
        }catch (Exception e){
            e.printStackTrace();
            cassandraClient = null;
            return;
        }
        try{
            cassandraClient.set_keyspace(Buyer.KEY_SPACE);
        }catch (Exception e){
            e.printStackTrace();
            try{
                SchemaIniter.init(cassandraClient);
                cassandraClient.set_keyspace(Buyer.KEY_SPACE);
            }catch (Exception ee){
                ee.printStackTrace();
                cassandraClient = null;
            }
        }
    }


    @Override
    public void insertBuyer(Buyer buyer) throws Exception{
        if(cassandraClient == null){
            throw new Exception("Can't connect to Cassandra.");
        }
        if(buyer == null){
            throw new Exception("Can't insert null buyer to Cassandra");
        }
        if(buyer.getUserName() == null || buyer.getUserName().isEmpty()){
            throw new Exception("Can't insert null buyerUserName to Cassandra");
        }

        Map<ByteBuffer,Map<String, List<Mutation>>> mutationMap = new HashMap<>();
        Map<String,List<Mutation>> cfMutationMap = new HashMap<>();
        List<Mutation> mutationList = new ArrayList<>();

        if(buyer.getAge() > 0){
            SchemaIniter.processColumn("age",String.valueOf(buyer.getAge()),mutationList);
        }

        if(buyer.getAddress()!=null && !buyer.getAddress().isEmpty()){
            SchemaIniter.processColumn("address",buyer.getAddress(),mutationList);
        }

        if(buyer.getSex()!=null && !buyer.getSex().isEmpty()){
            SchemaIniter.processColumn("sex",buyer.getSex(),mutationList);
        }

        if(buyer.getName()!=null && !buyer.getName().isEmpty()){
            SchemaIniter.processColumn("name",buyer.getName(),mutationList);
        }

        if(!mutationList.isEmpty()){
            cfMutationMap.put(Buyer.COLUMN_FAMILY, mutationList);
            mutationMap.put(ByteBuffer.wrap(buyer.getUserName()
                    .getBytes(StandardCharsets.UTF_8)),cfMutationMap);
            cassandraClient.batch_mutate(mutationMap, ConsistencyLevel.ONE);
        }
    }

    @Override
    public Buyer getBuyer(String buyerUserName) throws Exception{
        if(cassandraClient == null){
            throw new Exception("Can't connect to Cassandra");
        }
        if(buyerUserName == null || buyerUserName.isEmpty()){
            throw new Exception("Can't get null buyer to Cassandra");
        }
        ColumnParent columnParent = new ColumnParent();
        columnParent.column_family = Buyer.COLUMN_FAMILY;
        SliceRange range = new SliceRange(ByteBuffer.wrap(new byte[]{}),
                ByteBuffer.wrap(new byte[]{}), true ,Integer.MAX_VALUE);
        SlicePredicate slicePredicate = new SlicePredicate();
        slicePredicate.slice_range=range;
        List<ColumnOrSuperColumn> buyerColumns = cassandraClient.get_slice(ByteBuffer.wrap(
                buyerUserName.getBytes(StandardCharsets.UTF_8)),columnParent,
                slicePredicate,ConsistencyLevel.ONE);

        Buyer buyer = new Buyer();
        buyer.setUserName(buyerUserName);
        for(ColumnOrSuperColumn cosc : buyerColumns){
            Column c = cosc.column;
            String label = new String(c.getName(),StandardCharsets.UTF_8);
            String value = new String(c.getValue(),StandardCharsets.UTF_8);
            if("age".equals(label)){
                buyer.setAge(Integer.parseInt(value));
            }else if("address".equals(label)){
                buyer.setAddress(value);
            }else if("sex".equals(label)){
                buyer.setSex(value);
            }else if("name".equals(label)){
                buyer.setName(value);
            }
        }
        return buyer;
    }
}
