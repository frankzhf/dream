package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.SysMobileJpush;
import com.shengtong.smartlamppost.commons.entity.SysMobileJpushExample;
import java.util.List;

public interface SysMobileJpushMapper {
    int deleteByPrimaryKey(String userId);

    int insert(SysMobileJpush record);

    int insertSelective(SysMobileJpush record);

    List<SysMobileJpush> selectByExample(SysMobileJpushExample example);

    SysMobileJpush selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(SysMobileJpush record);

    int updateByPrimaryKey(SysMobileJpush record);
}