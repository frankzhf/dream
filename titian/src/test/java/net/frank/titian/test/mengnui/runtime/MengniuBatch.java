package net.frank.titian.test.mengnui.runtime;

import net.frank.titian.base.AbstractSQLiteBatch;
import net.frank.titian.define.BatchContext;
import net.frank.titian.test.mengnui.context.MengniuContext;

public class MengniuBatch extends AbstractSQLiteBatch {

	@Override
	public BatchContext prepare(String retailerId) {
		MengniuContext context = new MengniuContext();
		context.fillData(retailerId);
		return context;
	}

	@Override
	public void hook(BatchContext context) {
		// TODO Auto-generated method stub

	}

}
