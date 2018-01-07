package net.frank.corejava0.jakarta.ch02;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

public class StringUtilsSample {
	
	public static void main(String[] args) {
		String test = "";
		String test2 = "\n\n\t";
		String test3 = null;
		String test4 = "Test";
		System.out.println("test blank? " + StringUtils.isBlank(test));
		System.out.println("test2 blank? " + StringUtils.isBlank(test2));
		System.out.println("test3 blank? " + StringUtils.isBlank(test3));
		System.out.println("test4 blank? " + StringUtils.isBlank(test4));
		
		
		System.out.println("test not blank? " + StringUtils.isNotBlank(test));
		System.out.println("test2 not blank? " + StringUtils.isNotBlank(test2));
		System.out.println("test3 not blank? " + StringUtils.isNotBlank(test3));
		System.out.println("test4 not blank? " + StringUtils.isNotBlank(test4));
		
		test = "This a test of the abbreviation.";
		test2 = "Test";
		System.out.println(StringUtils.abbreviate(test, 10));
		System.out.println(StringUtils.abbreviate(test2, 10));
		
		String message = "There was a palpable sense that the rest of the world " +
						"might, one day, cease to exist. In the midst of the " +
						"confusion-the absence of firm ground, - something would " +
						"fail to recover. The whole city is still, in a way, " +
						"holding it's breath, hoping the the worst has come and "+
						"gone.";
		
		int index = message.indexOf("ground");
		int offset = index -20;
		int width = 40 +12;
		
		String context = StringUtils.abbreviate(message,offset,width);
		System.out.println("The word 'ground' in context: " + context);
		
		
		String testArrayString = "One, Two Three, Four Five";
		String [] tokens = testArrayString.split("[' '', ']");
		System.out.println(ArrayUtils.toString(tokens));
		
		tokens = StringUtils.split(testArrayString," ,");
		System.out.println(ArrayUtils.toString(tokens));
		
		String htmlContent ="<html>\n" +
								"<head>\n"+
									"<title>Test Page</title>\n" +
								"</head>\n"+
								"<body>\n"+
									"<p>This is a TEST!</p>" +
								"</body>\n"+
							"<html>";
		String title = StringUtils.substringBetween(htmlContent, "<title>","</title>");
		System.out.println(title);
		
		String variables = "{45},{35},{120}";
		int sum = 0;
		tokens = StringUtils.split(variables,",");
		for(int i=0;i<tokens.length;i++) {
			String numberStr = StringUtils.substringBetween(tokens[i], "{", "}");
			Integer number = Integer.parseInt(numberStr);
			sum += number;
		}
		System.out.println("Variables: " + variables + ", sum : " + sum);
		
		
		String test1 = " \n\r Testing 1 2 3";
		test2 = " \r\n";
		String trimTest1 = StringUtils.trim(test1);
		
		String trimTest2 = StringUtils.trimToNull(test2);
		String trimTest3 = StringUtils.trim(test2);
		
		System.out.println(trimTest1);
		System.out.println(trimTest2);
		System.out.println(trimTest3);
		
		
		String original = "--------***---SHAZAM!---***--------";
		String stripped = StringUtils.strip(original,"-*");
		
		System.out.println("Stripped: " + stripped);
		
		String input = "hello\n";
		String chomped = StringUtils.chomp(input);
		System.out.println("chomped:" + chomped);
		System.out.println(createHeader("TEST"));
		
		String sentence = "I am Susan.";
		String reversed = reverseSentence(sentence);
		System.out.println(sentence);
		System.out.println(reversed);
		
		int dist = StringUtils.getLevenshteinDistance("Word", "World");
		String diff = StringUtils.difference("Word", "World");
		index = StringUtils.indexOfDifference("Word","World");
		
		System.out.println("Edit Distance:" +  dist);
		System.out.println("Difference:" +  diff);
		System.out.println("Diff Index:" + index);
		
	}
	
	private static String createHeader(String title) {
		int width = 30;
		String bg = "*";
		String stars =  StringUtils.repeat(bg, 30);
		String entered = StringUtils.center(title, width,bg);
		String heading =
				StringUtils.join(new Object[] {stars,entered,stars},"\n");
		return heading;
	}
	
	private static String reverseSentence(String sentence) {
		String reversed = StringUtils.removeEnd(sentence,".");
		reversed = StringUtils.reverseDelimited(reversed, ' ');
		reversed = reversed +".";
		return reversed;
	}
	
}
