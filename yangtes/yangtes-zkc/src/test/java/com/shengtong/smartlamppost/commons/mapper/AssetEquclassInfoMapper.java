package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.AssetEquclassInfo;
import com.shengtong.smartlamppost.commons.entity.AssetEquclassInfoExample;
import java.util.List;

public interface AssetEquclassInfoMapper {
    int deleteByPrimaryKey(Integer equclassId);

    int insert(AssetEquclassInfo record);

    int insertSelective(AssetEquclassInfo record);

    List<AssetEquclassInfo> selectByExample(AssetEquclassInfoExample example);

    AssetEquclassInfo selectByPrimaryKey(Integer equclassId);

    int updateByPrimaryKeySelective(AssetEquclassInfo record);

    int updateByPrimaryKey(AssetEquclassInfo record);
}