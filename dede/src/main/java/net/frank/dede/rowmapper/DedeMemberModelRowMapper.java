package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeMemberModel;

import org.springframework.jdbc.core.RowMapper;

public final class DedeMemberModelRowMapper implements RowMapper<DedeMemberModel> {

	@Override
	public DedeMemberModel mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeMemberModel to = new DedeMemberModel();
		to.setId(rs.getLong("id"));
		to.setName(rs.getString("name"));
		to.setTable(rs.getString("table"));
		to.setDescription(rs.getString("description"));
		to.setState(rs.getInt("state"));
		to.setIssystem(rs.getInt("issystem"));
		to.setInfo(rs.getString("info").toCharArray());
		return to;
	}
}
