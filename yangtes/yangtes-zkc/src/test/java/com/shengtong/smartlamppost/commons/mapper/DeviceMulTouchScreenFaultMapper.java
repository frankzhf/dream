package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.DeviceMulTouchScreenFault;
import com.shengtong.smartlamppost.commons.entity.DeviceMulTouchScreenFaultExample;
import java.util.List;

public interface DeviceMulTouchScreenFaultMapper {
    int deleteByPrimaryKey(String id);

    int insert(DeviceMulTouchScreenFault record);

    int insertSelective(DeviceMulTouchScreenFault record);

    List<DeviceMulTouchScreenFault> selectByExample(DeviceMulTouchScreenFaultExample example);

    DeviceMulTouchScreenFault selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DeviceMulTouchScreenFault record);

    int updateByPrimaryKey(DeviceMulTouchScreenFault record);
}