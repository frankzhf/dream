package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.DeviceRfidTaskUserResult;
import com.shengtong.smartlamppost.commons.entity.DeviceRfidTaskUserResultExample;
import java.util.List;

public interface DeviceRfidTaskUserResultMapper {
    int deleteByPrimaryKey(String id);

    int insert(DeviceRfidTaskUserResult record);

    int insertSelective(DeviceRfidTaskUserResult record);

    List<DeviceRfidTaskUserResult> selectByExample(DeviceRfidTaskUserResultExample example);

    DeviceRfidTaskUserResult selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DeviceRfidTaskUserResult record);

    int updateByPrimaryKey(DeviceRfidTaskUserResult record);
}