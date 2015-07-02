package net.frank.framework.dao;

public interface BaseJdbcDao {
	public Long getSeqNext(String seqName);
	public void executeSql(String sql);
	public Object executeQuery(String sql);
}