package net.frank.corejava1.ch13;

/***
 *  java.util.Collection<E>
 *  Iterator<E> iterator()
 *  返回一个用于访问集合中每个元素的迭代器
 *
 *  int size()
 *  返回当前存储在集合中的元素个数
 *
 *  boolean isEmpty()
 *  如果集合中没有元素，返回true
 *
 *  boolean contains(Object ojb)
 *  如果集合中包含了一个与obj相等的对象，返回true
 *
 *  boolean containsAll(Collection<?> other
 *  如果这个集合包含other集合中的所有元素，返回true
 *
 *  boolean add(Object element)
 *  将一个元素添加到集合中。如果由于这个调用改变了集合，返回true
 *
 *  boolean addAll(Collection<? extends E> other)
 *  将other集合中的所有元素添加到这个集合，如果由于这个调用改变了集合，返回true
 *
 *  boolean remove(Object obj)
 *  从这个集合中删除等于obj的对象。如果有对象被删除，返回true
 *
 *  boolean removeAll(Collection<?> other)
 *  从这个集合中删除other集合中存在的所有元素。如果由于这个调用改变了集合，返回true
 *
 *  void clear()
 *  从这个集合中删除所有的元素
 *
 *  boolean retainAll(Collection<?> other)
 *  从这个集合中删除others集合中的元素不同的元素。如果由于这个调用改变了集合，返回true
 *
 *  Object[] toArray()
 *  返回这个集合的对象数组
 *
 *  <T> T[] toArray(T[] arrayToFill)
 *  返回这个集合的对象数组。
 *
 *  java.util.Iterator<E>
 *  boolean hasNext()
 *  如果存在可访问的元素
 *
 *  E next()
 *  返回将要访问的下一个对象，如果已经到达集合的尾部，将抛出一个NoSuchElementException
 *
 *  void remove()
 *  删除上次访问的对象。这个方法必须紧跟在访问一个元素之后执行。如果上次访问之后，集合已经发生变化，这个方法将抛出一个IllegalStateException
 *
 */


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/***
 * Java库中的具体集合类
 *  ArrayList                           一种可以动态增长或缩减的索引序列
 *  LinkedList                          一种可以在任何位置进行高效插入和删除操作的有序序列
 *  ArrayDeque                          一种用循环数组实现的双端队列
 *  HashSet                             一种没有重复元素的无序集合
 *  TreeSet                             一种有序集
 *  EnumSet                             一种包含枚举类型值的集
 *  LinkedHashSet                       一种可以记住元素插入次序的集合
 *  PriorityQueue                       一种允许高效删除最小元素的集合
 *  HashMap                             一种存储健/值关联的数据结构
 *  TreeMap                             一种键值有序排列的映射表
 *  EnumMap                             一种键值属于枚举类型的映射表
 *  LinkedHashMap                       一种可记住键/值项添加次序的映射表
 *  WeakHashMap                         一种其值无用武之地后可以被垃圾回收器回收的映射表
 *  IdentityHashMap                     一种用==而不是用equals比较键值的映射表
 *
 *
 *
 */
public class LinkedListTest {

    public static void main(String[] args){
        List<String> a = new LinkedList<>();
        a.add("Amy");
        a.add("Carl");
        a.add("Erica");

        List<String> b = new LinkedList<>();
        b.add("Bob");
        b.add("Doug");
        b.add("Frances");
        b.add("Gloria");

        //集合b 加入集合a
        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();
        while(bIter.hasNext()){
            if(aIter.hasNext()){
                aIter.next();
            }
            aIter.add(bIter.next());
        }
        //打印结果有序
        //[Amy, Bob, Carl, Doug, Erica, Frances, Gloria]
        System.out.println(a);

        //重置迭代器
        bIter = b.iterator();
        //去掉b集合第偶元素
        while (bIter.hasNext()){
            bIter.next();
            if(bIter.hasNext()){
                bIter.next();
                bIter.remove();
            }
        }
        //打印结果
        //[Bob, Frances]
        System.out.println(b);

        //集合a 去掉所有集合b中的元素
        a.removeAll(b);

        //集合a 最终的元素
        //[Amy, Carl, Doug, Erica, Gloria]
        System.out.println(a);
    }

    /***
     *  java.util.List<E>
     *  ListIterator<E> listIterator()
     *  返回一个列表迭代器，以便用来访问列表中的元素
     *
     *  ListIterator<E> listIterator(int index)
     *  返回一个列表代迭器，以便用来访问列表中的元素，这个元素是第一次调用next返回的给定索引的元素
     *
     *  void add(int i, E element)
     *  在给定位置添加一个元素
     *
     *  void addAll(int i, Collection<? extends E> elements)
     *  将某个集合中的所有元素添加到给定位置
     *
     *  E remove(int i)
     *  删除给定位置的元素并返回这个元素
     *
     *  E get(int i)
     *  获取给定位置的元素
     *
     *  E set(int i, E element)
     *  用新元素取代给定位置的元素，并返回原来那个元素
     *
     *  int indexOf(Object element)
     *  返回与指定元素相等的元素在列表中第一次出现的位置，如果没有这样的元素将返回-1
     *
     *  int lastIndexOf(Object element)
     *  返回与指定元素相等的元素在列表中最后一次出现的位置
     *
     *  java.util.ListIterator<E>
     *  void add(E newElement)
     *  在当前位置增加一个元素
     *
     *  void set(E newElement)
     *  用新元素取代next或previous上次访问的元素。如果在next或previous上次调用之后表结构被修改了，将抛出一个IllegalStateException
     *
     *  boolean hasPrevious()
     *  当反向迭代列表时，还有可供访问的元素，返回true
     *
     *  E previous()
     *  返回前一个对象，如果已经到达列表头部，就抛出一个NoSuchElementException
     *
     *  int nextIndex()
     *  返回下一次调next方法时将返回的元素索引
     *
     *  int previousIndex()
     *  返加下一次调用previous方法时将返回的元素索引
     *
     *  java.util.LinkedList<E>
     *  LinkedList()
     *  构造一个空链表
     *
     *  LinkedList(Collection<？extends E> elements)
     *  构造一个链表，并将集合中所有的元素添加到这个链表中
     *
     *  void addFirst(E element)
     *  void addLast(E element)
     *  将某个元素添加到链表头部或尾部
     *
     *  E getFirst()
     *  E getLast()
     *  返回链表的头部或尾部
     *
     *  E removeFirst()
     *  E removeLast()
     *  删除并返回链表的头部或尾部元素
     *
     */


}
