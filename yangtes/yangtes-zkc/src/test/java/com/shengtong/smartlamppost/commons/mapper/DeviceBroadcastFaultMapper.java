package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.DeviceBroadcastFault;
import com.shengtong.smartlamppost.commons.entity.DeviceBroadcastFaultExample;
import java.util.List;

public interface DeviceBroadcastFaultMapper {
    int deleteByPrimaryKey(String id);

    int insert(DeviceBroadcastFault record);

    int insertSelective(DeviceBroadcastFault record);

    List<DeviceBroadcastFault> selectByExample(DeviceBroadcastFaultExample example);

    DeviceBroadcastFault selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DeviceBroadcastFault record);

    int updateByPrimaryKey(DeviceBroadcastFault record);
}