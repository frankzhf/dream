package net.frank.demos.kafka.ch04;

import net.frank.demos.kafka.ch03.Customer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Collections;
import java.util.Properties;
import java.util.stream.Collectors;

public class CustomerDeserializerConsumerTest {

    public static void main(String[] args){
        Properties kafkaProps = new Properties();
        kafkaProps.put("bootstrap.servers","localhost:9092");
        kafkaProps.put("group.id","CountryCounter");
        kafkaProps.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        kafkaProps.put("value.deserializer","net.frank.demos.kafka.ch04.CustomerDeserializer");

        KafkaConsumer<String, Customer> consumer =
                new KafkaConsumer<String, Customer>(kafkaProps);

        consumer.subscribe(Collections.singletonList("CustomerCountry"));
        while(true){
            ConsumerRecords<String, Customer> records = consumer.poll(100);
            for(ConsumerRecord<String,Customer> record : records){
                System.out.println("current customer Id: " + record.value().getCustomerId()
                        + " and current customer name : " + record.value().getCustomerName());
            }
        }

    }


}
