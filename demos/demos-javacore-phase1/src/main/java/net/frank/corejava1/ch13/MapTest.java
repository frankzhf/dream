package net.frank.corejava1.ch13;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MapTest {

    public static void main(String[] args){
        Map<String, Employee> staff = new HashMap<>();
        staff.put("144-25-5464",new Employee("Amy Lee"));
        staff.put("567-24-2546",new Employee("Harry Hacker"));
        staff.put("157-62-7935",new Employee("Gary Cooper"));
        staff.put("456-62-5527",new Employee("Francesca Cruz"));

        System.out.println(staff);
        staff.remove("567-24-2546");
        staff.put("456-72-5527",new Employee("Francesca Miller"));

        System.out.println(staff.get("157-62-7935"));

        for(Map.Entry<String,Employee> entry: staff.entrySet()){
            String key = entry.getKey();
            Employee value = entry.getValue();
            System.out.println("key= " + key +",value=" + value);
        }

    }

    /***
     *  java.util.Map<K,V>
     *  V get(Object key)
     *  获取与键对应的值
     *
     *  V put(K key, V value)
     *  将键与对应的值关系插入到映射表
     *
     *  void putAll(Map<? extends K, ? extends V> entries)
     *  将给定映射表中的所有条目添加到这个映射表中
     *
     *  boolean containsKey(Object key)
     *  如果在映射表中已经有这个键，返回true
     *
     *  boolean containsValue(Object value)
     *  如果在映射表中已经有这个值，返回true
     *
     *  Set<Map.Entry<K,V>> entrySet()
     *  返回Map.Entry对象的集视图，即映射表中的键值对。
     *
     *  Set<K> keySet()
     *  返回映射表中所有键的集视图
     *
     *  Collection<V> values()
     *  返回映射表中所有值的集视图
     *
     *  java.util.Map.Entry<K,V>
     *  K getKey()
     *  V getValue()
     *  返回这个条目的键或值
     *
     *  V  setValue(V newValue)
     *  设置在映射表中与新值对应的值，并返回旧值
     *
     *  java.util.HashMap<K,V>
     *  HashMap()
     *  HashMap(int initialCapacity)
     *  HashMap(int initialCapacity, float loadFactor)
     *  用给定的容量和装填因子构造一个空的散列映射表
     *
     *  java.util.TreeMap<K,V>
     *  TreeMap(Comparator<? super K> c)
     *  构造一个对映射表，并使用一个指定的比较器对键进行排序
     *
     *  TreeMap(Map<? extends K, ? extends V> entries)
     *  构造一个对映射表，并将某个映射表中的所有条目添加到树映射表中
     *
     *  TreeMap(SortedMap<? extends K, ? extends V> entries)
     *  构造一个树映射表，将某个有序映射表中的所有条目添加到树映射表中，并使用与给定的有序映射表相同的比较器
     *
     *  java.util.SortedMap<K,V>
     *  Comparator<? super K> comparator()
     *  返回对键进行排序的比较器
     *
     *  K firstKey()
     *  K lastKey()
     *  返回映射表中最小元素和最大元素
     *
     *  专用集与映射表类
     *  java.util.WeakHashMap<K,V>
     *  WeakHashMap()
     *  WeakHashMap(int initialCapacity)
     *  WeakHashMap(int initialCapacity, float loadFactor)
     *  用给定的容量和填充因子构造一个空的散列映射表
     *
     *  java.util.LinkedHashSet<E>
     *  LinkedHashSet()
     *  LinkedHashSet(int initialCapacity)
     *  LinkedHashSet(int initialCapacity, float loadFactor)
     *  用给定的容量和填充因子构造一个空链接散列集
     *
     *  java.util.LinkedHashMap<K,V>
     *  LinkedHashMap()
     *  LinkedHashMap(int initialCapacity)
     *  LinkedHashMap(int initialCapacity, float loadFactor)
     *  LinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder)
     *  用给定的容量、填充因子和顺序构造一个空的链接散列映射表
     *
     *  boolean removeEldestEntry(Map.Entry<K,V> eldest)
     *  如果想要删除eldest元素，并同时返回true,就应该覆盖这个方法
     *
     *  java.util.EnumSet<E extends Enum<E>>
     *  static <E extends Enum<E>> EnumSet<E> allOf(Class<E> enumType)
     *  返回一个包含给定枚举类型的所有值的集
     *
     *  static <E extends Enum<E>> EnumSet<E> noneOf(Class<E> enumType)
     *  返回一个空集，并有足够的空间保存给定的枚举类型是的所有的值
     *
     *  static <E extends Enum<E>> EnumSet<E> range(E from, E to)
     *  返回一个包含from-to之间所有值（包括两个边界）的集
     *
     *  static <E extends Enum<E>> EnumSet<E> of(E value)
     *  static <E extends Enum<E>> EnumSet<E> of(E value, E... values)
     *  返回包括给定值的集
     *
     *  java.util.EnumMap<K extends Enum<K>,V>
     *  构造一个键为给定类型的空映射集
     *
     *  java.util.IdentityHashMap<K,V>
     *  IdentityHashMap()
     *  IdentityHashMap(int expectedMaxSize)
     *  构造一个空的标识散列映射集，其容量是大于1.5*expectedMaxSize的2的最小次幂
     *
     *  java.lang.System
     *  static int identityHashCode(Object obj)
     *  返回Object.hasCode计算出来的相同散列码（根据对象的内存地址产生），退使obj所属的类已经重新定义了hashCode方法也是如此
     *
     *  集合框架
     *  java.util.Collections
     *  static <E> Collection<E> unmodifiableCollection(Collection<E> c)
     *  static <E> List<E> unmodifiableList(List<E> c)
     *  static <E> Set<E> unmodifiableSet(Set<E> c)
     *  static <E> SortedSet<E> unmodifiableSortedSet(SortedSet<E> c)
     *  static <K,V> Map<K,V> unmodifiableMap(Map<K,V> c)
     *  static <K,V> SortedMap<K,V> unmodifiableSortedMap(SortedMap<K,V> c)
     *  构造一个集合视图，其更改器方法将抛出一个UnsupportedOperationException
     *
     *  static<E> Collection<E> synchronizedCollection(Collection<E> c)
     *  static<E> List<E> synchronizedList(List<E> c)
     *  static<E> Set<E> synchronizedSet(Set<E> c)
     *  static<E> SortedSet<E> synchronizedSortedSet(SortedSet<E> c)
     *  static<K,V> Map<K,V> synchronizedMap(Map<K,V> c)
     *  static<K,V> SortedMap<K,V> synchronizedSortedMap(SortedMap<K,V> c)
     *  构造一个集合视图，其方法都是同步的
     *
     *  static<E> Collection<E> checkedCollection(Collection<E> c)
     *  static<E> List<E> checkedList(List<E> c)
     *  static<E> Set<E> checkedSet(Set<E> c)
     *  static<E> SortedSet<E> checkedSortedSet(SortedSet<E> c)
     *  static<K,V> Map<K,V> checkedMap(Map<K,V> c)
     *  static<K,V> SortedMap<K,V> checkedSortedMap(SortedMap<K,V> c)
     *  构造一个集合视图，如果插入一个错误的元素，将抛出一个ClassCastException
     *
     *  static <E> List<E> nCopies(int n, E value)
     *  构造一个对象视图，它可以作为n个相同的元素的不可修改列表
     *
     *  static <E> Set<E> singleton(E value)
     *  构造一个对象视图，它可以作为单个元素的集
     *
     *  java.util.Arrays
     *  static <E> List<E> asList(E... array)
     *  返回一个数组元素的列表视图，这个数据 是可以修改的，但其大小不可变
     *
     *  java.util.List<E>
     *  List<E> subList(int firstIncluded, int lastExcluded)
     *  返回给定位置范围内的所有元素的列表视图
     *
     *  java.util.SortedSet<E>
     *  SortedSet<E> subSet(E firstIncluded, E lastExcluded)
     *  SortedSet<E> headSet(E firstExcluded)
     *  SortedSet<E> tailSet(E firstIncluded)
     *  返回给定范围的元素视图
     *
     *  java.util.NavigableSet<E>
     *  NavigableSet<E> subSet(E from, boolean fromIncluded, E to, boolean toInclude)
     *  NavigableSet<E> headSet(E to, boolean toIncluded)
     *  NavigableSet<E> tailSet(E from, boolean fromIncluded)
     *  返回给定范围内的元素视图。 boolean标志决定视图是否包含边界
     *
     *  java.util.SortedMap<K,V>
     *  SortedMap<K,V> subMap(K firstIncluded, K firstExcluded)
     *  SortedMap<K,V> headMap(K firstExcluded)
     *  SortedMap<K,V> tailMap(K firstIncluded)
     *  返回在给定范围内的键条目的映射表视图
     *
     *  java.util.NavigableMap<K,V>
     *  NavigableMap<K,V> subMap(K from, boolean fromIncluded, K to, boolean toIncluded)
     *  NavigableMap<K,V> headMap(K from, boolean formIncluded)
     *  NavigableMap<K,V) tailMap(K to, boolean toIncluded)
     *  返回在给定范围内的键条目的映射表视图。boolean标志视图是否包含边界
     *
     *
     */


}

class Employee{
    private String name;
    private Date hireDay;

    public Employee(String n) {
        name = n;
        hireDay = new Date();
    }
}
