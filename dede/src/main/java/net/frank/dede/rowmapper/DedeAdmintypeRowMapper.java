package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeAdmintype;

import org.springframework.jdbc.core.RowMapper;

public final class DedeAdmintypeRowMapper implements RowMapper<DedeAdmintype> {

	@Override
	public DedeAdmintype mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeAdmintype to = new DedeAdmintype();
		to.setRank(rs.getFloat("rank"));
		to.setTypename(rs.getString("typename"));
		to.setSystem(rs.getInt("system"));
		to.setPurviews(rs.getString("purviews").toCharArray());
		return to;
	}
}
