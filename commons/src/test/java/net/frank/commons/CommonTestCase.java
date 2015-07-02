package net.frank.commons;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import junit.framework.TestCase;

public class CommonTestCase extends TestCase {
	
	protected transient Log log = LogFactory.getLog(getClass());
	@Test
	public final void testFunctuion(){
		log.debug("Call CommonTestCase.TestFunctuion()");
	}
}
