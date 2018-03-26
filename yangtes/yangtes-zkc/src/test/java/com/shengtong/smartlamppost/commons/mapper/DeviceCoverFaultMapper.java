package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.DeviceCoverFault;
import com.shengtong.smartlamppost.commons.entity.DeviceCoverFaultExample;
import java.util.List;

public interface DeviceCoverFaultMapper {
    int deleteByPrimaryKey(String id);

    int insert(DeviceCoverFault record);

    int insertSelective(DeviceCoverFault record);

    List<DeviceCoverFault> selectByExample(DeviceCoverFaultExample example);

    DeviceCoverFault selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DeviceCoverFault record);

    int updateByPrimaryKey(DeviceCoverFault record);
}