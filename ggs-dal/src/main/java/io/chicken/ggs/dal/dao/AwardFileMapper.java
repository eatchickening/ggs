package io.chicken.ggs.dal.dao;

import io.chicken.ggs.dal.model.AwardFile;

public interface AwardFileMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AwardFile record);

    int insertSelective(AwardFile record);

    AwardFile selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AwardFile record);

    int updateByPrimaryKey(AwardFile record);
}