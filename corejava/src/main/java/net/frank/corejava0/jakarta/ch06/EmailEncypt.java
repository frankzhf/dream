package net.frank.corejava0.jakarta.ch06;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.digester.Digester;
import org.apache.commons.digester.Rule;
import org.apache.commons.lang3.StringUtils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class EmailEncypt {

	public static void main(String[] args) {
		Message message = new Message();
		message.setText("Hello World");
		System.out.println("Initial Message: " + message.getText());
		
		InputStream encrypt = EmailEncypt.class.getResourceAsStream("./encrypt.xml");
		Digester digester = new Digester();
		digester.addRule("*/email", new EmailRule());
		digester.addRule("*/lower", new LowerRule());
		digester.addRule("*/reverse", new ReverseRule());
		digester.addRule("*/replace", new ReplaceRule());
		
		digester.push(message);
		try {
			digester.parse(encrypt);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Resulting Message: " + message.getText());
		
	}

}

class Message{
	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}

class LowerRule extends Rule{
	public LowerRule() {
		super();
	}
	
	public void body(String namespace, String name, String text)throws Exception{
		Message message = (Message) digester.getRoot();
		String lower = StringUtils.lowerCase(message.getText());
		message.setText(lower);
	}
}

class ReplaceRule extends Rule{
	public ReplaceRule() {
		super();
	}
	
	public void begin(Attributes attributes) throws Exception{
		Message message = (Message) digester.getRoot();
		String repl = attributes.getValue("search");
		String with = attributes.getValue("replace");
		String text = message.getText();
		String translated = 
				StringUtils.replace(text, repl, with);
		message.setText(translated);
	}
}

class EmailRule extends Rule{
	private String to;
	private String from;
	public EmailRule() {
		super();
	}
	public void begin(Attributes attributes) throws Exception{
		from = attributes.getValue("from");
		System.out.println("from=" +from);
		to= attributes.getValue("to");
		System.out.println("to=" +to);
	}
	
	public void end() throws Exception {}
}

class ReverseRule extends Rule{
	public ReverseRule() {
		super();
	}
	
	public void body(String namespace, String name, String text)throws Exception{
		Message message = (Message) digester.getRoot();
		String reverse = StringUtils.reverse(message.getText());
		message.setText(reverse);
	}
	
}
