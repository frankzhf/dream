package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeArctype;

import org.springframework.jdbc.core.RowMapper;

public final class DedeArctypeRowMapper implements RowMapper<DedeArctype> {

	@Override
	public DedeArctype mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeArctype to = new DedeArctype();
		to.setId(rs.getLong("id"));
		to.setReid(rs.getInt("reid"));
		to.setTopid(rs.getInt("topid"));
		to.setSortrank(rs.getInt("sortrank"));
		to.setTypename(rs.getString("typename"));
		to.setTypedir(rs.getString("typedir"));
		to.setIsdefault(rs.getInt("isdefault"));
		to.setDefaultname(rs.getString("defaultname"));
		to.setIssend(rs.getInt("issend"));
		to.setChanneltype(rs.getInt("channeltype"));
		to.setMaxpage(rs.getInt("maxpage"));
		to.setIspart(rs.getInt("ispart"));
		to.setCorank(rs.getInt("corank"));
		to.setTempindex(rs.getString("tempindex"));
		to.setTemplist(rs.getString("templist"));
		to.setTemparticle(rs.getString("temparticle"));
		to.setNamerule(rs.getString("namerule"));
		to.setNamerule2(rs.getString("namerule2"));
		to.setModname(rs.getString("modname"));
		to.setDescription(rs.getString("description"));
		to.setKeywords(rs.getString("keywords"));
		to.setSeotitle(rs.getString("seotitle"));
		to.setMoresite(rs.getBoolean("moresite"));
		to.setSitepath(rs.getString("sitepath"));
		to.setSiteurl(rs.getString("siteurl"));
		to.setIshidden(rs.getInt("ishidden"));
		to.setCross(rs.getBoolean("cross"));
		to.setCrossid(rs.getString("crossid").toCharArray());
		to.setContent(rs.getString("content").toCharArray());
		to.setSmalltypes(rs.getString("smalltypes").toCharArray());
		return to;
	}
}
