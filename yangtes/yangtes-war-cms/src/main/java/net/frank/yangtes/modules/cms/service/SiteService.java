package net.frank.yangtes.modules.cms.service;

import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.frank.yangtes.commons.persistence.Page;
import net.frank.yangtes.commons.service.CrudService;
import net.frank.yangtes.modules.cms.dao.SiteDao;
import net.frank.yangtes.modules.cms.entity.Site;
import net.frank.yangtes.modules.cms.utils.CmsUtils;

/**
 * 站点Service
 */
@Service
@Transactional(readOnly = true)
public class SiteService extends CrudService<SiteDao, Site> {
	public Page<Site> findPage(Page<Site> page, Site site) {
		site.getSqlMap().put("site", dataScopeFilter(site.getCurrentUser(), "o", "u"));
		return super.findPage(page, site);
	}

	@Transactional(readOnly = false)
	public void save(Site site) {
		if (site.getCopyright() != null) {
			site.setCopyright(StringEscapeUtils.unescapeHtml4(site.getCopyright()));
		}
		super.save(site);
		CmsUtils.removeCache("site_" + site.getId());
		CmsUtils.removeCache("siteList");
	}

	@Transactional(readOnly = false)
	public void delete(Site site, Boolean isRe) {
		site.setDelFlag(isRe != null && isRe ? Site.DEL_FLAG_NORMAL : Site.DEL_FLAG_DELETE);
		super.delete(site);
		CmsUtils.removeCache("site_" + site.getId());
		CmsUtils.removeCache("siteList");
	}

}
