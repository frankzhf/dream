package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeSysTask;

import org.springframework.jdbc.core.RowMapper;

public final class DedeSysTaskRowMapper implements RowMapper<DedeSysTask> {

	@Override
	public DedeSysTask mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeSysTask to = new DedeSysTask();
		to.setId(rs.getLong("id"));
		to.setTaskname(rs.getString("taskname"));
		to.setDourl(rs.getString("dourl"));
		to.setIslock(rs.getBoolean("islock"));
		to.setRuntype(rs.getBoolean("runtype"));
		to.setRuntime(rs.getString("runtime"));
		to.setStarttime(rs.getInt("starttime"));
		to.setEndtime(rs.getInt("endtime"));
		to.setFreq(rs.getByte("freq"));
		to.setLastrun(rs.getInt("lastrun"));
		to.setDescription(rs.getString("description"));
		to.setParameter(rs.getString("parameter").toCharArray());
		to.setSettime(rs.getInt("settime"));
		to.setSta(rs.getString("sta"));
		return to;
	}
}
