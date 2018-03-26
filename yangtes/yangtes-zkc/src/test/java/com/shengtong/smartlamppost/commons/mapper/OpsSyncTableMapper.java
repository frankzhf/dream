package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.OpsSyncTable;
import com.shengtong.smartlamppost.commons.entity.OpsSyncTableExample;
import java.util.List;

public interface OpsSyncTableMapper {
    int deleteByPrimaryKey(String id);

    int insert(OpsSyncTable record);

    int insertSelective(OpsSyncTable record);

    List<OpsSyncTable> selectByExample(OpsSyncTableExample example);

    OpsSyncTable selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OpsSyncTable record);

    int updateByPrimaryKey(OpsSyncTable record);
}