package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.SysGridColumn;
import com.shengtong.smartlamppost.commons.entity.SysGridColumnExample;
import java.util.List;

public interface SysGridColumnMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysGridColumn record);

    int insertSelective(SysGridColumn record);

    List<SysGridColumn> selectByExample(SysGridColumnExample example);

    SysGridColumn selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysGridColumn record);

    int updateByPrimaryKey(SysGridColumn record);
}