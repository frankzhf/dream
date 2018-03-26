package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.SysThirdAuthorization;
import com.shengtong.smartlamppost.commons.entity.SysThirdAuthorizationExample;
import java.util.List;

public interface SysThirdAuthorizationMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysThirdAuthorization record);

    int insertSelective(SysThirdAuthorization record);

    List<SysThirdAuthorization> selectByExample(SysThirdAuthorizationExample example);

    SysThirdAuthorization selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysThirdAuthorization record);

    int updateByPrimaryKey(SysThirdAuthorization record);
}