package net.frank.corejava2.ch01;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class HrefMatch {

	public static void main(String[] args) {
		try{
			int flags = 0x1105;
			int UNICODE_CHARACTER_CLASS = 0x100;
			int UNICODE_CASE = 0x40;
			System.out.println(flags & UNICODE_CHARACTER_CLASS);
			if ((flags & UNICODE_CHARACTER_CLASS) != 0)
		            flags |= UNICODE_CASE;
			System.out.println(flags);
			
			String url;
			if(args.length >0){
				url = args[0];
			}else{
				url = "http://news.163.com";
			}
			InputStreamReader in = new InputStreamReader(new URL(url).openStream());
			
			StringBuilder input = new StringBuilder();
		
			int ch;
			while((ch=in.read())!=-1){
				input.append((char)ch);
			}
			String patternString = "<a\\s+href\\s*=\\s*(\"[^\"]*\"|[^\\s>]*)\\s*>";
			Pattern pattern = Pattern.compile(patternString,Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(input);
			while(matcher.find()){
				int start = matcher.start();
				int end = matcher.end();
				String match = input.substring(start,end);
				System.out.println(match);
			}
		}catch(IOException e){
			e.printStackTrace();
		}catch(PatternSyntaxException e){
			e.printStackTrace();
		}
	}
}

/**
 * Class java.util.regex.Pattern
 * static Pattern compile(String expression)
 * static Pattern compile(String expression, int flags)
 * 把正则表达式字符串编译到一个用于快速处理匹配的模式中
 * 参数 flags CASE_INSENSITIVE				0x02			  2
 * 			UNICODE_CASE				0x40			 64
 * 			MULTILINE					0x08			  8
 * 			UNIX_LINES 					0x01			  1
 * 			DOTALL						0x20			 32
 * 			CANON_EQ					0x100			256
 * 			UNICODE_CHARACTER_CLASS		0x80			128
 * 			LITERAL						0x10			 16
 * 			COMMENTS					0x04			  4
 * 
 *  Matcher matcher(CharSequence input)
 *  返回一个matcher对象，你可以用它在输入定位模式的匹配
 *  
 *  String[] split(CharSequence input)
 *  String[] split(CharSequence input, int limit)
 *  将输入分割成标号，其中模式指定了分隔符的形式。 limit是返回的数组个数限制
 *  
 *  Class java.util.regex.Matcher
 *  boolean matches()
 *  如果输入匹配模式，则返回true
 *  
 *  boolean lookingAt()
 *  如果输入匹配开头模式，则返回true
 *  
 *  boolean find()
 *  boolean find(int start)
 *  尝试查找下一个，如果找到了另一个匹配，则返回true
 *  
 *  int start()
 *  int end()
 *  返加当前匹配的开始索引和结尾之后的索引
 *  
 *  String group()
 *  返回当前的匹配
 *  
 *  int groupCount()
 *  返回输入模式中的群组数量
 *  
 *  int start(int groupIndex)
 *  int end(int groupIndex)
 *  返回当前匹配中给定的群组的开始和结尾后的位置，groupIndex从1开始， 0表示整个匹配
 *  
 *  String group(int groupIndex)
 *  返回匹配给定群组的字符串，groupIndex从1开始， 0表示整个匹配
 *  
 *  String replaceAll(String replacement)
 *  String replaceFirst(String replacement)
 *  返回从匹配器输入获得的通过将所有匹配或第一个匹配用替换字符串替换之后的字符串
 *  
 *  Matcher reset()
 *  Matcher reset(CharSequence input)
 *  复位匹配器的状态
 * 
 */

		
				
