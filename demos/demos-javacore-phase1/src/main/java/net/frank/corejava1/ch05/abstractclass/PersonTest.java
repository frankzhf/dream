package net.frank.corejava1.ch05.abstractclass;

public class PersonTest {

	public static void main(String[] args) {
		
		Person[] people = new Person[2];
		people[0] = new Employee("Harry Hacker",50000,1980,10,1);
		people[1] = new Student("Maria Morris","computer science");
		
		for(Person p: people) {
			System.out.println(p.getName() +"," + p.getDescription());
		}
		
	}

	
	/***
	 * java.lang.Object
	 * int hashCode()
	 * 返回对象的散列码。散列码可以是任意的整数，包括正数或负数。两个相等的对象要求返回相等的散列码
	 * 
	 * java.util.Arrays
	 * static Boolean equals(type[] a, type[] b)
	 * 如果二个数组长度相同，并且在对应的位置上的数据元素也均相同，将返回true。数组的元素类型可以是Object， int, long, short, char, boolean, float, double
	 * 
	 * static int hashCode(type[] a)
	 * 计算数组a的散列值
	 * 
	 * java.util.Objects
	 * static boolean equals(Object a, Object b)
	 * 如果a和b都是null,返回true;如果只有其中之一为null，则返回false；否则返回a.equals(b)
	 * 
	 * static int hash(Object... objects)
	 * 返回一个散列码，由提供的所有对象的散列码组合而得到
	 * 
	 * static int hashCode(Object a)
	 * 如果a为null返回0，否则返回a.hashCode()
	 * 
	 */
}
