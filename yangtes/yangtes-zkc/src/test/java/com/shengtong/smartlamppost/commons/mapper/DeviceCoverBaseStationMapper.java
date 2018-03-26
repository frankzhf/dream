package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.DeviceCoverBaseStation;
import com.shengtong.smartlamppost.commons.entity.DeviceCoverBaseStationExample;
import java.util.List;

public interface DeviceCoverBaseStationMapper {
    int deleteByPrimaryKey(String id);

    int insert(DeviceCoverBaseStation record);

    int insertSelective(DeviceCoverBaseStation record);

    List<DeviceCoverBaseStation> selectByExample(DeviceCoverBaseStationExample example);

    DeviceCoverBaseStation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DeviceCoverBaseStation record);

    int updateByPrimaryKey(DeviceCoverBaseStation record);
}