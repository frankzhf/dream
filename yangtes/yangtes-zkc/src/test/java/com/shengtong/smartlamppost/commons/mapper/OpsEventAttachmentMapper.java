package com.shengtong.smartlamppost.commons.mapper;

import com.shengtong.smartlamppost.commons.entity.OpsEventAttachment;
import com.shengtong.smartlamppost.commons.entity.OpsEventAttachmentExample;
import java.util.List;

public interface OpsEventAttachmentMapper {
    int deleteByPrimaryKey(String id);

    int insert(OpsEventAttachment record);

    int insertSelective(OpsEventAttachment record);

    List<OpsEventAttachment> selectByExample(OpsEventAttachmentExample example);

    OpsEventAttachment selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OpsEventAttachment record);

    int updateByPrimaryKey(OpsEventAttachment record);
}