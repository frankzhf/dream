package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.AssetEqumodelInfo;
import com.shengtong.smartlamppost.commons.entity.AssetEqumodelInfoExample;
import java.util.List;

public interface AssetEqumodelInfoMapper {
    int deleteByPrimaryKey(Integer equmodelId);

    int insert(AssetEqumodelInfo record);

    int insertSelective(AssetEqumodelInfo record);

    List<AssetEqumodelInfo> selectByExample(AssetEqumodelInfoExample example);

    AssetEqumodelInfo selectByPrimaryKey(Integer equmodelId);

    int updateByPrimaryKeySelective(AssetEqumodelInfo record);

    int updateByPrimaryKey(AssetEqumodelInfo record);
}