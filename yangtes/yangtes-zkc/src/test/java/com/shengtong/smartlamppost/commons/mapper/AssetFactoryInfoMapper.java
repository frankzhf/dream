package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.AssetFactoryInfo;
import com.shengtong.smartlamppost.commons.entity.AssetFactoryInfoExample;
import java.util.List;

public interface AssetFactoryInfoMapper {
    int deleteByPrimaryKey(Integer factoryId);

    int insert(AssetFactoryInfo record);

    int insertSelective(AssetFactoryInfo record);

    List<AssetFactoryInfo> selectByExample(AssetFactoryInfoExample example);

    AssetFactoryInfo selectByPrimaryKey(Integer factoryId);

    int updateByPrimaryKeySelective(AssetFactoryInfo record);

    int updateByPrimaryKey(AssetFactoryInfo record);
}