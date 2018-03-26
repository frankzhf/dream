package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.AssetUserInfo;
import com.shengtong.smartlamppost.commons.entity.AssetUserInfoExample;
import java.util.List;

public interface AssetUserInfoMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(AssetUserInfo record);

    int insertSelective(AssetUserInfo record);

    List<AssetUserInfo> selectByExample(AssetUserInfoExample example);

    AssetUserInfo selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(AssetUserInfo record);

    int updateByPrimaryKey(AssetUserInfo record);
}