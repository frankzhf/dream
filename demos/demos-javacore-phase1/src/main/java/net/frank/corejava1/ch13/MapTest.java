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
