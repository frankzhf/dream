package net.frank.corejava1.ch03;

//import java.io.Console;
import java.util.Scanner;

public class InputTest {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("What is you name?");
		String name = in.nextLine();
		System.out.print("How old are you?");
		int age = in.nextInt();
		in.close();
		System.out.println("Hello, " +name + ". Next year, you'll be " + (age+1));
		
		/**
		 * 注意 Scanner类不适合从控制台读取密码 
		Console console = System.console();
		String username = console.readLine("User name:");
		char[] passwd = console.readPassword("Password:");
		System.out.println("Hello, " + username + "! Your passwd is " + passwd);
		*/
		
		/***
		 * 
		 * java.util.Scanner
		 * Scanner(InputStream in)
		 * 从给定的输入流创建一个Scanner对象
		 * 
		 * Scanner(File f)
		 * Scanner(Path p)
		 * 构造从给定文件或文件路径读取数据
		 * 
		 * Scanner(String data)
		 * 构造从给定字符串读取数据
		 * 
		 * String nextLine()
		 * 读取下一行内容
		 * 
		 * String next()
		 * 读取下一个字（以空格作为分隔符)
		 * 
		 * int nextInt()
		 * double Double()
		 * 读取并转换一下表示整型或浮点的字符序列
		 *  
		 * boolean hasNext()
		 * 判断是否还有其它字
		 * 
		 * boolean hasNextInt()
		 * boolean hasNextDouble()
		 * 判断是否还有其表示整型或浮点的字符序列
		 * 
		 * java.io.PrintWriter
		 * PrintWriter(String fileName)
		 * 构造一个将数据写入文件的PrintWrite
		 * 
		 * java.nio.file.Path
		 * static Path get(String pathname)
		 * 根据给定路径名构造一个Path
		 * 
		 * java.lang.System
		 * static Console console()
		 * 如果有可能进行一个交互操作，返回一个终端，否则为空 javaw启动将为空
		 * 
		 * java.io.Console
		 * static char[] readPassword(String prompt, Object... args)
		 * static String readLine(String prompt, Object... args)
		 * 显示字符串prompt并读取用户输入，直到输入结束
		 * 
		 * 
		 */
		
		
	}
}
