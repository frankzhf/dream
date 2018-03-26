package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.DeviceMulTouchScreenPublishDetail;
import com.shengtong.smartlamppost.commons.entity.DeviceMulTouchScreenPublishDetailExample;
import java.util.List;

public interface DeviceMulTouchScreenPublishDetailMapper {
    int deleteByPrimaryKey(String id);

    int insert(DeviceMulTouchScreenPublishDetail record);

    int insertSelective(DeviceMulTouchScreenPublishDetail record);

    List<DeviceMulTouchScreenPublishDetail> selectByExample(DeviceMulTouchScreenPublishDetailExample example);

    DeviceMulTouchScreenPublishDetail selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DeviceMulTouchScreenPublishDetail record);

    int updateByPrimaryKey(DeviceMulTouchScreenPublishDetail record);
}