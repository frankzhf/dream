package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.DeviceAlertFault;
import com.shengtong.smartlamppost.commons.entity.DeviceAlertFaultExample;
import java.util.List;

public interface DeviceAlertFaultMapper {
    int deleteByPrimaryKey(String id);

    int insert(DeviceAlertFault record);

    int insertSelective(DeviceAlertFault record);

    List<DeviceAlertFault> selectByExample(DeviceAlertFaultExample example);

    DeviceAlertFault selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DeviceAlertFault record);

    int updateByPrimaryKey(DeviceAlertFault record);
}