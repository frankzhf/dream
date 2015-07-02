package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeErradd;

import org.springframework.jdbc.core.RowMapper;

public final class DedeErraddRowMapper implements RowMapper<DedeErradd> {

	@Override
	public DedeErradd mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeErradd to = new DedeErradd();
		to.setId(rs.getLong("id"));
		to.setAid(rs.getInt("aid"));
		to.setMid(rs.getInt("mid"));
		to.setTitle(rs.getString("title"));
		to.setType(rs.getInt("type"));
		to.setErrtxt(rs.getString("errtxt").toCharArray());
		to.setOktxt(rs.getString("oktxt").toCharArray());
		to.setSendtime(rs.getInt("sendtime"));
		return to;
	}
}
