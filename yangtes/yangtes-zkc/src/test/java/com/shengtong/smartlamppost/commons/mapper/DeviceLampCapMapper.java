package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.DeviceLampCap;
import com.shengtong.smartlamppost.commons.entity.DeviceLampCapExample;
import java.util.List;

public interface DeviceLampCapMapper {
    int deleteByPrimaryKey(String id);

    int insert(DeviceLampCap record);

    int insertSelective(DeviceLampCap record);

    List<DeviceLampCap> selectByExample(DeviceLampCapExample example);

    DeviceLampCap selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DeviceLampCap record);

    int updateByPrimaryKey(DeviceLampCap record);
}