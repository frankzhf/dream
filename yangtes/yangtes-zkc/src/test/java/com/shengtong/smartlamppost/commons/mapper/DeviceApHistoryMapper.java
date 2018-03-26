package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.DeviceApHistory;
import com.shengtong.smartlamppost.commons.entity.DeviceApHistoryExample;
import java.util.List;

public interface DeviceApHistoryMapper {
    int deleteByPrimaryKey(String id);

    int insert(DeviceApHistory record);

    int insertSelective(DeviceApHistory record);

    List<DeviceApHistory> selectByExample(DeviceApHistoryExample example);

    DeviceApHistory selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DeviceApHistory record);

    int updateByPrimaryKey(DeviceApHistory record);
}