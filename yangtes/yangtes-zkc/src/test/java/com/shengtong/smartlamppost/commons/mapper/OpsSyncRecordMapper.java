package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.OpsSyncRecord;
import com.shengtong.smartlamppost.commons.entity.OpsSyncRecordExample;
import java.util.List;

public interface OpsSyncRecordMapper {
    int deleteByPrimaryKey(String id);

    int insert(OpsSyncRecord record);

    int insertSelective(OpsSyncRecord record);

    List<OpsSyncRecord> selectByExample(OpsSyncRecordExample example);

    OpsSyncRecord selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OpsSyncRecord record);

    int updateByPrimaryKey(OpsSyncRecord record);
}