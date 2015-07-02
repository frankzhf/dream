package net.frank.android.util;

import java.util.ArrayList;

import net.frank.android.pinyin.HanziToPinyin;
import net.frank.android.pinyin.HanziToPinyin.Token;

public class PinYinUtil {
	public static String getPinYin(String input) {
		ArrayList<Token> tokens = HanziToPinyin.getInstance().get(input);
		StringBuilder sb = new StringBuilder();
		if (tokens != null && tokens.size() > 0) {
			for (Token token : tokens) {
				if (Token.PINYIN == token.type) {
					sb.append(token.target);
				} else {
					sb.append(token.source);
				}
			}
		}
		return sb.toString().toLowerCase();
	}
}
