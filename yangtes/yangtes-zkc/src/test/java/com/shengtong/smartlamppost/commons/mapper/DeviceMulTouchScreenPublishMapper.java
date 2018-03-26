package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.DeviceMulTouchScreenPublish;
import com.shengtong.smartlamppost.commons.entity.DeviceMulTouchScreenPublishExample;
import java.util.List;

public interface DeviceMulTouchScreenPublishMapper {
    int deleteByPrimaryKey(String id);

    int insert(DeviceMulTouchScreenPublish record);

    int insertSelective(DeviceMulTouchScreenPublish record);

    List<DeviceMulTouchScreenPublish> selectByExample(DeviceMulTouchScreenPublishExample example);

    DeviceMulTouchScreenPublish selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DeviceMulTouchScreenPublish record);

    int updateByPrimaryKey(DeviceMulTouchScreenPublish record);
}