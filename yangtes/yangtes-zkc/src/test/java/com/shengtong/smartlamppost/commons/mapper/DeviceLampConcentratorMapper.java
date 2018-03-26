package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.DeviceLampConcentrator;
import com.shengtong.smartlamppost.commons.entity.DeviceLampConcentratorExample;
import java.util.List;

public interface DeviceLampConcentratorMapper {
    int deleteByPrimaryKey(String id);

    int insert(DeviceLampConcentrator record);

    int insertSelective(DeviceLampConcentrator record);

    List<DeviceLampConcentrator> selectByExample(DeviceLampConcentratorExample example);

    DeviceLampConcentrator selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DeviceLampConcentrator record);

    int updateByPrimaryKey(DeviceLampConcentrator record);
}