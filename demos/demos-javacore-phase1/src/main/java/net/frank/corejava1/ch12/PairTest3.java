package net.frank.corejava1.ch12;

import net.frank.corejava1.ch05.equals.Employee;
import net.frank.corejava1.ch05.equals.Manager;

public class PairTest3 {

    public static void main(String[] args){
        Manager ceo = new Manager("Gus Greedy",8000000,2003,12,15);
        Manager cfo = new Manager("Sid Sneaky", 6000000,2003,12,15);

        Pair<Manager> buddies = new Pair<>(ceo,cfo);
        printBuddies(buddies);

        ceo.setBonus(1000000);
        cfo.setBonus(500000);

        Manager[] managers = {ceo,cfo};

        Pair<Employee> result = new Pair<>();
        minmaxBonus(managers,result);
        System.out.println("first: " +result.getFirst().getName()
            +", second: " + result.getSecond().getName());

        maxminBonus(managers,result);
        System.out.println("first: " +result.getFirst().getName()
                +", second: " + result.getSecond().getName());
    }

    public static void minmaxBonus(Manager[] a, Pair<Employee> result) {
        if(a== null || a.length == 0){
            return;
        }
        Manager min = a[0];
        Manager max = a[0];
        for(int i=1;i<a.length;i++){
            if(min.getSalary() > a[i].getSalary() ){
                min = a[i];
            }
            if(max.getSalary() < a[i].getSalary()){
                max = a[i];
            }
        }
        result.setFirst(min);
        result.setSecond(max);
    }

    public static void maxminBonus(Manager[] a, Pair<Employee> result) {
        minmaxBonus(a,result);
        PairAlg.swapHelper(result);
    }


    public static void printBuddies(Pair<Manager> buddies) {
        Employee first = buddies.getFirst();
        Employee second = buddies.getSecond();
        System.out.println(first.getName() + " and " + second.getName() + " are buddies.");
    }


}


class PairAlg{
    public static boolean hasNulls(Pair<?> p){
        return p.getFirst() == null || p.getSecond() == null;
    }

    public static void swap(Pair<?> p){
        swapHelper(p);
    }

    public static <T>  void swapHelper(Pair<T> p){
        T t = p.getSecond();
        p.setSecond(p.getFirst());
        p.setFirst(t);
    }

}