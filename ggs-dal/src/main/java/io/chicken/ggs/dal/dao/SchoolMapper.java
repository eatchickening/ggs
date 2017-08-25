package io.chicken.ggs.dal.dao;

import io.chicken.ggs.dal.model.School;

public interface SchoolMapper extends BaseDao<School>{
    int deleteByPrimaryKey(Long id);

    int insert(School record);

    int insertSelective(School record);

    School selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(School record);

    int updateByPrimaryKey(School record);
}