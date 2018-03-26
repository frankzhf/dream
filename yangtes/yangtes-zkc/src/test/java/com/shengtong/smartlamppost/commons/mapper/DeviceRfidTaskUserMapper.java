package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.DeviceRfidTaskUser;
import com.shengtong.smartlamppost.commons.entity.DeviceRfidTaskUserExample;
import java.util.List;

public interface DeviceRfidTaskUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(DeviceRfidTaskUser record);

    int insertSelective(DeviceRfidTaskUser record);

    List<DeviceRfidTaskUser> selectByExample(DeviceRfidTaskUserExample example);

    DeviceRfidTaskUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DeviceRfidTaskUser record);

    int updateByPrimaryKey(DeviceRfidTaskUser record);
}