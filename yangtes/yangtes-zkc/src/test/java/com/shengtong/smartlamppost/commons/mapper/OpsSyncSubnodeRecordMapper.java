package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.OpsSyncSubnodeRecord;
import com.shengtong.smartlamppost.commons.entity.OpsSyncSubnodeRecordExample;
import com.shengtong.smartlamppost.commons.entity.OpsSyncSubnodeRecordKey;
import java.util.List;

public interface OpsSyncSubnodeRecordMapper {
    int deleteByPrimaryKey(OpsSyncSubnodeRecordKey key);

    int insert(OpsSyncSubnodeRecord record);

    int insertSelective(OpsSyncSubnodeRecord record);

    List<OpsSyncSubnodeRecord> selectByExample(OpsSyncSubnodeRecordExample example);

    OpsSyncSubnodeRecord selectByPrimaryKey(OpsSyncSubnodeRecordKey key);

    int updateByPrimaryKeySelective(OpsSyncSubnodeRecord record);

    int updateByPrimaryKey(OpsSyncSubnodeRecord record);
}