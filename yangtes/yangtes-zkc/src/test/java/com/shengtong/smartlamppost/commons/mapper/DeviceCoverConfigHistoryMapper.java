package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.DeviceCoverConfigHistory;
import com.shengtong.smartlamppost.commons.entity.DeviceCoverConfigHistoryExample;
import java.util.List;

public interface DeviceCoverConfigHistoryMapper {
    int deleteByPrimaryKey(String id);

    int insert(DeviceCoverConfigHistory record);

    int insertSelective(DeviceCoverConfigHistory record);

    List<DeviceCoverConfigHistory> selectByExample(DeviceCoverConfigHistoryExample example);

    DeviceCoverConfigHistory selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DeviceCoverConfigHistory record);

    int updateByPrimaryKey(DeviceCoverConfigHistory record);
}