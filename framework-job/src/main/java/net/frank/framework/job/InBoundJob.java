package net.frank.framework.job;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.frank.framework.job.model.DataRow;
import net.frank.framework.job.parser.IPlaintextParser;

public abstract class InBoundJob extends AbstractJob {

	private Map<String, Object> jobContext;

	private List<DataRow> body;

	private int processSize = 1000;

	private String inFilePath;

	public InBoundJob(String inFilePath, int processSize) {
		this.inFilePath = inFilePath;
		this.processSize = processSize;
	}

	public InBoundJob(String inFilePath) {
		this(inFilePath, 1000);
	}

	@Override
	protected void runJob() throws JobException {
		log.info("InBoundJob start >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		if (checkRun()) {
			Connection conn = null;
			PreparedStatement ps = null;
			BufferedReader br = null;
			FileReader fr = null;
			int batchNum = 0;
			try {
				fr = new FileReader(inFilePath);
				br = new BufferedReader(fr);
				String line = null;
				body = new ArrayList<DataRow>();
				conn = getConnection();
				ps = conn.prepareStatement(getExecuteSql());
				while ((line = br.readLine()) != null) {
					processedNumPlus();
					if (line.startsWith(getHeaderFlag())) {
						log.info("\tProcess file Header Start >>>>>>>>>>>>>>>>>>>>>>>>>>>>");
						parserHeader(jobContext, line);
						log.info("\tProcess file Header End <<<<<<<<<<<<<<<<<<<<<<<<<<<<");
					} else if (line.startsWith(getTrailerFlag())) {
						log.info("\tProcess file Trailer Start >>>>>>>>>>>>>>>>>>>>>>>>>>>>");
						parserTrailer(jobContext, line);
						log.info("\tProcess file Trailer End <<<<<<<<<<<<<<<<<<<<<<<<<<<<");
					} else {
						productData(jobContext, body, line);
						if (body.size() == processSize) {
							batchNum++;
							log.info("\tProcess file body[" + batchNum + "|"
									+ body.size()
									+ "] Start >>>>>>>>>>>>>>>>>>>>>>>>>>>>");
							consumeData(ps, jobContext, body);
							log.info("\tProcess file body[" + batchNum + "|"
									+ body.size()
									+ "] End <<<<<<<<<<<<<<<<<<<<<<<<<<<<");
							body.clear();
						}
					}
				}
				if (body != null && !body.isEmpty()) {
					batchNum++;
					log.info("\tProcess file body[" + batchNum + "|"
							+ body.size()
							+ "] Start >>>>>>>>>>>>>>>>>>>>>>>>>>>>");
					consumeData(ps, jobContext, body);
					log.info("\tProcess file body[" + batchNum + "|"
							+ body.size()
							+ "] End <<<<<<<<<<<<<<<<<<<<<<<<<<<<");
					body.clear();
				}

			} catch (Exception e) {
				log.error(e.getMessage(), e);
				throw new JobException(e);
			} finally {
				try {
					if (br != null) {
						br.close();
					}
					if (fr != null) {
						fr.close();
					}
				} catch (IOException e) {
					log.error(e.getMessage(), e);
				}
			}
		}
		end();
		log.info("InBoundJob end <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	}

	protected void end() throws JobException {

	}

	public abstract boolean checkRun();

	public abstract String getExecuteSql();

	public abstract String getHeaderFlag();

	public abstract String getTrailerFlag();

	public abstract String parserHeader(Map<String, Object> jobContext,
			String line) throws JobException;

	public abstract String parserTrailer(Map<String, Object> jobContext,
			String line) throws JobException;

	public abstract IPlaintextParser getParser();

	public abstract void setPrepareStatementParameters(PreparedStatement ps,
			Map<String, Object> jobContext, DataRow dataRow)
			throws SQLException;

	protected void productData(Map<String, Object> jobContext,
			List<DataRow> body, String line) throws JobException {
		DataRow dataRow = new DataRow();
		IPlaintextParser parser = getParser();
		parser.processLine(line, dataRow);
		body.add(dataRow);
	}

	protected void consumeData(PreparedStatement ps,
			Map<String, Object> jobContext, List<DataRow> body)
			throws JobException {
		try {
			if (body != null && !body.isEmpty()) {
				for (int i = 0; i < body.size(); i++) {
					DataRow dataRow = body.get(i);
					setPrepareStatementParameters(ps,jobContext,dataRow);
					ps.addBatch();
				}
				ps.execute();
			}
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new JobException(e);
		}
	}

}
