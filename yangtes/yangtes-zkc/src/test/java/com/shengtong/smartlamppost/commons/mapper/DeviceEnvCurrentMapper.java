package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.DeviceEnvCurrent;
import com.shengtong.smartlamppost.commons.entity.DeviceEnvCurrentExample;
import java.util.List;

public interface DeviceEnvCurrentMapper {
    int deleteByPrimaryKey(String id);

    int insert(DeviceEnvCurrent record);

    int insertSelective(DeviceEnvCurrent record);

    List<DeviceEnvCurrent> selectByExample(DeviceEnvCurrentExample example);

    DeviceEnvCurrent selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DeviceEnvCurrent record);

    int updateByPrimaryKey(DeviceEnvCurrent record);
}