package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeFreelist;

import org.springframework.jdbc.core.RowMapper;

public final class DedeFreelistRowMapper implements RowMapper<DedeFreelist> {

	@Override
	public DedeFreelist mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeFreelist to = new DedeFreelist();
		to.setAid(rs.getInt("aid"));
		to.setTitle(rs.getString("title"));
		to.setNamerule(rs.getString("namerule"));
		to.setListdir(rs.getString("listdir"));
		to.setDefaultpage(rs.getString("defaultpage"));
		to.setNodefault(rs.getInt("nodefault"));
		to.setTemplet(rs.getString("templet"));
		to.setEdtime(rs.getInt("edtime"));
		to.setMaxpage(rs.getInt("maxpage"));
		to.setClick(rs.getInt("click"));
		to.setListtag(rs.getString("listtag").toCharArray());
		to.setKeywords(rs.getString("keywords"));
		to.setDescription(rs.getString("description"));
		return to;
	}
}
