package net.frank.dede;

import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import net.frank.commons.CommonConstants;
import net.frank.dede.bean.DedeAddonarticle;
import net.frank.framework.BaseTestCase;
import net.frank.framework.bo.BaseEntity;
import net.frank.framework.thin.Condition;
import net.frank.framework.thin.OrderBy;
import net.frank.framework.thin.SimpleQueryPage;
import net.frank.framework.ws.WsRenderProvider;

public final class TestSimpleQueryPageRender extends BaseTestCase {

	@Override
	public String[] getSpringConfig() {
		return new String[]{
				"classpath:applicationContext-base.xml",
				"classpath:applicationContext-datasource.xml",
				"classpath:applicationContext-dao.xml",
				"classpath:applicationContext-ws.xml"
		};
	}
	
	
	public void testInit(){
		logger.debug("Init success");
		SimpleQueryPage sqp = new SimpleQueryPage();
		sqp.setCurrentPage(1);
		sqp.setSize(10);
		sqp.setCount(-1);
		sqp.setMainQuerySql("select * from dede_addonarticle".toCharArray());
		sqp.setRowMapperName("net.frank.dede.rowmapper.DedeAddonarticleRowMapper");
		WsRenderProvider wsRenderProvider = (WsRenderProvider)getBean("wsRenderProvider");
		StringBuffer sb = new StringBuffer(CommonConstants.DEFAULT_STRING_BUFFER_LENGTH);
		sqp.setConditionList(new ArrayList<Condition>());
		sqp.setOrderByList(new ArrayList<OrderBy>());
		sqp.setResult(new ArrayList<BaseEntity>());
		Condition c1 = new Condition();
		c1.setColumnName("typeid");
		c1.setColumnType(Condition.COLUMN_TYPE_NUMBER);
		c1.setOperate(Condition.OPERATE_EQUAL);
		c1.setValue("11");
		sqp.getConditionList().add(c1);
		
		OrderBy o1 = new OrderBy();
		o1.setColumnName("aid");
		o1.setOrderStatus(OrderBy.ORDER_STATUS_DESC);
		sqp.getOrderByList().add(o1);
		
		DedeAddonarticle r1=new DedeAddonarticle();
		r1.setAid(77);
		r1.setTypeid(11);
		r1.setBody(new String("<html></html>").toCharArray());
		sqp.getResult().add(r1);
		long currTime = System.currentTimeMillis();
		System.out.println(currTime);
		wsRenderProvider.getWsRender(sqp.getClass().getName()).outputXml(sqp,"", sb);
		System.out.println(System.currentTimeMillis()-currTime);
		logger.info(sb.toString());
		
		
		Document document = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		StringReader sr = new StringReader(sb.toString());
		InputSource is = new InputSource(sr);
		try {
			builder = factory.newDocumentBuilder();
			document = builder.parse(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (document != null) {
			SimpleQueryPage rsqp = new SimpleQueryPage();
			wsRenderProvider.getWsRender(rsqp.getClass().getName()).setProperty(rsqp, document.getDocumentElement());
			System.out.println(System.currentTimeMillis()-currTime);
			logger.info(rsqp);
		}
	}
}
