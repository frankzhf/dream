package net.frank.corejava0.jakarta.ch02;

import org.apache.commons.lang3.text.WordUtils;

public class WordUtilsSample {

	public static void main(String[] args) {
		String message = "One Two Three Four Five";
		String wappedString = WordUtils.wrap(message, 20,"\n",false);
		System.out.println(wappedString);
	}

}
