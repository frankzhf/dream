package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.DeviceLampControl;
import com.shengtong.smartlamppost.commons.entity.DeviceLampControlExample;
import java.util.List;

public interface DeviceLampControlMapper {
    int deleteByPrimaryKey(String id);

    int insert(DeviceLampControl record);

    int insertSelective(DeviceLampControl record);

    List<DeviceLampControl> selectByExample(DeviceLampControlExample example);

    DeviceLampControl selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DeviceLampControl record);

    int updateByPrimaryKey(DeviceLampControl record);
}