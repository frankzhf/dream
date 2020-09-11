package net.frank.demos.flink;

import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class MinMain {


    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.createLocalEnvironment();
        env.fromElements(new Tuple2<>(1,5),
                new Tuple2<>(2,3),
                new Tuple2<>(4,5),
                new Tuple2<>(4,6))
            .keyBy(0)
            .min(1)
            .print();

        env.execute("minTest");
    }
}
