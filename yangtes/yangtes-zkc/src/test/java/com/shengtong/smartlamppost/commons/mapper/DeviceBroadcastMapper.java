package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.DeviceBroadcast;
import com.shengtong.smartlamppost.commons.entity.DeviceBroadcastExample;
import java.util.List;

public interface DeviceBroadcastMapper {
    int deleteByPrimaryKey(String id);

    int insert(DeviceBroadcast record);

    int insertSelective(DeviceBroadcast record);

    List<DeviceBroadcast> selectByExample(DeviceBroadcastExample example);

    DeviceBroadcast selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DeviceBroadcast record);

    int updateByPrimaryKey(DeviceBroadcast record);
}