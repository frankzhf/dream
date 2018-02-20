package net.frank.corejava0.desginpattern.interpreter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		String runtimeDir = 
				Main.class.getResource("/").getFile();
		try(
			
			BufferedReader reader = new BufferedReader(new FileReader(
					runtimeDir+"net/frank/corejava0/desginpattern/interpreter/program.txt"));
		){
			String text;
			while((text = reader.readLine()) != null) {
				System.out.println("text = \"" +text + "\"");
				Node node = new ProgramNode();
				node.parse(new Context(text));
				System.out.println("Node= " +node);
			}
		}catch(IOException |ParseException e) {
			System.err.println(e.getMessage());
		}
	}

}
