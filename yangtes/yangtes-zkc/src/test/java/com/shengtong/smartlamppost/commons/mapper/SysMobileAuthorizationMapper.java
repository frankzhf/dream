package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.SysMobileAuthorization;
import com.shengtong.smartlamppost.commons.entity.SysMobileAuthorizationExample;
import java.util.List;

public interface SysMobileAuthorizationMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysMobileAuthorization record);

    int insertSelective(SysMobileAuthorization record);

    List<SysMobileAuthorization> selectByExample(SysMobileAuthorizationExample example);

    SysMobileAuthorization selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysMobileAuthorization record);

    int updateByPrimaryKey(SysMobileAuthorization record);
}