package net.frank.framework.web.security;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.frank.framework.security.Session;

public final class SessionTableHolder {
	
	private static Log log = LogFactory.getLog(SessionTableHolder.class);
	
	private static List<ClientSession> clientSessionList = new ArrayList<ClientSession>();
	
	protected final static void addClientSession(ClientSession clientSession) {
		synchronized (clientSessionList) {
			if(clientSession!=null && Session.STATUS_LOGINED.equals(clientSession.getStatus())){
				if(!clientSessionList.isEmpty()){
					for(Iterator<ClientSession> it=clientSessionList.iterator();it.hasNext();){
						ClientSession curr = it.next();
						if(curr!=null && clientSession.getLoginName().equals(curr.getLoginName()) 
								&& clientSession.getClientIP().equals(curr.getClientIP())){
							log.debug("remove clientSession :" + curr) ;
							HttpSession httpSession= curr.getWebSession();
							curr.setStatus(Session.STATUS_INITIAL);
							if(httpSession!=null){
								httpSession.setMaxInactiveInterval(0);
								httpSession.invalidate();
							}
							it.remove();
							break;
						}
					}
				}
				log.debug("add new  clientSession :" + clientSession) ;
				clientSessionList.add(clientSession);
			}
		}
	}
	
	protected final static void remvoeClientSession(String loginName,String clientIp){
		synchronized (clientSessionList) {
			for(Iterator<ClientSession> it=clientSessionList.iterator();it.hasNext();){
				ClientSession curr = it.next();
				if(loginName.equals(curr.getLoginName()) 
						&& clientIp.equals(curr.getClientIP())){
					log.debug("remove clientSession :" + curr) ;
					it.remove();
					break;
				}
			}
		}
	}
	
	public static List<ClientSession> getClientSessionList(){
		synchronized (clientSessionList) {
			return  clientSessionList;
		}
	}
	
	public static ClientSession getClientSession(String loginName,String clientIp){
		synchronized (clientSessionList) {
			for(Iterator<ClientSession> it=clientSessionList.iterator();it.hasNext();){
				ClientSession curr = it.next();
				if(loginName.equals(curr.getLoginName()) 
						&& clientIp.equals(curr.getClientIP())){
					return curr;
				}
			}
			return null;
		}
	}
}
