package net.frank.demos.kafka.ch04;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.errors.WakeupException;

import java.util.*;

public class TestConsumerRebalance {

    public static void main(String[] args){
        Properties kafkaProps = new Properties();
        kafkaProps.put("bootstrap.servers","localhost:9092");
        kafkaProps.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        kafkaProps.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");

        kafkaProps.put("group.id","test");

        Consumer<String,String> consumer = new KafkaConsumer<>(kafkaProps);

        List<String> topics = new ArrayList<>();
        topics.add("test2");

        Map<TopicPartition, OffsetAndMetadata> currentOffsets
                = new HashMap<>();


        //
        try {
            consumer.subscribe(topics, new ConsumerRebalanceListener() {
                //获得新分区开始读取消息，
                public void onPartitionsAssigned(Collection<TopicPartition> partitions) {

                }

                //如果发生再均衡
                public void onPartitionsRevoked(Collection<TopicPartition> partitions) {
                    System.out.println("Lost partitions in rebalance. Committing current offsets:"
                            + currentOffsets);
                    consumer.commitSync(currentOffsets);
                }
            });
            /***
                consumer.seek簇方法用于跳过一定的消息
             ***/
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(100);
                for (ConsumerRecord<String, String> record : records) {
                    System.out.printf("topic = %s, partition = %s, offset = %d, customer = %s, country = %s\n",
                            record.topic(), record.partition(), record.offset(), record.key(), record.value());
                    currentOffsets.put(new TopicPartition(record.topic(), record.partition()),
                            new OffsetAndMetadata(record.offset() + 1, null));
                }
                consumer.commitAsync(currentOffsets, null);
            }
        }catch(WakeupException e){

        }catch(Exception e){

        }finally {
            try{
                consumer.commitSync(currentOffsets);
            }finally {
                consumer.close();
                System.out.println("Closed consumer and we are done.");
            }
        }
    }

    /****
     * 结束
     * 另一个线程里调用consumer.wakeup()
     * 如果循环在主程序里
     *
     Runtime.getRuntime().addShutdownHook(new Thread(){
        public void run(){
            System.out.println("Starting exit ...");
            consumer.wakeup();
            try{
                mainThread.join();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
     }
     *
     *
     * 另外，在退出线程时一定要consumer.close();
     * 向群组协调器发送消息，告之自己要离开群组
     *
     */


}
