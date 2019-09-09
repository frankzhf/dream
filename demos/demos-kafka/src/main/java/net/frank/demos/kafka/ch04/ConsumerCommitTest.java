package net.frank.demos.kafka.ch04;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;

import java.util.*;

public class ConsumerCommitTest {

    /***
     * 消费者更新分区当前位置的操作叫作提交
     *
     * 1）自动提交
     * --enable.auto.commit
     * 设置这个属性为true
     *
     * --auto.commit.interval.ms
     * 设置提交间隔，默认是５秒
     */

    public static void main(String[] args){
        Properties kafkaProps = new Properties();
        kafkaProps.put("bootstrap.servers","localhost:9092");
        kafkaProps.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        kafkaProps.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");

        kafkaProps.put("group.id","test");

        Consumer<String,String> consumer = new KafkaConsumer<>(kafkaProps);

        List<String> topics = new ArrayList<>();
        topics.add("test2");
        consumer.subscribe(topics);

        try{
            while(true){
                ConsumerRecords<String,String> records = consumer.poll(100);
                for(ConsumerRecord<String,String > record: records){
                    System.out.printf(String.format("topic = %s, partition = %s, offset =%d, key=%s, value= %s\n"
                            ,record.topic(),record.partition(),record.offset(),record.key(),record.value()));
                    //int updatedCount = 1
                    /***
                     *  2)同步提交当前偏移量
                     */
                    try{
                        consumer.commitSync();
                    }catch(CommitFailedException e){
                        System.err.println("commit failed" + e.getMessage());
                    }
                    /***
                     *  3)异步提交
                     */
                    consumer.commitAsync( (offices,e)->{
                        if(e!=null){
                            System.err.printf("Commit failed for offsets %s ");
                        }
                    });
                }
            }
        }finally {
            consumer.close();
        }

        /***
         * 4）同步异步组合提交
         *
         *

        try{
            while(true){
                ConsumerRecords<String,String> records = consumer.poll(100);
                for(ConsumerRecord<String,String> record : records){
                    System.out.printf("topic = %s, partition = %s, offset = %d, customer = %s,country= %s \n"
                        ,record.topic(),record.partition(),record.offset(),record.key(),record.value());
                }
                consumer.commitAsync();
            }
        }catch(Exception e){
            System.err.println("Unexpected error " + e);
        }finally{
            try{
                consumer.commitSync();
            }finally {
                consumer.close();
            }
        }
         ***/

        /***
         * 5)提交特定的偏移量
         *

        Map<TopicPartition, OffsetAndMetadata> currentOffsets = new HashMap<>();
        int count = 0;
        while(true){
            ConsumerRecords<String,String> records = consumer.poll(100);
            for(ConsumerRecord<String,String> record : records){
                System.out.printf("topic = %s, partition = %s, offset = %d, customer = %s, country = %s\n",
                        record.topic(), record.partition(),record.offset(),record.key(),record.value());
                currentOffsets.put(new TopicPartition(record.topic(), record.partition()),
                        new OffsetAndMetadata(record.offset() +1, "no metadata"));
                if(count %1000 == 0){
                    consumer.commitAsync(currentOffsets,(offices,e)->{
                        if(e!=null){
                            System.err.println(e.getMessage() + e);
                        }
                    });
                }

            }
        }
         **/
    }

}
