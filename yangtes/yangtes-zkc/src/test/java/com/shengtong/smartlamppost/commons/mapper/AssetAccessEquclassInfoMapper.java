package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.AssetAccessEquclassInfo;
import com.shengtong.smartlamppost.commons.entity.AssetAccessEquclassInfoExample;
import java.util.List;

public interface AssetAccessEquclassInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(AssetAccessEquclassInfo record);

    int insertSelective(AssetAccessEquclassInfo record);

    List<AssetAccessEquclassInfo> selectByExample(AssetAccessEquclassInfoExample example);

    AssetAccessEquclassInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AssetAccessEquclassInfo record);

    int updateByPrimaryKey(AssetAccessEquclassInfo record);
}