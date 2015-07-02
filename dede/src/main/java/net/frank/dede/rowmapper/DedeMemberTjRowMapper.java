package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeMemberTj;

import org.springframework.jdbc.core.RowMapper;

public final class DedeMemberTjRowMapper implements RowMapper<DedeMemberTj> {

	@Override
	public DedeMemberTj mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeMemberTj to = new DedeMemberTj();
		to.setMid(rs.getInt("mid"));
		to.setArticle(rs.getInt("article"));
		to.setAlbum(rs.getInt("album"));
		to.setArchives(rs.getInt("archives"));
		to.setHomecount(rs.getInt("homecount"));
		to.setPagecount(rs.getInt("pagecount"));
		to.setFeedback(rs.getInt("feedback"));
		to.setFriend(rs.getInt("friend"));
		to.setStow(rs.getInt("stow"));
		to.setSoft(rs.getInt("soft"));
		to.setInfo(rs.getInt("info"));
		to.setShop(rs.getInt("shop"));
		return to;
	}
}
