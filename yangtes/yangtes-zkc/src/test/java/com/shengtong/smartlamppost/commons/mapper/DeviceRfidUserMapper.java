package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.DeviceRfidUser;
import com.shengtong.smartlamppost.commons.entity.DeviceRfidUserExample;
import java.util.List;

public interface DeviceRfidUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(DeviceRfidUser record);

    int insertSelective(DeviceRfidUser record);

    List<DeviceRfidUser> selectByExample(DeviceRfidUserExample example);

    DeviceRfidUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DeviceRfidUser record);

    int updateByPrimaryKey(DeviceRfidUser record);
}