package net.frank.titian.test.mengnui.trigger;

import net.frank.titian.define.Batch;
import net.frank.titian.test.mengnui.runtime.MengniuBatch;

public class MainTrigger {
	public static void main(String[] args){
		Batch batch = new MengniuBatch();
		batch.mainFlow("carrefour");
	}
}
