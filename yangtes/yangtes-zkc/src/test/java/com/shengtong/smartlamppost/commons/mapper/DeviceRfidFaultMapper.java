package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.DeviceRfidFault;
import com.shengtong.smartlamppost.commons.entity.DeviceRfidFaultExample;
import java.util.List;

public interface DeviceRfidFaultMapper {
    int deleteByPrimaryKey(String id);

    int insert(DeviceRfidFault record);

    int insertSelective(DeviceRfidFault record);

    List<DeviceRfidFault> selectByExample(DeviceRfidFaultExample example);

    DeviceRfidFault selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DeviceRfidFault record);

    int updateByPrimaryKey(DeviceRfidFault record);
}