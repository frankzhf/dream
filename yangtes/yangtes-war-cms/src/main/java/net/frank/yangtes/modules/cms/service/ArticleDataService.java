package net.frank.yangtes.modules.cms.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.frank.yangtes.commons.service.CrudService;
import net.frank.yangtes.modules.cms.dao.ArticleDataDao;
import net.frank.yangtes.modules.cms.entity.ArticleData;

/**
 * 站点Service
 */
@Service
@Transactional(readOnly = true)
public class ArticleDataService extends CrudService<ArticleDataDao, ArticleData> {

}
