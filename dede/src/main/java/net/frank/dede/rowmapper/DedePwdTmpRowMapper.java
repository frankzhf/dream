package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedePwdTmp;

import org.springframework.jdbc.core.RowMapper;

public final class DedePwdTmpRowMapper implements RowMapper<DedePwdTmp> {

	@Override
	public DedePwdTmp mapRow(ResultSet rs, int index)
			throws SQLException {
		DedePwdTmp to = new DedePwdTmp();
		to.setMid(rs.getInt("mid"));
		to.setMembername(rs.getString("membername"));
		to.setPwd(rs.getString("pwd"));
		to.setMailtime(rs.getInt("mailtime"));
		return to;
	}
}
