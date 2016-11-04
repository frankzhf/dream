package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeAddonspec;

import org.springframework.jdbc.core.RowMapper;

public final class DedeAddonspecRowMapper implements RowMapper<DedeAddonspec> {

	@Override
	public DedeAddonspec mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeAddonspec to = new DedeAddonspec();
		to.setAid(rs.getInt("aid"));
		to.setTypeid(rs.getInt("typeid"));
		to.setNote(rs.getString("note").toCharArray());
		to.setTemplet(rs.getString("templet"));
		to.setUserip(rs.getString("userip"));
		to.setRedirecturl(rs.getString("redirecturl"));
		return to;
	}
}
