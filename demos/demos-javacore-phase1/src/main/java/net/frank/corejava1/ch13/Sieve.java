package net.frank.corejava1.ch13;

import java.util.BitSet;

public class Sieve {

    public static void main(String[] args){
        int n= 2000000;
        long start = System.currentTimeMillis();
        BitSet b = new BitSet(n+1);
        int count =0;
        int i;
        for(i=2;i<=n;i ++){
            b.set(i);
        }
        i= 2;
        while(i*i <= n){
            if(b.get(i)){
                count ++;
                int k= 2*i;
                while(k<=n){
                    b.clear(k);
                    k+= i;
                }
            }
            i++;
        }

        while(i<=n){
            if(b.get(i)){
                count++;
            }
            i++;
        }
        long end = System.currentTimeMillis();
        System.out.println(count + " primes");
        System.out.println((end-start) + " milliseconds");
    }

    /**
     * java.util.BitSet
     * BitSet(int initialCapacity)
     * 创建一个位集
     *
     * int length()
     * 返回位集的逻辑长度
     *
     * boolean get(int bit)
     * 获得一个位
     *
     * void set(int bit)
     * 设置一个位
     *
     * void clear(int bit)
     * 清除一个位
     *
     * void and(BitSet set)
     * 进行逻辑AND运算
     *
     * void or(BitSet set)
     * 进行逻辑or运算
     *
     * void xor(BitSet set)
     * 进行逻辑xor运算
     *
     * void andNot(BitSet set)
     * 清除这个位集中对应另一个位集中设备的所有位
     *
     */
}
