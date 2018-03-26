package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.DeviceLampFault;
import com.shengtong.smartlamppost.commons.entity.DeviceLampFaultExample;
import java.util.List;

public interface DeviceLampFaultMapper {
    int deleteByPrimaryKey(String id);

    int insert(DeviceLampFault record);

    int insertSelective(DeviceLampFault record);

    List<DeviceLampFault> selectByExample(DeviceLampFaultExample example);

    DeviceLampFault selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DeviceLampFault record);

    int updateByPrimaryKey(DeviceLampFault record);
}