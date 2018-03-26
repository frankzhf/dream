package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.SysRoleOfficeExample;
import com.shengtong.smartlamppost.commons.entity.SysRoleOfficeKey;
import java.util.List;

public interface SysRoleOfficeMapper {
    int deleteByPrimaryKey(SysRoleOfficeKey key);

    int insert(SysRoleOfficeKey record);

    int insertSelective(SysRoleOfficeKey record);

    List<SysRoleOfficeKey> selectByExample(SysRoleOfficeExample example);
}