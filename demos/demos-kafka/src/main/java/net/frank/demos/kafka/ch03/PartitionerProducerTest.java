package net.frank.demos.kafka.ch03;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;

public class PartitionerProducerTest {

    public static void main(String[] args){
        Properties kafkaProps = new Properties();
        kafkaProps.put("bootstrap.servers","localhost:9092");
        kafkaProps.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        kafkaProps.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
        kafkaProps.put("partitioner.class", "net.frank.demos.kafka.ch03.BananaPartitioner");

        Producer<String,String> producer = new KafkaProducer<>(kafkaProps);

        ProducerRecord<String,String> record
                = new ProducerRecord<>("CustomerCountry","Preision Products","France");
        try{
            //异步
            producer.send(record, (RecordMetadata metadata, Exception exception)-> {
                if(exception!=null){
                    exception.printStackTrace();
                }
            });
            //生产者要flush才会真正发送
            producer.flush();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
