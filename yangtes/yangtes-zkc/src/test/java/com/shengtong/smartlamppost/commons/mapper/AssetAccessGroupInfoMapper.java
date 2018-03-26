package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.AssetAccessGroupInfo;
import com.shengtong.smartlamppost.commons.entity.AssetAccessGroupInfoExample;
import java.util.List;

public interface AssetAccessGroupInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(AssetAccessGroupInfo record);

    int insertSelective(AssetAccessGroupInfo record);

    List<AssetAccessGroupInfo> selectByExample(AssetAccessGroupInfoExample example);

    AssetAccessGroupInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AssetAccessGroupInfo record);

    int updateByPrimaryKey(AssetAccessGroupInfo record);
}