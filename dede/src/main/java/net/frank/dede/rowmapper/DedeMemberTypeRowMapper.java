package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeMemberType;

import org.springframework.jdbc.core.RowMapper;

public final class DedeMemberTypeRowMapper implements RowMapper<DedeMemberType> {

	@Override
	public DedeMemberType mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeMemberType to = new DedeMemberType();
		to.setAid(rs.getInt("aid"));
		to.setRank(rs.getInt("rank"));
		to.setPname(rs.getString("pname"));
		to.setMoney(rs.getInt("money"));
		to.setExptime(rs.getInt("exptime"));
		return to;
	}
}
