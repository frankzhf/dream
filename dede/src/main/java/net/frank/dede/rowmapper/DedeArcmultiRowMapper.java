package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeArcmulti;

import org.springframework.jdbc.core.RowMapper;

public final class DedeArcmultiRowMapper implements RowMapper<DedeArcmulti> {

	@Override
	public DedeArcmulti mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeArcmulti to = new DedeArcmulti();
		to.setId(rs.getLong("id"));
		to.setTagid(rs.getString("tagid"));
		to.setUptime(rs.getInt("uptime"));
		to.setInnertext(rs.getString("innertext"));
		to.setPagesize(rs.getInt("pagesize"));
		to.setArcids(rs.getString("arcids").toCharArray());
		to.setOrdersql(rs.getString("ordersql"));
		to.setAddfieldssql(rs.getString("addfieldsSql"));
		to.setAddfieldssqljoin(rs.getString("addfieldsSqlJoin"));
		to.setAttstr(rs.getString("attstr").toCharArray());
		return to;
	}
}
