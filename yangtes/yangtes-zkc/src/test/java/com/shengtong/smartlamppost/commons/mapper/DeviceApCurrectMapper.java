package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.DeviceApCurrect;
import com.shengtong.smartlamppost.commons.entity.DeviceApCurrectExample;
import java.util.List;

public interface DeviceApCurrectMapper {
    int deleteByPrimaryKey(String id);

    int insert(DeviceApCurrect record);

    int insertSelective(DeviceApCurrect record);

    List<DeviceApCurrect> selectByExample(DeviceApCurrectExample example);

    DeviceApCurrect selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DeviceApCurrect record);

    int updateByPrimaryKey(DeviceApCurrect record);
}