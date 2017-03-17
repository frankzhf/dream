package net.frank.titian.test.mengnui.action.carrefour;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import net.frank.titian.base.AbstractAnt;
import net.frank.titian.define.AccountInfo;
import net.frank.titian.define.AntResult;
import net.frank.titian.define.BatchContext;
import net.frank.titian.define.Constants;

public class OrderAction extends AbstractAnt {
	
	public static final String url = "https://platform.powere2e.com/platform/mailbox/openInbox.htm?";
	
	@Override
	public boolean check() {
		return true;
	}

	@Override
	public AntResult process(CloseableHttpClient client, AccountInfo accountInfo,Properties retailerProperties, BatchContext Context) {
		AntResult result = new AntResult();
		HttpGet httpGet = null;
		HttpPost searchPost = null;
		HttpGet httpOrderGet = null;
		try {
			httpGet = new HttpGet("https://supplierweb.carrefour.com/callSSO.jsp");
			CloseableHttpResponse response = client.execute(httpGet);
			HttpEntity entity = response.getEntity();
			String entityStr = EntityUtils.toString(entity);
			response.close();
			if (entityStr.contains("Error您访问的页面出错")) {
				log.error(accountInfo + "订单查询页面加载出错,可能无权限访问");
            	result.setStatus(Constants.ACTION_RESULT.FAILURE);
    			result.setContent(accountInfo + "订单查询页面加载出错,可能无权限访问");
                return result;
			}
			if (!entityStr.contains("PowerE2E Platform")) {
				log.error(accountInfo + "订单查询页面加载出错,cannot forward to PowerE2E Platform");
				result.setStatus(Constants.ACTION_RESULT.FAILURE);
				result.setContent(accountInfo + "订单查询页面加载出错,cannot forward to PowerE2E Platform");
                return result;
			}
			File _workspace = new File(workspace);
			if(!_workspace.exists()){
				_workspace.mkdirs();
			}
			try{
				Thread.sleep(Long.decode(retailerProperties.getProperty("sleep.time")));
			}catch(InterruptedException e){
				log.error(e.getMessage(),e);
			}
			
			String startDate = retailerProperties.getProperty("daterange.start.date");
			String endDate = retailerProperties.getProperty("daterange.end.date");
			
			
			
			List<NameValuePair> searchformParams = new ArrayList<NameValuePair>();
            searchformParams.add(new BasicNameValuePair("receivedDateFrom", startDate)); // "01-12-2013"
            searchformParams.add(new BasicNameValuePair("receivedDateTo", endDate));
            HttpEntity searchFormEntity = new UrlEncodedFormEntity(searchformParams, "UTF-8");
            searchPost = new HttpPost(url);
            searchPost.setEntity(searchFormEntity);
            CloseableHttpResponse searchRes = client.execute(searchPost);
            String responseStr = EntityUtils.toString(searchRes.getEntity());
            searchRes.close();
			
            Document doc = Jsoup.parse(responseStr);
            Element mailboxForm = doc.select("form[name=mailboxForm]").first();
            Element table = mailboxForm.select("table").first();
            String recordStr = table.select("tr[align=right]").select("td").get(0).text();
            if (recordStr == null || recordStr.equals("")) {
                log.info(accountInfo + "订单收件箱日期" + startDate+"-" + endDate + "记录为 0");
                result.setStatus(Constants.ACTION_RESULT.SUCCESS);
                result.setContent(accountInfo + "订单收件箱日期" + startDate+"-" + endDate + "记录为 0");
                return result;
            }
            recordStr = recordStr.substring(recordStr.indexOf("共") + 1, recordStr.indexOf("记"));
            recordStr = recordStr.replaceAll(",", "");
            int record = Integer.parseInt(recordStr);
            int page = record % 10 > 0 ? record / 10 + 1 : record / 10;
            log.info(accountInfo + "订单收件箱" + "查询到日期: " + startDate+"-" + endDate + ",共有" + record + "笔订单");
            Elements msgIds = doc.select("input[name=msgId]");
            List<String> msgIdList = new ArrayList<String>();
            for (Element msgId : msgIds) {
                msgIdList.add(msgId.attr("value"));
            }
            while (page > 1) {
            	try{
    				Thread.sleep(Long.decode(retailerProperties.getProperty("sleep.time")));
    			}catch(InterruptedException e){
    				log.error(e.getMessage(),e);
    			}
            	searchPost = new HttpPost("https://platform.powere2e.com/platform/mailbox/navigateInbox.htm?gotoPage="
                         + page);
            	searchRes = client.execute(searchPost);
                responseStr = EntityUtils.toString(searchRes.getEntity());
                
                searchRes.close();
                doc = Jsoup.parse(responseStr);
                msgIds = doc.select("input[name=msgId]");
                for (Element msgId : msgIds) {
                    msgIdList.add(msgId.attr("value"));
                }
                page --;
            }
			
            for (String msgId : msgIdList) {
            	log.info(accountInfo + "订单收件箱 - 订单ID ：" + msgId);
            	try{
    				Thread.sleep(Long.decode(retailerProperties.getProperty("sleep.time")));
    			}catch(InterruptedException e){
    				log.error(e.getMessage(),e);
    			}
                httpOrderGet = new HttpGet(
                        "https://platform.powere2e.com/platform/mailbox/performDocAction.htm?actionId=1&guid=" + msgId);
                CloseableHttpResponse orderRes = client.execute(httpOrderGet);
                String orderDetail = EntityUtils.toString(orderRes.getEntity());
                orderRes.close();
                if (!orderDetail.contains("Carrefour Purchase Order")) {
                    continue;
                }
                File content = new File( _workspace,msgId + ".html" );
                RandomAccessFile rf = new RandomAccessFile(content,"rw");
                rf.writeUTF(orderDetail);
                rf.close();
            }
		} catch (IOException e) {
			result.setStatus(Constants.ACTION_RESULT.FAILURE);
			result.setContent(e.getMessage());
			return result;
		}
		return result;
	}

	@Override
	public String getOperateId() {
		return "order_sendbox";
	}
}
