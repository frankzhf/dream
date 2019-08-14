package net.frank.demos.kafka.ch04;

import net.frank.demos.kafka.ch03.Customer;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.TopicPartition;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SingleConsumerTest {

    //独立消费者
    public static void main(String[] args){
        Properties kafkaProps = new Properties();
        kafkaProps.put("bootstrap.servers","localhost:9092");
        kafkaProps.put("group.id","CountryCounter");
        kafkaProps.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        kafkaProps.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, Customer> consumer =
                new KafkaConsumer<String, Customer>(kafkaProps);

        List<PartitionInfo> partitionInfos = null;
        List<TopicPartition> partitions = new ArrayList<>();

        partitionInfos = consumer.partitionsFor("test2");
        if(partitionInfos!=null){
            for(PartitionInfo partitionInfo : partitionInfos){
                partitions.add(new TopicPartition(partitionInfo.topic()
                        ,partitionInfo.partition()));
            }
            consumer.assign(partitions);

            //后面和之前的代码一样
        }



    }
}
