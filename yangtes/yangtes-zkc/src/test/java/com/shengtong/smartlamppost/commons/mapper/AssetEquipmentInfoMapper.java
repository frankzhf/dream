package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.AssetEquipmentInfo;
import com.shengtong.smartlamppost.commons.entity.AssetEquipmentInfoExample;
import java.util.List;

public interface AssetEquipmentInfoMapper {
    int deleteByPrimaryKey(Integer equipmentId);

    int insert(AssetEquipmentInfo record);

    int insertSelective(AssetEquipmentInfo record);

    List<AssetEquipmentInfo> selectByExample(AssetEquipmentInfoExample example);

    AssetEquipmentInfo selectByPrimaryKey(Integer equipmentId);

    int updateByPrimaryKeySelective(AssetEquipmentInfo record);

    int updateByPrimaryKey(AssetEquipmentInfo record);
}