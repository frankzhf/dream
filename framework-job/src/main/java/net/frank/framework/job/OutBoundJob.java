package net.frank.framework.job;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.frank.commons.CommonConstants;
import net.frank.framework.job.generator.IPlaintextGenerator;
import net.frank.framework.job.model.DataColumn;
import net.frank.framework.job.model.DataRow;

public abstract class OutBoundJob extends AbstractJob {

	private List<DataRow> body = null;

	private int batchSize = 1000;

	private String outFilePath;

	public OutBoundJob(String outFilePath, int batchSize) {
		this.outFilePath = outFilePath;
		this.batchSize = batchSize;
	}

	public OutBoundJob(String outFilePath) {
		this(outFilePath, 1000);
	}

	@Override
	public void runJob() throws JobException {
		log.info("OutBoundJob start >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		if (checkRun()) {
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			BufferedWriter bw = null;
			FileWriter fw = null;
			int batchNumber = 0;
			try {
				conn = getConnection();
				ps = conn
						.prepareStatement(getQuerySql(),
								ResultSet.TYPE_FORWARD_ONLY,
								ResultSet.CONCUR_READ_ONLY);
				setPreparedStatementParameters(ps);
				rs = ps.executeQuery();
				body = new ArrayList<DataRow>();
				fw = new FileWriter(outFilePath);
				bw = new BufferedWriter(fw);
				log.info("\tProcess file Header Start >>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				processFileHeader(bw);
				log.info("\tProcess file Header End <<<<<<<<<<<<<<<<<<<<<<<<<<<<");
				while(rs.next()){
					processedNumPlus();
					productData(body,rs);
					if(body.size() == batchSize){
						batchNumber ++;
						log.info("\tProcess file body["+batchNumber+"|"+body.size()+"] Start >>>>>>>>>>>>>>>>>>>>>>>>>>>>");
						consumeData(body,bw);
						log.info("\tProcess file body["+batchNumber+"|"+body.size()+"] End <<<<<<<<<<<<<<<<<<<<<<<<<<<<");
						body.clear();
					}
				}
				if(body!=null && !body.isEmpty()){
					batchNumber ++;
					log.info("\tProcess file body["+batchNumber+"|"+body.size()+"] Start >>>>>>>>>>>>>>>>>>>>>>>>>>>>");
					consumeData(body,bw);
					log.info("\tProcess file body["+batchNumber+"|"+body.size()+"] End <<<<<<<<<<<<<<<<<<<<<<<<<<<<");
					body.clear();
				}
				log.info("\tProcess file Trailer Start >>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				processFileTrailer(bw);
				log.info("\tProcess file Trailer End <<<<<<<<<<<<<<<<<<<<<<<<<<<<");
				bw.flush();
				fw.flush();
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				throw new JobException(e);
			}finally{
				try{
					if(bw!=null){
						bw.close();
					}
					if(fw!=null){
						fw.close();
					}
					if(rs!=null){
						rs.close();
					}
					if(ps!=null){
						ps.close();
					}
					if(conn!=null){
						conn.close();
					}
				}catch(SQLException e){
					log.error(e.getMessage(),e);
					throw new JobException(e);
				}catch(IOException e){
					log.error(e.getMessage(),e);
					throw new JobException(e);
				}
			}
			end();
		}
		log.info("OutBoundJob end <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		
	}

	protected abstract String getQuerySql();

	protected abstract boolean checkRun();
	
	protected abstract void processFileHeader(BufferedWriter bw)throws IOException;
	
	protected abstract void processFileTrailer(BufferedWriter bw)throws IOException;
	
	protected void productData(List<DataRow> body,ResultSet rs) throws SQLException{
		DataRow dataRow = new DataRow();
		for(int i=0;i<rs.getMetaData().getColumnCount();i++){
			String key = rs.getMetaData().getColumnName(i+1);
			DataColumn dataColumn = new DataColumn();
			dataColumn.setColumnName(key);
			Object value = rs.getObject(key);
			if(value == null){
				value = CommonConstants.EMPTY_STRING;
			}
			dataColumn.setColumnValue(value.toString());
			dataRow.putColumn(dataColumn);
		}
		body.add(dataRow);
	}
	
	protected void consumeData(List<DataRow> body,BufferedWriter bw) throws JobException{
		IPlaintextGenerator generator = getGenerator();
		if(body!=null && !body.isEmpty()){
			for(int i=0;i<body.size();i++){
				DataRow dataRow = body.get(i);
				generator.processLine(dataRow, bw);
			}
		}
	}
	
	public abstract void setPreparedStatementParameters(PreparedStatement ps)
			throws SQLException;
	
	public abstract IPlaintextGenerator getGenerator();
	
	protected void end()throws JobException{
		
	}

}
