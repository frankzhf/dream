package net.frank.framework.job.parser;

import net.frank.framework.job.JobException;
import net.frank.framework.job.model.DataRow;

public interface IPlaintextParser {
	public void processLine(String line, DataRow dataRow) throws JobException;
}
