package net.frank.titian.retailer.action.carrefour;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import net.frank.titian.base.AbstractAnt;
import net.frank.titian.define.AccountInfo;
import net.frank.titian.define.AntResult;
import net.frank.titian.define.BatchContext;
import net.frank.titian.define.Constants;
import net.frank.titian.util.OcrUtil;

public class LoginAction extends AbstractAnt {
	
	private int retryTime = 10;
	
	public int getRetryTime(){
		return retryTime;
	}
	
	public void setRetryTime(int retryTime){
		this.retryTime = retryTime;
	}
	
	private static final String VILD_CODE_SERVICE_URL = "https://supplierweb.carrefour.com/includes/image.jsp";

	@Override
	public AntResult process(CloseableHttpClient client, AccountInfo accountInfo, Properties retailerProperties ,BatchContext context) {
		AntResult result = new AntResult();
		//String storage = context.getStorage();
		
		File _workspace = new File(workspace);
		if(!_workspace.exists()){
			_workspace.mkdirs();
		}
		
		File _ocr = new File(_workspace, "ocr");
		if (!_ocr.exists()) {
			_ocr.mkdirs();
		}
		HttpGet httpGet = new HttpGet(VILD_CODE_SERVICE_URL);
		int times = 0;
		do{
			times++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				log.error(e.getMessage(),e);
			}
			log.debug("Try " + times + " Ocr and login");
			String imgName = String.valueOf(System.currentTimeMillis());
			File _ocrImageFile = new File(_ocr, imgName + ".jpg");
			try {
				if (!_ocrImageFile.exists()) {
					_ocrImageFile.createNewFile();
				}
				FileOutputStream fos = new FileOutputStream(_ocrImageFile);
				CloseableHttpResponse response = client.execute(httpGet);
				HttpEntity entity = response.getEntity();
				entity.writeTo(fos);
				response.close();
				fos.close();
			} catch (IOException e) {
				result.setStatus(Constants.ACTION_RESULT.FAILURE);
				result.setContent(e.getMessage());
				return result;
			}
			String recognizeStr = OcrUtil.recognizeText(_ocrImageFile.getPath(), _ocr.getPath() +File.separator+ imgName, true);
			HttpPost httppost = null;
			try {
				List<NameValuePair> formParams = new ArrayList<NameValuePair>();
				formParams.add(new BasicNameValuePair("login", accountInfo.getLoginId()));
				formParams.add(new BasicNameValuePair("password", accountInfo.getPassword())); // 错误的密码
				formParams.add(new BasicNameValuePair("validate", recognizeStr));
				HttpEntity loginEntity = new UrlEncodedFormEntity(formParams, "UTF-8");
				httppost = new HttpPost("https://supplierweb.carrefour.com/login.do?action=doLogin");
				httppost.setEntity(loginEntity);
				CloseableHttpResponse loginResponse = client.execute(httppost);
				String responseStr = EntityUtils.toString(loginResponse.getEntity());
	            if (responseStr == null) {
	            	log.error(accountInfo + "网站登录出错,退出!");
	            	result.setStatus(Constants.ACTION_RESULT.FAILURE);
	    			result.setContent(accountInfo + "网站登录出错,退出!");
	                return result;
	            }if (responseStr.contains("验证码失效")) {
	                log.error(accountInfo + "验证码失效,Relogin...");
	                result.setStatus(Constants.ACTION_RESULT.FAILURE);
	    			result.setContent(accountInfo + "验证码失效,Relogin...");
	           
	            } else if (responseStr.contains("错误的密码")) {
	                log.error(accountInfo + "错误的密码,退出!");
	                result.setStatus(Constants.ACTION_RESULT.FAILURE);
	    			result.setContent(accountInfo + "错误的密码,退出!");
	                return result;
	            } else if (responseStr.contains("错误的用户名")) {
	                log.error(accountInfo + "错误的用户名,退出!");
	                result.setStatus(Constants.ACTION_RESULT.FAILURE);
	    			result.setContent(accountInfo + "错误的用户名,退出!");
	                return result;
	            } else if (responseStr.contains("系统出错") || !responseStr.contains("Welcome")) {
	                log.error(accountInfo + "网站登录出错,退出!");
	                result.setStatus(Constants.ACTION_RESULT.FAILURE);
	    			result.setContent(accountInfo + "网站登录出错,退出!");
	                return result;
	            }else{
		            loginResponse.close();
		            log.info(accountInfo + "登录成功!");
		            result.setStatus(Constants.ACTION_RESULT.SUCCESS);
		            return result;
	            }
			} catch (UnsupportedEncodingException e) {
				log.error(e.getMessage());
				result.setStatus(Constants.ACTION_RESULT.FAILURE);
				result.setContent(e.getMessage());
				return result;
			} catch (ClientProtocolException e) {
				log.error(e.getMessage());
				result.setStatus(Constants.ACTION_RESULT.FAILURE);
				result.setContent(e.getMessage());
				return result;
			} catch (IOException e) {
				log.error(e.getMessage());
				result.setStatus(Constants.ACTION_RESULT.FAILURE);
				result.setContent(e.getMessage());
				return result;
			}
		}while(result.getContent().contains("验证码失效,Relogin...") && times <=retryTime);
		return result;
	}

	@Override
	public boolean check() {
		return true;
	}

	@Override
	public String getOperateId() {
		return "login";
	}
}
