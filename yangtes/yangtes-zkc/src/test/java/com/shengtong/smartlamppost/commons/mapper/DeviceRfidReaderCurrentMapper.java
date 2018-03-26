package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.DeviceRfidReaderCurrent;
import com.shengtong.smartlamppost.commons.entity.DeviceRfidReaderCurrentExample;
import java.util.List;

public interface DeviceRfidReaderCurrentMapper {
    int deleteByPrimaryKey(String id);

    int insert(DeviceRfidReaderCurrent record);

    int insertSelective(DeviceRfidReaderCurrent record);

    List<DeviceRfidReaderCurrent> selectByExample(DeviceRfidReaderCurrentExample example);

    DeviceRfidReaderCurrent selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DeviceRfidReaderCurrent record);

    int updateByPrimaryKey(DeviceRfidReaderCurrent record);
}