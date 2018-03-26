package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.DeviceLampScreenPublish;
import com.shengtong.smartlamppost.commons.entity.DeviceLampScreenPublishExample;
import java.util.List;

public interface DeviceLampScreenPublishMapper {
    int deleteByPrimaryKey(String id);

    int insert(DeviceLampScreenPublish record);

    int insertSelective(DeviceLampScreenPublish record);

    List<DeviceLampScreenPublish> selectByExample(DeviceLampScreenPublishExample example);

    DeviceLampScreenPublish selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DeviceLampScreenPublish record);

    int updateByPrimaryKey(DeviceLampScreenPublish record);
}