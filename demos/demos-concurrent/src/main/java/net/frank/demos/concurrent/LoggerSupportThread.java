package net.frank.demos.concurrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerSupportThread extends Thread {
	protected transient Logger log = LoggerFactory.getLogger(getClass());
}
