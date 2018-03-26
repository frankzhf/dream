package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.DeviceRfidPunchCardRecord;
import com.shengtong.smartlamppost.commons.entity.DeviceRfidPunchCardRecordExample;
import java.util.List;

public interface DeviceRfidPunchCardRecordMapper {
    int deleteByPrimaryKey(String id);

    int insert(DeviceRfidPunchCardRecord record);

    int insertSelective(DeviceRfidPunchCardRecord record);

    List<DeviceRfidPunchCardRecord> selectByExample(DeviceRfidPunchCardRecordExample example);

    DeviceRfidPunchCardRecord selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DeviceRfidPunchCardRecord record);

    int updateByPrimaryKey(DeviceRfidPunchCardRecord record);
}