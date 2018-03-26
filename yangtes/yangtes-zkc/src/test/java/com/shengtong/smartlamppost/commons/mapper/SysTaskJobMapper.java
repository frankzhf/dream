package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.SysTaskJob;
import com.shengtong.smartlamppost.commons.entity.SysTaskJobExample;
import java.util.List;

public interface SysTaskJobMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysTaskJob record);

    int insertSelective(SysTaskJob record);

    List<SysTaskJob> selectByExample(SysTaskJobExample example);

    SysTaskJob selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysTaskJob record);

    int updateByPrimaryKey(SysTaskJob record);
}