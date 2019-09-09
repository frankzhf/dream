package net.frank.demos.kafka.ch04;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConsumerTest {
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
                }
            }
        }finally {
            consumer.close();
        }
    }

    /***
     * 消费者配制
     *
     *
     * --fetch.min.bytes
     * 指定消费者从服务器获取最小字节数
     *
     * --fetch.max.wait.ms
     * 访问broker后等待broker响应的时间
     *
     * --max.partition.fetch.bytes
     * 从每个分区里返回给消费者的最大字节数
     *
     * --session.timeout.ms
     * 会话超时毫秒，默认是3s
     *
     * --auto.offset.reset
     * 重置偏移量。可选latest | earliest 最迟 最早
     *
     * -enable.auto.commit
     * 是否允许自动提交
     *
     * --partition.assignment.strategy
     * 分区被分配的策略 Range| RoundRobin,自定义策略请实现AbstractPartitionAssignor
     *
     * --client.id
     * 客户端标识
     *
     * --max.poll.records
     * 单次消费请求可以返回的最大记录数量
     *
     * --receive.buffer.bytes
     * --send.buffer.bytes
     * Socket在读写数据时用的TCP缓存区大小
     *
     */

}
