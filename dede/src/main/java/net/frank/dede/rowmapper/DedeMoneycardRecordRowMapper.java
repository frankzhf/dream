package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeMoneycardRecord;

import org.springframework.jdbc.core.RowMapper;

public final class DedeMoneycardRecordRowMapper implements RowMapper<DedeMoneycardRecord> {

	@Override
	public DedeMoneycardRecord mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeMoneycardRecord to = new DedeMoneycardRecord();
		to.setAid(rs.getInt("aid"));
		to.setCtid(rs.getInt("ctid"));
		to.setCardid(rs.getString("cardid"));
		to.setUid(rs.getInt("uid"));
		to.setIsexp(rs.getInt("isexp"));
		to.setMtime(rs.getInt("mtime"));
		to.setUtime(rs.getInt("utime"));
		to.setMoney(rs.getInt("money"));
		to.setNum(rs.getInt("num"));
		return to;
	}
}
