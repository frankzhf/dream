package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.AssetGroupInfo;
import com.shengtong.smartlamppost.commons.entity.AssetGroupInfoExample;
import java.util.List;

public interface AssetGroupInfoMapper {
    int deleteByPrimaryKey(Integer groupId);

    int insert(AssetGroupInfo record);

    int insertSelective(AssetGroupInfo record);

    List<AssetGroupInfo> selectByExampleWithBLOBs(AssetGroupInfoExample example);

    List<AssetGroupInfo> selectByExample(AssetGroupInfoExample example);

    AssetGroupInfo selectByPrimaryKey(Integer groupId);

    int updateByPrimaryKeySelective(AssetGroupInfo record);

    int updateByPrimaryKeyWithBLOBs(AssetGroupInfo record);

    int updateByPrimaryKey(AssetGroupInfo record);
}