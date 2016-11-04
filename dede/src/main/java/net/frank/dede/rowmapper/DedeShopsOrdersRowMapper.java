package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeShopsOrders;

import org.springframework.jdbc.core.RowMapper;

public final class DedeShopsOrdersRowMapper implements RowMapper<DedeShopsOrders> {

	@Override
	public DedeShopsOrders mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeShopsOrders to = new DedeShopsOrders();
		to.setOid(rs.getString("oid"));
		to.setUserid(rs.getInt("userid"));
		to.setPid(rs.getInt("pid"));
		to.setPaytype(rs.getByte("paytype"));
		to.setCartcount(rs.getInt("cartcount"));
		to.setDprice(rs.getFloat("dprice"));
		to.setPrice(rs.getFloat("price"));
		to.setPricecount(rs.getFloat("priceCount"));
		to.setState(rs.getBoolean("state"));
		to.setIp(rs.getString("ip"));
		to.setStime(rs.getInt("stime"));
		return to;
	}
}
