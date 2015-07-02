package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeAddonarticle;

import org.springframework.jdbc.core.RowMapper;

public final class DedeAddonarticleRowMapper implements RowMapper<DedeAddonarticle> {

	@Override
	public DedeAddonarticle mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeAddonarticle to = new DedeAddonarticle();
		to.setAid(rs.getInt("aid"));
		to.setTypeid(rs.getInt("typeid"));
		to.setBody(rs.getString("body").toCharArray());
		to.setRedirecturl(rs.getString("redirecturl"));
		to.setTemplet(rs.getString("templet"));
		to.setUserip(rs.getString("userip"));
		return to;
	}
}
