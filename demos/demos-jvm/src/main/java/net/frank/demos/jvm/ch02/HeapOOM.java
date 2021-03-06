package net.frank.demos.jvm.ch02;

import java.util.ArrayList;
import java.util.List;

/***
 * VM args : -Xms20m -Xmx20M -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {

    static class OOMObject {}

    public static void main(String[] args){
        List<OOMObject> list = new ArrayList<>();
        while(true){
            list.add(new OOMObject());
        }
    }

}
