package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeMemberCompany;

import org.springframework.jdbc.core.RowMapper;

public final class DedeMemberCompanyRowMapper implements RowMapper<DedeMemberCompany> {

	@Override
	public DedeMemberCompany mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeMemberCompany to = new DedeMemberCompany();
		to.setMid(rs.getInt("mid"));
		to.setCompany(rs.getString("company"));
		to.setProduct(rs.getString("product"));
		to.setPlace(rs.getInt("place"));
		to.setVocation(rs.getInt("vocation"));
		to.setCosize(rs.getInt("cosize"));
		to.setTel(rs.getString("tel"));
		to.setFax(rs.getString("fax"));
		to.setLinkman(rs.getString("linkman"));
		to.setAddress(rs.getString("address"));
		to.setMobile(rs.getString("mobile"));
		to.setEmail(rs.getString("email"));
		to.setUrl(rs.getString("url"));
		to.setUptime(rs.getInt("uptime"));
		to.setChecked(rs.getBoolean("checked"));
		to.setIntroduce(rs.getString("introduce").toCharArray());
		to.setComface(rs.getString("comface"));
		return to;
	}
}
