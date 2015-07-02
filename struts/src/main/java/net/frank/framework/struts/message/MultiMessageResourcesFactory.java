package net.frank.framework.struts.message;

import org.apache.struts.util.MessageResources;
import org.apache.struts.util.MessageResourcesFactory;

public class MultiMessageResourcesFactory extends MessageResourcesFactory {

	private static final long serialVersionUID = 2551048833881935738L;

	@Override
	public MessageResources createResources(String config) {
		return new MultiMessageResources(this, config,this.returnNull);
	}

}
