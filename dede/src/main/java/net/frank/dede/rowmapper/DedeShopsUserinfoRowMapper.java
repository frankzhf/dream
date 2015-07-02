package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeShopsUserinfo;

import org.springframework.jdbc.core.RowMapper;

public final class DedeShopsUserinfoRowMapper implements RowMapper<DedeShopsUserinfo> {

	@Override
	public DedeShopsUserinfo mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeShopsUserinfo to = new DedeShopsUserinfo();
		to.setUserid(rs.getInt("userid"));
		to.setOid(rs.getString("oid"));
		to.setConsignee(rs.getString("consignee"));
		to.setAddress(rs.getString("address"));
		to.setZip(rs.getInt("zip"));
		to.setTel(rs.getString("tel"));
		to.setEmail(rs.getString("email"));
		to.setDes(rs.getString("des"));
		return to;
	}
}
