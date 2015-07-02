package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeMemberPerson;

import org.springframework.jdbc.core.RowMapper;

public final class DedeMemberPersonRowMapper implements RowMapper<DedeMemberPerson> {

	@Override
	public DedeMemberPerson mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeMemberPerson to = new DedeMemberPerson();
		to.setMid(rs.getInt("mid"));
		to.setOnlynet(rs.getBoolean("onlynet"));
		to.setSex(rs.getString("sex"));
		to.setUname(rs.getString("uname"));
		to.setQq(rs.getString("qq"));
		to.setMsn(rs.getString("msn"));
		to.setTel(rs.getString("tel"));
		to.setMobile(rs.getString("mobile"));
		to.setPlace(rs.getInt("place"));
		to.setOldplace(rs.getInt("oldplace"));
		to.setBirthday(rs.getDate("birthday"));
		to.setStar(rs.getInt("star"));
		to.setIncome(rs.getInt("income"));
		to.setEducation(rs.getInt("education"));
		to.setHeight(rs.getInt("height"));
		to.setBodytype(rs.getInt("bodytype"));
		to.setBlood(rs.getInt("blood"));
		to.setVocation(rs.getInt("vocation"));
		to.setSmoke(rs.getInt("smoke"));
		to.setMarital(rs.getInt("marital"));
		to.setHouse(rs.getInt("house"));
		to.setDrink(rs.getInt("drink"));
		to.setDatingtype(rs.getInt("datingtype"));
		to.setLanguage(rs.getString("language"));
		to.setNature(rs.getString("nature"));
		to.setLovemsg(rs.getString("lovemsg"));
		to.setAddress(rs.getString("address"));
		to.setUptime(rs.getInt("uptime"));
		return to;
	}
}
