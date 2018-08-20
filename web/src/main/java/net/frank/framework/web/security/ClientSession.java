package net.frank.framework.web.security;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.frank.commons.CommonConstants;
import net.frank.framework.bo.Account;
import net.frank.framework.bo.Group;
import net.frank.framework.bo.Privilege;
import net.frank.framework.bo.Resource;
import net.frank.framework.bo.Type;
import net.frank.framework.security.Session;

public class ClientSession implements Session, HttpSessionBindingListener {
	
	private transient Log log = LogFactory.getLog(this.getClass());
	
	private Integer loginType = LOGIN_TYPE_DEFAULT;
	private Integer status = STATUS_INITIAL;

	private String loginName;
	private String clientIP;
	private Date loginTime;
	private Date prevRequestTime;
	private String application;
	private String platform;

	private Account account;
	private String localCd;
	
	private Integer screenWith;
	private Integer screenHeight;

	private Group currentGroup;
	
	private HttpSession webSession;

	private Map<String, Object> attributes = new HashMap<String, Object>();
	
	
	public ClientSession(){
		
	}
			
	
	public ClientSession(String loginName, String clientIP) {
		this.loginName = loginName;
		this.clientIP = clientIP;
		this.setLoginTime(new Date());
	}

	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		log.debug("Call HttpSessionBindingListener.valueBound:" +arg0);
		//this.webSession = arg0.getSession();
		//SessionTableHolder.addClientSession(this);
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		log.debug("Call HttpSessionBindingListener.valueUnbound:"+arg0);
		//SessionTableHolder.remvoeClientSession(this.getLoginName(),this.getClientIP());
		//HttpSession httpSession = arg0.getSession();
		//if(httpSession!=null){
		//	try{
		//		httpSession.invalidate();
		//	}catch(IllegalStateException e){
		//		log.error(e.getMessage(),e);
		//	}
		//}
	}

	@Override
	public Integer getLoginType() {
		return loginType;
	}

	@Override
	public void setLocalCd(String localCd) {
		this.localCd = localCd;
	}

	@Override
	public String getLocalCd() {
		return localCd;
	}

	public void setLoginType(Integer loginType) {
		this.loginType = loginType;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getClientIP() {
		return clientIP;
	}

	public void setClientIP(String clientIP) {
		this.clientIP = clientIP;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	
	public Date getPrevRequestTime() {
		return prevRequestTime;
	}

	public void setPrevRequestTime(Date prevRequestTime) {
		this.prevRequestTime = prevRequestTime;
	}
	
	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}
	
	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Resource> getGroups() {
		List<Resource> list = (List<Resource>) attributes
				.get(CS_ATTRIBLE_GROUPS_KEY);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Privilege> getPrivileges() {
		List<Privilege> list = (List<Privilege>) attributes
				.get(CS_ATTRIBLE_PRIVILEGES_KEY);
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<Long, Type> getUserTypeMap() {
		Map<Long, Type> userTypeMap = (Map<Long, Type>) attributes
				.get(CS_ATTRIBLE_TYPES_KEY);
		return userTypeMap;
	}
	
	@SuppressWarnings("unchecked")
	public List<Type> getUserTypeList(){
		Map<Long, Type> userTypeMap = (Map<Long, Type>) attributes
				.get(CS_ATTRIBLE_TYPES_KEY);
		List<Type> rt = new ArrayList<Type>();
		if(userTypeMap!=null && !userTypeMap.isEmpty()){
			for(Iterator<Long> it=userTypeMap.keySet().iterator();it.hasNext();){
				Long key = it.next();
				rt.add(userTypeMap.get(key));
			}
		}
		return rt;
	}

	public Group getCurrentGroup() {
		return currentGroup;
	}

	public void setCurrentGroup(Group currentGroup) {
		this.currentGroup = currentGroup;
	}

	@Override
	public void setAttribute(String key, Object value) {
		attributes.put(key, value);
	}

	@Override
	public Object getAttribute(String key) {
		return attributes.get(key);
	}

	public Integer getScreenWith() {
		return screenWith;
	}

	public void setScreenWith(Integer screenWith) {
		this.screenWith = screenWith;
	}

	public Integer getScreenHeight() {
		return screenHeight;
	}

	public void setScreenHeight(Integer screenHeight) {
		this.screenHeight = screenHeight;
	}
	
	public HttpSession getWebSession(){
		return webSession;
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer(CommonConstants.SHORT_STRING_BUFFER_LENGTH);
		sb.append(super.toString()).append("[").append("\n");
		sb.append("\t").append("loginType:").append(getLoginType()).append("\n");
		sb.append("\t").append("clientIP:").append(getClientIP()).append("\n");
		sb.append("\t").append("status:").append(getStatus()).append("\n");
		sb.append("\t").append("webSession:").append(getWebSession()).append("]").append("\n");
		return sb.toString();
	}

}
