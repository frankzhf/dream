package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.DeviceLampScreen;
import com.shengtong.smartlamppost.commons.entity.DeviceLampScreenExample;
import java.util.List;

public interface DeviceLampScreenMapper {
    int deleteByPrimaryKey(String id);

    int insert(DeviceLampScreen record);

    int insertSelective(DeviceLampScreen record);

    List<DeviceLampScreen> selectByExample(DeviceLampScreenExample example);

    DeviceLampScreen selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DeviceLampScreen record);

    int updateByPrimaryKey(DeviceLampScreen record);
}