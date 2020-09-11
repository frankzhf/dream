package net.frank.demos.flink;

import org.apache.flink.api.common.functions.AggregateFunction;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.JavaType;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.windowing.ProcessWindowFunction;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class DemoMain {
    static ObjectMapper objectMapper = new ObjectMapper();

    static Time WINDOWS = Time.of(15, TimeUnit.SECONDS);

    public static void main(String[] args)throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.createLocalEnvironment();
        String dataJson = "[{\"logDate\":\"21/07/2020 15:21:34.189\",\"msgId\":61226969297323012,\"delay\":164},\n" +
                "  {\"logDate\":\"21/07/2020 15:21:34.191\",\"msgId\":61226969297847296,\"delay\":1002},\n" +
                "  {\"logDate\":\"21/07/2020 15:21:34.189\",\"msgId\":61226969297323013,\"delay\":1937},\n" +
                "  {\"logDate\":\"21/07/2020 15:21:34.189\",\"msgId\":61226969297323010,\"delay\":637},\n" +
                "  {\"logDate\":\"21/07/2020 15:21:34.192\",\"msgId\":61226969298109440,\"delay\":1136},\n" +
                "  {\"logDate\":\"21/07/2020 15:21:34.190\",\"msgId\":61226969297585152,\"delay\":1199},\n" +
                "  {\"logDate\":\"21/07/2020 15:21:34.189\",\"msgId\":61226969297323008,\"delay\":863},\n" +
                "  {\"logDate\":\"21/07/2020 15:21:34.193\",\"msgId\":61226969298371585,\"delay\":1053},\n" +
                "  {\"logDate\":\"21/07/2020 15:21:34.188\",\"msgId\":61226969297060868,\"delay\":1629},\n" +
                "  {\"logDate\":\"21/07/2020 15:21:34.193\",\"msgId\":61226969298371584,\"delay\":860},\n" +
                "  {\"logDate\":\"21/07/2020 15:21:34.188\",\"msgId\":61226969297060866,\"delay\":49},\n" +
                "  {\"logDate\":\"21/07/2020 15:21:34.188\",\"msgId\":61226969297060867,\"delay\":1545},\n" +
                "  {\"logDate\":\"21/07/2020 15:21:34.188\",\"msgId\":61226969297060865,\"delay\":996},\n" +
                "  {\"logDate\":\"21/07/2020 15:21:34.194\",\"msgId\":61226969298633728,\"delay\":122},\n" +
                "  {\"logDate\":\"21/07/2020 15:21:34.190\",\"msgId\":61226969297585153,\"delay\":1832},\n" +
                "  {\"logDate\":\"21/07/2020 15:21:34.189\",\"msgId\":61226969297323009,\"delay\":916},\n" +
                "  {\"logDate\":\"21/07/2020 15:21:34.187\",\"msgId\":61226969296798723,\"delay\":1937},\n" +
                "  {\"logDate\":\"21/07/2020 15:21:34.186\",\"msgId\":61226969296536577,\"delay\":151},\n" +
                "  {\"logDate\":\"21/07/2020 15:21:34.187\",\"msgId\":61226969296798720,\"delay\":788},\n" +
                "  {\"logDate\":\"21/07/2020 15:21:34.180\",\"msgId\":61226969294963712,\"delay\":245},\n" +
                "  {\"logDate\":\"21/07/2020 15:21:34.183\",\"msgId\":61226969295750144,\"delay\":1327},\n" +
                "  {\"logDate\":\"21/07/2020 15:21:34.187\",\"msgId\":61226969296798721,\"delay\":1279},\n" +
                "  {\"logDate\":\"21/07/2020 15:21:34.184\",\"msgId\":61226969296012288,\"delay\":1923},\n" +
                "  {\"logDate\":\"21/07/2020 15:21:34.187\",\"msgId\":61226969296798722,\"delay\":509},\n" +
                "  {\"logDate\":\"21/07/2020 15:21:34.188\",\"msgId\":61226969297060864,\"delay\":426},\n" +
                "  {\"logDate\":\"21/07/2020 15:21:34.178\",\"msgId\":61226969294439427,\"delay\":549},\n" +
                "  {\"logDate\":\"21/07/2020 15:21:34.179\",\"msgId\":61226969294701568,\"delay\":999},\n" +
                "  {\"logDate\":\"21/07/2020 15:21:34.178\",\"msgId\":61226969294439426,\"delay\":1849},\n" +
                "  {\"logDate\":\"21/07/2020 15:21:34.178\",\"msgId\":61226969294439424,\"delay\":1857},\n" +
                "  {\"logDate\":\"21/07/2020 15:21:34.178\",\"msgId\":61226969294439425,\"delay\":642},\n" +
                "  {\"logDate\":\"21/07/2020 15:21:34.186\",\"msgId\":61226969296536576,\"delay\":835},\n" +
                "  {\"logDate\":\"21/07/2020 15:21:34.189\",\"msgId\":61226969297323011,\"delay\":1669}]";



        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, DelayLogRecord.class);
        List<DelayLogRecord> data=objectMapper.readValue(dataJson, javaType);

        Random random = new Random();

        for(DelayLogRecord record:data){
            record.setLogDate( new Date( new Date().getTime() + random.nextInt(5000)));
            //Thread.sleep(100);
        }

        DataStreamSource<DelayLogRecord> ds = env.fromCollection(data);
        ds.print();


        DataStream<DelayLogStatistics> finalResult =
        ds.keyBy(DelayLogRecord::group)
                .timeWindow(WINDOWS)
                .aggregate(new AggregateFunction<DelayLogRecord,RecordInfo,RecordInfo>() {
                    @Override
                    public RecordInfo createAccumulator() {
                        return new RecordInfo();
                    }

                    @Override
                    public RecordInfo add(DelayLogRecord value, RecordInfo accumulator) {
                        long delay = value.getDelay();
                        if(delay > accumulator.getMax()){
                            accumulator.setMax(delay);
                        }
                        if(delay < accumulator.getMin()){
                            accumulator.setMin(delay);
                        }
                        long count = accumulator.getCount();
                        count ++;
                        accumulator.setCount(count);
                        long sum = accumulator.getSum();
                        sum += delay;
                        accumulator.setSum(sum);
                        return accumulator;
                    }

                    @Override
                    public RecordInfo getResult(RecordInfo accumulator) {
                        return accumulator;
                    }

                    @Override
                    public RecordInfo merge(RecordInfo a, RecordInfo b) {
                        RecordInfo result = new RecordInfo();
                        result.setMin(  a.getMin() <= b.getMin() ? a.getMin() : b.getMin());
                        result.setMax(  a.getMax() >= b.getMax() ? a.getMax() : b.getMax());
                        result.setCount(a.getCount() + b.getCount());
                        result.setSum(a.getSum() + b.getSum());
                        return result;
                    }
                }, new ProcessWindowFunction<RecordInfo, DelayLogStatistics,Date,TimeWindow>(){
                    @Override
                    public void process(Date date, Context context, Iterable<RecordInfo> elements, Collector<DelayLogStatistics> out) throws Exception {
                        DelayLogStatistics statistics = new DelayLogStatistics();
                        statistics.setBegin(new Date(context.window().getStart()));
                        statistics.setEnd(new Date(context.window().getEnd()));
                        long count = 0;
                        long sum = 0;
                        long min = Long.MAX_VALUE;
                        long max = Long.MIN_VALUE;
                        for(RecordInfo record:elements){
                            if(record.getMax() > max){
                                max = record.getMax();
                            }
                            if(record.getMin() < min){
                                min = record.getMin();
                            }
                            count += record.getCount();
                            sum += record.getSum();

                        }
                        long avg = sum / count;
                        statistics.setMax(max);
                        statistics.setMin(min);
                        statistics.setAvg(avg);
                        out.collect(statistics);
                    }
                });

        finalResult.print();

        env.execute("demo");

    }
}

class DelayLogRecord implements Serializable {

    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "dd/MM/yyyy HH:mm:ss.SSS", timezone="GMT+8")
    private Date logDate;

    private long msgId;

    private long delay;

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public long getMsgId() {
        return msgId;
    }

    public void setMsgId(long msgId) {
        this.msgId = msgId;
    }

    public long getDelay() {
        return delay;
    }

    public void setDelay(long delay) {
        this.delay = delay;
    }

    @Override
    public boolean equals(final Object o){
        if(this == o){
            return true;
        }
        if(o ==null || getClass()!= o.getClass()){
            return false;
        }
        final DelayLogRecord that = (DelayLogRecord) o;
        return Objects.equals(logDate,that.logDate) && Objects.equals(msgId,that.msgId)
                && Objects.equals(delay, that.delay);
    }

    public Date group(){
        Calendar c = Calendar.getInstance();
        c.setTime(logDate);
        c.set(Calendar.MILLISECOND,0);
        int second =c.get(Calendar.SECOND);
        if(second>=45){
            c.set(Calendar.SECOND,0);
            c.add(Calendar.MINUTE,1);
        }else if(second>=30){
            c.set(Calendar.SECOND,45);
        }else if(second>=15){
            c.set(Calendar.SECOND,30);
        }else if(second>=0){
            c.set(Calendar.SECOND,15);
        }
        return c.getTime();
    }

    @Override
    public int hashCode(){
        return Objects.hash(logDate,msgId,delay);
    }


    @Override
    public String toString() {
        try {
            return DemoMain.objectMapper.writeValueAsString(this);
        }catch(IOException e){

        }
        return "{}";
    }
}


class DelayLogStatistics implements Serializable {

    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "dd/MM/yyyy HH:mm:ss.SSS", timezone="GMT+8")
    private Date begin;

    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "dd/MM/yyyy HH:mm:ss.SSS", timezone="GMT+8")
    private Date end;

    private long min;

    private long max;

    private long avg;

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public long getMin() {
        return min;
    }

    public void setMin(long min) {
        this.min = min;
    }

    public long getMax() {
        return max;
    }

    public void setMax(long max) {
        this.max = max;
    }

    public long getAvg() {
        return avg;
    }

    public void setAvg(long avg) {
        this.avg = avg;
    }

    @Override
    public boolean equals(final Object o){
        if(this == o){
            return true;
        }
        if(o ==null || getClass()!= o.getClass()){
            return false;
        }
        final DelayLogStatistics that = (DelayLogStatistics) o;
        return Objects.equals(begin,that.begin) && Objects.equals(end,that.end)
                && Objects.equals(min, that.min) && Objects.equals(max, that.max)
                && Objects.equals(avg, that.avg);
    }

    @Override
    public int hashCode(){
        return Objects.hash(begin,end,min,max,avg);
    }


    @Override
    public String toString() {
        try {
            return DemoMain.objectMapper.writeValueAsString(this);
        }catch(IOException e){

        }
        return "{}";
    }
}

class RecordInfo{
    private long max= Long.MIN_VALUE;
    private long min= Long.MAX_VALUE;
    private long count = 0;
    private long sum = 0;

    public long getMax() {
        return max;
    }

    public void setMax(long max) {
        this.max = max;
    }

    public long getMin() {
        return min;
    }

    public void setMin(long min) {
        this.min = min;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }
}