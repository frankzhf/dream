package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.SysServiceConfig;
import com.shengtong.smartlamppost.commons.entity.SysServiceConfigExample;
import java.util.List;

public interface SysServiceConfigMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysServiceConfig record);

    int insertSelective(SysServiceConfig record);

    List<SysServiceConfig> selectByExample(SysServiceConfigExample example);

    SysServiceConfig selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysServiceConfig record);

    int updateByPrimaryKey(SysServiceConfig record);
}