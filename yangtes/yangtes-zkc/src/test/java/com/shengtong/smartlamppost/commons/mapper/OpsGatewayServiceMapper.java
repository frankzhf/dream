package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.OpsGatewayService;
import com.shengtong.smartlamppost.commons.entity.OpsGatewayServiceExample;
import java.util.List;

public interface OpsGatewayServiceMapper {
    int deleteByPrimaryKey(String id);

    int insert(OpsGatewayService record);

    int insertSelective(OpsGatewayService record);

    List<OpsGatewayService> selectByExample(OpsGatewayServiceExample example);

    OpsGatewayService selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OpsGatewayService record);

    int updateByPrimaryKey(OpsGatewayService record);
}