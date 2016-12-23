package net.frank.yangtes.modules.cms.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.frank.yangtes.commons.persistence.Page;
import net.frank.yangtes.commons.service.CrudService;
import net.frank.yangtes.modules.cms.dao.CommentDao;
import net.frank.yangtes.modules.cms.entity.Comment;

/**
 * 评论Service
 */
@Service
@Transactional(readOnly = true)
public class CommentService extends CrudService<CommentDao, Comment> {

	public Page<Comment> findPage(Page<Comment> page, Comment comment) {
		comment.getSqlMap().put("dsf", dataScopeFilter(comment.getCurrentUser(), "o", "u"));
		return super.findPage(page, comment);
	}
	
	@Transactional(readOnly = false)
	public void delete(Comment entity, Boolean isRe) {
		super.delete(entity);
	}
}
