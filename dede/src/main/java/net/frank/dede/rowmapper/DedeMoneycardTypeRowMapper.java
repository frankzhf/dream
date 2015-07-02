package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeMoneycardType;

import org.springframework.jdbc.core.RowMapper;

public final class DedeMoneycardTypeRowMapper implements RowMapper<DedeMoneycardType> {

	@Override
	public DedeMoneycardType mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeMoneycardType to = new DedeMoneycardType();
		to.setTid(rs.getInt("tid"));
		to.setNum(rs.getInt("num"));
		to.setMoney(rs.getInt("money"));
		to.setPname(rs.getString("pname"));
		return to;
	}
}
