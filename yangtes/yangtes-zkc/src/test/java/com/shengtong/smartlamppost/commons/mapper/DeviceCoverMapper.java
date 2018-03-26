package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.DeviceCover;
import com.shengtong.smartlamppost.commons.entity.DeviceCoverExample;
import java.util.List;

public interface DeviceCoverMapper {
    int deleteByPrimaryKey(String id);

    int insert(DeviceCover record);

    int insertSelective(DeviceCover record);

    List<DeviceCover> selectByExample(DeviceCoverExample example);

    DeviceCover selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DeviceCover record);

    int updateByPrimaryKey(DeviceCover record);
}