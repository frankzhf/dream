package net.frank.demos.kafka.ch03;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.record.InvalidRecordException;
import org.apache.kafka.common.utils.Utils;

import java.util.List;
import java.util.Map;

public class BananaPartitioner implements Partitioner {

    public void configure(Map<String, ?> configs){

    }

    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster){
        List<PartitionInfo> partitions = cluster.partitionsForTopic(topic);
        int numPartitions = partitions.size();
        if(keyBytes == null || (!(key instanceof  String))){
            throw new InvalidRecordException("We expect all messages to have customer name as key");
        }
        if(((String)key).equals("Banana")){
            return numPartitions;
        }

        if(numPartitions>1) {
            return (Math.abs(Utils.murmur2(keyBytes)) % (numPartitions - 1));
        }else{
            return 0;
        }
    }

    public void close(){

    }

}
