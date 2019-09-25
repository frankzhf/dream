package net.frank.corejava1.ch13;

import java.util.Comparator;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args){
        SortedSet<Item> parts = new TreeSet<>();
        parts.add(new Item("Toaster",1234));
        parts.add(new Item("Widget",4562));
        parts.add(new Item("Modem",9912));

        System.out.println(parts);

        SortedSet<Item> sortByDescription = new TreeSet<>(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                String descrA = o1.getDescription();
                String descrB = o2.getDescription();
                return descrA.compareTo(descrB);
            }
        });
        sortByDescription.addAll(parts);
        System.out.println(sortByDescription);
    }
}


class Item implements Comparable<Item>{
    private String description;
    private int partNumber;

    public Item(String sDescription, int aPartNumber){
        description = sDescription;
        partNumber = aPartNumber;
    }

    public String getDescription(){
        return description;
    }

    public String toString(){
        return "[description=" + description +", partNumber=" + partNumber +"]";
    }

    public boolean equals(Object otherObject){
        if(this == otherObject){
            return true;
        }
        if(otherObject == null){
            return false;
        }
        if(getClass()!= otherObject.getClass()){
            return false;
        }
        Item other = (Item) otherObject;
        return Objects.equals(description,other.description) && partNumber == other.partNumber;
    }

    public int hashCode(){
        return Objects.hash(description,partNumber);
    }

    public int compareTo(Item other){
        return Integer.compare(partNumber,other.partNumber);
    }

}

/***
 *  java.util.TreeSet<E>
 *  TreeSet()
 *  构造一个空树集
 *
 *  TreeSet(Collection<? extends E> elements)
 *  构造一个树集，并将集合中的所有元素添加到树集中
 *
 *  java.lang.Comparable<T>
 *  int compareTo(T other)
 *  将这个对象(this)与另一个对象(other)进行比较，如果this位于other之前则返回负值，如果二个对象在排列顺序中处于相同的位置则返回0，如果this位于other之后则返回正值
 *
 *  java.util.Comparator<T>
 *  int compare(T a, T b)
 *  将两个对象进行比较，如果a位于b之前则返回负值，如果两个对象在排列顺序中处于相同的位置则返回0，如果a位于b之后则返回正值
 *
 *  java.util.SortedSet<E>
 *  Comparator<? super E> comparator()
 *  返回用于对元素进行排序的比较器。如果元素用Comparable接口的compareTo方法进行比较则返回null
 *
 *  E first()
 *  E last()
 *  返回有序集中的最小元素或最大元素
 *
 *  java.util.NavigableSet<E>
 *  E higher(E value)
 *  E lower(E value)
 *  返回大于value的最小元素或小于value的最大元素
 *
 *  E ceiling(E value)
 *  E floor(E value
 *  返回大于等于value的最小元素或小于等于value的最大元素
 *
 *  E pollFirst()
 *  E pollLast()
 *  删除并返回这个集中的最大元素或最小元素
 *
 *  Iterator<E> descendingIterator()
 *  返回一个按照递减顺序遍历集中元素的迭代器
 *
 *  java.util.TreeSet<E>
 *  TreeSet()
 *  构造一个用于排列Comparable对象的树集
 *
 *  TreeSet(Comparator<? super E> c)
 *  构造一个树集，并使用指定的比较器对其中元素进行排序
 *
 *  TreeSet(SortedSet<? extends E> elements)
 *  构造一个树集，将有序集中所有元素添加到这个树集中，并使用给定集合相同的元素比较器
 *
***/
