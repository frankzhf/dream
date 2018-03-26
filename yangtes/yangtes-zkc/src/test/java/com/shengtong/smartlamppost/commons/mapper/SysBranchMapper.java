package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.SysBranch;
import com.shengtong.smartlamppost.commons.entity.SysBranchExample;
import java.util.List;

public interface SysBranchMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysBranch record);

    int insertSelective(SysBranch record);

    List<SysBranch> selectByExample(SysBranchExample example);

    SysBranch selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysBranch record);

    int updateByPrimaryKey(SysBranch record);
}