package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.DeviceLampScreenPublishDetail;
import com.shengtong.smartlamppost.commons.entity.DeviceLampScreenPublishDetailExample;
import java.util.List;

public interface DeviceLampScreenPublishDetailMapper {
    int deleteByPrimaryKey(String id);

    int insert(DeviceLampScreenPublishDetail record);

    int insertSelective(DeviceLampScreenPublishDetail record);

    List<DeviceLampScreenPublishDetail> selectByExample(DeviceLampScreenPublishDetailExample example);

    DeviceLampScreenPublishDetail selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DeviceLampScreenPublishDetail record);

    int updateByPrimaryKey(DeviceLampScreenPublishDetail record);
}