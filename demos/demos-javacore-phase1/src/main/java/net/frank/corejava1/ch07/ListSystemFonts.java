package net.frank.corejava1.ch07;

import java.awt.GraphicsEnvironment;
import java.util.Arrays;

public class ListSystemFonts {

	public static void main(String[] args) {
		String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		System.out.println(Arrays.toString(fontNames));
	}

}
