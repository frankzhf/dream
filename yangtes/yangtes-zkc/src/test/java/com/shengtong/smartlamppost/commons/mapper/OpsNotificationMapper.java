package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.OpsNotification;
import com.shengtong.smartlamppost.commons.entity.OpsNotificationExample;
import java.util.List;

public interface OpsNotificationMapper {
    int deleteByPrimaryKey(String id);

    int insert(OpsNotification record);

    int insertSelective(OpsNotification record);

    List<OpsNotification> selectByExample(OpsNotificationExample example);

    OpsNotification selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OpsNotification record);

    int updateByPrimaryKey(OpsNotification record);
}