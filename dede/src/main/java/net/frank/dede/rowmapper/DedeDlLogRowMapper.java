package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeDlLog;

import org.springframework.jdbc.core.RowMapper;

public final class DedeDlLogRowMapper implements RowMapper<DedeDlLog> {

	@Override
	public DedeDlLog mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeDlLog to = new DedeDlLog();
		to.setId(rs.getLong("id"));
		to.setIp(rs.getString("ip"));
		to.setLang(rs.getString("lang"));
		to.setDtype(rs.getString("dtype"));
		to.setDltime(rs.getInt("dltime"));
		to.setReferrer(rs.getString("referrer"));
		to.setUserAgent(rs.getString("user_agent"));
		return to;
	}
}
