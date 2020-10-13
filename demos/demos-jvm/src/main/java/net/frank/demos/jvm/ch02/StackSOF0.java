package net.frank.demos.jvm.ch02;

/**
 * VM args : -Xss128k
 */

public class StackSOF0 {

    private int stackLength = 1;

    public void stackLeak(){
        stackLength ++;
        stackLeak();
    }

    public static void main(String[] args){
        StackSOF0 oom = new StackSOF0();
        try{
            oom.stackLeak();
        }catch (Throwable e){
            System.out.println("Stack length : " + oom.stackLength);
            throw  e;
        }
    }


}
