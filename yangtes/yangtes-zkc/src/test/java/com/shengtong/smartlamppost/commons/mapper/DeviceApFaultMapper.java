package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.DeviceApFault;
import com.shengtong.smartlamppost.commons.entity.DeviceApFaultExample;
import java.util.List;

public interface DeviceApFaultMapper {
    int deleteByPrimaryKey(String id);

    int insert(DeviceApFault record);

    int insertSelective(DeviceApFault record);

    List<DeviceApFault> selectByExample(DeviceApFaultExample example);

    DeviceApFault selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DeviceApFault record);

    int updateByPrimaryKey(DeviceApFault record);
}