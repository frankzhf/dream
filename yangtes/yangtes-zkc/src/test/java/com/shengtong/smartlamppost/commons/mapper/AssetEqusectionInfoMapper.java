package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.AssetEqusectionInfo;
import com.shengtong.smartlamppost.commons.entity.AssetEqusectionInfoExample;
import java.util.List;

public interface AssetEqusectionInfoMapper {
    int deleteByPrimaryKey(Integer equsectionId);

    int insert(AssetEqusectionInfo record);

    int insertSelective(AssetEqusectionInfo record);

    List<AssetEqusectionInfo> selectByExample(AssetEqusectionInfoExample example);

    AssetEqusectionInfo selectByPrimaryKey(Integer equsectionId);

    int updateByPrimaryKeySelective(AssetEqusectionInfo record);

    int updateByPrimaryKey(AssetEqusectionInfo record);
}