package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.SysHeatmap;
import com.shengtong.smartlamppost.commons.entity.SysHeatmapExample;
import java.util.List;

public interface SysHeatmapMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysHeatmap record);

    int insertSelective(SysHeatmap record);

    List<SysHeatmap> selectByExample(SysHeatmapExample example);

    SysHeatmap selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysHeatmap record);

    int updateByPrimaryKey(SysHeatmap record);
}