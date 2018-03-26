package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.DeviceLampScreenCaptureDetail;
import com.shengtong.smartlamppost.commons.entity.DeviceLampScreenCaptureDetailExample;
import java.util.List;

public interface DeviceLampScreenCaptureDetailMapper {
    int deleteByPrimaryKey(String id);

    int insert(DeviceLampScreenCaptureDetail record);

    int insertSelective(DeviceLampScreenCaptureDetail record);

    List<DeviceLampScreenCaptureDetail> selectByExample(DeviceLampScreenCaptureDetailExample example);

    DeviceLampScreenCaptureDetail selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DeviceLampScreenCaptureDetail record);

    int updateByPrimaryKey(DeviceLampScreenCaptureDetail record);
}