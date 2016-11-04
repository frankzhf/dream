package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeArchives;

import org.springframework.jdbc.core.RowMapper;

public final class DedeArchivesRowMapper implements RowMapper<DedeArchives> {

	@Override
	public DedeArchives mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeArchives to = new DedeArchives();
		to.setId(rs.getLong("id"));
		to.setTypeid(rs.getInt("typeid"));
		to.setTypeid2(rs.getString("typeid2"));
		to.setSortrank(rs.getInt("sortrank"));
		to.setFlag(rs.getString("flag"));
		to.setIsmake(rs.getInt("ismake"));
		to.setChannel(rs.getInt("channel"));
		to.setArcrank(rs.getInt("arcrank"));
		to.setClick(rs.getInt("click"));
		to.setMoney(rs.getInt("money"));
		to.setTitle(rs.getString("title"));
		to.setShorttitle(rs.getString("shorttitle"));
		to.setColor(rs.getString("color"));
		to.setWriter(rs.getString("writer"));
		to.setSource(rs.getString("source"));
		to.setLitpic(rs.getString("litpic"));
		to.setPubdate(rs.getInt("pubdate"));
		to.setSenddate(rs.getInt("senddate"));
		to.setMid(rs.getInt("mid"));
		to.setKeywords(rs.getString("keywords"));
		to.setLastpost(rs.getInt("lastpost"));
		to.setScores(rs.getInt("scores"));
		to.setGoodpost(rs.getInt("goodpost"));
		to.setBadpost(rs.getInt("badpost"));
		to.setVoteid(rs.getInt("voteid"));
		to.setNotpost(rs.getBoolean("notpost"));
		to.setDescription(rs.getString("description"));
		to.setFilename(rs.getString("filename"));
		to.setDutyadmin(rs.getInt("dutyadmin"));
		to.setTackid(rs.getInt("tackid"));
		to.setMtype(rs.getInt("mtype"));
		to.setWeight(rs.getInt("weight"));
		return to;
	}
}
