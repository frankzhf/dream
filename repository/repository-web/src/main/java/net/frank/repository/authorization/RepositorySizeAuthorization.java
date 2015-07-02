package net.frank.repository.authorization;

import net.frank.commons.CommonConstants;
import net.frank.framework.bo.Limit;
import net.frank.framework.bo.Resource;
import net.frank.framework.security.Authorization;
import net.frank.framework.security.Session;
import net.frank.framework.service.QueryService;

public class RepositorySizeAuthorization implements Authorization {

	public static final String REPO_CAPACITY_KEY = "REPO_CAPACITY";

	private static final String PERSON_REPOSITORY_SIZE_ALAIS = "PERSON_REPOSITORY_SZIE";

	private QueryService queryService;

	public void setQueryService(QueryService queryService) {
		this.queryService = queryService;
	}

	@Override
	public void exec(Session session) {
		if (Session.STATUS_LOGINED.equals(session.getStatus())) {
			Resource home = session.getAccount().getHome$3();
			Resource configRes = queryService.getResource(home.getId(),
					CommonConstants.CONTEXT.ACCOUNT.CONFIG);
			if(configRes !=null){
				Resource prsaRes = queryService.getResource(configRes.getId(),
						PERSON_REPOSITORY_SIZE_ALAIS);
				if(prsaRes!=null){
					Limit personRepositryLimit = (Limit)queryService.getBo(prsaRes);
					session.setAttribute(REPO_CAPACITY_KEY, personRepositryLimit);
				}else{
					Limit zeroLimit = new Limit();
					zeroLimit.setLimitName(PERSON_REPOSITORY_SIZE_ALAIS);
					zeroLimit.setLimitValue(0L);
					zeroLimit.setCurrentValue(0L);
					session.setAttribute(REPO_CAPACITY_KEY, zeroLimit);
				}
			}else{
				Limit zeroLimit = new Limit();
				zeroLimit.setLimitName(PERSON_REPOSITORY_SIZE_ALAIS);
				zeroLimit.setLimitValue(0L);
				zeroLimit.setCurrentValue(0L);
				session.setAttribute(REPO_CAPACITY_KEY, zeroLimit);
			}
		}
	}

}
