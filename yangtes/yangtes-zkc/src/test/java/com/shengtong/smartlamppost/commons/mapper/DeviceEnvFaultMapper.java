package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.DeviceEnvFault;
import com.shengtong.smartlamppost.commons.entity.DeviceEnvFaultExample;
import java.util.List;

public interface DeviceEnvFaultMapper {
    int deleteByPrimaryKey(String id);

    int insert(DeviceEnvFault record);

    int insertSelective(DeviceEnvFault record);

    List<DeviceEnvFault> selectByExample(DeviceEnvFaultExample example);

    DeviceEnvFault selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DeviceEnvFault record);

    int updateByPrimaryKey(DeviceEnvFault record);
}