package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeSysEnum;

import org.springframework.jdbc.core.RowMapper;

public final class DedeSysEnumRowMapper implements RowMapper<DedeSysEnum> {

	@Override
	public DedeSysEnum mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeSysEnum to = new DedeSysEnum();
		to.setId(rs.getLong("id"));
		to.setEname(rs.getString("ename"));
		to.setEvalue(rs.getString("evalue"));
		to.setEgroup(rs.getString("egroup"));
		to.setDisorder(rs.getInt("disorder"));
		to.setIssign(rs.getBoolean("issign"));
		return to;
	}
}
