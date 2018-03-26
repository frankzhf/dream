package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.DeviceRfidCard;
import com.shengtong.smartlamppost.commons.entity.DeviceRfidCardExample;
import java.util.List;

public interface DeviceRfidCardMapper {
    int deleteByPrimaryKey(String id);

    int insert(DeviceRfidCard record);

    int insertSelective(DeviceRfidCard record);

    List<DeviceRfidCard> selectByExample(DeviceRfidCardExample example);

    DeviceRfidCard selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DeviceRfidCard record);

    int updateByPrimaryKey(DeviceRfidCard record);
}