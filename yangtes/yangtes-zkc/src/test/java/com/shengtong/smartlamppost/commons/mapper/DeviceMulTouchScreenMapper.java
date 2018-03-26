package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.DeviceMulTouchScreen;
import com.shengtong.smartlamppost.commons.entity.DeviceMulTouchScreenExample;
import java.util.List;

public interface DeviceMulTouchScreenMapper {
    int deleteByPrimaryKey(String id);

    int insert(DeviceMulTouchScreen record);

    int insertSelective(DeviceMulTouchScreen record);

    List<DeviceMulTouchScreen> selectByExample(DeviceMulTouchScreenExample example);

    DeviceMulTouchScreen selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DeviceMulTouchScreen record);

    int updateByPrimaryKey(DeviceMulTouchScreen record);
}