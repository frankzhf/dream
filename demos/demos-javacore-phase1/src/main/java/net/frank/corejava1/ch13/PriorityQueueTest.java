package net.frank.corejava1.ch13;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args){
        PriorityQueue<GregorianCalendar> pq = new PriorityQueue<>();
        pq.add(new GregorianCalendar(1906, Calendar.DECEMBER,9));
        pq.add(new GregorianCalendar(1815, Calendar.DECEMBER,10));
        pq.add(new GregorianCalendar(1903, Calendar.DECEMBER,3));
        pq.add(new GregorianCalendar(1910, Calendar.JUNE,22));

        System.out.println("Iterating over elements...");
        for(GregorianCalendar date: pq){
            System.out.println(date.get(Calendar.YEAR));
        }

        while(!pq.isEmpty()){
            System.out.println(pq.remove().get(Calendar.YEAR));
        }

    }

    /***
     *  java.util.Queue<E>
     *  boolean add(E element)
     *  boolean offer(E element）
     *  如果队列没有满，将给定的元素添加到这个队列并返回true。如果队列满了，第一个方法将抛出一个IllegalStateException,第二个方法返回false
     *
     *  E remove()
     *  E poll()
     *  假如队列没有满，删除并返回这个队列头部元素。如果队列是空的，第一方法抛出NoSuchElementException,而第二个方法返回null
     *
     *  E element()
     *  E peek()
     *  如果队列不空，返回这个队列头部元素，但不删除。如果队列空，第一方法抛出NoSuchElementException,而第二方法返回null
     *
     *  java.utilDeque<E>
     *  void addFirst(E element)
     *  void addLast(E element)
     *  boolean offerFirst(E element)
     *  boolean offerLast(E element)
     *  将给定的对象添加到双端队列的头部或尾部，如果队列满了，前面两个方法将抛出一个IllegalStateException,而后面两个方法返回false
     *
     *  E removeFirst()
     *  E removeLast()
     *  E pollFirst()
     *  E pollLast()
     *  如果队列不空，删除并返回队列头部或尾部的元素。如果队列为空，前面两个方法将抛出一个NoSuchElementException.而后面两个方法返回null
     *
     *  E getFirst()
     *  E getLast()
     *  E peekFirst()
     *  E peekLast()
     *  如果队列非空，返回队列头部或尾部的元素，但不删除。如果队列空，前面两个方法将抛出一个NoSuchElementException,而后面两个方法返回null
     *
     *  java.util.ArrayDeque<E>
     *  ArrayDeque()
     *  ArrayDeque(int initialCapacity)
     *  用初始容量16或给定的初始容量构造一个无限双端队列
     *
     *  java.util.PriorityQueue
     *  PriorityQueue()
     *  PriorityQueue(int initialCapacity)
     *  构造一个用于存放Comparable对象的优先级队列
     *
     *  PriorityQueue(int initialCapacity, Comparator<? super E> e)
     *  构造一个优先级队列，并用指定的比较器对元素进行排序
     *
     */

}
