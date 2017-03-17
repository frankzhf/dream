package net.frank.titian.base;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import net.frank.titian.define.AccountInfo;
import net.frank.titian.util.PoiUtil;

public class SpringExcelBatchContext extends AbstractBatchContext {
	
	private String userExcelStorePath;

	public void setUserExcelStorePath(String userExcelStorePath) {
		this.userExcelStorePath = userExcelStorePath;
	}
	
	@Override
	public void fillData(String retailerId) {
		
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(userExcelStorePath);
		HSSFWorkbook workbook = null;
		try{
			workbook = new HSSFWorkbook(is);
		}catch(IOException e){
			throw new RuntimeException(e.getMessage(),e);
		}
		if(StringUtils.isBlank(retailerId)){
			int sheetCount = workbook.getNumberOfSheets();
			for(int i=0;i<sheetCount;i++){
				increaseRetailer();
				HSSFSheet sheet = workbook.getSheetAt(i);
				getAccountInfoList().addAll(getAccountInfoFormSheet(sheet));
			}
		}else{
			increaseRetailer();
			HSSFSheet sheet = workbook.getSheet(retailerId);
			getAccountInfoList().addAll(getAccountInfoFormSheet(sheet));
		}
	}
	
	
	private List<AccountInfo> getAccountInfoFormSheet(HSSFSheet sheet) {
		List<AccountInfo> userList = new ArrayList<AccountInfo>();
		for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
			HSSFRow row = sheet.getRow(rowIndex);
			if (row == null) {
				break;
			}
			if (!"Y".equalsIgnoreCase(PoiUtil.getCellValue(row.getCell(2)))) {
				continue;
			}
			AccountInfo user = new AccountInfo();
			user.setRetailerId(sheet.getSheetName());
			user.setLoginId(PoiUtil.getCellValue(row.getCell(0)));
			user.setPassword(PoiUtil.getCellValue(row.getCell(1)));
			/***
			if (Constants.RETAILER_HUALIAN.equals(sheet.getSheetName())) {
                String cityName = getCellValueAsStr(row.getCell(3));
                String storeType = getCellValueAsStr(row.getCell(4));
                String urlKey = cityName+storeType;
                user.setUrl(Utils.getHualianURLByID(urlKey));
				user.setDistrict(getCellValueAsStr(row.getCell(5)));
				user.setAgency(getCellValueAsStr(row.getCell(6)));
				user.setLoginNm(getCellValueAsStr(row.getCell(7)));
				user.setStoreNo(getCellValueAsStr(row.getCell(8)));
			}
			if (Constants.RETAILER_YONGHUI.equals(sheet.getSheetName())) {
				user.setDistrict(getCellValueAsStr(row.getCell(3)));
			}
			***/
			userList.add(user);
		}
		return userList;
	}

}
