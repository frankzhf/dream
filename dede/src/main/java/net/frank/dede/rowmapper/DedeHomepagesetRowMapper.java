package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeHomepageset;

import org.springframework.jdbc.core.RowMapper;

public final class DedeHomepagesetRowMapper implements RowMapper<DedeHomepageset> {

	@Override
	public DedeHomepageset mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeHomepageset to = new DedeHomepageset();
		to.setTemplet(rs.getString("templet"));
		to.setPosition(rs.getString("position"));
		to.setShowmod(rs.getByte("showmod"));
		return to;
	}
}
