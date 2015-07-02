package net.frank.framework;

import java.io.FileWriter;

public class BatchInsertTestData {
	//private static final String PREFFIX_PRIMARY_KEY = "a3d65f30a5c81e97a5c7a5cbf";
	
	private static String INSERT_SQL_0 = "INSERT INTO TBL_SR_MAST("+
			"SR_ID,SR_NO,OU_ID,NATURE_ID,STATUS_CODE,PROCESS_INSTANCE_ID,"+
			"CREATED_BY,CREATED_DT,UPDATED_BY,UPDATED_DT,SR_DESC,ASSIGNED_TO,"+
			"EXP_START_DT,EXP_DUE_DT,SLA_EXEMPT_FLAG,SLA_EXEMPT_REASON,TYPE_OF_REQ_ID)"+
			"VALUES('4a3d65f30a5c81e97a5c7a5cbf";
	private static String quot = "'";
	private static String comma = ",";
	private static String subtraction = "-";
	
	private static String SR_NO_PRE = "QMS-HR-";
	
	private static String ONE_DAY = "20130624";
	private static String TWO_DAY = "20130625";
	
	
	//4a3d65f30a5c81e97a5c7a5cbf000000','QMS-HR-20130624-0001','03e3a0a1c0a8aaa600b6ba69200cd492','Normal','CLOSED',NULL,
	//		'DEF-user-beelay',GETDATE(),NULL,NULL,NULL,NULL,
	//		NULL,NULL,NULL,NULL,'req-type-process');
	
	
	public static void main(String[] args)throws Exception{
		
		FileWriter fw = new FileWriter("d:/temp/insert.sql");
		
		StringBuffer sb = null;
		
		int sin = 0;
		int dou = 0;
		
		//int i= 0;
		for(int i=0;i<18000;i++){
			sb = new StringBuffer(1024);
			String pk_suffix = Integer.toHexString(i);
			String fullPkSuffix = toFixSixBit(pk_suffix);
			sb.append(INSERT_SQL_0).append(fullPkSuffix).append(quot).append(comma);
			if(i%2==0){
				sb.append(quot).append(SR_NO_PRE).append(ONE_DAY).append(subtraction).append(toFixFourBit((""+sin++))).append(quot).append(comma);
			}else{
				sb.append(quot).append(SR_NO_PRE).append(TWO_DAY).append(subtraction).append(toFixFourBit((""+dou++))).append(quot).append(comma);
			}
			sb.append("'03e3a0a1c0a8aaa600b6ba69200cd492',").
				append("'Normal',").
				append("'CLOSED',").
				append("NULL,").
				append("'DEF-user-beelay',").
				append("GETDATE(),").
				append("NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,").
				append("'req-type-process');\n");
			fw.write(sb.toString());
		}
		fw.flush();
		fw.close();
		//}
	}
	
	private static String toFixSixBit(String value){
		if(value.length()<6){
			StringBuffer sb = new StringBuffer(6);
			for(int i=0;i<6-value.length();i++){
				sb.append("0");
			}
			sb.append(value);
			return sb.toString();
		}
		return value;
	} 
	
	private static String toFixFourBit(String value){
		if(value.length()<4){
			StringBuffer sb = new StringBuffer(6);
			for(int i=0;i<4-value.length();i++){
				sb.append("0");
			}
			sb.append(value);
			return sb.toString();
		}
		return value;
	} 
	
}
