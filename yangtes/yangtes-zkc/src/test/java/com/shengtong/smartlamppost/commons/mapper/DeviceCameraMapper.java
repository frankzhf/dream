package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.DeviceCamera;
import com.shengtong.smartlamppost.commons.entity.DeviceCameraExample;
import java.util.List;

public interface DeviceCameraMapper {
    int deleteByPrimaryKey(String id);

    int insert(DeviceCamera record);

    int insertSelective(DeviceCamera record);

    List<DeviceCamera> selectByExample(DeviceCameraExample example);

    DeviceCamera selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DeviceCamera record);

    int updateByPrimaryKey(DeviceCamera record);
}