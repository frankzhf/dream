package net.frank.demos.jvm.ch02;

/**
 * VM args : -Xss2M
 */

public class StackOOM {

    private void dontStop(){
        while(true){

        }
    }

    public void stackLeakByThread(){
        while(true){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }


    public static void main(String[] args){
        StackOOM oom = new StackOOM();
        oom.stackLeakByThread();
    }



}
