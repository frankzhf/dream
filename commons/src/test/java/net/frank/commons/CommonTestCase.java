package net.frank.commons;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import junit.framework.TestCase;

public class CommonTestCase extends TestCase {
	
	protected transient Logger log = LoggerFactory.getLogger(getClass());
	@Test
	public final void testFunctuion(){
		log.debug("Call CommonTestCase.TestFunctuion()");
	}
}
