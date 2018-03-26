package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.AssetLampInfo;
import com.shengtong.smartlamppost.commons.entity.AssetLampInfoExample;
import java.util.List;

public interface AssetLampInfoMapper {
    int deleteByPrimaryKey(Integer lampId);

    int insert(AssetLampInfo record);

    int insertSelective(AssetLampInfo record);

    List<AssetLampInfo> selectByExample(AssetLampInfoExample example);

    AssetLampInfo selectByPrimaryKey(Integer lampId);

    int updateByPrimaryKeySelective(AssetLampInfo record);

    int updateByPrimaryKey(AssetLampInfo record);
}