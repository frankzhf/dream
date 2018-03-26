package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.DeviceRfidTask;
import com.shengtong.smartlamppost.commons.entity.DeviceRfidTaskExample;
import java.util.List;

public interface DeviceRfidTaskMapper {
    int deleteByPrimaryKey(String id);

    int insert(DeviceRfidTask record);

    int insertSelective(DeviceRfidTask record);

    List<DeviceRfidTask> selectByExample(DeviceRfidTaskExample example);

    DeviceRfidTask selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DeviceRfidTask record);

    int updateByPrimaryKey(DeviceRfidTask record);
}