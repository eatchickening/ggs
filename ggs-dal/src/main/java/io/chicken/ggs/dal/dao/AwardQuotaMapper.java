package io.chicken.ggs.dal.dao;

import io.chicken.ggs.dal.model.AwardQuota;

import java.util.List;

public interface AwardQuotaMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AwardQuota record);

    int insertSelective(AwardQuota record);

    int insertCollection(List<AwardQuota> record);
    AwardQuota selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AwardQuota record);

    int updateByPrimaryKey(AwardQuota record);
}