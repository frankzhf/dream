package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.AssetAreaInfo;
import com.shengtong.smartlamppost.commons.entity.AssetAreaInfoExample;
import java.util.List;

public interface AssetAreaInfoMapper {
    int deleteByPrimaryKey(Integer areaId);

    int insert(AssetAreaInfo record);

    int insertSelective(AssetAreaInfo record);

    List<AssetAreaInfo> selectByExample(AssetAreaInfoExample example);

    AssetAreaInfo selectByPrimaryKey(Integer areaId);

    int updateByPrimaryKeySelective(AssetAreaInfo record);

    int updateByPrimaryKey(AssetAreaInfo record);
}