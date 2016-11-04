package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeMemberGroup;

import org.springframework.jdbc.core.RowMapper;

public final class DedeMemberGroupRowMapper implements RowMapper<DedeMemberGroup> {

	@Override
	public DedeMemberGroup mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeMemberGroup to = new DedeMemberGroup();
		to.setId(rs.getLong("id"));
		to.setGroupname(rs.getString("groupname"));
		to.setMid(rs.getInt("mid"));
		return to;
	}
}
