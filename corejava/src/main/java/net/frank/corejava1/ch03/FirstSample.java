package net.frank.corejava1.ch03;

public class FirstSample {
	public static void main(String[] args) {
		System.out.println("We will not user 'Hello, World!");
	}
}

/***
 * java.lang.String
 * char charAt(int index)
 * 返回给定位置的代码单元
 * 
 * int codePointAt(int index) //第index个字符的 ascii 10进值的值
 * 返回从给定位置开始或结束的代码点
 * 
 * int offsetByCodePoints(int startIndex, int cpCount)
 * 返回从startIndex代码开始，位移cpCount后的代码点索引
 * 
 * int compareTo(String other)
 * 按照字典排序，如果字符串位于other前，返回一个负数，如果字符串位于other后，返回一个正数，相等的话，返回0
 * 
 * boolean endsWith(String suffix)
 * 是否以suffix结尾
 * 
 * boolean equals(Object other)
 * 是否相等
 * 
 * boolean equalsIgnoreCase(String other)
 * 是否相等，忽略大小写
 * 
 * int indexOf(String str)
 * int indexOf(String str, int fromIndex)
 * int indexOf(int cp)
 * int indexOf(int cp, int fromIndex)
 * 返回第一个与str或代码点匹配的开始位置的下标
 * 
 * int lastIndexOf(String str)
 * int lastIndexOf(String str, int fromIndex)
 * int lastIndexOf(int cp)
 * int lastIndexOf(int cp, inst fromIndex)
 * 返回最后一个与str或代码点匹配的开始位置的下标
 * 
 * int length()
 * 返回字符串长度
 * 
 * int codePointCount(int startIndex, int endIndex)
 * 从startIndex到endIndex-1位置的代码点的数量
 * 
 * String replace(CharSequence oldString, CharSequence newString)
 * 替换字符串
 * 
 * boolean startWith(String prefix)
 * 是否是prefix开始
 * 
 * String substring(int beginIndex)
 * String substring(int beginIndex, int endIndex)
 * 取子串
 * 
 * String toLowerCase()
 * 转小写
 * 
 * String toUpperCase()
 * 转大写
 * 
 * String trim();
 * 截空首尾
 * 
 * java.lang.StringBuffer && java.lang.StringBuilder 前者线程同步，可用于多线程程序，后者可用于单线程程序
 * StringBuilder()
 * 构造一个空的字符串构建器
 * 
 * int length()
 * 返回字符串构建器的长度
 * 
 * StringBuilder append(String str)
 * 追加一个字符串
 * 
 * StringBuilder append(char c)
 * 追加一个字符
 * 
 * StringBuilder appendCodePoint(int cp)
 * 追加一个代码
 * 
 * void setCharAt(int i, char c)
 * 将第i个代码单元设置为c
 * 
 * StringBuilder insert(int offset, String str)
 * 在指定位置插入str
 * 
 * StringBuilder insert(int offset, char c)
 * 在指定位置插入c
 * 
 * StringBuilder delete(int startIndex, int endIndex)
 * 删除startIndex到endIndex-1的代码单元
 * 
 * String toString()
 * 构造器内容相同的字符串
 *
**/
