package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.DeviceEnvHistory;
import com.shengtong.smartlamppost.commons.entity.DeviceEnvHistoryExample;
import java.util.List;

public interface DeviceEnvHistoryMapper {
    int deleteByPrimaryKey(String id);

    int insert(DeviceEnvHistory record);

    int insertSelective(DeviceEnvHistory record);

    List<DeviceEnvHistory> selectByExample(DeviceEnvHistoryExample example);

    DeviceEnvHistory selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DeviceEnvHistory record);

    int updateByPrimaryKey(DeviceEnvHistory record);
}