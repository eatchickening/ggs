package io.chicken.ggs.dal.dao;

import io.chicken.ggs.dal.model.ActivityFile;

public interface ActivityFileMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ActivityFile record);

    int insertSelective(ActivityFile record);

    ActivityFile selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ActivityFile record);

    int updateByPrimaryKey(ActivityFile record);
}