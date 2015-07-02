package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeAddoninfos;

import org.springframework.jdbc.core.RowMapper;

public final class DedeAddoninfosRowMapper implements RowMapper<DedeAddoninfos> {

	@Override
	public DedeAddoninfos mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeAddoninfos to = new DedeAddoninfos();
		to.setAid(rs.getInt("aid"));
		to.setTypeid(rs.getInt("typeid"));
		to.setChannel(rs.getInt("channel"));
		to.setArcrank(rs.getInt("arcrank"));
		to.setMid(rs.getInt("mid"));
		to.setClick(rs.getInt("click"));
		to.setTitle(rs.getString("title"));
		to.setLitpic(rs.getString("litpic"));
		to.setUserip(rs.getString("userip"));
		to.setSenddate(rs.getInt("senddate"));
		to.setFlag(rs.getString("flag"));
		to.setLastpost(rs.getInt("lastpost"));
		to.setScores(rs.getInt("scores"));
		to.setGoodpost(rs.getInt("goodpost"));
		to.setBadpost(rs.getInt("badpost"));
		to.setNativeplace(rs.getInt("nativeplace"));
		to.setInfotype(rs.getString("infotype"));
		to.setBody(rs.getString("body").toCharArray());
		to.setEndtime(rs.getInt("endtime"));
		to.setTel(rs.getString("tel"));
		to.setEmail(rs.getString("email"));
		to.setAddress(rs.getString("address"));
		to.setLinkman(rs.getString("linkman"));
		return to;
	}
}
