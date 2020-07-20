package net.frank.demos.flink;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

public class FlatMapMain {

    public static void main(String[] args)throws Exception{
        StreamExecutionEnvironment env = StreamExecutionEnvironment.createLocalEnvironment();
        env.fromElements("123 sffs ffe")
                .flatMap(new FlatMapFunction<String, String>() {
                    @Override
                    public void flatMap(String value, Collector<String> out) throws Exception {
                        String [] values = value.split(" ");
                        for(String insert : values){
                            out.collect(insert);
                        }
                    }
                })
                .print();
        env.execute("FlatMapDemo");

    }
}


