package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeFlinktype;

import org.springframework.jdbc.core.RowMapper;

public final class DedeFlinktypeRowMapper implements RowMapper<DedeFlinktype> {

	@Override
	public DedeFlinktype mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeFlinktype to = new DedeFlinktype();
		to.setId(rs.getLong("id"));
		to.setTypename(rs.getString("typename"));
		return to;
	}
}
