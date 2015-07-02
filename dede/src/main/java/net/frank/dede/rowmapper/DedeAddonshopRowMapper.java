package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeAddonshop;

import org.springframework.jdbc.core.RowMapper;

public final class DedeAddonshopRowMapper implements RowMapper<DedeAddonshop> {

	@Override
	public DedeAddonshop mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeAddonshop to = new DedeAddonshop();
		to.setAid(rs.getInt("aid"));
		to.setTypeid(rs.getInt("typeid"));
		to.setBody(rs.getString("body").toCharArray());
		to.setPrice(rs.getFloat("price"));
		to.setTrueprice(rs.getFloat("trueprice"));
		to.setBrand(rs.getString("brand"));
		to.setUnits(rs.getString("units"));
		to.setTemplet(rs.getString("templet"));
		to.setUserip(rs.getString("userip"));
		to.setRedirecturl(rs.getString("redirecturl"));
		to.setVocation(rs.getString("vocation"));
		to.setInfotype(rs.getString("infotype"));
		to.setUptime(rs.getInt("uptime"));
		return to;
	}
}
