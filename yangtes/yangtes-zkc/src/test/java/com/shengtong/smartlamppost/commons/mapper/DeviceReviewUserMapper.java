package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.DeviceReviewUser;
import com.shengtong.smartlamppost.commons.entity.DeviceReviewUserExample;
import java.util.List;

public interface DeviceReviewUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(DeviceReviewUser record);

    int insertSelective(DeviceReviewUser record);

    List<DeviceReviewUser> selectByExample(DeviceReviewUserExample example);

    DeviceReviewUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DeviceReviewUser record);

    int updateByPrimaryKey(DeviceReviewUser record);
}