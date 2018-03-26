package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.DeviceLuxCurrent;
import com.shengtong.smartlamppost.commons.entity.DeviceLuxCurrentExample;
import java.util.List;

public interface DeviceLuxCurrentMapper {
    int deleteByPrimaryKey(String id);

    int insert(DeviceLuxCurrent record);

    int insertSelective(DeviceLuxCurrent record);

    List<DeviceLuxCurrent> selectByExample(DeviceLuxCurrentExample example);

    DeviceLuxCurrent selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DeviceLuxCurrent record);

    int updateByPrimaryKey(DeviceLuxCurrent record);
}