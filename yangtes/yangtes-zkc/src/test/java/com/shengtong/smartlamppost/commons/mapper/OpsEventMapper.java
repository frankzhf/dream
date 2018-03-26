package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.OpsEvent;
import com.shengtong.smartlamppost.commons.entity.OpsEventExample;
import java.util.List;

public interface OpsEventMapper {
    int deleteByPrimaryKey(String id);

    int insert(OpsEvent record);

    int insertSelective(OpsEvent record);

    List<OpsEvent> selectByExample(OpsEventExample example);

    OpsEvent selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OpsEvent record);

    int updateByPrimaryKey(OpsEvent record);
}