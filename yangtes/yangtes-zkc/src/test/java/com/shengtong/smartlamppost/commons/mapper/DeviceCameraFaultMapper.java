package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.DeviceCameraFault;
import com.shengtong.smartlamppost.commons.entity.DeviceCameraFaultExample;
import java.util.List;

public interface DeviceCameraFaultMapper {
    int deleteByPrimaryKey(String id);

    int insert(DeviceCameraFault record);

    int insertSelective(DeviceCameraFault record);

    List<DeviceCameraFault> selectByExample(DeviceCameraFaultExample example);

    DeviceCameraFault selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DeviceCameraFault record);

    int updateByPrimaryKey(DeviceCameraFault record);
}