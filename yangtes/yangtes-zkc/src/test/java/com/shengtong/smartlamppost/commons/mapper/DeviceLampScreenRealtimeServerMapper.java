package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.DeviceLampScreenRealtimeServer;
import com.shengtong.smartlamppost.commons.entity.DeviceLampScreenRealtimeServerExample;
import java.util.List;

public interface DeviceLampScreenRealtimeServerMapper {
    int deleteByPrimaryKey(String id);

    int insert(DeviceLampScreenRealtimeServer record);

    int insertSelective(DeviceLampScreenRealtimeServer record);

    List<DeviceLampScreenRealtimeServer> selectByExample(DeviceLampScreenRealtimeServerExample example);

    DeviceLampScreenRealtimeServer selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DeviceLampScreenRealtimeServer record);

    int updateByPrimaryKey(DeviceLampScreenRealtimeServer record);
}