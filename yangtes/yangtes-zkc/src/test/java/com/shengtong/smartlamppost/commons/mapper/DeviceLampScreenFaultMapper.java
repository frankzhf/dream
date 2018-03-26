package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.DeviceLampScreenFault;
import com.shengtong.smartlamppost.commons.entity.DeviceLampScreenFaultExample;
import java.util.List;

public interface DeviceLampScreenFaultMapper {
    int deleteByPrimaryKey(String id);

    int insert(DeviceLampScreenFault record);

    int insertSelective(DeviceLampScreenFault record);

    List<DeviceLampScreenFault> selectByExample(DeviceLampScreenFaultExample example);

    DeviceLampScreenFault selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DeviceLampScreenFault record);

    int updateByPrimaryKey(DeviceLampScreenFault record);
}