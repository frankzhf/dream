package net.frank.demos.flink;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.util.ArrayList;
import java.util.List;

public class FilterMain {

    public static void main(String[] args)throws Exception{
        StreamExecutionEnvironment env = StreamExecutionEnvironment.createLocalEnvironment();

        List<Integer> data = new ArrayList<>();
        data.add(1);
        data.add(2);
        data.add(3);
        data.add(4);
        env.fromCollection(data)
            .filter(v->v%2==0)
            .print();

        env.execute("filterDemo");

    }

}
