package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.OpsDeviceLog;
import com.shengtong.smartlamppost.commons.entity.OpsDeviceLogExample;
import java.util.List;

public interface OpsDeviceLogMapper {
    int deleteByPrimaryKey(String id);

    int insert(OpsDeviceLog record);

    int insertSelective(OpsDeviceLog record);

    List<OpsDeviceLog> selectByExample(OpsDeviceLogExample example);

    OpsDeviceLog selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OpsDeviceLog record);

    int updateByPrimaryKey(OpsDeviceLog record);
}