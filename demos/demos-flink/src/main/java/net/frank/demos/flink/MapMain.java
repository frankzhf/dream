package net.frank.demos.flink;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.io.Serializable;

public class MapMain {


    public static void main(String[] args)throws Exception{
        StreamExecutionEnvironment env = StreamExecutionEnvironment.createLocalEnvironment();
        env.fromElements(new MapItem("1",5),
                new MapItem("2",6),
                new MapItem("3",9))
        .map(item->{
            item.setValue(item.getValue() +1);
            return item;
        }).print();
        env.execute("MapDemo");
    }
}

class MapItem implements Serializable {

    private String key;

    private Integer value;

    public MapItem(String key, Integer value){
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString(){
        return key + " = " + value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}