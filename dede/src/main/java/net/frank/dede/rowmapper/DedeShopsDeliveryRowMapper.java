package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeShopsDelivery;

import org.springframework.jdbc.core.RowMapper;

public final class DedeShopsDeliveryRowMapper implements RowMapper<DedeShopsDelivery> {

	@Override
	public DedeShopsDelivery mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeShopsDelivery to = new DedeShopsDelivery();
		to.setPid(rs.getInt("pid"));
		to.setDname(rs.getString("dname"));
		to.setPrice(rs.getFloat("price"));
		to.setDes(rs.getString("des"));
		to.setOrders(rs.getInt("orders"));
		return to;
	}
}
