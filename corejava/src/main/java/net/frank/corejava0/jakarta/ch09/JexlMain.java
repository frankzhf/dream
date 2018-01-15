package net.frank.corejava0.jakarta.ch09;

import java.util.ArrayList;

import org.apache.commons.jexl3.JexlBuilder;
import org.apache.commons.jexl3.JexlContext;
import org.apache.commons.jexl3.JexlEngine;
import org.apache.commons.jexl3.JexlExpression;
import org.apache.commons.jexl3.MapContext;

public class JexlMain {
	
	public static void main(String[] args) {
		Opera opera = new Opera();
		opera.setName("The Magic Flute");
		opera.setComposer("Mozart");
		opera.setYear(1791);
		opera.setActs(new ArrayList<String>(2));
		
		String expr = "`${opera.getName()} was composed by ${opera.getComposer()} in ${opera.getYear()}" +
				"This opera has ${opera.getActs().size()} acts.`";
		
		JexlEngine jexl = new JexlBuilder().create();
	    
	    // Create an expression
	    JexlExpression e = jexl.createExpression( expr );
	    JexlContext jc = new MapContext();
	    jc.set("opera", opera );
	    
	    // Now evaluate the expression, getting the result
	    Object o = e.evaluate(jc);
	    System.out.println(o);
	}
}