package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.DeviceAlert;
import com.shengtong.smartlamppost.commons.entity.DeviceAlertExample;
import java.util.List;

public interface DeviceAlertMapper {
    int deleteByPrimaryKey(String id);

    int insert(DeviceAlert record);

    int insertSelective(DeviceAlert record);

    List<DeviceAlert> selectByExample(DeviceAlertExample example);

    DeviceAlert selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DeviceAlert record);

    int updateByPrimaryKey(DeviceAlert record);
}