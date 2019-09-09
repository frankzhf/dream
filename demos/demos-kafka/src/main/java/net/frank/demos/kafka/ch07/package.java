package net.frank.demos.kafka.ch07; /***

 实验环境
 curl http://localhost:8083
 {"version":"0.10.1.0","commit":"3402a74efb23d1d4"}

 git clone https://github.com/confluentinc/kafka-connect-elasticsearch
 switch tag v3.2.0
 mvn clean install -Dmaven.test.skip=true

 git clone https://github.com/confluentinc/kafka-connect-jdbc
 switch tag v3.1.0
 mvn clean install -Dmaven.test.skip=true

 copy its target folder below *.jar to libs
 bin/connect-distributed.sh config/connect-distributed.properties &

 查connect可用的插件
 [zhaofeng@kedacom55 ~]$ curl http://localhost:8083/connector-plugins |python -m json.tool
 % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
 Dload  Upload   Total   Spent    Left  Speed
 100   323  100   323    0     0  39714      0 --:--:-- --:--:-- --:--:-- 46142
 [
 {
 "class": "io.confluent.connect.jdbc.JdbcSourceConnector"
 },
 {
 "class": "io.confluent.connect.elasticsearch.ElasticsearchSinkConnector"
 },
 {
 "class": "org.apache.kafka.connect.file.FileStreamSourceConnector"
 },
 {
 "class": "org.apache.kafka.connect.file.FileStreamSinkConnector"
 },
 {
 "class": "io.confluent.connect.jdbc.JdbcSinkConnector"
 }
 ]


 查询Jdbc插件的配制信息

 [zhaofeng@kedacom55 ~]$ curl -X PUT -d "{}" localhost:8083/connector-plugins/JdbcSourceConnector/config/validate --header "content-Type:application/json" | python -m json.tool
 % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
 Dload  Upload   Total   Spent    Left  Speed
 100 12001    0 11999  100     2   436k     74 --:--:-- --:--:-- --:--:--  450k
 {
 "configs": [
 {
 "definition": {
 "default_value": "",
 "dependents": [],
 "display_name": "Timestamp Column Name",
 "documentation": "The name of the timestamp column to use to detect new or modified rows. This column may not be nullable.",
 "group": "Mode",
 "importance": "MEDIUM",
 "name": "timestamp.column.name",
 "order": 3,
 "required": false,
 "type": "STRING",
 "width": "MEDIUM"
 },
 "value": {
 "errors": [
 "Query mode must be specified"
 ],
 "name": "timestamp.column.name",
 "recommended_values": [],
 "value": "",
 "visible": true
 }
 },...
 以下少略
 ],
 "name": "JdbcSourceConnector"
 }

启动jdbc数据库
java -jar $DERBY_HOME/lib/derbyrun.jar server start&
connect 'jdbc:derby://localhost:1527/kafka-demo;create=true';
create table LOGIN(USERNAME varchar(30), LOGIN_TIME timestamp);
插记录
insert into LOGIN values('gwenshap', CURRENT_TIMESTAMP);
....
....

创建和配制jdbc连接器
注意表名字段名区分大小写的
[zhaofeng@kedacom55 ~]$ echo '{"name":"derby-login-connector","config":{"connector.class":"JdbcSourceConnector","connection.url":"jdbc:derby://localhost:1527/kafka-demo","mode":"timestamp","table.whitelist":"LOGIN","validate.non.null":false,"timestamp.column.name":"LOGIN_TIME","topic.prefix":"derby."}}' |curl -X POST -d @- http://localhost:8083/connectors --header "content-Type:application/json"

删除jdbc连接器
[zhaofeng@kedacom55 ~]$ curl -X DELETE http://localhost:8083/connectors/derby-login-connector

jdbc连接器暂停，继续，重启
curl -X PUT http://localhost:8083/connectors/derby-login-connector/pause
curl -X PUT http://localhost:8083/connectors/derby-login-connector/resume
curl -X PUT http://localhost:8083/connectors/derby-login-connector/restart
查看主题
[zhaofeng@kedacom55 ~]$ kafka/opt/kafka_2.11-0.10.1.0/bin/kafka-console-consumer.sh --new --bootstrap-server=localhost:9092 --topic derby.LOGIN --from-beginning
消费者能收到 数据库里的记录的json格式

创建和配制es连接器
注意主题名区分大小写的
[zhaofeng@kedacom55 ~]$ echo '{"name":"elastic-login-connector","config":{"connector.class":"ElasticsearchSinkConnector","connection.url":"http://localhost:9200","type.name":"derby-data","topics":"derby.LOGIN","key.ignore":true}}'| curl -X POST -d @- http://localhost:8083/connectors --header "content-Type:application/json"

暂无解 es的索引名不能大写，要排查derby建表时将表及字段改成小写

 ***/