/***
1安装Zookeeper 3.4.6

tar -zxf zookeeper-3.4.6.tar.gz
mv zookeeper-3.4.6 /usr/local/zookeeper
maker -p /var/lib/zookeeper
cat > /usr/local/zookeeper/conf/zoo.cfg << EOF
tickTime=2000
dataDir=/var/lib/zookeeper
clientPort=2181
EOF

/usr/local/zookeeper/bin/zkServer.sh start

 windows下启动
zkServer.cmd


2安装Kafka Broker

tar -zxf kafka_2.11-0.9.0.1.tgz
mv kafka_2.11-0.9.0.1 /usr/local/kafka
mkdir /tmp/kafka-logs

/usr/local/kafka/bin/kafka-server-start.sh -daemon /usr/local/kafka/config/server.properties

 windows下启动
 windows\kafka-server-start.bat ../config/server.properties


 Kafka Broker 常规配置
 --broker.id
 broker标识符

 --port
 监听端口

 --zookeeper.connect
 定义一个hostname:port/path指定kafka集群的chroot

 --log.dirs
 kafka数据目录

 --num.recovery.threads.per.data.dir
 每个kafka数据目录的处理线程数

 --auto.create.topics.enabled
 允许自动创建主题

 主题默认配置
 --num.partitions
 新创建的主题包含多少个分区，一个分区的吞吐量不需要超过５０Ｍ/每秒

 --log.retention.ms
 数据可以保存多久，默认一周168小时

 --log.retention.bytes
 数据覆盖的字节数，默认1G

 --log.segment.bytes
 日志片段字节数上限

 --log.segment.ms
 日志片段时间上限

 --message.max.bytes
 消息最大字节数，默认1M

 常规命令

 创建主题
 kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 -- partitions 1 --topic test

 查看主题详情
 kafka-topics.sh --describe --zookeeper localhost:2181 --topic test

 生产者
 kafka-console-producer.sh --broker-list localhost:9092 --topic test


 消费者
 kafka-console-consumer.sh --zookeeper localhost:2181 --topic test --from-beginning

 ***/