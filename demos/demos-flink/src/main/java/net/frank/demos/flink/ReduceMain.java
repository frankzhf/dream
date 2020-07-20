package net.frank.demos.flink;

import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class ReduceMain{

    public static void main(String[] args)throws Exception{
        StreamExecutionEnvironment env = StreamExecutionEnvironment.createLocalEnvironment();

        env.fromElements(new Tuple2(1,5),new Tuple2(2,3),new Tuple2(4,5),new Tuple2(4,6))
                .keyBy(0)
                .reduce((t1,t2)-> new Tuple2(t1.f0,(int)t1.f1 + (int)t2.f1))
                .print();
        env.execute("reduceDemo");
    }

}
