package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeMemberStow;

import org.springframework.jdbc.core.RowMapper;

public final class DedeMemberStowRowMapper implements RowMapper<DedeMemberStow> {

	@Override
	public DedeMemberStow mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeMemberStow to = new DedeMemberStow();
		to.setId(rs.getLong("id"));
		to.setMid(rs.getInt("mid"));
		to.setAid(rs.getInt("aid"));
		to.setTitle(rs.getString("title"));
		to.setAddtime(rs.getInt("addtime"));
		to.setType(rs.getString("type"));
		return to;
	}
}
