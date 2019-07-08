package net.frank.corejava1.ch11;

public class ClassLoadTest {

	public static void main(String[] args) {
		String query = "select m.id,\n" +
				"\tm.reference_no AS referenceNo,\n" +
				"\tm.status,\n" +
				"\ts.company_chinese_name AS customerCompanyChName,\n" +
				"\ts.company_english_name AS customerCompanyEnName,\n" +
				"\ts.contact_email AS customerContactEmail,\n" +
				"\tm.rm_soeid AS rmSeoid,\n" +
				"\tm.rm_name AS rmName,\n" +
				"\tm.maker_soeid AS makerSeoid,\n" +
				"\tm.maker_name AS makerName,\n" +
				"\tm.checker_soeid AS checkerSeoid,\n" +
				"\tm.checker_name AS checkerName,\n" +
				"\tISNULL(n.notification_time, t.complate_date) AS baseCheckerTime\n" +
				"\tfrom(\n" +
				"select * from tbl_acc_opening_request \n" +
				"where del_flag='N' and status = 'STG3_CHECKLIST_GENERATED' and process_status='Processing') m\n" +
				"\tleft join tbl_acc_ser s on m.id = s.opening_request_id\n" +
				"\tleft join tbl_acc_opening_stage_timeline t on m.id = t.opening_request_id and \n" +
				"\t\tt.stage='STG2_SER_RAISED'\n" +
				"\tleft join tbl_acc_opening_status_notification n on \n" +
				"\t\tm.id = n.opening_request_id and n.stage='STG3_CHECKLIST_GENERATED'\n" +
				"where ISNULL(n.notification_time, t.complate_date)  < ?\n" +
				"\n" +
				"union \n" +
				"\n" +
				"select m.id,\n" +
				"\tm.reference_no AS referenceNo,\n" +
				"\tm.status,\n" +
				"\ts.company_chinese_name AS customerCompanyChName,\n" +
				"\ts.company_english_name AS customerCompanyEnName,\n" +
				"\ts.contact_email AS customerContactEmail,\n" +
				"\tm.rm_soeid AS rmSeoid,\n" +
				"\tm.rm_name AS rmName,\n" +
				"\tm.maker_soeid AS makerSeoid,\n" +
				"\tm.maker_name AS makerName,\n" +
				"\tm.checker_soeid AS checkerSeoid,\n" +
				"\tm.checker_name AS checkerName,\n" +
				"\tISNULL(n.notification_time, t.complate_date) AS baseCheckerTime\n" +
				"\tfrom(\n" +
				"select * from tbl_acc_opening_request \n" +
				"where del_flag='N' and status = 'STG5_SEND_TO_PBOC' and process_status='Processing') m\n" +
				"\tleft join tbl_acc_ser s on m.id = s.opening_request_id\n" +
				"\tleft join tbl_acc_opening_stage_timeline t on m.id = t.opening_request_id and \n" +
				"\t\tt.stage='STG4_PRE_DOC_RECEIVED'\n" +
				"\tleft join tbl_acc_opening_status_notification n on \n" +
				"\t\tm.id = n.opening_request_id and n.stage='STG5_SEND_TO_PBOC'\n" +
				"where ISNULL(n.notification_time, t.complate_date)  <  ? \n" +
				"\n" +
				"union\n" +
				"\n" +
				"select m.id,\n" +
				"\tm.reference_no AS referenceNo,\n" +
				"\tm.status,\n" +
				"\ts.company_chinese_name AS customerCompanyChName,\n" +
				"\ts.company_english_name AS customerCompanyEnName,\n" +
				"\ts.contact_email AS customerContactEmail,\n" +
				"\tm.rm_soeid AS rmSeoid,\n" +
				"\tm.rm_name AS rmName,\n" +
				"\tm.maker_soeid AS makerSeoid,\n" +
				"\tm.maker_name AS makerName,\n" +
				"\tm.checker_soeid AS checkerSeoid,\n" +
				"\tm.checker_name AS checkerName,\n" +
				"\tISNULL(n.notification_time, t.complate_date) AS baseCheckerTime\n" +
				"\tfrom(\n" +
				"select * from tbl_acc_opening_request \n" +
				"where del_flag='N' and status = 'STG8_SYS_SETUP' and process_status='Processing') m\n" +
				"\tleft join tbl_acc_ser s on m.id = s.opening_request_id\n" +
				"\tleft join tbl_acc_opening_stage_timeline t on m.id = t.opening_request_id and \n" +
				"\t\tt.stage='STG7_OBTAIN_PBOC_CERT'\n" +
				"\tleft join tbl_acc_opening_status_notification n on \n" +
				"\t\tm.id = n.opening_request_id and n.stage='STG8_SYS_SETUP'\n" +
				"where ISNULL(n.notification_time, t.complate_date)  < ?";
		
		
		System.out.println(query);
		
		
	}

}
