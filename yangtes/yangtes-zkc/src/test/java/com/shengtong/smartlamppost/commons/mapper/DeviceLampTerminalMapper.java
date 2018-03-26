package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.DeviceLampTerminal;
import com.shengtong.smartlamppost.commons.entity.DeviceLampTerminalExample;
import java.util.List;

public interface DeviceLampTerminalMapper {
    int deleteByPrimaryKey(String id);

    int insert(DeviceLampTerminal record);

    int insertSelective(DeviceLampTerminal record);

    List<DeviceLampTerminal> selectByExample(DeviceLampTerminalExample example);

    DeviceLampTerminal selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DeviceLampTerminal record);

    int updateByPrimaryKey(DeviceLampTerminal record);
}