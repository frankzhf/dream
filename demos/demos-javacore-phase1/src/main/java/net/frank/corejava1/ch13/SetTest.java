package net.frank.corejava1.ch13;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class SetTest {

    public static void main(String[] args){
        Set<String> words = new HashSet<>();
        long totalTime = 0;
        Scanner in = new Scanner(System.in);
        String word;
        while(in.hasNext()){
            word =in.next();
            if(!word.equals("quit")){
                long callTime = System.currentTimeMillis();
                words.add(word);
                callTime = System.currentTimeMillis() - callTime;
                totalTime += callTime;
            }else{
                break;
            }
        }
        Iterator<String> iter = words.iterator();
        for(int i=1;i<=20 && iter.hasNext();i++){
            System.out.println(iter.next());
        }
        System.out.println("...");
        System.out.println(words.size() + " distinct words. " + totalTime +" milliseconds.");
    }

    /**
     *  java.util.HashSet<E>
     *  HashSet()
     *  构造一个空散列表
     *
     *  HashSet(Collection<？extends E> elements)
     *  构造一个散列集，并将集合中的所有元素添加到这个散列集中
     *
     *  HashSet(int initialCapacity)
     *  构造一个空的具有指定容量（桶数）的散列集
     *
     *  HashSet(int initialCapacity, float loadFactor)
     *  构造一个具有指定容量和装填因子的空散列集
     *
     *  java.lang.Object
     *  int hashCode()
     *  返回这个对象的散列码
     *
     */
}
