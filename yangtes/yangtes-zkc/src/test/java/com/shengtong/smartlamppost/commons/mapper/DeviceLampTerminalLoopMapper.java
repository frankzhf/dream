package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.DeviceLampTerminalLoop;
import com.shengtong.smartlamppost.commons.entity.DeviceLampTerminalLoopExample;
import java.util.List;

public interface DeviceLampTerminalLoopMapper {
    int deleteByPrimaryKey(String id);

    int insert(DeviceLampTerminalLoop record);

    int insertSelective(DeviceLampTerminalLoop record);

    List<DeviceLampTerminalLoop> selectByExample(DeviceLampTerminalLoopExample example);

    DeviceLampTerminalLoop selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DeviceLampTerminalLoop record);

    int updateByPrimaryKey(DeviceLampTerminalLoop record);
}