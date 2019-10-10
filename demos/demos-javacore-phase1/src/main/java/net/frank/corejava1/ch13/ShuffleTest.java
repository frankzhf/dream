package net.frank.corejava1.ch13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class ShuffleTest {

    public static void main(String[] args){
        List<Integer> numbers = new ArrayList<>();
        for(int i=0;i<=49;i++){
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        List<Integer> winningCombination = numbers.subList(0,6);
        Collections.sort(winningCombination);
        System.out.println(winningCombination);
    }

    /***
     * java.util.Collections
     * static <T extends Comparable<? superT>> void sort(List<T> elements)
     * static <T> void sort(List<T> elements, Comparator<? super T> c)
     * 使用稳定的排序算法，对列表中的元素进行排序。
     *
     * static void shuffle(List<?> elements)
     * static void shuffle(List<?> elements, Random r)
     * 随机地打乱列表中的元素
     *
     * static<T> Comparator<T> reverseOrder()
     * 返回一个比较器
     *
     * static<T> Comparator<T> reverseOrder(Comparator<T> comp)
     * 返回一个比较器，它用与comp指定顺序的逆序对元素进行排序
     *
     * 二分法
     * java.util.Collections
     * static <T extends Comparable<? super T>> int binarySearch(List<T>elements, T key)
     * static <T> int binarySearch(List<T> elements, T key, Comparator<? super T> c)
     * 从有序表中搜索一个键，如果元素扩展了AbstractSequentialList,则采用线性查找，否则将采用二分查找。
     *
     * 简单算法
     * java.util.Collections
     * static <T extends Comparable<? super T>> T min(Collection<T> elements)
     * static <T extends Comparable<? super T>> T max(Collection<T> elements)
     * static <T> min(Collection<T> elements, Comparator <? super T> c)
     * static <T> max(Collection<T> elements, Comparator <? super T> c)
     * 返回集合中的最小或最大的元还给
     *
     * static <T> void copy(List<? super T> to, List<T> from)
     * 将原列表中的所有元素复制到目标列表的相应位置上。目标列表的长度至少与原列表一样
     *
     * static <T> void fill(List<? super T>l, T value)
     * 将列表中所有位置设置为相同的值
     *
     * static <T> boolean addAll(Collection<? super T> c, T... values)
     * 将所有值添加到集合中，如果集合改变了，则返回true
     *
     * static <T> boolean replaceAll(List<T> l, T oldValue, T newValue)
     * 用newValue取代所有值为oldValue的元素
     *
     * static int indexOfSubList(List<?> l, List<?> s)
     * static int lastIndexOfSubList(List<?> l, List<?> s)
     * 子列表在父列表中的下标
     *
     * static void swap(List<?> l, int i, int j)
     * 交换给定偏移量的两个元素
     *
     * static void reverse(List<?> l)
     * 逆置列表中元素的顺序
     *
     * static void rotate(List<?> l, int d)
     * 旋转列表中的元素
     *
     * static int frequency(Collection<?> c, Object o)
     * 返回c中与对象相同的元素个数
     *
     * boolean disjoint(Collection<?> c1,Collection<?> c2)
     * 如果两个集合没有共同的元素，则返回true
     *
     * 遗留的集合
     * java.util.Enumeration<E>
     * boolean hasMoreElements()
     * 如果还有更新的元素可以查看，则返回true
     *
     * E netElement()
     * 返回被检查的下一个元素。如果hasMoreElements()返回false,则不要调用这个方法
     *
     * java.util.Hashtable
     * Enumeration<K> keys()
     * 返回一个遍历散列表中键的枚举对象
     *
     * Enumeration<V> elements()
     * 返回一个遍因散列表中元素的枚举对象
     *
     * java.util.Vector<E>
     * Enumeration<E> elements
     * 返回遍历向量中元素的枚举对象
     *
     * java.util.Properties
     * Properties()
     * 创建一个空的属性映射表
     *
     * Properties(Properties defaults)
     * 创建一个带有一组默认值的空的属性映射表
     *
     * String getProperty(String key)
     * 获得属性的对应关系；返回与键对应的字符串
     *
     * String getProperty(String key, String defaultValue)
     * 获得在键没有找到时具有的默认值属性
     *
     * void load(InputStream in)
     * 从InputStream加载属性映射表
     *
     * void store(OutputStream out, String commentString)
     * 把属性映射表存储到OutputStream
     *
     * java.util.Stack<E>
     * E push(E item)
     * 将item压入栈并返回item
     *
     * E pop()
     * 弹出并返回栈顶的item。如果栈为空，请不要调用这个方法
     *
     * E peek()
     * 返回栈顶元素，但不弹出，如果栈为空，请不要调用这个方法
     *
     * java.util.BitSet
     * BitSet(int initialCapacity)
     *
     *
     * int length()
     *
     *
     * boolean get(int bit)
     *
     *
     * void set(int bit)
     *
     *
     * void clear(int bit)
     *
     *
     * void and(BitSet set)
     *
     *
     * void or(BitSet set)
     *
     *
     * void xor(BitSet set)
     *
     *
     * void andNot(BitSet set)
     *
     */
}
