package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeMyadtype;

import org.springframework.jdbc.core.RowMapper;

public final class DedeMyadtypeRowMapper implements RowMapper<DedeMyadtype> {

	@Override
	public DedeMyadtype mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeMyadtype to = new DedeMyadtype();
		to.setId(rs.getLong("id"));
		to.setTypename(rs.getString("typename"));
		return to;
	}
}
