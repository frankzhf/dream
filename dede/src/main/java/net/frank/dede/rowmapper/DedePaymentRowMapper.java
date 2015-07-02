package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedePayment;

import org.springframework.jdbc.core.RowMapper;

public final class DedePaymentRowMapper implements RowMapper<DedePayment> {

	@Override
	public DedePayment mapRow(ResultSet rs, int index)
			throws SQLException {
		DedePayment to = new DedePayment();
		to.setId(rs.getLong("id"));
		to.setCode(rs.getString("code"));
		to.setName(rs.getString("name"));
		to.setFee(rs.getString("fee"));
		to.setDescription(rs.getString("description").toCharArray());
		to.setRank(rs.getByte("rank"));
		to.setConfig(rs.getString("config").toCharArray());
		to.setEnabled(rs.getBoolean("enabled"));
		to.setCod(rs.getBoolean("cod"));
		to.setOnline(rs.getBoolean("online"));
		return to;
	}
}
