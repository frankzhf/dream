package net.frank.android.util;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Color;

public class ColorUtil {
	private static List<Integer> colorList= null;
	public static List<Integer> getUsuallyColorList() {
		if(colorList == null){
			colorList = new ArrayList<Integer>();
			colorList.add(Color.RED);
			colorList.add(Color.GREEN);
			colorList.add(Color.BLUE);
			colorList.add(Color.YELLOW);
			colorList.add(Color.CYAN);
			colorList.add(Color.MAGENTA);
			colorList.add(Color.DKGRAY);
			colorList.add(Color.GRAY);
			colorList.add(Color.LTGRAY);
			colorList.add(Color.TRANSPARENT);
		}
		return colorList;
	}
}
