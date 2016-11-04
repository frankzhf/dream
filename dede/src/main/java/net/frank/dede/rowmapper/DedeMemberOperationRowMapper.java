package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeMemberOperation;

import org.springframework.jdbc.core.RowMapper;

public final class DedeMemberOperationRowMapper implements RowMapper<DedeMemberOperation> {

	@Override
	public DedeMemberOperation mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeMemberOperation to = new DedeMemberOperation();
		to.setAid(rs.getInt("aid"));
		to.setBuyid(rs.getString("buyid"));
		to.setPname(rs.getString("pname"));
		to.setProduct(rs.getString("product"));
		to.setMoney(rs.getInt("money"));
		to.setMtime(rs.getInt("mtime"));
		to.setPid(rs.getInt("pid"));
		to.setMid(rs.getInt("mid"));
		to.setSta(rs.getInt("sta"));
		to.setOldinfo(rs.getString("oldinfo"));
		return to;
	}
}
