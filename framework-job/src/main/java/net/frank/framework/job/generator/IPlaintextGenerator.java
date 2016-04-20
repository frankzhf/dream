package net.frank.framework.job.generator;

import java.io.BufferedWriter;

import net.frank.framework.job.JobException;
import net.frank.framework.job.model.DataRow;

public interface IPlaintextGenerator {
	public void processLine(DataRow dataRow, BufferedWriter bw)
			throws JobException;
}
