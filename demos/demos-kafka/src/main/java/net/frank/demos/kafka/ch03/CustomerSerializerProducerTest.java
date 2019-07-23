package net.frank.demos.kafka.ch03;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;

public class CustomerSerializerProducerTest {


    public static void main(String[] args){
        Properties kafkaProps = new Properties();
        kafkaProps.put("bootstrap.servers","localhost:9092");
        kafkaProps.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        kafkaProps.put("value.serializer","net.frank.demos.kafka.ch03.CustomerSerializer");

        Producer<String,Customer> producer = new KafkaProducer<>(kafkaProps);

        Customer customer = new Customer(1000,"1000's customer name");
        //customer.setCustomerId(1000);
        //customer.setCustomerName("1000's customer name");
        ProducerRecord<String,Customer> record
                = new ProducerRecord<>("CustomerCountry","Preision Products",customer);
        producer.send(record, (RecordMetadata metadata, Exception exception)-> {
            if(exception!=null){
                exception.printStackTrace();
            }
        });
        producer.flush();
    }

}
