package net.frank.demos.kafka.ch03;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;

public class ProducerTest {

    public static void main(String[] args){
        Properties kafkaProps = new Properties();
        kafkaProps.put("bootstrap.servers","localhost:9092");
        kafkaProps.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        kafkaProps.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");

        Producer<String,String> producer = new KafkaProducer<>(kafkaProps);

        ProducerRecord<String,String> record
                = new ProducerRecord<>("CustomerCountry","Preision Products","France");

        try{
            //发送消息
            /***
            producer.send(record );
            ***/
            //同步发送消息
            /***
            producer.send(record).get();
             ***/

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

    /****
     * 生产者配制
     *
     * acks
     *      为０时，没有服务通知，吞吐量最大
     *      为１时，只要集群首领节点收到，就通知生产者，消息已经发送成功
     *      acks=all，全部节点都收到，才通知
     *
     *
     * buffer.memory
     * 生产者内存缓冲大小，如果应用发送消息的速度超过发送到服务器的速度，会异致生产者空间不足。send（）方法调用要么被阻塞，要么抛出异常
     *
     *
     * compression.type
     * 压缩类型，snappy,gzip,lz4
     *
     * retries
     * 当消息发磅不成功时，重发次数
     *
     * batch.size
     * 批次大小，这个是字节数
     *
     * linger.ms
     * 生产者在发送批次之前等待更多消息加入批次的时间
     *
     * client.id
     * 可以是任意字符串，服务器会用它来识别消息来源
     *
     * max.in.flight.requests.per.connection
     * 生产者在收到服务器响应之前可以发送多少个消息。
     *
     * timeout.ms
     *     broker等待同步副本返回消息的确认时间
     * request.timeout.ms
     *      生产者在发送数据时等待服务器返回的响应时间
     * metadata.fetch.timeout.ms
     *      生产者在获取元数据时等待服务器返回响应的时间
     *
     * max.block.ms
     * 当生产者调用send()方法或使用partitionsFor()方法获取元数据时生产者的阻塞时间
     *
     * max.request.size
     * 生产者发送请求的大小。
     *
     *
     * receive.buffer.bytes
     * send.buffer.bytes
     * TCP socket接受和发送数据包的缓冲大小。如果它们被设成-1，就使用操作系统的默认值
     *
     *
     */

}
