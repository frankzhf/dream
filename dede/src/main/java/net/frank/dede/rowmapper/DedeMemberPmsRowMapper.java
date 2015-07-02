package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeMemberPms;

import org.springframework.jdbc.core.RowMapper;

public final class DedeMemberPmsRowMapper implements RowMapper<DedeMemberPms> {

	@Override
	public DedeMemberPms mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeMemberPms to = new DedeMemberPms();
		to.setId(rs.getLong("id"));
		to.setFloginid(rs.getString("floginid"));
		to.setFromid(rs.getInt("fromid"));
		to.setToid(rs.getInt("toid"));
		to.setTologinid(rs.getString("tologinid"));
		to.setFolder(rs.getString("folder"));
		to.setSubject(rs.getString("subject"));
		to.setSendtime(rs.getInt("sendtime"));
		to.setWritetime(rs.getInt("writetime"));
		to.setHasview(rs.getBoolean("hasview"));
		to.setIsadmin(rs.getBoolean("isadmin"));
		to.setMessage(rs.getString("message").toCharArray());
		return to;
	}
}
