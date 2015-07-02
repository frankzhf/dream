package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeLog;

import org.springframework.jdbc.core.RowMapper;

public final class DedeLogRowMapper implements RowMapper<DedeLog> {

	@Override
	public DedeLog mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeLog to = new DedeLog();
		to.setLid(rs.getInt("lid"));
		to.setAdminid(rs.getInt("adminid"));
		to.setFilename(rs.getString("filename"));
		to.setMethod(rs.getString("method"));
		to.setQuery(rs.getString("query"));
		to.setCip(rs.getString("cip"));
		to.setDtime(rs.getInt("dtime"));
		return to;
	}
}
