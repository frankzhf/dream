package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeMemberStowtype;

import org.springframework.jdbc.core.RowMapper;

public final class DedeMemberStowtypeRowMapper implements RowMapper<DedeMemberStowtype> {

	@Override
	public DedeMemberStowtype mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeMemberStowtype to = new DedeMemberStowtype();
		to.setStowname(rs.getString("stowname"));
		to.setIndexname(rs.getString("indexname"));
		to.setIndexurl(rs.getString("indexurl"));
		return to;
	}
}
