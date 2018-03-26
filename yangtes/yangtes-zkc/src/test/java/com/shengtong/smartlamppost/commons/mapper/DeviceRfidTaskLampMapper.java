package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.DeviceRfidTaskLamp;
import com.shengtong.smartlamppost.commons.entity.DeviceRfidTaskLampExample;
import java.util.List;

public interface DeviceRfidTaskLampMapper {
    int deleteByPrimaryKey(String id);

    int insert(DeviceRfidTaskLamp record);

    int insertSelective(DeviceRfidTaskLamp record);

    List<DeviceRfidTaskLamp> selectByExample(DeviceRfidTaskLampExample example);

    DeviceRfidTaskLamp selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DeviceRfidTaskLamp record);

    int updateByPrimaryKey(DeviceRfidTaskLamp record);
}