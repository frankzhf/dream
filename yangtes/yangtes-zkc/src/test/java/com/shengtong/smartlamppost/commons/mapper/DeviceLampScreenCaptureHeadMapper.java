package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.DeviceLampScreenCaptureHead;
import com.shengtong.smartlamppost.commons.entity.DeviceLampScreenCaptureHeadExample;
import java.util.List;

public interface DeviceLampScreenCaptureHeadMapper {
    int deleteByPrimaryKey(String id);

    int insert(DeviceLampScreenCaptureHead record);

    int insertSelective(DeviceLampScreenCaptureHead record);

    List<DeviceLampScreenCaptureHead> selectByExample(DeviceLampScreenCaptureHeadExample example);

    DeviceLampScreenCaptureHead selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DeviceLampScreenCaptureHead record);

    int updateByPrimaryKey(DeviceLampScreenCaptureHead record);
}