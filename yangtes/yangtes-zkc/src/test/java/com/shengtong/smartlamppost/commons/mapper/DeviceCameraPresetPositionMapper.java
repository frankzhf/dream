package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.DeviceCameraPresetPosition;
import com.shengtong.smartlamppost.commons.entity.DeviceCameraPresetPositionExample;
import java.util.List;

public interface DeviceCameraPresetPositionMapper {
    int deleteByPrimaryKey(String id);

    int insert(DeviceCameraPresetPosition record);

    int insertSelective(DeviceCameraPresetPosition record);

    List<DeviceCameraPresetPosition> selectByExample(DeviceCameraPresetPositionExample example);

    DeviceCameraPresetPosition selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DeviceCameraPresetPosition record);

    int updateByPrimaryKey(DeviceCameraPresetPosition record);
}