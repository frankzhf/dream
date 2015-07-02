package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeShopsProducts;

import org.springframework.jdbc.core.RowMapper;

public final class DedeShopsProductsRowMapper implements RowMapper<DedeShopsProducts> {

	@Override
	public DedeShopsProducts mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeShopsProducts to = new DedeShopsProducts();
		to.setAid(rs.getInt("aid"));
		to.setOid(rs.getString("oid"));
		to.setUserid(rs.getInt("userid"));
		to.setTitle(rs.getString("title"));
		to.setPrice(rs.getFloat("price"));
		to.setBuynum(rs.getInt("buynum"));
		return to;
	}
}
