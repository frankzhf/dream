package net.frank.yangtes.modules.sys.security;

import java.util.Collection;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cas.CasAuthenticationException;
import org.apache.shiro.cas.CasRealm;
import org.apache.shiro.cas.CasToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.validation.Assertion;
import org.jasig.cas.client.validation.TicketValidationException;
import org.jasig.cas.client.validation.TicketValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.frank.yangtes.commons.config.Global;
import net.frank.yangtes.commons.web.Servlets;
import net.frank.yangtes.modules.sys.entity.Menu;
import net.frank.yangtes.modules.sys.entity.Role;
import net.frank.yangtes.modules.sys.entity.User;
import net.frank.yangtes.modules.sys.security.Principal;
import net.frank.yangtes.modules.sys.service.SystemService;
import net.frank.yangtes.modules.sys.utils.LogUtils;
import net.frank.yangtes.modules.sys.utils.UserUtils;

/***
 * properties file
 * 
 * cas.server.url=http://192.168.1.79:8280/cas
   cas.server.login.url=${cas.server.url}/login
   cas.server.logout.url=${cas.server.url}/logout
   cas.project.url=http://192.168.1.86:8080/suyuan
 * 
 * Cas spring configuration
 * 
 * <bean name="shiroFilterChainDefinitions" class="java.lang.String">
		<constructor-arg>
			<value>
				....
				....
				${adminPath}/logout = logout
				/shiro-cas = casLogout,casFilter
				${adminPath}/** = user,casLogout
				/** = casLogout
				...
			</value>
		</constructor-arg>
	</bean>
 * <bean id="casFilter" class="net.frank.yangtes.modules.sys.security.DefaultCasRealm">
		<!-- 配置验证错误时的失败页面 -->
		<property name="failureUrl" value="${cas.server.login.url}?service=${cas.project.url}/shiro-cas" />
		<property name="logoutUrl" value="${cas.server.logout.url}?service=${cas.project.url}/shiro-cas" />
		<property name="successUrl" value="${adminPath}/login" />
	</bean>
	<!-- 自定义的单点登出filter,用来清除项目自己的Session/登陆信息 -->
	<bean id="casLogoutFilter" class="net.frank.yangtes.modules.sys.security.DefaultCasLogoutFilter" />
	<bean id="logout" class="org.apache.shiro.web.filter.authc.LogoutFilter">
		<property name="redirectUrl"
			value="${cas.server.logout.url}?service=${cas.project.url}/shiro-cas" />
	</bean>
	
	<!-- 安全认证过滤器 -->
	<bean id="shiroFilter" class="org.apache.shiro.spring.web.ShiroFilterFactoryBean">
		<property name="securityManager" ref="securityManager" />
		<property name="loginUrl"
			value="${cas.server.login.url}?service=${cas.project.url}/shiro-cas" />
		<property name="unauthorizedUrl"
			value="${cas.server.login.url}?service=${cas.project.url}/shiro-cas" />
		<property name="successUrl" value="${adminPath}?login" />
		<property name="filters">
			<map>
				<!-- <entry key="entAuthc" value-ref="enterpriseAuthc" /> -->
				<entry key="casFilter" value-ref="casFilter" />
				<entry key="casLogout" value-ref="casLogoutFilter" />
				<entry key="logout" value-ref="logout" />
				<!-- <entry key="authc" value-ref="formAuthenticationFilter" /> -->
			</map>
		</property>
		<property name="filterChainDefinitions">
			<ref bean="shiroFilterChainDefinitions" />
		</property>
	</bean>
	
	
	<bean id="casRealm" class="com.linkdotter.cas.LdCasRealm">
		<property name="systemService" ref="systemService" />
		<property name="casServerUrlPrefix" value="${cas.server.url}" />
		<property name="casService" value="${cas.project.url}/shiro-cas" />
	</bean>

	<!-- 定义Shiro安全管理配置 -->
	<bean id="securityManager" class="org.apache.shiro.web.mgt.DefaultWebSecurityManager">
		<property name="realm" ref="casRealm" />
	...
	...
 * 
 * 
 * 
 * @author zhaofeng
 *
 */


public class DefaultCasRealm extends CasRealm {
	
	private final static Logger log = LoggerFactory.getLogger(DefaultCasRealm.class);
	
	private SystemService systemService;

	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}
	
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		log.debug("doGetAuthenticationInfo trigger");
		if(token == null){
			return null;
		}
		CasToken casToken = (CasToken) token;
		String ticket = (String) casToken.getCredentials();
		if(!org.apache.shiro.util.StringUtils.hasText(ticket)){
			return null;
		}
		TicketValidator ticketValidator = ensureTicketValidator();
		try {
			Assertion casAssertion = ticketValidator.validate(ticket, getCasService());
			AttributePrincipal casPrincipal = casAssertion.getPrincipal();
			String userId = casPrincipal.getName();
			String referenceId = "";
			if(casPrincipal.getAttributes().get("reference_id") != null)
				referenceId = casPrincipal.getAttributes().get("reference_id").toString();   
			log.debug("Validate ticket : {} in CAS server : {} to retrieve user : {}", new Object[] { ticket,
					getCasServerUrlPrefix(), userId });
			casToken.setUserId(userId);
			User user;
			if(StringUtils.isNotBlank(referenceId)){
				user = systemService.getUser(referenceId);
			}else{
				user = systemService.getUserByLoginName(userId);
			}
			casToken.setUserId(user.getLoginName());	
			return new SimpleAuthenticationInfo(new Principal(user, false), ticket,getName());  
		} catch (TicketValidationException e) {
			throw new CasAuthenticationException((new StringBuilder()).append("Unable to validate ticket [")
					.append(ticket).append("]").toString(), e);
		}
	}
	
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		log.debug("doGetAuthorizationInfo trigger");
		Principal principal = (Principal)principals.getPrimaryPrincipal();
		
		if (!Global.TRUE.equals(Global.getConfig("user.multiAccountLogin"))){
			Collection<Session> sessions = systemService.getSessionDao().getActiveSessions(true, principal, UserUtils.getSession());
			if (sessions.size() > 0){
				if (UserUtils.getSubject().isAuthenticated()){
					for (Session session : sessions){
						systemService.getSessionDao().delete(session);
					}
				}else{
					UserUtils.getSubject().logout();
					throw new AuthenticationException("msg:账号已在其它地方登录，请重新登录。");
				}
			}
		}
		User user = systemService.getUserByLoginName(principal.getLoginName());
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		List<Menu> list = UserUtils.getMenuList();
		for (Menu menu : list){
			if (StringUtils.isNotBlank(menu.getPermission())){
				// 添加基于Permission的权限信息
				for (String permission : StringUtils.split(menu.getPermission(),",")){
					info.addStringPermission(permission);
				}
			}
		}
		// 添加用户权限
		info.addStringPermission("user");
		// 添加用户角色信息
		for (Role role : user.getRoleList()){
			info.addRole(role.getEnname());
		}
		// 更新登录IP和时间
		systemService.updateUserLoginInfo(user);
		// 记录登录日志
		LogUtils.saveLog(Servlets.getRequest(), "系统登录");
		return info;
	}
}